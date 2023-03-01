package com.levm.expendienteMedico.Controller;

import java.net.URI;
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

import com.levm.expendienteMedico.Service.IExpedienteService;
import com.levm.expendienteMedico.entity.Expediente;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/expediente")
public class ExpedienteController {
	
	
	private IExpedienteService expedienteService;
	
	@Autowired
	public ExpedienteController(IExpedienteService expedienteService) {
		this.expedienteService = expedienteService;
	}
	@GetMapping
	public ResponseEntity<List<?>> getAll() {
		log.info("Se ejecuta el proceso getAll de ExpedienteController");
		List<Expediente> expedientes = expedienteService.getAll();
		if(expedientes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(expedientes);
	}
	@GetMapping("/{idExpediente}")
	public ResponseEntity<?> getById(@PathVariable Long idExpediente) {
		log.info("Se ejecuta el proceso getById de ExpedienteController");
		Optional<Expediente> expediente =expedienteService.getById(idExpediente);
		if(expediente.isPresent()) {
			return ResponseEntity.ok( expediente);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	@DeleteMapping("/{idExpediente}")
	public ResponseEntity<?> delete(Expediente expediente) {
		log.info("Se ejecuta el proceso delete de ExpedienteController");
		
		expedienteService.delete(expediente);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		
	}
	@PostMapping 
	public ResponseEntity<?> create(@Valid @RequestBody Expediente expediente) {
		log.info("Inicia el proceso create de ExpedienteController");
		
		expedienteService.create(expediente);
		
		return ResponseEntity
				.created(URI.create("")).build();
	}
	@PutMapping("/{idExpediente}")
	public ResponseEntity<?> update(@PathVariable long idExpediente,@Valid @RequestBody Expediente expediente) {
		log.info("Se ejecuta el proceso update de ExpedienteController");
		
		if(expedienteService.update(idExpediente,expediente))
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		
		
	}
	
	
	

}
