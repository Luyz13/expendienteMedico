package com.levm.expendienteMedico.Service;

import java.util.List;
import java.util.Optional;

import com.levm.expendienteMedico.entity.Indicacion;
import com.levm.expendienteMedico.entity.Receta;

public interface IIndicacionService {
	
	List<Indicacion> getAll();
	
	Optional<Indicacion> getById(int idIndicacion);
	
	void delete(Indicacion indicacion);
	
	void create(Indicacion indicacion);
	
	void update(int idIndicacion, Indicacion indicacion);

	void addRecetaTo(int idIndicacion, Receta receta);

}
