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

import com.levm.expendienteMedico.Service.IIndicacionService;
import com.levm.expendienteMedico.entity.Indicacion;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/indicacion")
public class IndicacionController {
	
	private IIndicacionService indicacionService;

	@Autowired
	public IndicacionController(IIndicacionService indicacionService) {
		this.indicacionService = indicacionService;
	}
	
	@GetMapping
	public ResponseEntity<List<Indicacion>> getAll() {
		log.info("Se ejecuta el proceso getAll de IndicacionController");
		List<Indicacion> indicaciones = indicacionService.getAll();
		if(indicaciones == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(indicaciones,HttpStatus.OK);
	}

	@GetMapping("/{idIndicacion}")
	public Optional<Indicacion> getById(@PathVariable int idIndicacion) {
		log.info("Se ejecuta el proceso getById de IndicacionController");
		
		return indicacionService.getById(idIndicacion);
	}
	
	@DeleteMapping("/{idIndicacion}")
	public void delete(Indicacion indicacion) {
		log.info("Inicia el proceso delete de IndicacionController");
		
		indicacionService.delete(indicacion);
		
		log.info("Termina el proceso delete de IndicacionController");
	}
	
	@PostMapping
	public void create(@Valid @RequestBody Indicacion indicacion) {
		
		log.info("Inicia el proceso create de IndicacionController");
		
		indicacionService.create(indicacion);
		
		log.info("Termina el proceso create de IndicacionController");
	}
	@PutMapping("/{idIndicacion}")
	public void update(@PathVariable int idIndicacion,@Valid @RequestBody Indicacion indicacion) {
		log.info("Inicia el proceso update de IndicacionController");
		
		indicacionService.update(idIndicacion,indicacion);
		
		log.info("Termina el proceso update de IndicacionController");
	}
}
