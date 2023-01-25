package com.levm.expendienteMedico.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

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
public class ExpedienteMedico {
	
	@Id
	@GeneratedValue
	private long idExpediente;
	
	@CreationTimestamp
	private Date fechaAlta;
	
	@CreationTimestamp
	private Date fechaActualizacion;
	
	

	public ExpedienteMedico(Date fechaAlta, Date fechaActualizacion) {
		super();
		this.fechaAlta = fechaAlta;
		this.fechaActualizacion = fechaActualizacion;
	}

	public ExpedienteMedico(long idExpediente) {
		this.idExpediente = idExpediente;
	}
}
