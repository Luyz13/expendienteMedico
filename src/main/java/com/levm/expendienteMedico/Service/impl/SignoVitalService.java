package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.ISignoVitalService;
import com.levm.expendienteMedico.entity.SignoVital;
import com.levm.expendienteMedico.repository.ISignoVital;

@Service
public class SignoVitalService implements ISignoVitalService{
	
	private static Logger logger = LoggerFactory.getLogger(SignoVitalService.class);
	
	private ISignoVital signoRepository;
	
	@Autowired
	public SignoVitalService(ISignoVital signoRepository) {
		this.signoRepository = signoRepository;
	}

	@Override
	public List<SignoVital> getAll() {
		
		logger.info("Se ejecuta el proceso getAll de SignoVitalService");

		logger.info("Se ejecuta el proceso findAll de ISignoVital");

		return signoRepository.findAll();
	}

	@Override
	public Optional<SignoVital> getById(int idSigno) {
		
		logger.info("Se ejecuta el proceso getById de SignoVitalService");

		logger.info("Se ejecuta el proceso findById de ISignoVital");

		return signoRepository.findById(idSigno);
	}

	@Override
	public void delete(SignoVital signo) {
		logger.info("Inicia el proceso delete de SignoVitalService");

		logger.info("Inicia el proceso delete de ISignoVital");
		
		signoRepository.delete(signo);
		
		logger.info("Termina el proceso delete de ISignoVital");

		logger.info("Termina el proceso delete de SignoVitalService");
	}

	@Override
	public void create(SignoVital signo) {
		logger.info("Inicia el proceso create de SignoVitalService");

		logger.info("Inicia el proceso save de ISignoVital");
		
		signoRepository.save(signo);
		
		logger.info("Termina el proceso save de ISignoVital");
		
		logger.info("Termina el proceso create de SignoVitalService");
	}

	@Override
	public void update(SignoVital signo) {
		logger.info("Inicia el proceso update de SignoVitalService");

		logger.info("Se valida la existencia del registro");
		
		if(signoRepository.existsById(signo.getIdSigno())) {
			logger.info("Inicia el proceso update del registro");
			
			signoRepository.save(signo);
			
			logger.info("Termina el proceso update del registro");
		}
		logger.info("Termina el proceso update de SignoVitalService");
	}
}
