package com.levm.expendienteMedico.entity.builders;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.levm.expendienteMedico.entity.RespuestaError;

public class RespuestaErrorBuilder extends RespuestaBaseBuilder {

    private String error;
    private String mensaje;
  
   public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

@Override
   public RespuestaErrorBuilder status(HttpStatus estatus) {
        this.estatus = estatus.value();

        if (estatus.isError()) {
            this.error = estatus.getReasonPhrase();
        }

        return this;
    }

    public RespuestaErrorBuilder error(String error) {
        this.error = error;
        return this;
    }

    public RespuestaErrorBuilder message(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public RespuestaError build() {
        RespuestaError respuesta = new RespuestaError();
        respuesta.setEstatus(estatus);
        respuesta.setError(error);
        respuesta.setMensaje(mensaje);
        respuesta.setRuta(ruta);
        return respuesta;
    }

    public ResponseEntity<RespuestaError> entidad() {
        return ResponseEntity.status(estatus).headers(HttpHeaders.EMPTY).body(build());
    }
}
