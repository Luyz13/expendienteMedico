package com.levm.expendienteMedico.Controller.handlers;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.levm.expendienteMedico.entity.RespuestaError;
import com.levm.expendienteMedico.entity.RespuestaErrores;

@RestControllerAdvice
public class ManejadorGlobalExcepciones extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> manejaException(Exception ex, WebRequest request) {
		return  RespuestaError
				.builder1()
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.message("Server encountered an error")
				.ruta(request.getDescription(false).substring(4))
				.entidad();
	}
	
	/*@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleStatusException(MethodArgumentNotValidException ex, WebRequest request) {

		return RespuestaErrores
				.builder()
				.exception(ex).
				ruta(request.getDescription(false).substring(4))
				.entidad();
	}*/
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request){
        Map<String,String> errors = new TreeMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.put(error.getField(), error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()){
            errors.put(error.getObjectName(), error.getDefaultMessage());
        }

        RespuestaErrores respuestaErrores = new RespuestaErrores();
        respuestaErrores.setErrores(errors);
        respuestaErrores.setRuta(request.getDescription(false).substring(4));
        return handleExceptionInternal(ex,respuestaErrores,headers, HttpStatus.BAD_REQUEST, request);
    }
	@Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers,
                                                                         HttpStatusCode status,
                                                                         WebRequest request) {

        Map<String, String> errors = new TreeMap<>();

        StringBuilder builder = new StringBuilder();
        builder.append("El método ");
        builder.append(ex.getMethod());
        builder.append(" no está soportado para esta petición. Los métodos soportados son ");

        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

        errors.put("Error", builder.toString());
        RespuestaErrores respuestaErrores = new RespuestaErrores();
        respuestaErrores.setErrores(errors);
        respuestaErrores.setRuta(request.getDescription(false).substring(4));

        return new ResponseEntity<Object>(respuestaErrores, headers, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
