package com.levm.expendienteMedico.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.levm.expendienteMedico.entity.Expediente;

public interface IExpedienteService {
	
	List<Expediente> getAll();
	
	Optional<Expediente> getById(Long idExpediente);
	
	List<Expediente> getByfechaAltaLessThanEqual(Date fechaAlta);
	
	List<Expediente> getByfechaAltaGreaterThanEqual(Date fechaAlta);
	
	void delete(Expediente expediente);
	
	void create(Expediente expediente);
	
	void update( long idExpediente,Expediente expediente);

}
