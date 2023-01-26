package com.example.demo.imple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CommentRepo;
import com.example.demo.Repository.MyPostRepo;
import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.intefeceService.CommentsInterface;
import com.example.demo.payload.CommentDto;

@Service
public class CommentsImple implements CommentsInterface {

	@Autowired
	private MyPostRepo postrepo;
	
	@Autowired
	private CommentRepo commentrep;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CommentDto createComments(CommentDto dto, Integer post_dto) {
		
		Post post = this.postrepo.findById(post_dto).orElseThrow(()->new ResourceNotFoundException("Post"," post_id",post_dto));
	
		Comment comment = this.mapper.map(dto , Comment.class);
		
		comment.setPost(post);
	
		
		Comment savecomment = this.commentrep.save(comment);
		
		
		return this.mapper.map(savecomment, CommentDto.class);
	}

	@Override
	public void deletcomments(Integer commet_id) {
		
		Comment comment = this.commentrep.findById(commet_id).orElseThrow(()->new ResourceNotFoundException("Comment","commet_id",commet_id));

		this.commentrep.delete(comment);
	}

	@Override
	public CommentDto updateing(CommentDto dto, Integer post_id,Integer comment_id) {
		Post post = this.postrepo.findById(post_id).orElseThrow(()->new ResourceNotFoundException("post","post",post_id));
	
          Comment comment = this.commentrep.findById(comment_id).orElseThrow(()->new ResourceNotFoundException("comment_id"," comment_id", comment_id));
          comment.setContent(dto.getContent());
         
          post.setContent(dto.getContent());
          
          this.postrepo.save(post);
        
          Comment save = this.commentrep.save(comment);
          
		return this.mapper.map(save,CommentDto.class);
	}

}
