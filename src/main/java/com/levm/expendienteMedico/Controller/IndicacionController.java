package com.levm.expendienteMedico.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.levm.expendienteMedico.Service.IIndicacionService;
import com.levm.expendienteMedico.entity.IndicacionGeneral;

@RestController
@RequestMapping("/indicacion")
public class IndicacionController {
	
	private IIndicacionService indicacionService;

	public IndicacionController(IIndicacionService indicacionService) {
		this.indicacionService = indicacionService;
	}
	
	@GetMapping("/all")
	public List<IndicacionGeneral> getAll() {
		return indicacionService.getAll();
	}

	@GetMapping("/{idIndicacion}")
	public Optional<IndicacionGeneral> getById(@PathVariable int idIndicacion) {
		return indicacionService.getById(idIndicacion);
	}
	
	@DeleteMapping("/{idIndicacion}")
	public void delete(IndicacionGeneral indicacion) {
		indicacionService.delete(indicacion);
	}
	
	@PostMapping
	public void create(@RequestBody IndicacionGeneral indicacion) {
		indicacionService.create(indicacion);
	}
	@PutMapping("/{idIndicacion}")
	public void update(@RequestBody IndicacionGeneral indicacion) {
		indicacionService.update(indicacion);
	}
}
