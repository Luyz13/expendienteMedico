package com.levm.expendienteMedico.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		return ResponseEntity.ok(expedienteService.getAll());
	}
	@GetMapping("/{idExpediente}")
	public ResponseEntity<?> getById(@PathVariable Long idExpediente) {
		log.info("Se ejecuta el proceso getById de ExpedienteController");
		
		return ResponseEntity.ok( expedienteService.getById(idExpediente));
	}
	@DeleteMapping("/{idExpediente}")
	public void delete(Expediente expediente) {
		log.info("Inicia el proceso delete de ExpedienteController");
		
		expedienteService.delete(expediente);
		
		log.info("Termina el proceso delete de ExpedienteController");
	}
	@PostMapping 
	public ResponseEntity<?> create(@Valid @RequestBody Expediente expediente) {
		log.info("Inicia el proceso create de ExpedienteController");
		
		expedienteService.create(expediente);
		
		return ResponseEntity
				.created(URI.create("")).build();
	}
	@PutMapping("/{idExpediente}")
	public void update(@PathVariable long idExpediente,@Valid @RequestBody Expediente expediente) {
		log.info("Inicia el proceso update de ExpedienteController");
		
		expedienteService.update(idExpediente,expediente);
		
		log.info("Termina el proceso update de ExpedienteController");
	}
	
	
	

}
