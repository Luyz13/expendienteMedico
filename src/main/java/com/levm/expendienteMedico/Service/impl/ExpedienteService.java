package com.levm.expendienteMedico.Service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IExpedienteService;
import com.levm.expendienteMedico.entity.Expediente;
import com.levm.expendienteMedico.repository.IExpedienteRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ExpedienteService implements IExpedienteService {
		
	private IExpedienteRepository expedienteRepository;

	@Autowired
	public ExpedienteService(IExpedienteRepository expedienteRepository) {
		this.expedienteRepository = expedienteRepository;
	}

	public List<Expediente> getAll() {
		log.info("Se ejecuta el proceso getAll de ExpedienteService");
		
		log.info("Se ejecuta el proceso findAll de IExpedienteMedicoRepository");
		
		return expedienteRepository.findAll();
	}

	public Optional<Expediente> getById(Long idExpediente) {
		
		log.info("Se ejecuta el proceso getById de ExpedienteService");
		
		log.info("Se ejecuta el proceso findById de IExpedienteMedicoRepository");
		
		return expedienteRepository.findById(idExpediente);
		
	}

	public void delete(Expediente expediente) {
		
		log.info("Inicia el proceso delete de ExpedienteService");
		
		log.info("Inicia el proceso delete de IExpedienteMedicoRepository");
		
		expedienteRepository.delete(expediente);
		
		log.info("Termina el proceso delete de IExpedienteMedicoRepository");

		log.info("Termina el proceso delete de IExpedienteMedicoRepository");
	}

	public void create(Expediente expediente) {
		log.info("Inicia el proceso create de ExpedienteService");
		
		log.info("Inicia el proceso save de IExpedienteMedicoRepository");
		
		expedienteRepository.save(expediente);
		
		log.info("Termina el proceso save de IExpedienteMedicoRepository");
		
		log.info("Termina el proceso create de ExpedienteService");
		
	}
	public void update( long idExpediente,Expediente expediente) {
		log.info("Inicia el proceso update de ExpedienteService");
		
		log.info("Se valida la existencia del registro");
		
		if(expedienteRepository.existsById(idExpediente))
		{
			log.info("Inicia el proceso update del registro");
			expediente.setIdExpediente(idExpediente);
			expedienteRepository.save(expediente);
			log.info("Termina el proceso update del registro");
		}
		
		log.info("Termina el proceso update de ExpedienteService");
		
	}

	@Override
	public List<Expediente> getByfechaAltaLessThanEqual(Date fechaAlta) {
		
		return expedienteRepository.findByfechaAltaLessThanEqual(fechaAlta);
	}

	@Override
	public List<Expediente> getByfechaAltaGreaterThanEqual(Date fechaAlta) {
		
		return expedienteRepository.findByfechaAltaGreaterThanEqual(fechaAlta);
	}
	
	

}
