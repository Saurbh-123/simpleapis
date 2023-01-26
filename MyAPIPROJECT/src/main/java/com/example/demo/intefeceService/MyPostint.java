package com.example.demo.intefeceService;

import java.util.List;

import com.example.demo.payload.CatogryDto;
import com.example.demo.payload.PostDto;
import com.example.demo.payload.PostResponse;
import com.example.demo.payload.UserDto;

public interface MyPostint {
	
	/* POST CREATE METHOD */

	PostDto create(PostDto dto,Integer u_id,Integer c_id);
	
	/* UDPDATE POST */
	
	
	PostDto updatei(PostDto dto,UserDto dtouser,CatogryDto catdto,Integer id);
	
	
	/* Get all */
	
	
	 PostResponse getall(Integer pagenumber,Integer pagesize);
	 
	 
		/* DELETE ALL */
	 
	 void deleing(Integer id);
	 
		/* GET BY ID */
	 
	PostDto getbyid(Integer id);
	 
	 List<PostDto> getPostsByCatogry(Integer catogry_id);
	 List<PostDto> getPostsByUser(Integer user_id);
	 
	 
	 
	 
}
