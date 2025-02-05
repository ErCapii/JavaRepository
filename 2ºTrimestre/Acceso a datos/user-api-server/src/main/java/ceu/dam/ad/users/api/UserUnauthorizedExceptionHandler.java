package ceu.dam.ad.users.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ceu.dam.ad.users.service.UserUnauthorizedException;

@ControllerAdvice
public class UserUnauthorizedExceptionHandler {

	@ExceptionHandler(UserUnauthorizedException.class)
	public ResponseEntity<String> handle(UserUnauthorizedException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}

}