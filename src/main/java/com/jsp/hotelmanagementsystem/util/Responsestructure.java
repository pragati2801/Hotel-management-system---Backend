package com.jsp.hotelmanagementsystem.util;

import lombok.Data;

@Data
public class Responsestructure<T> {
	private String message;
	private int status;
	private T data;

}
