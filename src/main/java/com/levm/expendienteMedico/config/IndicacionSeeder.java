package com.levm.expendienteMedico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.levm.expendienteMedico.entity.Indicacion;
import com.levm.expendienteMedico.repository.IIndicacionRepository;

@Component
public class IndicacionSeeder implements CommandLineRunner {

	private IIndicacionRepository indicacionRepository;
	
	@Autowired
	public IndicacionSeeder(IIndicacionRepository indicacionRepository) {
		this.indicacionRepository = indicacionRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		Indicacion indicacion = indicacionRepository.findById(1).orElse(null);
		if(indicacion == null)
		{
			indicacion = new Indicacion(
					"Tomar liquidos");
			indicacionRepository.save(indicacion);
		}
		 indicacion = indicacionRepository.findById(2).orElse(null);
		if(indicacion == null)
		{
			indicacion = new Indicacion(
					"Guardar reposo");
			indicacionRepository.save(indicacion);
		}
		
	}

}
