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

import com.levm.expendienteMedico.Service.IExpedienteService;
import com.levm.expendienteMedico.entity.ExpedienteMedico;

@RestController
@RequestMapping("/expediente")
public class ExpedienteController {
	
	private static Logger logger = LoggerFactory.getLogger(ExpedienteController.class);
	
	private IExpedienteService expedienteService;
	
	@Autowired
	public ExpedienteController(IExpedienteService expedienteService) {
		this.expedienteService = expedienteService;
	}
	@GetMapping("/all")
	public List<ExpedienteMedico> getAll() {
		logger.info("Se ejecuta el proceso getAll de ExpedienteController");
		
		return expedienteService.getAll();
	}
	@GetMapping("/{idExpediente}")
	public Optional<ExpedienteMedico> getById(@PathVariable Long idExpediente) {
		logger.info("Se ejecuta el proceso getById de ExpedienteController");
		
		return expedienteService.getById(idExpediente);
	}
	@DeleteMapping("/{idExpediente}")
	public void delete(ExpedienteMedico expediente) {
		logger.info("Inicia el proceso delete de ExpedienteController");
		
		expedienteService.delete(expediente);
		
		logger.info("Termina el proceso delete de ExpedienteController");
	}
	@PostMapping 
	public void create(@RequestBody ExpedienteMedico expediente) {
		logger.info("Inicia el proceso create de ExpedienteController");
		
		expedienteService.create(expediente);
		
		logger.info("Termina el proceso create de ExpedienteController");
	}
	@PutMapping
	public void update(@RequestBody ExpedienteMedico expediente) {
		logger.info("Inicia el proceso update de ExpedienteController");
		
		expedienteService.update(expediente);
		
		logger.info("Termina el proceso update de ExpedienteController");
	}
	
	
	

}
