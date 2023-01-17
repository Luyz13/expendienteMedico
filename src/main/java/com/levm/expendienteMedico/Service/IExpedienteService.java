package com.levm.expendienteMedico.Service;

import java.util.List;
import java.util.Optional;

import com.levm.expendienteMedico.entity.ExpedienteMedico;

public interface IExpedienteService {
	
	List<ExpedienteMedico> getAll();
	
	Optional<ExpedienteMedico> getById(Long idExpediente);
	
	void delete(ExpedienteMedico expediente);
	
	void create(ExpedienteMedico expediente);
	
	void update( long idExpediente,ExpedienteMedico expediente);

}
