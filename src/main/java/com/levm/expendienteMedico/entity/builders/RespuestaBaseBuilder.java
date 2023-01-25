package com.levm.expendienteMedico.entity.builders;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class RespuestaBaseBuilder {

	protected int estatus;

	protected String ruta;

	public RespuestaBaseBuilder estatus(int estatus) {
		this.estatus = estatus;
		return this;
	}

	public RespuestaBaseBuilder status(HttpStatus estatus) {
		this.estatus = estatus.value();
		return this;
	}
	public RespuestaBaseBuilder ruta(String ruta) {
        this.ruta = ruta;
        return this;
    }
	public ResponseEntity<?> entidad() {
		return ResponseEntity.status(estatus).headers(HttpHeaders.EMPTY).body(null);
	}
}
