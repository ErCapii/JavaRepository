package ceu.dam.ad.mongo.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ceu.dam.ad.mongo.services.DatosIncorrectosException;

@ControllerAdvice
public class DatosIncorrectosHandler {

		@ExceptionHandler(DatosIncorrectosException.class)
		public ResponseEntity<String> handle(DatosIncorrectosException ex){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
}
