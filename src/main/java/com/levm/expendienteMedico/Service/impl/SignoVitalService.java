package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.ISignoVitalService;
import com.levm.expendienteMedico.entity.SignoVital;
import com.levm.expendienteMedico.repository.ISignoVital;

@Service
public class SignoVitalService implements ISignoVitalService{
	
	private ISignoVital signoRepository;
	
	@Autowired
	public SignoVitalService(ISignoVital signoRepository) {
		this.signoRepository = signoRepository;
	}

	@Override
	public List<SignoVital> getAll() {

		return signoRepository.findAll();
	}

	@Override
	public Optional<SignoVital> getById(int idSigno) {

		return signoRepository.findById(idSigno);
	}

	@Override
	public void delete(SignoVital signo) {
		signoRepository.delete(signo);
	}

	@Override
	public void create(SignoVital signo) {
		signoRepository.save(signo);
	}

	@Override
	public void update(SignoVital signo) {
		if(signoRepository.existsById(signo.getIdSigno())) {
			signoRepository.save(signo);
		}
	}
}
