package com.Direction.Entity.exception;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import com.Direction.Entity.film.DirNotFoundException;

@ControllerAdvice
@RestController
public class CustomResponseEntity {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest request){
		ExceptionResponse exceptionResponse= new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(com.Direction.Entity.film.DirNotFoundException.class)
	public final ResponseEntity<Object> handlerDirNotFoundException(DirNotFoundException ex,WebRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<Object> handlerMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders header,HttpStatus Status,WebRequest request){
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),"not validated",ex.getBindingResult().toString());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
}
