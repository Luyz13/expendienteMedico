package com.levm.expendienteMedico.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	public Persona() {
	}

	public Persona(String nombre, String apellidoMat, String apellidoPat, String fechaNacimiento, char sexo) {
		this.nombre = nombre;
		this.apellidoMat = apellidoMat;
		this.apellidoPat = apellidoPat;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoMat() {
		return apellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	public String getApellidoPat() {
		return apellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
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

	@Override
	public int hashCode() {
		return Objects.hash(apellidoMat, apellidoPat, fechaNacimiento, nombre, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidoMat, other.apellidoMat) && Objects.equals(apellidoPat, other.apellidoPat)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && Objects.equals(nombre, other.nombre)
				&& sexo == other.sexo;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidoMat=" + apellidoMat + ", apellidoPat=" + apellidoPat
				+ ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + "]";
	}
	
	
	
	
	
	

}
