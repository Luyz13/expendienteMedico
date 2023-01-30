package com.levm.expendienteMedico.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="expedientes")
public class Expediente {
	
	@Id
	@GeneratedValue
	private long idExpediente;
	
	private Date fechaAlta;
	
	private Date fechaActualizacion;
	
	

	public Expediente(Date fechaAlta, Date fechaActualizacion) {
		super();
		this.fechaAlta = fechaAlta;
		this.fechaActualizacion = fechaActualizacion;
	}

	public Expediente(long idExpediente) {
		this.idExpediente = idExpediente;
	}
}
