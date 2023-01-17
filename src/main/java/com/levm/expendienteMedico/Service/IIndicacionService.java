package com.levm.expendienteMedico.Service;

import java.util.List;
import java.util.Optional;

import com.levm.expendienteMedico.entity.IndicacionGeneral;

public interface IIndicacionService {
	
	List<IndicacionGeneral> getAll();
	
	Optional<IndicacionGeneral> getById(int idIndicacion);
	
	void delete(IndicacionGeneral indicacion);
	
	void create(IndicacionGeneral indicacion);
	
	void update(int idIndicacion, IndicacionGeneral indicacion);

}
