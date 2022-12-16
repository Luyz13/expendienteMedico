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
		return medicamentoService.getAll();
	}
	
	@GetMapping
	public Optional<Medicamento> getById( @PathVariable Long idMedicamento) {
		return medicamentoService.getById(idMedicamento);
	}
	
	@DeleteMapping("/{idMedicamento}")
	public void delete(Medicamento medicamento) {
		medicamentoService.delete(medicamento);
	}

	@PostMapping
	public void create(@RequestBody Medicamento medicamento) {
		medicamentoService.create(medicamento);
	}
	@PutMapping("/{idMedicamento}")
	public void update(@RequestBody Medicamento medicamento) {
		medicamentoService.update(medicamento);
	}
	
	
	
	

}
