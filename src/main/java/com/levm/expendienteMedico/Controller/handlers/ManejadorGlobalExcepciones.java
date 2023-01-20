package com.levm.expendienteMedico.Controller.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.levm.expendienteMedico.entity.RespuestaError;
import com.levm.expendienteMedico.entity.RespuestaErrores;

@RestControllerAdvice
public class ManejadorGlobalExcepciones{

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> manejaException(Exception ex, WebRequest request) {
		return  RespuestaError
				.builder1()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.message("Server encountered an error")
				.ruta(request.getDescription(false).substring(4))
				.entidad();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleStatusException(MethodArgumentNotValidException ex, WebRequest request) {

		return RespuestaErrores
				.builder()
				.exception(ex).
				ruta(request.getDescription(false).substring(4))
				.entidad();
	}
}
