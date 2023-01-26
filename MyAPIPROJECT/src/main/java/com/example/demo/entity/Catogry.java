package com.example.demo.entity;

import java.util.*;
import javax.persistence.*;

@Entity
public class Catogry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
	private Integer catogaryId;
	
	@Column(name = "C_title")
	private String catogorytitle;

	private String catogoryabout;
	
	
	@OneToMany(mappedBy = "catogry",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Post> psots = new ArrayList<>();
	
	
	
	public Catogry() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Catogry(Integer catogaryId, String catogorytitle, String catogoryabout) {
		super();
		this.catogaryId = catogaryId;
		this.catogorytitle = catogorytitle;
		this.catogoryabout = catogoryabout;
	}
	public Integer getCatogaryId() {
		return catogaryId;
	}
	public void setCatogaryId(Integer catogaryId) {
		this.catogaryId = catogaryId;
	}
	public String getCatogorytitle() {
		return catogorytitle;
	}
	public void setCatogorytitle(String catogorytitle) {
		this.catogorytitle = catogorytitle;
	}
	public String getCatogoryabout() {
		return catogoryabout;
	}
	public void setCatogoryabout(String catogoryabout) {
		this.catogoryabout = catogoryabout;
	}

}
