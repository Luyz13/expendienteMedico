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

import com.levm.expendienteMedico.Service.IRecetaService;
import com.levm.expendienteMedico.entity.Receta;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/receta")
public class RecetaController {
		
	private IRecetaService recetaService;

	@Autowired
	public RecetaController(IRecetaService recetaService) {
		this.recetaService = recetaService;
	}
	@GetMapping
	public List<Receta> getAll() {
		log.info("Se ejecuta el proceso getAll de RecetaController");
		
		return recetaService.getAll();
	}
	
	@GetMapping("/{idReceta}")
	public Optional<Receta> getById( @PathVariable int idReceta) {
		log.info("Se ejecuta el proceso getById de RecetaController");
		
		return recetaService.getById(idReceta);
	}
	@DeleteMapping("/{idReceta}")
	public void delete(Receta receta) {
		log.info("Inicia el proceso delete de RecetaController");
		
		recetaService.delete(receta);
		
		log.info("Termina el proceso delete de RecetaController");
	}
	@PostMapping
	public void create(@RequestBody Receta receta) {
		log.info("Inicia el proceso create de RecetaController");
		
		recetaService.create(receta);
		
		log.info("Termina el proceso create de RecetaController");
	}
	@PutMapping("/{idReceta}")
	public void update( @RequestBody Receta receta) {
		log.info("Inicia el proceso update de RecetaController");
		
		recetaService.update(receta);
		
		log.info("Termina el proceso update de RecetaController");
	}
	
	
	
	
	

}
