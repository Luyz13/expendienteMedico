package com.levm.expendienteMedico.entity;

import javax.persistence.*;

@Entity
@Table(name="pacientes")
public class Paciente {
	
	@Id
	private int id;
	
	private String nombre;
	private String apellidoMat;
	private String apellidoPat;
	private String fechaNacimiento;
	private char sexo;
	
	public Paciente() {
		super();
	}

	public Paciente(int id) {
		super();
		this.id = id;
	}

	public Paciente(String nombre, String apellidoMat, String apellidoPat, String fechaNacimiento, char sexo) {
		super();
		this.nombre = nombre;
		this.apellidoMat = apellidoMat;
		this.apellidoPat = apellidoPat;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}
}
