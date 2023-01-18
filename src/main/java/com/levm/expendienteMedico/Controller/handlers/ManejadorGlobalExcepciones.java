package com.levm.expendienteMedico.Controller.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.levm.expendienteMedico.entity.RespuestaError;

@RestControllerAdvice
public class ManejadorGlobalExcepciones {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleStatusException(MethodArgumentNotValidException ex, WebRequest request) {

		return RespuestaError.builder()
				.exception(ex)
				.ruta(request.getDescription(false)
						.substring(4))
						.entidad();
	}
	
}
