package com.jsp.hotelmanagementsystem.exception;

public class Idnotfound extends RuntimeException{
private String message="id not found";
	
	@Override
	public String getMessage() {
		return message;
	}

	public Idnotfound(String message) {
		this.message = message;
	}

	public Idnotfound() {
		super();
	}
	

}
