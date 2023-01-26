package com.example.demo.intefeceService;

import com.example.demo.payload.CommentDto;

public interface CommentsInterface {

	CommentDto createComments(CommentDto dto,Integer post_dto);
	void deletcomments(Integer commet_id); 
	CommentDto updateing(CommentDto dto,Integer post_id,Integer comment_id);
	
}
