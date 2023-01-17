package com.levm.expendienteMedico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name="recetas")
public class Receta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReceta;
	
	private String padecimiento;
	
	private boolean alergias;
	

	@ManyToOne
	@JoinColumn(name = "no_expediente")
	ExpedienteMedico expedienteMedico;
	
	@ManyToOne
	@JoinColumn(name = "id_medico")
	Medico medico;
	
	@OneToOne
	@JoinColumn(name = "id_signo", referencedColumnName = "id_signo")
	private SignoVital signos;
	
	
	

	public Receta(String padecimiento, boolean alergias) {
		super();
		this.padecimiento = padecimiento;
		this.alergias = alergias;
	}



	public Receta(int idReceta) {
		this.idReceta = idReceta;
	}
}
