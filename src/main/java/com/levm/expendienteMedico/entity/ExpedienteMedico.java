package com.levm.expendienteMedico.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExpedienteMedico {
	
	@Id
	@GeneratedValue
	private long idExpediente;
	
	private String fechaAlta;
	private String fechaActualizacion;
	
	public ExpedienteMedico() {
		super();
	}

	public ExpedienteMedico(String fechaAlta, String fechaActualizacion) {
		super();
		this.fechaAlta = fechaAlta;
		this.fechaActualizacion = fechaActualizacion;
	}

	public long getIdExpediente() {
		return idExpediente;
	}

	public void setIdExpediente(long idExpediente) {
		this.idExpediente = idExpediente;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(String fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
}
