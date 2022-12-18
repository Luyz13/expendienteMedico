package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.levm.expendienteMedico.Service.IPacienteService;
import com.levm.expendienteMedico.entity.Paciente;
import com.levm.expendienteMedico.repository.IPacienteRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class PacienteService implements IPacienteService{

	
	private IPacienteRepository pacienteRepository;
	
	@Autowired
	public PacienteService(IPacienteRepository pacienteRepository )
	{
		this.pacienteRepository = pacienteRepository;
	}

	public List<Paciente> buscarPacientes() {
		
		log.info("Se ejecuta el proceso getAll de PacienteService");

		log.info("Se ejecuta el proceso findAll de IPacienteRepository");
		
		return pacienteRepository.findAll();
	}

	public Optional<Paciente> buscarPaciente(int idPaciente) {
		
		log.info("Se ejecuta el proceso getById de PacienteService");

		log.info("Se ejecuta el proceso findById de IPacienteRepository");
		
		return pacienteRepository.findById(idPaciente);
	}

	public void eliminarPaciente(Paciente paciente) {
		log.info("Inicia el proceso delete de PacienteService");

		log.info("Inicia el proceso delete de IPacienteRepository");
		
		pacienteRepository.delete(paciente);
		
		log.info("Termina el proceso delete de IPacienteRepository");

		log.info("Termina el proceso delete de PacienteService");
	}

	public void agregarPaciente(Paciente paciente) {
		log.info("Inicia el proceso create de PacienteService");

		log.info("Inicia el proceso save de IPacienteRepository");
		
		pacienteRepository.save(paciente);
		
		log.info("Termina el proceso save de IPacienteRepository");
		
		log.info("Termina el proceso create de PacienteService");
	}

	public void actualizarPaciente(Paciente paciente) {
		log.info("Inicia el proceso update de PacienteService");

		log.info("Se valida la existencia del registro");
		
		if(pacienteRepository.existsById(paciente.getId()))
		{
			log.info("Inicia el proceso update del registro");
			
			pacienteRepository.save(paciente);
			
			log.info("Termina el proceso update del registro");
		}
		log.info("Termina el proceso update de PacienteService");
	}
}
