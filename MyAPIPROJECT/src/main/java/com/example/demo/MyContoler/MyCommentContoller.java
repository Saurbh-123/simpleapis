package com.example.demo.MyContoler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ApiofMessage;
import com.example.demo.imple.CommentsImple;
import com.example.demo.payload.CommentDto;

@RestController
@RequestMapping("/comment")
public class MyCommentContoller {

	@Autowired
	private CommentsImple comment;
	
	@PostMapping("/post/{post_id}/")
	public ResponseEntity<CommentDto> createcomments1(@RequestBody  CommentDto dto,@PathVariable("post_id") Integer post_id){
		
		CommentDto dto2 = this.comment.createComments(dto, post_id);
	
		return new ResponseEntity<CommentDto>(dto2, HttpStatus.CREATED);
		
	}
	@PutMapping("/{post_id}/{comment_id}")
	public ResponseEntity<CommentDto> uppdtaing(@RequestBody CommentDto dto,@PathVariable("post_id") Integer post_id,@PathVariable("comment_id")Integer comment_id){
		
		CommentDto updateing = this.comment.updateing(dto, post_id,comment_id);
		
		return new ResponseEntity<CommentDto>(updateing,HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiofMessage> dele(@PathVariable("id") Integer id){
		
		this.comment.deletcomments(id);
	
	   return new ResponseEntity<ApiofMessage>(new ApiofMessage("Your Id Is deleted Successfully",true),HttpStatus.OK);
	}
	
}
