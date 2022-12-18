package com.levm.expendienteMedico.entity;

import jakarta.persistence.*;

@Entity
@Table(name="pacientes")
public class Paciente extends Persona{
	

	public Paciente() {
	}

	public Paciente(String nombre, String apellidoMat, String apellidoPat, String fechaNacimiento, char sexo) {
		super(nombre, apellidoMat, apellidoPat, fechaNacimiento, sexo);

	}		
}
