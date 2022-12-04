package com.levm.expendienteMedico.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.entity.Paciente;
import com.levm.expendienteMedico.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;

	public List<Paciente> buscarPacientes() {
		return pacienteRepository.buscarPacientes();
	}

	public Paciente buscarPaciente(int noExpediente) {
		return pacienteRepository.buscarPaciente(noExpediente);
	}

	public void eliminarPaciente(Paciente paciente) {
		pacienteRepository.eliminarPaciente(paciente);
	}

	public void agregarPaciente(Paciente paciente) {
		pacienteRepository.agregarPaciente(paciente);
	}

	public void actualizarPaciente(Paciente paciente) {
		pacienteRepository.actualizarPaciente(paciente);
	}

	public int hashCode() {
		return pacienteRepository.hashCode();
	}

	public boolean equals(Object obj) {
		return pacienteRepository.equals(obj);
	}

	public String toString() {
		return pacienteRepository.toString();
	}
	
	
	

}
