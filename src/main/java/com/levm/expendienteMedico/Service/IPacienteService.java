package com.levm.expendienteMedico.Service;

import java.util.Collection;
import java.util.List;

import com.levm.expendienteMedico.entity.Expediente;
import com.levm.expendienteMedico.entity.Paciente;

public interface IPacienteService {
	
	List<Paciente> buscarPacientes();

	Paciente buscarPaciente(int noExpediente);
	
	Collection<Paciente> findPacienteBySexo(char sexo);

	void eliminarPaciente(Paciente paciente);

	void agregarPaciente(Paciente paciente);

	void actualizarPaciente(int idPaciente,Paciente paciente);
	
	void agregarExpediente(int idPaciente,Expediente expediente);

}
