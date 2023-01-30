package com.levm.expendienteMedico.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="indicaciones")
public class Indicacion {
	
	@Id
	@GeneratedValue
	private int idIndicacion;
	
	@NotEmpty(message = "El comentario debe estar informado")
	@Size(min = 4, max= 30, message = "El comentario debe tener entre 4 y 30 caracteres")
	@NotBlank(message ="El comentario no deben ser puros espacios")
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name = "no_receta")
	Receta receta;
	
	public Indicacion(int idIndicacion, String comentario) {
		super();
		this.idIndicacion = idIndicacion;
		this.comentario = comentario;
	}
	public Indicacion(int idIndicacion) {
		super();
		this.idIndicacion = idIndicacion;
	}

	public Indicacion(String comentario) {
		this.comentario = comentario;
	}
}
