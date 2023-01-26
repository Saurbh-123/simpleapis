package com.example.demo.MyContoler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.imple.MyPostimple;
import com.example.demo.payload.CatogryDto;
import com.example.demo.payload.PostDto;
import com.example.demo.payload.PostResponse;
import com.example.demo.payload.UserDto;

@RestController
@RequestMapping("/post/")
public class MyPostContoller {
	
	@Autowired
	private MyPostimple postimple;
	
	
	
	@PostMapping("/user/{userid}/catogry/{catorgyid}")
	public ResponseEntity<PostDto> createingss(@RequestBody PostDto  dto,
			@PathVariable("userid") Integer userid,
			@PathVariable("catorgyid") Integer catorgyid) {
		
		PostDto dto2 = this.postimple.create(dto, userid, catorgyid);
		
		return new  ResponseEntity<PostDto>(dto2,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatngsw(@RequestBody PostDto dto,
			@RequestBody UserDto dto1,
			@RequestBody CatogryDto dto2,
			@PathVariable("id") Integer id){
		
		PostDto updatei = this.postimple.updatei(dto, dto1, dto2, id);
		
		
		return new ResponseEntity<PostDto>(updatei,HttpStatus.OK);
	}
	
	@GetMapping("/{pagenumber}/{pagesize}")
	public ResponseEntity<PostResponse> getallpost(@PathVariable(value = "pagenumber") Integer pagenumber,
			@PathVariable(value = "pagesize") Integer pagesize)
	{
	
		 PostResponse list = this.postimple.getall(pagenumber, pagesize);
		 
		 
        return new ResponseEntity<PostResponse>(list,HttpStatus.OK);
	}
	

	/* GetByUser */

	@GetMapping("/user/{user_id}/")
	public ResponseEntity<List<PostDto>> getpostbyuser(@PathVariable("user_id") Integer id){
		List<PostDto> post = this.postimple.getPostsByUser(id);
		return new ResponseEntity<List<PostDto>>(post,HttpStatus.OK);
      
    }

	/* GETBYCATOGRY */
	@GetMapping("/catogry/{id}/")
	public ResponseEntity<List<PostDto>> getpostbycatogry(@PathVariable Integer id){
		List<PostDto> post = this.postimple.getPostsByCatogry(id);
		return new ResponseEntity<List<PostDto>>(post,HttpStatus.OK);}
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getbyids(@PathVariable("id") Integer id){
		PostDto getbyid = this.postimple.getbyid(id);
		return new ResponseEntity<PostDto>(getbyid,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletebyid(@PathVariable("id") Integer id){
		this.postimple.deleing(id);
		return ResponseEntity.status(HttpStatus.GONE).build();
	}
	
	
	
	
}