package com.levm.expendienteMedico.entity;

import java.time.LocalDateTime;

import com.levm.expendienteMedico.entity.builders.RespuestaErrorBuilder;
import com.levm.expendienteMedico.entity.builders.RespuestaErroresBuilder;

public class RespuestaBase {

	private final LocalDateTime timestamp = LocalDateTime.now();

	private int estatus;

	private String ruta;

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public static RespuestaErroresBuilder builder() {
		return new RespuestaErroresBuilder();
	}
	public static RespuestaErrorBuilder builder1() {
		return new RespuestaErrorBuilder();
	}
}
