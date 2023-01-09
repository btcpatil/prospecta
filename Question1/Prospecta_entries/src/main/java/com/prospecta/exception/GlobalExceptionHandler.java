package com.prospecta.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EntryException.class)
	public ResponseEntity<ErrorDetails> entryExceptionHandler(EntryException ee){
		
		ErrorDetails error = new ErrorDetails();
		error.setTimeStamp(LocalDateTime.now());
		error.setMessage(ee.getMessage());
		
		return new ResponseEntity<ErrorDetails>(error,HttpStatus.BAD_GATEWAY);
		
	}
	
}
