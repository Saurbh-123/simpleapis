package com.example.demo.payload;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.entity.Catogry;
import com.example.demo.entity.User;

public class PostDto
{

	private Integer p_id;
	private String title;
	private String content;
	private String imagename;
	private Date adddate;
	private User user;
	private Catogry catogry;
	
	private Set<CommentDto> comment = new HashSet<>();
	
	
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}



	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public Date getAdddate() {
		return adddate;
	}
	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Catogry getCatogry() {
		return catogry;
	}
	public void setCatogry(Catogry catogry) {
		this.catogry = catogry;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Set<CommentDto> getComment() {
		return comment;
	}
	public void setComment(Set<CommentDto> comment) {
		this.comment = comment;
	}
	public PostDto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

}
