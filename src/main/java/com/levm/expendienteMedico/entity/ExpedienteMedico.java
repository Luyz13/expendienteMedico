package com.levm.expendienteMedico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class ExpedienteMedico {
	
	@Id
	@GeneratedValue
	private long idExpediente;
	
	private String fechaAlta;
	private String fechaActualizacion;
	
	

	public ExpedienteMedico(String fechaAlta, String fechaActualizacion) {
		super();
		this.fechaAlta = fechaAlta;
		this.fechaActualizacion = fechaActualizacion;
	}

	public ExpedienteMedico(long idExpediente) {
		this.idExpediente = idExpediente;
	}
}
