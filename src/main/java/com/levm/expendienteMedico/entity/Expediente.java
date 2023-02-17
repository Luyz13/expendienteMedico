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
	
	private String fechaAlta;
	
	private String fechaActualizacion;
	
	

	public Expediente(String fechaAlta, String fechaActualizacion) {
		super();
		this.fechaAlta = fechaAlta;
		this.fechaActualizacion = fechaActualizacion;
	}

	public Expediente(long idExpediente) {
		this.idExpediente = idExpediente;
	}
}
