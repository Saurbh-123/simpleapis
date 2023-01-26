package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException{

	String resource;
	String field;
	long fieldid;
	
	public ResourceNotFoundException(String resource, String field, long fieldid) {
		super(String.format(" %s not found with %s : %s ",resource,field,fieldid));
		this.resource = resource;
		this.field = field;
		this.fieldid = fieldid;
	}
	
	
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public long getFieldid() {
		return fieldid;
	}
	public void setFieldid(long fieldid) {
		this.fieldid = fieldid;
	}
}
