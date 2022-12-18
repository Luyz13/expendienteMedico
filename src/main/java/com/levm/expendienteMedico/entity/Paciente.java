package com.levm.expendienteMedico.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="pacientes")
public class Paciente extends Persona{
	
	@OneToOne
	@JoinColumn(name="expedienteId", referencedColumnName ="idExpediente")
	private ExpedienteMedico expediente;
	
	

	public Paciente(String nombre, String apellidoMat, String apellidoPat, String fechaNacimiento, char sexo) {
		super(nombre, apellidoMat, apellidoPat, fechaNacimiento, sexo);

	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}	
	
}
