package com.levm.expendienteMedico.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.levm.expendienteMedico.Service.ISignoVitalService;
import com.levm.expendienteMedico.entity.SignoVital;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/signoVital")
public class SignoController {
	
	private ISignoVitalService signoService;

	@Autowired
	public SignoController(ISignoVitalService signoService) {
		
		this.signoService = signoService;
	}
	@GetMapping
	public List<SignoVital> getAll() {
		log.info("Se ejecuta el proceso getAll de SignoController");
		
		return signoService.getAll();
	}
	@GetMapping("/{idSigno}")
	public Optional<SignoVital> getById(@PathVariable int idSigno) {
		log.info("Se ejecuta el proceso getById de SignoController");
		
		return signoService.getById(idSigno);
		
		
	}
	@DeleteMapping("/{idSigno}")
	public void delete(SignoVital signo) {
		log.info("Inicia el proceso delete de SignoController");
		
		signoService.delete(signo);
		
		log.info("Termina el proceso delete de SignoController");
	}
	@PostMapping
	public void create(@RequestBody SignoVital signo) {
		log.info("Inicia el proceso create de SignoController");
		
		signoService.create(signo);
		
		log.info("Termina el proceso create de SignoController");
	}
	@PutMapping("/{idSgino}")
	public void update(@PathVariable int idSigno,@RequestBody SignoVital signo) {
		log.info("Inicia el proceso update de SignoController");
		
		signoService.update(idSigno,signo);
		
		log.info("Termina el proceso update de SignoController");
	}
	
	
	

}
