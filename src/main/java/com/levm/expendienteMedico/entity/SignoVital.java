package com.levm.expendienteMedico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SignoVital {
	
	@Id
	@GeneratedValue
	private int idSigno;
	
	private Long temperatura;
	private Long peso;
	private Long talla;
	
	public SignoVital() {
		super();
	}

	public SignoVital(Long temperatura, Long peso, Long talla) {
		super();
		this.temperatura = temperatura;
		this.peso = peso;
		this.talla = talla;
	}

	public int getIdSigno() {
		return idSigno;
	}

	public void setIdSigno(int idSigno) {
		this.idSigno = idSigno;
	}

	public Long getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Long temperatura) {
		this.temperatura = temperatura;
	}

	public Long getPeso() {
		return peso;
	}

	public void setPeso(Long peso) {
		this.peso = peso;
	}

	public Long getTalla() {
		return talla;
	}

	public void setTalla(Long talla) {
		this.talla = talla;
	}
}
