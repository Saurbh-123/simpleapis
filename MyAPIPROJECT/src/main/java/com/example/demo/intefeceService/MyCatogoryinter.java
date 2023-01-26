package com.example.demo.intefeceService;

import java.util.List;

import com.example.demo.payload.CatogryDto;

public interface MyCatogoryinter {

	//Create Object
	
	CatogryDto createing(CatogryDto dto);
	
	//Updating Object 
	
	CatogryDto updateing(CatogryDto dto,Integer cid);
	
	
	//Get All Object
	
	List<CatogryDto> getallobject();
	
	//Get Single Object By id

	CatogryDto getbyid(Integer id);
	
	
	//Deleting  Single Object By id
	
	void deletingobjectbyid(Integer id);

	
	//Deleting All Object
	
	void deletall();
	
}
