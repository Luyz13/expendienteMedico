package com.levm.expendienteMedico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class SignoVital {
	
	@Id
	@GeneratedValue
	private int idSigno;
	
	private Long temperatura;
	private Long peso;
	private Long talla;
	

	public SignoVital(Long temperatura, Long peso, Long talla) {
		super();
		this.temperatura = temperatura;
		this.peso = peso;
		this.talla = talla;
	}
}
