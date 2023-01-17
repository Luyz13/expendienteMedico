package com.levm.expendienteMedico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.levm.expendienteMedico.entity.IndicacionGeneral;
import com.levm.expendienteMedico.repository.IIndicacionGeneralRepository;

@Component
public class IndicacionSeeder implements CommandLineRunner {

	private IIndicacionGeneralRepository indicacionRepository;
	
	@Autowired
	public IndicacionSeeder(IIndicacionGeneralRepository indicacionRepository) {
		this.indicacionRepository = indicacionRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		IndicacionGeneral indicacion = indicacionRepository.findById(1).orElse(null);
		if(indicacion == null)
		{
			indicacion = new IndicacionGeneral(
					"Tomar liquidos");
			indicacionRepository.save(indicacion);
		}
		 indicacion = indicacionRepository.findById(2).orElse(null);
		if(indicacion == null)
		{
			indicacion = new IndicacionGeneral(
					"Guardar reposo");
			indicacionRepository.save(indicacion);
		}
		
	}

}
