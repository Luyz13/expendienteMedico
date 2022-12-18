package com.levm.expendienteMedico.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	private static Logger logger = LoggerFactory.getLogger(PacienteController.class);
	
	private PacienteService pacienteService;

	@Autowired
	public PacienteController(PacienteService pacienteService) {
		
		logger.info("Se ejecuta el proceso getAll de PacienteController");
		
		this.pacienteService = pacienteService;
	}

	@GetMapping("/all")
	public List<Paciente> buscarPacientes() {
		logger.info("Se ejecuta el proceso getById de PacienteController");
		
		return pacienteService.buscarPacientes();
	}
	
	@GetMapping("/{noExpediente}")
	public Optional<Paciente> buscarPaciente(@PathVariable int noExpediente) {
		logger.info("Se ejecuta el proceso getById de PacienteController");
		
		return pacienteService.buscarPaciente(noExpediente);
	}
	@DeleteMapping("/{noExpediente}")
	public void eliminarPaciente(Paciente paciente) {
		logger.info("Inicia el proceso delete de PacienteController");
		
		pacienteService.eliminarPaciente(paciente);
		
		logger.info("Termina el proceso delete de PacienteController");
	}
	
	
	@PostMapping
	public void agregarPaciente(@RequestBody Paciente paciente) {
		logger.info("Inicia el proceso create de PacienteController");
		
		pacienteService.agregarPaciente(paciente);
		
		logger.info("Termina el proceso create de PacienteController");
	}

	@PutMapping("/{noExpediente}")
	public void actualizarPaciente(@RequestBody Paciente paciente) {
		logger.info("Inicia el proceso update de PacienteController");
		
		pacienteService.actualizarPaciente(paciente);
		
		logger.info("Termina el proceso update de PacienteController");
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
