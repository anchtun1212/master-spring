package com.anchtun.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.anchtun.model.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// for each exception implemented here will be applicable for each class annotated by annotations @RestController
@RestControllerAdvice(annotations = RestController.class)
// used if spring confused about the two GlobalExceptionRestController and GlobalExceptionController but no need
//@Order(1)
public class GlobalExceptionRestController extends ResponseEntityExceptionHandler {

	// because we extends ResponseEntityExceptionHandler so we can override handleMethodArgumentNotValid
	// invoked when someone try to send invalid input data in our REST web service
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		Response response = new Response(status.value(), ex.getBindingResult().toString());
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(response);
	}
	
	@ExceptionHandler
	public ResponseEntity<Response> exceptionHandler(Exception exception) {
		Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(response);
	}
}
