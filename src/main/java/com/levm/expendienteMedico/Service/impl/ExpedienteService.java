package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IExpedienteService;
import com.levm.expendienteMedico.entity.ExpedienteMedico;
import com.levm.expendienteMedico.repository.IExpedienteMedicoRepository;

@Service
public class ExpedienteService implements IExpedienteService {
	
	private static Logger logger = LoggerFactory.getLogger(ExpedienteService.class);
	
	private IExpedienteMedicoRepository expedienteRepository;

	@Autowired
	public ExpedienteService(IExpedienteMedicoRepository expedienteRepository) {
		this.expedienteRepository = expedienteRepository;
	}

	public List<ExpedienteMedico> getAll() {
		logger.info("Se ejecuta el proceso getAll de ExpedienteService");
		
		logger.info("Se ejecuta el proceso findAll de IExpedienteMedicoRepository");
		
		return expedienteRepository.findAll();
	}

	public Optional<ExpedienteMedico> getById(Long idExpediente) {
		
		logger.info("Se ejecuta el proceso getById de ExpedienteService");
		
		logger.info("Se ejecuta el proceso findById de IExpedienteMedicoRepository");
		
		return expedienteRepository.findById(idExpediente);
		
	}

	public void delete(ExpedienteMedico expediente) {
		
		logger.info("Inicia el proceso delete de ExpedienteService");
		
		logger.info("Inicia el proceso delete de IExpedienteMedicoRepository");
		
		expedienteRepository.delete(expediente);
		
		logger.info("Termina el proceso delete de IExpedienteMedicoRepository");

		logger.info("Termina el proceso delete de IExpedienteMedicoRepository");
	}

	public void create(ExpedienteMedico expediente) {
		logger.info("Inicia el proceso create de ExpedienteService");
		
		logger.info("Inicia el proceso save de IExpedienteMedicoRepository");
		
		expedienteRepository.save(expediente);
		
		logger.info("Termina el proceso save de IExpedienteMedicoRepository");
		
		logger.info("Termina el proceso create de ExpedienteService");
		
	}
	public void update(ExpedienteMedico expediente) {
		logger.info("Inicia el proceso update de ExpedienteService");
		
		logger.info("Se valida la existencia del registro");
		
		if(expedienteRepository.existsById(expediente.getIdExpediente()))
		{
			logger.info("Inicia el proceso update del registro");
			expedienteRepository.save(expediente);
			logger.info("Termina el proceso update del registro");
		}
		
		logger.info("Termina el proceso update de ExpedienteService");
		
	}
	
	

}
