package com.levm.expendienteMedico.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
@RequestMapping("/signoVital")
public class SignoController {
	
	private static Logger logger = LoggerFactory.getLogger(SignoController.class);
	
	private ISignoVitalService signoService;

	@Autowired
	public SignoController(ISignoVitalService signoService) {
		
		this.signoService = signoService;
	}
	@GetMapping("/all")
	public List<SignoVital> getAll() {
		logger.info("Se ejecuta el proceso getAll de SignoController");
		
		return signoService.getAll();
	}
	@GetMapping("/{idSigno}")
	public Optional<SignoVital> getById(@PathVariable int idSigno) {
		logger.info("Se ejecuta el proceso getById de SignoController");
		
		return signoService.getById(idSigno);
		
		
	}
	@DeleteMapping("/{idSigno}")
	public void delete(SignoVital signo) {
		logger.info("Inicia el proceso delete de SignoController");
		
		signoService.delete(signo);
		
		logger.info("Termina el proceso delete de SignoController");
	}
	@PostMapping
	public void create(@RequestBody SignoVital signo) {
		logger.info("Inicia el proceso create de SignoController");
		
		signoService.create(signo);
		
		logger.info("Termina el proceso create de SignoController");
	}
	@PutMapping("/{idSgino}")
	public void update(@RequestBody SignoVital signo) {
		logger.info("Inicia el proceso update de SignoController");
		
		signoService.update(signo);
		
		logger.info("Termina el proceso update de SignoController");
	}
	
	
	

}
