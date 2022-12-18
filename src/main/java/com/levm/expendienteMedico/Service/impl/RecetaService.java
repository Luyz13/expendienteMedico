package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IRecetaService;
import com.levm.expendienteMedico.entity.Receta;
import com.levm.expendienteMedico.repository.IRecetaRepository;

@Service
public class RecetaService implements IRecetaService {
	
	private static Logger logger = LoggerFactory.getLogger(RecetaService.class);
	
	private IRecetaRepository recetaRepository;
	
	@Autowired
	public RecetaService(IRecetaRepository recetaRepository) {
		this.recetaRepository = recetaRepository;
	}

	@Override
	public List<Receta> getAll() {
		logger.info("Se ejecuta el proceso getAll de RecetaService");

		logger.info("Se ejecuta el proceso findAll de IRecetaRepository");
		
		return recetaRepository.findAll();
	}

	@Override
	public Optional<Receta> getById(int idReceta) {
		logger.info("Se ejecuta el proceso getById de RecetaService");

		logger.info("Se ejecuta el proceso findById de IRecetaRepository");
		
		return recetaRepository.findById(idReceta);
	}

	@Override
	public void delete(Receta receta) {
		logger.info("Inicia el proceso delete de RecetaService");

		logger.info("Inicia el proceso delete de IRecetaRepository");
		
		recetaRepository.delete(receta);
		
		logger.info("Termina el proceso delete de IRecetaRepository");

		logger.info("Termina el proceso delete de RecetaService");
	}

	@Override
	public void create(Receta receta) {
		logger.info("Inicia el proceso create de RecetaService");

		logger.info("Inicia el proceso save de IRecetaRepository");
		
		recetaRepository.save(receta);
		
		logger.info("Termina el proceso save de IRecetaRepository");
		
		logger.info("Termina el proceso create de RecetaService");
	}

	@Override
	public void update(Receta receta) {
		logger.info("Inicia el proceso update de RecetaService");

		logger.info("Se valida la existencia del registro");
		
		if(recetaRepository.existsById(receta.getIdReceta())) {
			
			logger.info("Inicia el proceso update del registro");
			
			recetaRepository.save(receta);
			
			logger.info("Termina el proceso update del registro");
		}
		logger.info("Termina el proceso update de RecetaService");
	}

}
