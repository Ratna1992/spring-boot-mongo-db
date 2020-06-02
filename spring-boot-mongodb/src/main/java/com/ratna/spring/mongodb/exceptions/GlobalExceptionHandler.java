package com.ratna.spring.mongodb.exceptions;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NoFilmsDataException.class)
	public ResponseEntity<ErrorResponse> handleNoFilmsDataException(NoFilmsDataException e) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMsg(e.getMessage());
		error.setTimeStamp(LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = NoActorsDataException.class)
	public ResponseEntity<ErrorResponse> handleNoActorssDataException(NoActorsDataException e) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMsg(e.getMessage());
		error.setTimeStamp(LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}


}
