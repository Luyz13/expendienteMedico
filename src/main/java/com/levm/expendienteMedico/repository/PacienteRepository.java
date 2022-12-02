package com.levm.expendienteMedico.repository;

import java.util.List;

import com.levm.expendienteMedico.entity.Paciente;

public interface PacienteRepository {
	
	List<Paciente> buscarPacientes();
	
	Paciente buscarPaciente(int noExpediente);
	
	void eliminarPaciente(Paciente paciente);
	
	void agregarPaciente(Paciente paciente);
	
	void actualizarPaciente(Paciente paciente);
	

}
