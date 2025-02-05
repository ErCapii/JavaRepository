package ceu.dam.ad.users.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ceu.dam.ad.users.service.DuplicateUserException;

@ControllerAdvice
public class DuplicateUserExceptionHandler {

	@ExceptionHandler(DuplicateUserException.class)
	public ResponseEntity<String> handle(DuplicateUserException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
}