package com.levm.expendienteMedico.repository;

import java.util.List;

import com.levm.expendienteMedico.entity.Paciente;

public interface PacienteRepository {
	
	List<Paciente> findAll();
	
	Paciente findById(int noExpediente);
	
	void delete(Paciente paciente);
	
	void save(Paciente paciente);
	
	void update(Paciente paciente);
	

}
