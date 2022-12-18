package com.levm.expendienteMedico.config;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.levm.expendienteMedico.entity.Medico;
import com.levm.expendienteMedico.repository.IMedicoRepository;

@Component
public class MedicoSeeder implements CommandLineRunner {
	
	private IMedicoRepository medicoRepository;
	

	public MedicoSeeder(IMedicoRepository medicoRepository) {
		this.medicoRepository = medicoRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		Optional<Medico> medico = medicoRepository.findById(1);
		
		if(medico.isEmpty())
		{
			Medico medico1 = new Medico("1856575",
					"UAEM",
					"Altagracia",
					"Mondragon",
					"Duran",
					"18/01/1985",
					'F');
			medicoRepository.save(medico1);
			
		}
	}
}
