package com.example.demo.imple;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.MyDao;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.intefeceService.Myinterface;
import com.example.demo.payload.UserDto;

@Service
public class UserServiceImple implements Myinterface {

	@Autowired
	private MyDao dao;
	
	@Autowired
	private ModelMapper model;

	
	@Override
	public List<UserDto> getalluser() {
		List<User> list = this.dao.findAll();
		List<UserDto> list2 = list.stream().map(e->this.userTodto(e)).collect(Collectors.toList());
	
		return  list2;
	}

	@Override
	public UserDto update(UserDto dto, int id) {
		User user = this.dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("User"," Id ",id));
		
		user.setName(dto.getName());
		user.setPassword(dto.getPassword());
		user.setEmail(dto.getEmail());
		user.setAbout(dto.getAbout());
		
         User save = this.dao.save(user);		
		
         UserDto dto2 = this.userTodto(save);
		
		return dto2;
	}
             
	
	
	public UserDto findingbyid(Integer id) {
	   
		User byId = this.dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("User"," Id ",id));
		
		UserDto dto = this.userTodto(byId);
	
		
		return dto;
	}
	
	@Override
	public UserDto creatuser(UserDto dto) {
		User user = this.dtoTOuser(dto);
		User user2 = this.dao.save(user);
		UserDto user1 = this.userTodto(user2);
		return user1;
	}
	
	
	
	@Override
	public void deleteuser(int id) {
		this.dao.deleteById(id);
		
	}
	
	@Override
	public UserDto deleteingall() {
		this.dao.deleteAll();
		return null;
	}
	
	
	
	public UserDto userTodto (User user) {
		UserDto dto = this.model.map(user, UserDto.class);
		return dto;
		
//		dto.setId(user.getId());
//		dto.setName(user.getName());
//		dto.setPassword(user.getPassword());
//		dto.setEmail(user.getEmail());
//		dto.setAbout(user.getAbout());
	}
	
	public User dtoTOuser(UserDto dto) {
		User u = this.model.map(dto,User.class);
		return u;
//		
//	    u.setId(dto.getId());
//	    u.setName(dto.getName());
//		u.setPassword(dto.getPassword());
//		u.setEmail(dto.getEmail());
//		u.setAbout(dto.getAbout());
//		
	}


	
}

