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

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired 
	PacienteService pacienteService;

	@GetMapping
	public List<Paciente> buscarPacientes() {
		return pacienteService.buscarPacientes();
	}
	
	@GetMapping("/{noExpediente}")
	public Optional<Paciente> buscarPaciente(@PathVariable int noExpediente) {
		return pacienteService.buscarPaciente(noExpediente);
	}
	@DeleteMapping("/noExpediente")
	public void eliminarPaciente(Paciente paciente) {
		pacienteService.eliminarPaciente(paciente);
	}
	
	@PostMapping
	public void agregarPaciente(@RequestBody Paciente paciente) {
		pacienteService.agregarPaciente(paciente);
	}

	@PutMapping("/{noExpediente}")
	public void actualizarPaciente(@RequestBody Paciente paciente) {
		pacienteService.actualizarPaciente(paciente);
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
