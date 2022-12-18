package com.levm.expendienteMedico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class IndicacionGeneral {
	
	@Id
	@GeneratedValue
	private int idIndicacion;
	
	private String comentario;

	public IndicacionGeneral() {
		super();
	}

	public IndicacionGeneral(int idIndicacion, String comentario) {
		super();
		this.idIndicacion = idIndicacion;
		this.comentario = comentario;
	}

	public int getIdIndicacion() {
		return idIndicacion;
	}

	public void setIdIndicacion(int idIndicacion) {
		this.idIndicacion = idIndicacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	

}
