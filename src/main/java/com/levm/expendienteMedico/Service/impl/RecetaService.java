package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IRecetaService;
import com.levm.expendienteMedico.entity.Receta;
import com.levm.expendienteMedico.repository.IRecetaRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecetaService implements IRecetaService {
	
	private IRecetaRepository recetaRepository;
	
	@Autowired
	public RecetaService(IRecetaRepository recetaRepository) {
		this.recetaRepository = recetaRepository;
	}

	@Override
	public List<Receta> getAll() {
		log.info("Se ejecuta el proceso getAll de RecetaService");

		log.info("Se ejecuta el proceso findAll de IRecetaRepository");
		
		return recetaRepository.findAll();
	}

	@Override
	public Optional<Receta> getById(int idReceta) {
		log.info("Se ejecuta el proceso getById de RecetaService");

		log.info("Se ejecuta el proceso findById de IRecetaRepository");
		
		return recetaRepository.findById(idReceta);
	}

	@Override
	public void delete(Receta receta) {
		log.info("Inicia el proceso delete de RecetaService");

		log.info("Inicia el proceso delete de IRecetaRepository");
		
		recetaRepository.delete(receta);
		
		log.info("Termina el proceso delete de IRecetaRepository");

		log.info("Termina el proceso delete de RecetaService");
	}

	@Override
	public void create(Receta receta) {
		log.info("Inicia el proceso create de RecetaService");

		log.info("Inicia el proceso save de IRecetaRepository");
		
		recetaRepository.save(receta);
		
		log.info("Termina el proceso save de IRecetaRepository");
		
		log.info("Termina el proceso create de RecetaService");
	}

	@Override
	public void update(Receta receta) {
		log.info("Inicia el proceso update de RecetaService");

		log.info("Se valida la existencia del registro");
		
		if(recetaRepository.existsById(receta.getIdReceta())) {
			
			log.info("Inicia el proceso update del registro");
			
			recetaRepository.save(receta);
			
			log.info("Termina el proceso update del registro");
		}
		log.info("Termina el proceso update de RecetaService");
	}

}
