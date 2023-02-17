package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IMedicamentoService;
import com.levm.expendienteMedico.entity.Medicamento;
import com.levm.expendienteMedico.repository.IMedicamentoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedicamentoService implements IMedicamentoService {
	
	private IMedicamentoRepository medicamentoRepository;
	
	@Autowired
	public MedicamentoService(IMedicamentoRepository medicamentoRepository) {
		this.medicamentoRepository = medicamentoRepository;
	}

	@Override
	public List<Medicamento> getAll() {
		
		log.info("Se ejecuta el proceso getAll de MedicamentoService");

		log.info("Se ejecuta el proceso findAll de IMedicamentoRepository");

		return medicamentoRepository.findAll();
	}

	@Override
	public Optional<Medicamento> getById(Long idMedicamento) {
		
		log.info("Se ejecuta el proceso getById de MedicamentoService");

		log.info("Se ejecuta el proceso findById de IMedicamentoRepository");

		return medicamentoRepository.findById(idMedicamento);
	}

	@Override
	public void delete(Medicamento medicamento) {
		
		log.info("Inicia el proceso delete de MedicamentoService");

		log.info("Inicia el proceso delete de IMedicamentoRepository");
		
		medicamentoRepository.delete(medicamento);
		
		log.info("Termina el proceso delete de IMedicamentoRepository");

		log.info("Termina el proceso delete de MedicamentoService");
	}

	@Override
	public void create(Medicamento medicamento) {
		
		log.info("Inicia el proceso create de MedicamentoService");

		log.info("Inicia el proceso save de IMedicamentoRepository");
		
		medicamentoRepository.save(medicamento);
		
		log.info("Termina el proceso save de IMedicamentoRepository");
		
		log.info("Termina el proceso create de MedicamentoService");
	}

	@Override
	public void update(Long idMedicamento,Medicamento medicamento) {
		log.info("Inicia el proceso update de MedicamentoService");

		log.info("Se valida la existencia del registro");

		if(medicamentoRepository.existsById(idMedicamento)) {
			log.info("Inicia el proceso update del registro");
			medicamento.setIdMedicamento(idMedicamento);
			medicamentoRepository.save(medicamento);

			log.info("Termina el proceso update del registro");
		}
		
		log.info("Termina el proceso update de MedicamentoService");
	}

	@Override
	public List<Medicamento> getByDenominacion(String denominacion) {
	
		return medicamentoRepository.findAll()
				.stream()
				.filter( medicamento -> medicamento.getDenominacion().compareTo(denominacion)== 0)
				.collect(Collectors.toList());
	}

	@Override
	public List<Medicamento> getByViaAdministracion(String via) {
		return medicamentoRepository.findAll()
				.stream()
				.filter( medicamento -> medicamento.getViaAdministracion().compareTo(via)== 0)
				.collect(Collectors.toList());
	}

}
