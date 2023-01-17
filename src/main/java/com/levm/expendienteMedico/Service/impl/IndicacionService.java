package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IIndicacionService;
import com.levm.expendienteMedico.entity.IndicacionGeneral;
import com.levm.expendienteMedico.repository.IIndicacionGeneralRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IndicacionService implements IIndicacionService{
		
	private IIndicacionGeneralRepository indicacionRepository;

	@Autowired
	public IndicacionService(IIndicacionGeneralRepository indicacionRepository) {
		this.indicacionRepository = indicacionRepository;
	}

	@Override
	public List<IndicacionGeneral> getAll() {
		log.info("Se ejecuta el proceso getAll de ExpedienteService");

		log.info("Se ejecuta el proceso findAll de IIndicacionGeneralRepository");
		
		return indicacionRepository.findAll();
	}

	@Override
	public Optional<IndicacionGeneral> getById(int idIndicacion) {

		log.info("Se ejecuta el proceso getById de ExpedienteService");	

		log.info("Se ejecuta el proceso findById de IIndicacionGeneralRepository");
		
		return indicacionRepository.findById(idIndicacion);
	}

	@Override
	public void delete(IndicacionGeneral indicacion) {
		log.info("Inicia el proceso delete de ExpedienteService");

		log.info("Inicia el proceso delete de IIndicacionGeneralRepository");
		
		indicacionRepository.delete(indicacion);
		
		log.info("Termina el proceso delete de IIndicacionGeneralRepository");

		log.info("Termina el proceso delete de ExpedienteService");
		
	}

	@Override
	public void create(IndicacionGeneral indicacion) {
		log.info("Inicia el proceso create de ExpedienteService");

		log.info("Inicia el proceso save de IIndicacionGeneralRepository"); 
		
		indicacionRepository.save(indicacion);
		
		log.info("Termina el proceso save de IIndicacionGeneralRepository");
		
		log.info("Termina el proceso create de ExpedienteService");
		
	}

	@Override
	public void update(int idIndicacion,IndicacionGeneral indicacion) {
		log.info("Inicia el proceso update de ExpedienteService");

		log.info("Se valida la existencia del registro");
		
		if(indicacionRepository.existsById(idIndicacion))
		{
			log.info("Inicia el proceso update del registro");
			indicacion.setIdIndicacion(idIndicacion);
			indicacionRepository.save(indicacion);
			
			log.info("Termina el proceso update del registro");
		}
		log.info("Termina el proceso update de ExpedienteService");
	}
	
	
	

}
