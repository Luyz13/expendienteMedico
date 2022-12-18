package com.levm.expendienteMedico.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Persona {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;
	private String nombre;
	private String apellidoMat;
	private String apellidoPat;
	private String fechaNacimiento;
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
}
