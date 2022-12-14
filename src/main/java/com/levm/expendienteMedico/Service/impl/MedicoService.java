package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IMedicoService;
import com.levm.expendienteMedico.entity.Medico;
import com.levm.expendienteMedico.repository.IMedicoRepository;

@Service
public class MedicoService implements IMedicoService {

	private IMedicoRepository medicoRepository;
	
	@Autowired
	public MedicoService(IMedicoRepository medicoRepository) {
		this.medicoRepository = medicoRepository;
	}

	@Override
	public List<Medico> getAll() {
		return medicoRepository.findAll();
	}

	@Override
	public Optional<Medico> getById(String cedulaProfecional) {

		return medicoRepository.findById(cedulaProfecional);
	}

	@Override
	public void delete(Medico medico) {
		medicoRepository.delete(medico);
	}

	@Override
	public void create(Medico medico) {
		medicoRepository.save(medico);
		
	}

	@Override
	public void update(Medico medico) {
		if(medicoRepository.existsById(medico.getCedulaProfecional()))
		{
			medicoRepository.save(medico);
		}
	}

}
