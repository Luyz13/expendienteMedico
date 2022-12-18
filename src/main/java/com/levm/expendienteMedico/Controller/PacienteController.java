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

import com.levm.expendienteMedico.Service.impl.PacienteService;
import com.levm.expendienteMedico.entity.Paciente;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/paciente")
@Slf4j
public class PacienteController {
		
	private PacienteService pacienteService;

	@Autowired
	public PacienteController(PacienteService pacienteService) {
		
		log.info("Se ejecuta el proceso getAll de PacienteController");
		
		this.pacienteService = pacienteService;
	}

	@GetMapping("/all")
	public List<Paciente> buscarPacientes() {
		log.info("Se ejecuta el proceso getById de PacienteController");
		
		return pacienteService.buscarPacientes();
	}
	
	@GetMapping("/{noExpediente}")
	public Optional<Paciente> buscarPaciente(@PathVariable int noExpediente) {
		log.info("Se ejecuta el proceso getById de PacienteController");
		
		return pacienteService.buscarPaciente(noExpediente);
	}
	@DeleteMapping("/{noExpediente}")
	public void eliminarPaciente(Paciente paciente) {
		log.info("Inicia el proceso delete de PacienteController");
		
		pacienteService.eliminarPaciente(paciente);
		
		log.info("Termina el proceso delete de PacienteController");
	}
	
	
	@PostMapping
	public void agregarPaciente(@RequestBody Paciente paciente) {
		log.info("Inicia el proceso create de PacienteController");
		
		pacienteService.agregarPaciente(paciente);
		
		log.info("Termina el proceso create de PacienteController");
	}

	@PutMapping("/{noExpediente}")
	public void actualizarPaciente(@RequestBody Paciente paciente) {
		log.info("Inicia el proceso update de PacienteController");
		
		pacienteService.actualizarPaciente(paciente);
		
		log.info("Termina el proceso update de PacienteController");
	}

	public int hashCode() {
		return pacienteService.hashCode();
	}

	public boolean equals(Object obj) {
		return pacienteService.equals(obj);
	}

	public String toString() {
		return pacienteService.toString();
	}
	
	
	

}
