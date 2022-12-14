package com.levm.expendienteMedico.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levm.expendienteMedico.Service.IIndicacionService;
import com.levm.expendienteMedico.entity.IndicacionGeneral;
import com.levm.expendienteMedico.repository.IIndicacionGeneralRepository;

@Service
public class IndicacionService implements IIndicacionService{
	
	private IIndicacionGeneralRepository indicacionRepository;

	@Autowired
	public IndicacionService(IIndicacionGeneralRepository indicacionRepository) {
		this.indicacionRepository = indicacionRepository;
	}

	@Override
	public List<IndicacionGeneral> getAll() {
		return indicacionRepository.findAll();
	}

	@Override
	public Optional<IndicacionGeneral> getById(int idIndicacion) {
		return indicacionRepository.findById(idIndicacion);
	}

	@Override
	public void delete(IndicacionGeneral indicacion) {
		indicacionRepository.delete(indicacion);
		
	}

	@Override
	public void create(IndicacionGeneral indicacion) {
		indicacionRepository.save(indicacion);
		
	}

	@Override
	public void update(IndicacionGeneral indicacion) {
		if(indicacionRepository.existsById(indicacion.getIdIndicacion()))
		{
			indicacionRepository.save(indicacion);
		}
	}
	
	
	

}
