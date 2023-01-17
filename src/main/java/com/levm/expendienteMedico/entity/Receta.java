package com.levm.expendienteMedico.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
	
	@NotEmpty(message = "El padecimiento debe estar informado")
	@Size(min = 4, max= 30, message = "El padecimiento debe tener entre 4 y 30 caracteres")
	@NotBlank(message ="El padecimiento no debe estar conformada por espacios")
	private String padecimiento;
	
	@NotEmpty(message = "La alergias deben estar informado")
	@NotBlank(message ="Las alergias no debe estar conformada por espacios")
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
