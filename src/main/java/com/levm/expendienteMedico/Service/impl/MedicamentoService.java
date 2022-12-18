package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IMedicamentoService;
import com.levm.expendienteMedico.entity.Medicamento;
import com.levm.expendienteMedico.repository.IMedicamentoRepository;

@Service
public class MedicamentoService implements IMedicamentoService {
	
	private static Logger logger = LoggerFactory.getLogger(MedicamentoService.class);
	
	private IMedicamentoRepository medicamentoRepository;
	
	@Autowired
	public MedicamentoService(IMedicamentoRepository medicamentoRepository) {
		this.medicamentoRepository = medicamentoRepository;
	}

	@Override
	public List<Medicamento> getAll() {
		
		logger.info("Se ejecuta el proceso getAll de MedicamentoService");

		logger.info("Se ejecuta el proceso findAll de IMedicamentoRepository");

		return medicamentoRepository.findAll();
	}

	@Override
	public Optional<Medicamento> getById(Long idMedicamento) {
		
		logger.info("Se ejecuta el proceso getById de MedicamentoService");

		logger.info("Se ejecuta el proceso findById de IMedicamentoRepository");

		return medicamentoRepository.findById(idMedicamento);
	}

	@Override
	public void delete(Medicamento medicamento) {
		
		logger.info("Inicia el proceso delete de MedicamentoService");

		logger.info("Inicia el proceso delete de IMedicamentoRepository");
		
		medicamentoRepository.delete(medicamento);
		
		logger.info("Termina el proceso delete de IMedicamentoRepository");

		logger.info("Termina el proceso delete de MedicamentoService");
	}

	@Override
	public void create(Medicamento medicamento) {
		
		logger.info("Inicia el proceso create de MedicamentoService");

		logger.info("Inicia el proceso save de IMedicamentoRepository");
		
		medicamentoRepository.save(medicamento);
		
		logger.info("Termina el proceso save de IMedicamentoRepository");
		
		logger.info("Termina el proceso create de MedicamentoService");
	}

	@Override
	public void update(Medicamento medicamento) {
		logger.info("Inicia el proceso update de MedicamentoService");

		logger.info("Se valida la existencia del registro");

		if(medicamentoRepository.existsById(medicamento.getIdMedicamento())) {
			logger.info("Inicia el proceso update del registro");
			
			medicamentoRepository.save(medicamento);

			logger.info("Termina el proceso update del registro");
		}
		
		logger.info("Termina el proceso update de MedicamentoService");
	}

}
