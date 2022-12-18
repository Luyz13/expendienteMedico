package com.levm.expendienteMedico.entity;

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
	
	private Long temperatura;
	private Long peso;
	private Long talla;
	
	@OneToOne(mappedBy = "signos")
	private Receta receta;
	
	
	

	public SignoVital(Long temperatura, Long peso, Long talla) {
		super();
		this.temperatura = temperatura;
		this.peso = peso;
		this.talla = talla;
	}
}
