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
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoActorsDataException.class)
	public ResponseEntity<ErrorResponse> handleNoActorssDataException(NoActorsDataException e) {
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoCustomersDataException.class)
	public ResponseEntity<ErrorResponse> handleNoCustomersDataException(NoCustomersDataException e) {
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoPaymentsDataException.class)
	public ResponseEntity<ErrorResponse> handleNoPaymentsDataException(NoPaymentsDataException e) {
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoAccountDetailsDataException.class)
	public ResponseEntity<ErrorResponse> handleNoAccountDetailsDataException(NoAccountDetailsDataException e) {
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = DataLoadDataException.class)
	public ResponseEntity<ErrorResponse> handleDataLoadDataException(DataLoadDataException e) {
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoRegionDetailsDataException.class)
	public ResponseEntity<ErrorResponse> handleNoRegionDetailsDataException(NoRegionDetailsDataException e) {
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoAccountHolderDataException.class)
	public ResponseEntity<ErrorResponse> handleNoAccountHolderDataException(NoAccountHolderDataException e) {
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoUserOrderDataException.class)
	public ResponseEntity<ErrorResponse> handleNoUserOrderDataException(NoUserOrderDataException e) {
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoBookDataException.class)
	public ResponseEntity<ErrorResponse> handleNoBookDataException(NoBookDataException e) {
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoInventoryDataException.class)
	public ResponseEntity<ErrorResponse> handleNoInventoryDataException(NoInventoryDataException e) {
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = NoStaffDataException.class)
	public ResponseEntity<ErrorResponse> handleNoStaffDataException(NoStaffDataException e) {
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NoFileFoundException.class)
	public ResponseEntity<ErrorResponse> handleNoFileFoundException(NoFileFoundException e) {
		return new ResponseEntity<>(getErrorResponse(e), HttpStatus.NOT_FOUND);
	}

	public ErrorResponse getErrorResponse(RuntimeException e) {
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMsg(e.getMessage());
		error.setTimeStamp(LocalDate.now());
		return error;

	}

}
