package com.levm.expendienteMedico.Service;

import java.util.List;
import java.util.Optional;

import com.levm.expendienteMedico.entity.Medico;

public interface IMedicoService {

	List<Medico> getAll();
	
	Optional<Medico> getById(String cedulaProfecional);
	
	void delete(Medico medico);
	
	void create(Medico medico);
	
	void update(Medico medico);
}
