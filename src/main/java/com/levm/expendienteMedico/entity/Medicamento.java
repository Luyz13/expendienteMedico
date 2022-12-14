package com.levm.expendienteMedico.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Medicamento {
	
	@Id
	@GeneratedValue
	private Long idMedicamento;
	
	private String denominacion;
	private String viaAdministracion;
	private String frecuencia;
	private String duracion;
	
	public Medicamento() {
		super();
	}

	public Medicamento(String denominacion, String viaAdministracion, String frecuencia, String duracion) {
		super();
		this.denominacion = denominacion;
		this.viaAdministracion = viaAdministracion;
		this.frecuencia = frecuencia;
		this.duracion = duracion;
	}

	public Long getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(Long idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getViaAdministracion() {
		return viaAdministracion;
	}

	public void setViaAdministracion(String viaAdministracion) {
		this.viaAdministracion = viaAdministracion;
	}

	public String getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
}
