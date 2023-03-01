package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IIndicacionService;
import com.levm.expendienteMedico.entity.Indicacion;
import com.levm.expendienteMedico.entity.Receta;
import com.levm.expendienteMedico.repository.IIndicacionRepository;
import com.levm.expendienteMedico.repository.IRecetaRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IndicacionService implements IIndicacionService{
		
	private IIndicacionRepository indicacionRepository;
	private IRecetaRepository recetaRepository;

	@Autowired
	public IndicacionService(IIndicacionRepository indicacionRepository,
			IRecetaRepository recetaRepository) {
		this.indicacionRepository = indicacionRepository;
		this.recetaRepository = recetaRepository;
	}

	@Override
	public List<Indicacion> getAll() {
		log.info("Se ejecuta el proceso findAll de IIndicacionGeneralRepository");
		List<Indicacion> indicaciones =indicacionRepository.findAll();
		if(indicaciones.isEmpty())
		{
			return null;
		}
		return indicaciones;
	}

	@Override
	public Optional<Indicacion> getById(int idIndicacion) {

		log.info("Se ejecuta el proceso getById de ExpedienteService");	

		log.info("Se ejecuta el proceso findById de IIndicacionGeneralRepository");
		
		return indicacionRepository.findById(idIndicacion);
	}

	@Override
	public void delete(Indicacion indicacion) {
		log.info("Inicia el proceso delete de ExpedienteService");

		log.info("Inicia el proceso delete de IIndicacionGeneralRepository");
		
		indicacionRepository.delete(indicacion);
		
		log.info("Termina el proceso delete de IIndicacionGeneralRepository");

		log.info("Termina el proceso delete de ExpedienteService");
		
	}

	@Override
	public void create(Indicacion indicacion) {
		log.info("Inicia el proceso create de ExpedienteService");

		log.info("Inicia el proceso save de IIndicacionGeneralRepository"); 
		
		indicacionRepository.save(indicacion);
		
		log.info("Termina el proceso save de IIndicacionGeneralRepository");
		
		log.info("Termina el proceso create de ExpedienteService");
		
	}

	@Override
	public void update(int idIndicacion,Indicacion indicacion) {
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

	@Override
	public void addRecetaTo(int idIndicacion, Receta receta) {
		if(indicacionRepository.existsById(idIndicacion))
		{
			Indicacion indicacion = indicacionRepository.findById(idIndicacion).orElse(null);
			receta = recetaRepository.findById(receta.getIdReceta()).orElse(null);
			indicacion.setReceta( receta);
			indicacionRepository.save(indicacion);
		}
		
	}
	
	
	

}
