package com.jsp.hotelmanagementsystem.exception;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.hotelmanagementsystem.util.Responsestructure;

@ControllerAdvice
public class Applicationexceptionhandler extends ResponseEntityExceptionHandler {
	
Responsestructure<String> responsestructure=new Responsestructure<>();
	
	@ExceptionHandler(Idnotfound.class)
	public ResponseEntity<Responsestructure<String>> idnotfound(Idnotfound ex) {
		responsestructure.setMessage("given id is not found");
		responsestructure.setStatus(HttpStatus.NOT_FOUND.value());
		responsestructure.setData(ex.getMessage());
		return new ResponseEntity<Responsestructure<String>>(responsestructure,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(Maxnumberofexception.class)
	public ResponseEntity<Responsestructure<String>> maxnumberofpeopleexception(Maxnumberofexception ex){
		responsestructure.setMessage("max limit of people for the particular room");
		responsestructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responsestructure.setData(ex.getMessage());
		return new ResponseEntity<Responsestructure<String>>(responsestructure,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<ObjectError> errors=ex.getAllErrors();
		Map<String, String> map=new LinkedHashMap<String, String>();
		for(ObjectError er:errors) {
			String fieldname=((FieldError)er).getField();
			String message=((FieldError)er).getDefaultMessage();
			map.put(fieldname, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}

}
