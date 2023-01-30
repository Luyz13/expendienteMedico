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
@Table(name="medicamentos")
public class Medicamento {
	
	@Id
	@GeneratedValue
	private Long idMedicamento;
	
	@NotEmpty(message = "La denominación debe estar informada")
	@Size(min = 4, max= 30, message = "La denominación debe tener entre 4 y 30 caracteres")
	@NotBlank(message ="La denominación no debe estar conformada por espacios")
	private String denominacion;
	
	@NotEmpty(message = "La via de admintración debe estar informada")
	@NotBlank(message ="La  via de admintración  no debe estar conformada por espacios")
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
	public Medicamento(Long idMedicamento,String denominacion, String viaAdministracion, String frecuencia, String duracion) {
		super();
		this.idMedicamento=idMedicamento;
		this.denominacion = denominacion;
		this.viaAdministracion = viaAdministracion;
		this.frecuencia = frecuencia;
		this.duracion = duracion;
	}
	

}
