package com.levm.expendienteMedico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Receta {
	
	@Id
	@GeneratedValue
	private int idReceta;
	
	private String padecimiento;
	
	private boolean alergias;

	public Receta() {
		super();
	}

	public Receta(int idReceta, String padecimiento, boolean alergias) {
		super();
		this.idReceta = idReceta;
		this.padecimiento = padecimiento;
		this.alergias = alergias;
	}

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public String getPadecimiento() {
		return padecimiento;
	}

	public void setPadecimiento(String padecimiento) {
		this.padecimiento = padecimiento;
	}

	public boolean isAlergias() {
		return alergias;
	}

	public void setAlergias(boolean alergias) {
		this.alergias = alergias;
	}
	
	

}
