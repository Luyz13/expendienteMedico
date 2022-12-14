package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IRecetaService;
import com.levm.expendienteMedico.entity.Receta;
import com.levm.expendienteMedico.repository.IRecetaRepository;

@Service
public class RecetaService implements IRecetaService {
	
	private IRecetaRepository recetaRepository;
	
	@Autowired
	public RecetaService(IRecetaRepository recetaRepository) {
		this.recetaRepository = recetaRepository;
	}

	@Override
	public List<Receta> getAll() {
		
		return recetaRepository.findAll();
	}

	@Override
	public Optional<Receta> getById(int idReceta) {
		
		return recetaRepository.findById(idReceta);
	}

	@Override
	public void delete(Receta receta) {
		recetaRepository.delete(receta);
	}

	@Override
	public void create(Receta receta) {
		recetaRepository.save(receta);
	}

	@Override
	public void update(Receta receta) {
		if(recetaRepository.existsById(receta.getIdReceta())) {
			recetaRepository.save(receta);
		}
	}

}
