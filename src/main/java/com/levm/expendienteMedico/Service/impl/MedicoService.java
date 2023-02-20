package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	public Medico getById(int medicoId) {
		
		log.info("Se ejecuta el proceso getById de MedicoService");

		log.info("Se ejecuta el proceso findById de IMedicoRepository");

		return medicoRepository.findById(medicoId).orElse(null);
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
	public Medico create(Medico medico) {
		
		log.info("Inicia el proceso create de MedicoService");

		log.info("Inicia el proceso save de IMedicoRepository");
		
		return medicoRepository.save(medico);
			
	}

	@Override
	public Medico update(int idMedico,Medico medico) {
		log.info("Inicia el proceso update de MedicoService");

		log.info("Se valida la existencia del registro");
		
		if(medicoRepository.existsById(idMedico))
		{
			log.info("Inicia el proceso update del registro");
			medico.setId(idMedico);
			return medicoRepository.save(medico);
			
			
		}
		return null;
	}

	@Override
	public List<Medico> getByUniversidad(String Universidad) {
		return medicoRepository.findAll()
				.stream()
				.filter(medico -> medico.getUniversidad().compareTo(Universidad) == 0)
				.collect(Collectors.toList());
				
	}

	@Override
	public Optional<Medico> getByCedula(String cedula) {
		// TODO Auto-generated method stub
		return medicoRepository.findBycedulaProfecional(cedula);
	}

}
