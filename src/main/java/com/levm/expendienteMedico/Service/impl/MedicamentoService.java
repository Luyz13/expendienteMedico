package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IMedicamentoService;
import com.levm.expendienteMedico.entity.Medicamento;
import com.levm.expendienteMedico.repository.IMedicamentoRepository;

@Service
public class MedicamentoService implements IMedicamentoService {
	
	private IMedicamentoRepository medicamentoRepository;
	
	@Autowired
	public MedicamentoService(IMedicamentoRepository medicamentoRepository) {
		this.medicamentoRepository = medicamentoRepository;
	}

	@Override
	public List<Medicamento> getAll() {

		return medicamentoRepository.findAll();
	}

	@Override
	public Optional<Medicamento> getById(Long idMedicamento) {

		return medicamentoRepository.findById(idMedicamento);
	}

	@Override
	public void delete(Medicamento medicamento) {
		medicamentoRepository.delete(medicamento);
	}

	@Override
	public void create(Medicamento medicamento) {
		medicamentoRepository.save(medicamento);
	}

	@Override
	public void update(Medicamento medicamento) {

		if(medicamentoRepository.existsById(medicamento.getIdMedicamento())) {
			medicamentoRepository.save(medicamento);
		}
	}

}
