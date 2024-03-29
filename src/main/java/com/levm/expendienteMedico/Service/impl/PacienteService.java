package com.levm.expendienteMedico.Service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.levm.expendienteMedico.Service.IPacienteService;
import com.levm.expendienteMedico.entity.Expediente;
import com.levm.expendienteMedico.entity.Paciente;
import com.levm.expendienteMedico.repository.IExpedienteRepository;
import com.levm.expendienteMedico.repository.IPacienteRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class PacienteService implements IPacienteService{

	
	private IPacienteRepository pacienteRepository;
	private IExpedienteRepository expedienteRepository;
	
	@Autowired
	public PacienteService(IPacienteRepository pacienteRepository,IExpedienteRepository expedienteRepository)
	{
		this.pacienteRepository = pacienteRepository;
		this.expedienteRepository = expedienteRepository;
	}

	public List<Paciente> buscarPacientes() {
		
		log.info("Se ejecuta el proceso getAll de PacienteService");

		log.info("Se ejecuta el proceso findAll de IPacienteRepository");
		
		return pacienteRepository.findAll();
	}
	public Paciente buscarPaciente(int idPaciente) {
		
		log.info("Se ejecuta el proceso getById de PacienteService");

		log.info("Se ejecuta el proceso findById de IPacienteRepository");
		
		return pacienteRepository.findById(idPaciente).orElse(null);
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

	public void actualizarPaciente(int idPaciente,Paciente paciente) {
		log.info("Inicia el proceso update de PacienteService");

		log.info("Se valida la existencia del registro");
		
		if(pacienteRepository.existsById(idPaciente))
		{
			log.info("Inicia el proceso update del registro");
			paciente.setId(idPaciente);
			paciente.setExpediente(pacienteRepository.findById(idPaciente).get().getExpediente());
			pacienteRepository.save(paciente);
			
			log.info("Termina el proceso update del registro");
		}
		log.info("Termina el proceso update de PacienteService");
	}

	@Override
	public void agregarExpediente(int idPaciente, Expediente expediente) {
		if(pacienteRepository.existsById(idPaciente)) {
			Paciente paciente=pacienteRepository.findById(idPaciente).orElse(null);
			expediente=expedienteRepository.findById(expediente.getIdExpediente()).orElse(null);
			paciente.setExpediente(expediente);
			pacienteRepository.save((Paciente)paciente);
		}
		
	}

	@Override
	public Collection<Paciente> findPacienteBySexo(char sexo) {
	
		return  pacienteRepository.findAll()
				.stream()
				.filter(paciente -> (Character.compare(paciente.getSexo(), sexo)==0))
				.collect(Collectors.toList());
				
				
	}
}
