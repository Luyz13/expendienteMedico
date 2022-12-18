package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IIndicacionService;
import com.levm.expendienteMedico.entity.IndicacionGeneral;
import com.levm.expendienteMedico.repository.IIndicacionGeneralRepository;

@Service
public class IndicacionService implements IIndicacionService{
	
	private static Logger logger = LoggerFactory.getLogger(IndicacionService.class);
	
	private IIndicacionGeneralRepository indicacionRepository;

	@Autowired
	public IndicacionService(IIndicacionGeneralRepository indicacionRepository) {
		this.indicacionRepository = indicacionRepository;
	}

	@Override
	public List<IndicacionGeneral> getAll() {
		logger.info("Se ejecuta el proceso getAll de ExpedienteService");

		logger.info("Se ejecuta el proceso findAll de IIndicacionGeneralRepository");
		
		return indicacionRepository.findAll();
	}

	@Override
	public Optional<IndicacionGeneral> getById(int idIndicacion) {

		logger.info("Se ejecuta el proceso getById de ExpedienteService");	

		logger.info("Se ejecuta el proceso findById de IIndicacionGeneralRepository");
		
		return indicacionRepository.findById(idIndicacion);
	}

	@Override
	public void delete(IndicacionGeneral indicacion) {
		logger.info("Inicia el proceso delete de ExpedienteService");

		logger.info("Inicia el proceso delete de IIndicacionGeneralRepository");
		
		indicacionRepository.delete(indicacion);
		
		logger.info("Termina el proceso delete de IIndicacionGeneralRepository");

		logger.info("Termina el proceso delete de ExpedienteService");
		
	}

	@Override
	public void create(IndicacionGeneral indicacion) {
		logger.info("Inicia el proceso create de ExpedienteService");

		logger.info("Inicia el proceso save de IIndicacionGeneralRepository"); 
		
		indicacionRepository.save(indicacion);
		
		logger.info("Termina el proceso save de IIndicacionGeneralRepository");
		
		logger.info("Termina el proceso create de ExpedienteService");
		
	}

	@Override
	public void update(IndicacionGeneral indicacion) {
		logger.info("Inicia el proceso update de ExpedienteService");

		logger.info("Se valida la existencia del registro");
		
		if(indicacionRepository.existsById(indicacion.getIdIndicacion()))
		{
			logger.info("Inicia el proceso update del registro");
			
			indicacionRepository.save(indicacion);
			
			logger.info("Termina el proceso update del registro");
		}
		logger.info("Termina el proceso update de ExpedienteService");
	}
	
	
	

}
