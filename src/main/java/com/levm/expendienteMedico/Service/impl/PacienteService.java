package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IPacienteService;
import com.levm.expendienteMedico.entity.Paciente;
import com.levm.expendienteMedico.repository.IPacienteRepository;

@Service
public class PacienteService implements IPacienteService{
	private static Logger logger = LoggerFactory.getLogger(PacienteService.class);
	
	private IPacienteRepository pacienteRepository;
	
	@Autowired
	public PacienteService(IPacienteRepository pacienteRepository )
	{
		this.pacienteRepository = pacienteRepository;
	}

	public List<Paciente> buscarPacientes() {
		
		logger.info("Se ejecuta el proceso getAll de PacienteService");

		logger.info("Se ejecuta el proceso findAll de IPacienteRepository");
		
		return pacienteRepository.findAll();
	}

	public Optional<Paciente> buscarPaciente(int idPaciente) {
		
		logger.info("Se ejecuta el proceso getById de PacienteService");

		logger.info("Se ejecuta el proceso findById de IPacienteRepository");
		
		return pacienteRepository.findById(idPaciente);
	}

	public void eliminarPaciente(Paciente paciente) {
		logger.info("Inicia el proceso delete de PacienteService");

		logger.info("Inicia el proceso delete de IPacienteRepository");
		
		pacienteRepository.delete(paciente);
		
		logger.info("Termina el proceso delete de IPacienteRepository");

		logger.info("Termina el proceso delete de PacienteService");
	}

	public void agregarPaciente(Paciente paciente) {
		logger.info("Inicia el proceso create de PacienteService");

		logger.info("Inicia el proceso save de IPacienteRepository");
		
		pacienteRepository.save(paciente);
		
		logger.info("Termina el proceso save de IPacienteRepository");
		
		logger.info("Termina el proceso create de PacienteService");
	}

	public void actualizarPaciente(Paciente paciente) {
		logger.info("Inicia el proceso update de PacienteService");

		logger.info("Se valida la existencia del registro");
		
		if(pacienteRepository.existsById(paciente.getId()))
		{
			logger.info("Inicia el proceso update del registro");
			
			pacienteRepository.save(paciente);
			
			logger.info("Termina el proceso update del registro");
		}
		logger.info("Termina el proceso update de PacienteService");
	}
}
