package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IPacienteService;
import com.levm.expendienteMedico.entity.Paciente;
import com.levm.expendienteMedico.repository.IPacienteRepository;

@Service
public class PacienteService implements IPacienteService{
	
	
	private IPacienteRepository pacienteRepository;
	
	@Autowired
	public PacienteService(IPacienteRepository pacienteRepository )
	{
		this.pacienteRepository = pacienteRepository;
	}

	public List<Paciente> buscarPacientes() {
		return pacienteRepository.findAll();
	}

	public Optional<Paciente> buscarPaciente(int idPaciente) {
		return pacienteRepository.findById(idPaciente);
	}

	public void eliminarPaciente(Paciente paciente) {
		pacienteRepository.delete(paciente);
	}

	public void agregarPaciente(Paciente paciente) {
		pacienteRepository.save(paciente);
	}

	public void actualizarPaciente(Paciente paciente) {
		if(pacienteRepository.existsById(paciente.getIdPaciente()))
		{
			pacienteRepository.save(paciente);
		}
	}
}
