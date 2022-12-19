package com.levm.expendienteMedico.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class SignoVital {
	
	@Id
	@GeneratedValue
	@Column(name = "id_signo")
	private int idSigno;
	
	private double temperatura;
	private double peso;
	private double talla;
	
	@JsonIgnore
	@OneToOne(mappedBy = "signos")
	private Receta receta;
	
	
	

	public SignoVital(double temperatura, double peso, double talla) {
		super();
		this.temperatura = temperatura;
		this.peso = peso;
		this.talla = talla;
	}

	public SignoVital(int idSigno) {
		this.idSigno = idSigno;
	}
}
