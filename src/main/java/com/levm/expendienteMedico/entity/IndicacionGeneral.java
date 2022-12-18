package com.levm.expendienteMedico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class IndicacionGeneral {
	
	@Id
	@GeneratedValue
	private int idIndicacion;
	
	private String comentario;

	public IndicacionGeneral(int idIndicacion, String comentario) {
		super();
		this.idIndicacion = idIndicacion;
		this.comentario = comentario;
	}
}
