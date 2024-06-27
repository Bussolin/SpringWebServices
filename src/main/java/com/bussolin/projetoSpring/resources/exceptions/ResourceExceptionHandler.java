package com.bussolin.projetoSpring.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bussolin.projetoSpring.services.exceptions.DataBaseException;
import com.bussolin.projetoSpring.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	
	@ExceptionHandler( ResourceNotFoundException.class )
	public ResponseEntity<StandartError> resourceNotFoundException( ResourceNotFoundException e, HttpServletRequest request ){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError err = new StandartError( Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI() );
		return ResponseEntity.status( status ).body( err );
	}
	
	@ExceptionHandler( DataBaseException.class )
	public ResponseEntity<StandartError> dataBaseException( DataBaseException e, HttpServletRequest request ){
		String error = "Database Error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandartError err = new StandartError( Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI() );
		return ResponseEntity.status( status ).body( err );
	}
}
