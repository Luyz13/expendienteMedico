package com.levm.expendienteMedico.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="medicos")
public class Medico extends Persona {
	
	@NotEmpty(message = "La cedula profesional debe estar informada")
	@Size(min = 7, max= 10, message = "La denominación debe tener entre 7 y 10 caracteres")
	@NotBlank(message ="La denominación no debe estar conformada por espacios")
	private String cedulaProfecional;
	
	@NotEmpty(message = "La cedula profesional debe estar informada")
	@Size(min = 4, max= 30, message = "La denominación debe tener entre 4 y 30 caracteres")
	@NotBlank(message ="La denominación no debe estar conformada por espacios")
	private String universidad;
	
	public Medico(int Id,String cedulaProfecional,String universidad,String nombre, String apellidoPaterno,String apellidoMaterno, String fechaNacimiento, char sexo) {
		super(Id,nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, sexo);
		this.cedulaProfecional = cedulaProfecional;
		this.universidad = universidad;
	}
	
	public Medico(String cedulaProfecional,String universidad,String nombre, String apellidoPaterno,String apellidoMaterno, String fechaNacimiento, char sexo) {
		super(nombre,  apellidoPaterno,apellidoMaterno, fechaNacimiento, sexo);
		this.cedulaProfecional = cedulaProfecional;
		this.universidad = universidad;
	}
	
	public Medico(int id) {
		super(id);
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
}
