package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IMedicoService;
import com.levm.expendienteMedico.entity.Medico;
import com.levm.expendienteMedico.repository.IMedicoRepository;

@Service
public class MedicoService implements IMedicoService {
	
	private static Logger logger = LoggerFactory.getLogger(MedicoService.class);

	private IMedicoRepository medicoRepository;
	
	@Autowired
	public MedicoService(IMedicoRepository medicoRepository) {
		
		this.medicoRepository = medicoRepository;
	}

	@Override
	public List<Medico> getAll() {
		logger.info("Se ejecuta el proceso getAll de MedicoService");

		logger.info("Se ejecuta el proceso findAll de IMedicoRepository");
		
		return medicoRepository.findAll();
	}

	@Override
	public Optional<Medico> getById(String cedulaProfecional) {
		
		logger.info("Se ejecuta el proceso getById de MedicoService");

		logger.info("Se ejecuta el proceso findById de IMedicoRepository");

		return medicoRepository.findById(cedulaProfecional);
	}

	@Override
	public void delete(Medico medico) {
		logger.info("Inicia el proceso delete de MedicoService");

		logger.info("Inicia el proceso delete de IMedicoRepository");
		
		medicoRepository.delete(medico);
		
		logger.info("Termina el proceso delete de IMedicoRepository");
		
		logger.info("Termina el proceso delete de MedicoService");
	}

	@Override
	public void create(Medico medico) {
		
		logger.info("Inicia el proceso create de MedicoService");

		logger.info("Inicia el proceso save de IMedicoRepository");
		
		medicoRepository.save(medico);
		
		logger.info("Termina el proceso save de IMedicoRepository");
		
		logger.info("Termina el proceso create de MedicoService");		
	}

	@Override
	public void update(Medico medico) {
		logger.info("Inicia el proceso update de MedicoService");

		logger.info("Se valida la existencia del registro");
		
		if(medicoRepository.existsById(medico.getCedulaProfecional()))
		{
			logger.info("Inicia el proceso update del registro");
			
			medicoRepository.save(medico);
			
			logger.info("Termina el proceso update del registro");
		}
		logger.info("Termina el proceso update de MedicoService");
	}

}
