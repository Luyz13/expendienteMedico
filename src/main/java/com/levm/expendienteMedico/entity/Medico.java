package com.levm.expendienteMedico.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="medicos")
public class Medico extends Persona {
	
	private String cedulaProfecional;
	private String universidad;
	
	
	

	public Medico(String cedulaProfecional, String universidad) {
		super();
		this.cedulaProfecional = cedulaProfecional;
		this.universidad = universidad;
	}

	public Medico(String cedulaProfecional,String universidad,String nombre, String apellidoMat, String apellidoPat, String fechaNacimiento, char sexo) {
		super(nombre, apellidoMat, apellidoPat, fechaNacimiento, sexo);
		this.cedulaProfecional = cedulaProfecional;
		this.universidad = universidad;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cedulaProfecional, universidad);
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
		Medico other = (Medico) obj;
		return Objects.equals(cedulaProfecional, other.cedulaProfecional)
				&& Objects.equals(universidad, other.universidad);
	}

	public Medico(int id) {
		super(id);
	}
}
