package com.levm.expendienteMedico.Service;

import java.util.List;

import com.levm.expendienteMedico.entity.ExpedienteMedico;
import com.levm.expendienteMedico.entity.Paciente;

public interface IPacienteService {
	
	List<Paciente> buscarPacientes();

	Paciente buscarPaciente(int noExpediente);

	void eliminarPaciente(Paciente paciente);

	void agregarPaciente(Paciente paciente);

	void actualizarPaciente(int idPaciente,Paciente paciente);
	
	void agregarExpediente(int idPaciente,ExpedienteMedico expediente);

}
