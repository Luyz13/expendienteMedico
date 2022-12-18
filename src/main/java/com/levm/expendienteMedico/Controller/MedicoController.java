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

import com.levm.expendienteMedico.Service.IMedicoService;
import com.levm.expendienteMedico.entity.Medico;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/medico")
public class MedicoController {
	
	private IMedicoService medicoService;
	
	@Autowired
	public MedicoController(IMedicoService medicoService) {
		
		this.medicoService = medicoService;
	}
	@GetMapping("/all")
	public List<Medico> getAll() {
		
		log.info("Se ejecuta el proceso getAll de MedicoController");
		
		
		return medicoService.getAll();
	}
	
	@GetMapping("/{cedulaProfecional}")
	public Optional<Medico> getById(@PathVariable int medicoId) {
		
		log.info("Se ejecuta el proceso getById de MedicoController");		
		
		return medicoService.getById(medicoId);
	}
	
	@DeleteMapping("/{cedulaProfecional}")
	public void delete(Medico medico) {
		
		log.info("Inicia el proceso delete de MedicoController");
		
		medicoService.delete(medico);

		log.info("Termina el proceso delete de MedicoController");
	}

	@PostMapping
	public void create(@RequestBody Medico medico) {
		log.info("Inicia el proceso create de MedicoController");
		
		medicoService.create(medico);
		
		log.info("Termina el proceso create de MedicoController");
		
	}
	@PutMapping("/{cedulaProfecional}")
	public void update( @RequestBody Medico medico) {
		log.info("Inicia el proceso update de MedicoController");
		
		medicoService.update(medico);

		log.info("Termina el proceso update de MedicoController");
		
	}
}
