package com.jsp.hotelmanagementsystem.exception;

public class Maxnumberofexception extends RuntimeException {
	
private String message="we cannot have these many number of peoples in the selected room";
	
	@Override
	public String getMessage() {
		return message;
	}

	public Maxnumberofexception(String message) {
		this.message = message;
	}

	public Maxnumberofexception() {
		super();
	}
	

}
