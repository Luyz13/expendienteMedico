package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IMedicoService;
import com.levm.expendienteMedico.entity.Medico;
import com.levm.expendienteMedico.repository.IMedicoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicoService implements IMedicoService {
	
	private IMedicoRepository medicoRepository;
	
	@Autowired
	public MedicoService(IMedicoRepository medicoRepository) {
		
		this.medicoRepository = medicoRepository;
	}

	@Override
	public List<Medico> getAll() {
		log.info("Se ejecuta el proceso getAll de MedicoService");

		log.info("Se ejecuta el proceso findAll de IMedicoRepository");
		
		return medicoRepository.findAll();
	}

	@Override
	public Optional<Medico> getById(int medicoId) {
		
		log.info("Se ejecuta el proceso getById de MedicoService");

		log.info("Se ejecuta el proceso findById de IMedicoRepository");

		return medicoRepository.findById(medicoId);
	}

	@Override
	public void delete(Medico medico) {
		log.info("Inicia el proceso delete de MedicoService");

		log.info("Inicia el proceso delete de IMedicoRepository");
		
		medicoRepository.delete(medico);
		
		log.info("Termina el proceso delete de IMedicoRepository");
		
		log.info("Termina el proceso delete de MedicoService");
	}

	@Override
	public void create(Medico medico) {
		
		log.info("Inicia el proceso create de MedicoService");

		log.info("Inicia el proceso save de IMedicoRepository");
		
		medicoRepository.save(medico);
		
		log.info("Termina el proceso save de IMedicoRepository");
		
		log.info("Termina el proceso create de MedicoService");		
	}

	@Override
	public void update(int idMedico,Medico medico) {
		log.info("Inicia el proceso update de MedicoService");

		log.info("Se valida la existencia del registro");
		
		if(medicoRepository.existsById(idMedico))
		{
			log.info("Inicia el proceso update del registro");
			medico.setId(idMedico);
			medicoRepository.save(medico);
			
			log.info("Termina el proceso update del registro");
		}
		log.info("Termina el proceso update de MedicoService");
	}

}
