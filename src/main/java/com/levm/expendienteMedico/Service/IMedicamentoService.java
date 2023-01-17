package com.levm.expendienteMedico.Service;

import java.util.List;
import java.util.Optional;

import com.levm.expendienteMedico.entity.Medicamento;

public interface IMedicamentoService {
	
	List<Medicamento> getAll();
	
	Optional<Medicamento> getById(Long idMedicamento);
	
	void delete(Medicamento medicamento);
	
	void create(Medicamento medicamento);
	
	void update(Long idMedicamento,Medicamento medicamento);

}
