package com.example.demo.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer p_id;
    
	private String title;
	private String content;
	private String imagename;
	private Date adddate;
	
	@ManyToOne
	@JoinColumn(name = "catory_id")
	private Catogry catogry;
	
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Comment> comment = new HashSet<>();
	
	
	





	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
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

	public Catogry getCatogry() {
		return catogry;
	}

	public void setCatogry(Catogry catogry) {
		this.catogry = catogry;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Integer p_id, String title, String content, String imagename, Date adddate, Catogry catogry,
			User user) {
		super();
		this.p_id = p_id;
		this.title = title;
		this.content = content;
		this.imagename = imagename;
		this.adddate = adddate;
		this.catogry = catogry;
		this.user = user;
	}
	
	
	
	
	
	
}
