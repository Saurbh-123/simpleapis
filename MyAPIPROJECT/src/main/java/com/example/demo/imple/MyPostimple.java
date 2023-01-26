package com.example.demo.imple;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.MyDao;
import com.example.demo.Repository.MyPostRepo;
import com.example.demo.Repository.MyRepoCatogory;
import com.example.demo.entity.Catogry;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.intefeceService.MyPostint;
import com.example.demo.payload.CatogryDto;
import com.example.demo.payload.PostDto;
import com.example.demo.payload.PostResponse;
import com.example.demo.payload.UserDto;

@Service
public class MyPostimple implements MyPostint {

	@Autowired
	private MyPostRepo repo;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private MyDao dao;

	@Autowired
	private MyRepoCatogory catogory;
	

	@Override
	public PostDto create(PostDto dto, Integer u_id, Integer c_id) {
		User user = this.dao.findById(u_id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", u_id));
		Catogry catory = this.catogory.findById(c_id)
				.orElseThrow(() -> new ResourceNotFoundException("Catogry", "id", c_id));
		Post map = this.mapper.map(dto, Post.class);
		map.setImagename("default.png");
		map.setCatogry(catory);
		map.setUser(user);
		map.setAdddate(new Date(0));
		Post save = this.repo.save(map);
		PostDto map2 = this.mapper.map(save, PostDto.class);
		return map2;
	}

	@Override
	public PostDto updatei(PostDto dto,UserDto userdto,CatogryDto catdto, Integer id) {
		Post singlepost = this.repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		User singleuser = this.dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		Catogry singlecatogory = this.catogory.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
		

		singlepost.setTitle(dto.getTitle());
		singlepost.setContent(dto.getContent());
		singlepost.setCatogry(singlecatogory);
		singlepost.setUser(singleuser);
		
		singleuser.setAbout(userdto.getAbout());
		singleuser.setEmail(userdto.getEmail());
		singleuser.setName(userdto.getName());
		singleuser.setPassword(userdto.getPassword());
		
		singlecatogory .setCatogorytitle(catdto.getCatogorytitle());
		singlecatogory .setCatogoryabout(catdto.getCatogoryabout());
		Post save = this.repo.save(singlepost);
		return this.mapper.map(save, PostDto.class);
	}

	@Override
	public PostResponse getall( Integer pagenumber,Integer pagesize ) {
		Pageable pageable = PageRequest.of(pagenumber, pagesize );
	  Page<Post> all = this.repo.findAll(pageable);
        List<Post> list = all.getContent();
	 List<PostDto> collect = list.stream().map(e->this.mapper.map(e, PostDto.class)).collect(Collectors.toList());
	 
	 PostResponse postresponse = new PostResponse();
	 postresponse.setContent(collect);
	 postresponse.setPageNumber(pageable.getPageNumber());
	 postresponse .setPageSize(pageable.getPageSize());
	 postresponse .setTotleEnlements(all.getTotalElements());
	 postresponse .setTotalPage(all.getTotalPages());
	 
	 if(all.isLast()) {
	 postresponse .setLastPage("This is Last Page");
	 }
	 else {
		 postresponse .setLastPage("Page is Left");
	 }
	 return postresponse;
	}

	@Override
	public void deleing(Integer id) {
		
		 this.repo.deleteById(id);;
	}

	@Override
	public PostDto getbyid(Integer id) {
          Post post = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id));              
		 PostDto dto = this.mapper.map(post, PostDto.class);
		return dto;
	}

	@Override
	public List<PostDto> getPostsByCatogry(Integer catogry_id) {

		Catogry catogry = this.catogory.findById(catogry_id).orElseThrow(()-> new ResourceNotFoundException("catorgy","id",catogry_id));
		List<Post> list = this.repo.findByCatogry(catogry);
		List<PostDto> collect = list.stream().map((e)->this.mapper.map(e, PostDto.class)).collect(Collectors.toList());
		return collect ;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer user_id) {
		User or = this.dao.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("User","id",user_id));
		List<Post> findByUser = this.repo.findByUser(or);
		List<PostDto> collect = findByUser.stream().map((e)-> this.mapper.map(e, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

}
