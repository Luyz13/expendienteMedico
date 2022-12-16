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

import com.levm.expendienteMedico.Service.IExpedienteService;
import com.levm.expendienteMedico.entity.ExpedienteMedico;

@RestController
@RequestMapping("/expediente")
public class ExpedienteController {
		
	private IExpedienteService expedienteService;
	
	@Autowired
	public ExpedienteController(IExpedienteService expedienteService) {
		this.expedienteService = expedienteService;
	}
	@GetMapping("/all")
	public List<ExpedienteMedico> getAll() {
		return expedienteService.getAll();
	}
	@GetMapping("/{idExpediente}")
	public Optional<ExpedienteMedico> getById(@PathVariable Long idExpediente) {
		return expedienteService.getById(idExpediente);
	}
	@DeleteMapping("/{idExpediente}")
	public void delete(ExpedienteMedico expediente) {
		expedienteService.delete(expediente);
	}
	@PostMapping 
	public void create(@RequestBody ExpedienteMedico expediente) {
		expedienteService.create(expediente);
	}
	@PutMapping
	public void update(@RequestBody ExpedienteMedico expediente) {
		expedienteService.update(expediente);
	}
	
	
	

}
