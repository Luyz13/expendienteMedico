package com.levm.expendienteMedico.Service;

import java.util.List;
import java.util.Optional;

import com.levm.expendienteMedico.entity.Receta;

public interface IRecetaService {
	List<Receta> getAll();
	
	Optional<Receta> getById(int idReceta);
	
	void delete(Receta receta);
	
	void create(Receta receta);
	
	void update(int idReceta,Receta receta);
}
