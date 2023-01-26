package com.example.demo.imple;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.MyRepoCatogory;
import com.example.demo.entity.Catogry;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.intefeceService.MyCatogoryinter;
import com.example.demo.payload.CatogryDto;

@Service
public class MyCatogoryimple implements MyCatogoryinter {
//  AUTO#WIRED
	/* BUSINESSLOGICES CODE HERE */
	@Autowired
	private MyRepoCatogory catogory;
	
	@Autowired
	private ModelMapper mapper;
	
//	AUTO#WIRED
	
	
	//CTRAETIN  Single Objects
	
	@Override
	public CatogryDto createing(CatogryDto dto) {
	
		Catogry map = this.mapper.map(dto, Catogry.class);
		Catogry save = this.catogory.save(map);
		CatogryDto map2 = this.mapper.map(save, CatogryDto.class);
		return map2;
	}

	//Updating Single Object
	
	@Override
	public CatogryDto updateing(CatogryDto dto, Integer cid) {
		Catogry c = this.catogory.findById(cid).orElseThrow(()-> new ResourceNotFoundException("Catogory","id",cid));
		c.setCatogoryabout(dto.getCatogoryabout());
		c.setCatogorytitle(dto.getCatogorytitle());
		Catogry save = this.catogory.save(c);
		CatogryDto map = this.mapper.map(save, CatogryDto.class);
		return map;}
	
	//Get All Object

	@Override
	public List<CatogryDto> getallobject() {
		
		List<Catogry> find = (List<Catogry>) this.catogory.findAll();
		List<CatogryDto> list = find.stream().map((cat)-> this.mapper.map(cat, CatogryDto.class)).collect(Collectors.toList());
		
		return list;
		}
	
	
	
       //Get BY ID
	@Override
	public CatogryDto getbyid(Integer id) {		
		Object id2 = this.catogory.findById(id).orElseThrow(()-> new ResourceNotFoundException("Catorgy"," id ",id));
		CatogryDto dto = this.mapper.map(id2,CatogryDto.class);
		return dto;}

	//Deleting Objects
	@Override
	public void deletingobjectbyid(Integer id) {

		Catogry id2 = this.catogory.findById(id).orElseThrow(()-> new ResourceNotFoundException("Catogory"," id",id));
        this.catogory.delete(id2);
        
	}

	
	
	
	//deleting all
	@Override
	public void deletall() {
        this.catogory.deleteAll();}
}
