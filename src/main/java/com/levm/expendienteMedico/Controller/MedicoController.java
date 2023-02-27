package com.levm.expendienteMedico.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/medico")
@Slf4j
public class MedicoController {
	
	private IMedicoService medicoService;
	
	@Autowired
	public MedicoController(IMedicoService medicoService) {
		
		this.medicoService = medicoService;
	}
	@GetMapping
	public List<Medico> getAll() {
		
		log.info("Se ejecuta el proceso getAll de MedicoController");
		
		
		return medicoService.getAll();
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Medico> getById(@PathVariable int id) {
		
		log.info("Se ejecuta el proceso getById de MedicoController");		
		Medico med = medicoService.getById(id);
		if( med != null)
		{
			return new ResponseEntity<Medico>(med, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public void delete(Medico medico) {
		
		log.info("Inicia el proceso delete de MedicoController");
		
		medicoService.delete(medico);

		log.info("Termina el proceso delete de MedicoController");
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Medico medico) {
		log.info("Inicia el proceso create de MedicoController");
		try {
			Medico _medico=medicoService.create(medico);
			return new ResponseEntity<>(_medico,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> update( @PathVariable int id,@Valid @RequestBody Medico medico) {
		log.info("Inicia el proceso update de MedicoController");
		
		return new ResponseEntity<Medico>( medicoService.update( id,medico),HttpStatus.OK);

		
		
	}
}
