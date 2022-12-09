package com.levm.expendienteMedico.entity;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="pacientes")
public class Paciente extends Persona{
	
	@Id
	@GeneratedValue
	private int idPaciente;

	public Paciente() {
		super();
	}

	public Paciente(String nombre, String apellidoMat, String apellidoPat, String fechaNacimiento, char sexo) {
		super(nombre, apellidoMat, apellidoPat, fechaNacimiento, sexo);

	}
	
	public Paciente(int idPaciente,String nombre, String apellidoMat, String apellidoPat, String fechaNacimiento, char sexo) {
		super(nombre, apellidoMat, apellidoPat, fechaNacimiento, sexo);
		this.idPaciente=idPaciente;

	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idPaciente);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return idPaciente == other.idPaciente;
	}
	
	
	
	
	
	
	
	
	
		
}
