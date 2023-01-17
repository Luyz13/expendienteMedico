package com.levm.expendienteMedico.entity;

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
public class Medicamento {
	
	@Id
	@GeneratedValue
	private Long idMedicamento;
	
	private String denominacion;
	private String viaAdministracion;
	private String frecuencia;
	private String duracion;
	
	@ManyToOne
	@JoinColumn(name = "no_receta")
	Receta receta;

	public Medicamento(String denominacion, String viaAdministracion, String frecuencia, String duracion) {
		super();
		this.denominacion = denominacion;
		this.viaAdministracion = viaAdministracion;
		this.frecuencia = frecuencia;
		this.duracion = duracion;
	}

}
