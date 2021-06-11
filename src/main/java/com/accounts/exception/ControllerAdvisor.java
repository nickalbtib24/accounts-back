package com.accounts.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@ResponseBody
public class ControllerAdvisor extends ResponseEntityExceptionHandler{

    @ExceptionHandler({AccountAlreadyExistsException.class, AccountNotFoundException.class})
	public ResponseEntity<Object> handleExceptions(Exception exception, WebRequest request){
	    Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", exception.getMessage());
        body.put("code", 1);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
    
    @ExceptionHandler(InsufficientFundsException.class)
	public ResponseEntity<Object> handleAccountInsufficientFundsException(InsufficientFundsException exception, WebRequest request){
	    Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", exception.getMessage());
        body.put("code", 2);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
      
	
}
