package com.example.demo.intefeceService;

import java.util.List;

import com.example.demo.payload.UserDto;

public interface Myinterface {

	 List<UserDto> getalluser();
	 
	 UserDto update(UserDto dto,int id);
	 
	 UserDto findingbyid(Integer id);
	 
	 
	 UserDto creatuser(UserDto dto);
	 
	 
	 void deleteuser(int id);
	 
	 UserDto deleteingall();
	 
	 
}
