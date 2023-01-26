package com.example.demo.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CatogryDto {

	private Integer catogaryId;
	@NotBlank
	@Size(min=4)
	private String catogorytitle;
	@NotBlank
	private String catogoryabout;
	
	public Integer getCatogaryId() 
	{
		return catogaryId;
	}
	public void setCatogaryId(Integer catogaryId) {
		this.catogaryId = catogaryId;
	}

	public CatogryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CatogryDto(Integer catogaryId, String catogorytitle, String catogoryabout) {
		super();
		this.catogaryId = catogaryId;
		this.catogorytitle = catogorytitle;
		this.catogoryabout = catogoryabout;
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
