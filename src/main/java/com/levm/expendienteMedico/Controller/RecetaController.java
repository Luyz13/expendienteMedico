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
		return recetaService.getAll();
	}
	
	@GetMapping("/{idReceta}")
	public Optional<Receta> getById( @PathVariable int idReceta) {
		return recetaService.getById(idReceta);
	}
	@DeleteMapping("/{idReceta}")
	public void delete(Receta receta) {
		recetaService.delete(receta);
	}
	@PostMapping
	public void create(@RequestBody Receta receta) {
		recetaService.create(receta);
	}
	@PutMapping("/{idReceta}")
	public void update( @RequestBody Receta receta) {
		recetaService.update(receta);
	}
	
	
	
	
	

}
