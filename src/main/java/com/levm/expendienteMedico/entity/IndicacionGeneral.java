package com.levm.expendienteMedico.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="indicaciones")
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
