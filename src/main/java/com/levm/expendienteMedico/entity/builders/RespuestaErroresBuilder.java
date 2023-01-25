package com.levm.expendienteMedico.entity.builders;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.levm.expendienteMedico.entity.RespuestaErrores;

public class RespuestaErroresBuilder extends RespuestaBaseBuilder{

    private Map<String, String> errores;
    
    public RespuestaErroresBuilder errores(Map<String, String> errores) {
        this.errores = errores;
        return this;
    }

    public RespuestaErroresBuilder exception(MethodArgumentNotValidException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        this.estatus = status.value();

        errores = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errores.put(fieldName, errorMessage);
        });

        return this;
    }
    public RespuestaErrores build() {
        RespuestaErrores respuesta = new RespuestaErrores();
        respuesta.setEstatus(estatus);
        respuesta.setErrores(errores);
        respuesta.setRuta(ruta);
        return respuesta;
    }
    @Override
    public ResponseEntity<RespuestaErrores> entidad() {
        return ResponseEntity.status(estatus).headers(HttpHeaders.EMPTY).body(build());
    }
   
    
}
