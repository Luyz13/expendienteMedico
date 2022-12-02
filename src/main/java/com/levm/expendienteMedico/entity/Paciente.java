package com.levm.expendienteMedico.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.*;
import java.util.Date;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="pacientes")
public class Paciente {
	
	@Id
	@GeneratedValue
	private int noExpediente;
	
	private String nombre;
	private String apellidoMat;
	private String apellidoPat;
	private String fechaNacimiento;
	private char sexo;
	
	public Paciente() {
		super();
	}

	public Paciente(int noExpediente) {
		super();
		this.noExpediente = noExpediente;
	}

	public Paciente(String nombre, String apellidoMat, String apellidoPat, String fechaNacimiento, char sexo) {
		super();
		this.nombre = nombre;
		this.apellidoMat = apellidoMat;
		this.apellidoPat = apellidoPat;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}
	

	public int getNoExpediente() {
		return noExpediente;
	}

	public void setNoExpediente(int noExpediente) {
		this.noExpediente = noExpediente;
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
		StringBuilder sB = null;
		sB.append(this.nombre)
		.append(" ")
		.append(this.apellidoPat)
		.append(" ")
		.append(this.apellidoMat);
		
		return sB.toString();
	}
	
	public int getEdad() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(this.fechaNacimiento, formato);
		LocalDate fechaAct = LocalDate.now();
		Period periodo = Period.between(fechaNac, fechaAct);
		return periodo.getYears();
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidoMat, apellidoPat, fechaNacimiento, noExpediente, nombre, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(apellidoMat, other.apellidoMat) && Objects.equals(apellidoPat, other.apellidoPat)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && noExpediente == other.noExpediente
				&& Objects.equals(nombre, other.nombre) && sexo == other.sexo;
	}
	
	
	
}
