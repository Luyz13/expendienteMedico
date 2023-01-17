package com.levm.expendienteMedico.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Persona {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	
	@NotEmpty(message = "El sexo debe estar informado")
	@NotBlank(message ="El sexo no debe estar conformada por espacios")
	private String nombre;
	
	@NotEmpty(message = "El sexo debe estar informado")
	@NotBlank(message ="El sexo no debe estar conformada por espacios")
	private String apellidoMat;
	
	@NotEmpty(message = "El sexo debe estar informado")
	@NotBlank(message ="El sexo no debe estar conformada por espacios")
	private String apellidoPat;
	
	@Pattern(regexp = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$")
	private String fechaNacimiento;
	
	@NotEmpty(message = "El sexo debe estar informado")
	@NotBlank(message ="El sexo no debe estar conformada por espacios")
	private char sexo;

	
	public Persona(String nombre, String apellidoMat, String apellidoPat, String fechaNacimiento, char sexo) {
		this.nombre = nombre;
		this.apellidoMat = apellidoMat;
		this.apellidoPat = apellidoPat;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}
	
	
	public String getNombreCompleto(){
		StringBuilder sB = new StringBuilder();
		sB.append(this.nombre)
		.append(" ")
		.append(this.apellidoPat)
		.append(" ")
		.append(this.apellidoMat);
		
		return sB.toString();
	}

    @JsonIgnore
	public int getEdad() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(this.fechaNacimiento, formato);
		LocalDate fechaAct = LocalDate.now();
		Period periodo = Period.between(fechaNac, fechaAct);
		return periodo.getYears();
	}


	public Persona(int id) {
		this.id = id;
	}
}
