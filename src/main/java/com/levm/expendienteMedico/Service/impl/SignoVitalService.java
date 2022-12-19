package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.ISignoVitalService;
import com.levm.expendienteMedico.entity.SignoVital;
import com.levm.expendienteMedico.repository.ISignoVitalRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SignoVitalService implements ISignoVitalService{
		
	private ISignoVitalRepository signoRepository;
	
	@Autowired
	public SignoVitalService(ISignoVitalRepository signoRepository) {
		this.signoRepository = signoRepository;
	}

	@Override
	public List<SignoVital> getAll() {
		
		log.info("Se ejecuta el proceso getAll de SignoVitalService");

		log.info("Se ejecuta el proceso findAll de ISignoVital");

		return signoRepository.findAll();
	}

	@Override
	public Optional<SignoVital> getById(int idSigno) {
		
		log.info("Se ejecuta el proceso getById de SignoVitalService");

		log.info("Se ejecuta el proceso findById de ISignoVital");

		return signoRepository.findById(idSigno);
	}

	@Override
	public void delete(SignoVital signo) {
		log.info("Inicia el proceso delete de SignoVitalService");

		log.info("Inicia el proceso delete de ISignoVital");
		
		signoRepository.delete(signo);
		
		log.info("Termina el proceso delete de ISignoVital");

		log.info("Termina el proceso delete de SignoVitalService");
	}

	@Override
	public void create(SignoVital signo) {
		log.info("Inicia el proceso create de SignoVitalService");

		log.info("Inicia el proceso save de ISignoVital");
		
		signoRepository.save(signo);
		
		log.info("Termina el proceso save de ISignoVital");
		
		log.info("Termina el proceso create de SignoVitalService");
	}

	@Override
	public void update(int idSigno,SignoVital signo) {
		log.info("Inicia el proceso update de SignoVitalService");

		log.info("Se valida la existencia del registro");
		
		if(signoRepository.existsById(idSigno)) {
			log.info("Inicia el proceso update del registro");
			
			signo.setIdSigno(idSigno);
			signoRepository.save(signo);
			
			log.info("Termina el proceso update del registro");
		}
		log.info("Termina el proceso update de SignoVitalService");
	}
}
