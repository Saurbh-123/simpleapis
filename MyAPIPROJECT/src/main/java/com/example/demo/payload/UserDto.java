package com.example.demo.payload;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto {
	
	private int id;
	@NotEmpty(message = "Can Not Left Empty")
	@Size(max=10)
	private String name;
	@Email
	@NotBlank(message = "Can Not Left Empty")
	private String email;
	@NotEmpty(message = "Empty Is Not allow")
	@Size(min=4,max=10,message = "Minimum 4 and Maximum 10 Character alow")
	private String password;
	
	@Column(length = 500)
	private String about;

	
	public UserDto(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	

}
