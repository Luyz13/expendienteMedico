package com.levm.expendienteMedico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Receta {
	
	@Id
	@GeneratedValue
	private int idReceta;
	
	private String padecimiento;
	
	private boolean alergias;

	public Receta(String padecimiento, boolean alergias) {
		super();
		this.padecimiento = padecimiento;
		this.alergias = alergias;
	}
}
