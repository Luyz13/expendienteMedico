package com.levm.expendienteMedico.Service;

import java.util.List;
import java.util.Optional;

import com.levm.expendienteMedico.entity.Medico;

public interface IMedicoService {

	List<Medico> getAll();
	
	Medico getById(int medicoId);
	
	void delete(Medico medico);
	
	Medico create(Medico medico);
	
	Medico update(int idMedico,Medico medico);
	
	List<Medico> getByUniversidad(String Universidad);
	
	Optional<Medico> getByCedula(String cedula);
}
