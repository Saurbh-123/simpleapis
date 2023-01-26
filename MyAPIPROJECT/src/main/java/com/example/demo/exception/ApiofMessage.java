package com.example.demo.exception;

public class ApiofMessage {
	
	String message;
	boolean   Field;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isField() {
		return Field;
	}
	public void setField(boolean field) {
		Field = field;
	}
	public ApiofMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiofMessage(String message, boolean field) {
		super();
		this.message = message;
		Field = field;
	}


}
