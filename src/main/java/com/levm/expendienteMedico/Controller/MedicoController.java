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


import com.levm.expendienteMedico.Service.IMedicoService;
import com.levm.expendienteMedico.entity.Medico;

public class MedicoController {
	
	private IMedicoService medicoService;
	
	@Autowired
	public MedicoController(IMedicoService medicoService) {
		this.medicoService = medicoService;
	}
	@GetMapping("/all")
	public List<Medico> getAll() {
		return medicoService.getAll();
	}
	
	@GetMapping("/{cedulaProfecional}")
	public Optional<Medico> getById(@PathVariable String cedulaProfecional) {
		return medicoService.getById(cedulaProfecional);
	}
	
	@DeleteMapping("/{cedulaProfecional}")
	public void delete(Medico medico) {
		medicoService.delete(medico);
	}

	@PostMapping
	public void create(@RequestBody Medico medico) {
		medicoService.create(medico);
	}
	@PutMapping("/{cedulaProfecional}")
	public void update( @RequestBody Medico medico) {
		medicoService.update(medico);
	}
	
	

}
