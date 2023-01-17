package com.levm.expendienteMedico.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name = "no_receta")
	Receta receta;
	
	public IndicacionGeneral(int idIndicacion, String comentario) {
		super();
		this.idIndicacion = idIndicacion;
		this.comentario = comentario;
	}



	public IndicacionGeneral(String comentario) {
		this.comentario = comentario;
	}
}
