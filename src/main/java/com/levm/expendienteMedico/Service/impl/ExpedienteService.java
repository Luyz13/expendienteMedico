package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IExpedienteService;
import com.levm.expendienteMedico.entity.ExpedienteMedico;
import com.levm.expendienteMedico.repository.IExpedienteMedicoRepository;

@Service
public class ExpedienteService implements IExpedienteService {
	
	private IExpedienteMedicoRepository expedienteRepository;

	@Autowired
	public ExpedienteService(IExpedienteMedicoRepository expedienteRepository) {
		this.expedienteRepository = expedienteRepository;
	}

	public List<ExpedienteMedico> getAll() {
		return expedienteRepository.findAll();
	}

	public Optional<ExpedienteMedico> getById(Long idExpediente) {
		return expedienteRepository.findById(idExpediente);
	}

	public void delete(ExpedienteMedico expediente) {
		expedienteRepository.delete(expediente);
		
	}

	public void create(ExpedienteMedico expediente) {
		expedienteRepository.save(expediente);
		
	}
	public void update(ExpedienteMedico expediente) {
		if(expedienteRepository.existsById(expediente.getIdExpediente()))
		{
			expedienteRepository.save(expediente);
		}
		
	}
	
	

}
