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

import com.levm.expendienteMedico.Service.IMedicamentoService;
import com.levm.expendienteMedico.entity.Medicamento;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
	
	private IMedicamentoService medicamentoService;

	@Autowired
	public MedicamentoController(IMedicamentoService medicamentoService) {
		
		this.medicamentoService = medicamentoService;
	}
	
	@GetMapping("/all")
	public List<Medicamento> getAll() {
		log.info("Se ejecuta el proceso getAll de MedicamentoController");
		
		return medicamentoService.getAll();
	}
	
	@GetMapping
	public Optional<Medicamento> getById( @PathVariable Long idMedicamento) {
		log.info("Se ejecuta el proceso getById de MedicamentoController");
		
		return medicamentoService.getById(idMedicamento);
	}
	
	@DeleteMapping("/{idMedicamento}")
	public void delete(Medicamento medicamento) {
		log.info("Inicia el proceso delete de MedicamentoController");
		
		medicamentoService.delete(medicamento);
		
		log.info("Termina el proceso delete de MedicamentoController");
	}

	@PostMapping
	public void create(@RequestBody Medicamento medicamento) {
		log.info("Inicia el proceso create de MedicamentoController");
		
		medicamentoService.create(medicamento);
		
		log.info("Termina el proceso create de MedicamentoController");
	}
	@PutMapping("/{idMedicamento}")
	public void update(@RequestBody Medicamento medicamento) {
		log.info("Inicia el proceso update de MedicamentoController");
		
		medicamentoService.update(medicamento);
		
		log.info("Termina el proceso update de MedicamentoController");
	}
	
	
	
	

}
