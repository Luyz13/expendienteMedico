package com.levm.expendienteMedico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.levm.expendienteMedico.entity.SignoVital;
import com.levm.expendienteMedico.repository.ISignoVitalRepository;

@Component
public class SignoSeeder implements CommandLineRunner  {
	
	private ISignoVitalRepository signoRepository;
	
	@Autowired
	public SignoSeeder(ISignoVitalRepository signoRepository) {
		this.signoRepository = signoRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		SignoVital signo= signoRepository.findById(1).orElse(null);
		if(signo == null)
		{
			signo = new SignoVital(
					37.4,
					70.1,
					1.69);
			signoRepository.save(signo);
		}
		signo= signoRepository.findById(2).orElse(null);
		if(signo == null)
		{
			signo = new SignoVital(
					38,
					69,
					1.69);
			signoRepository.save(signo);
		}
		
	}

}
