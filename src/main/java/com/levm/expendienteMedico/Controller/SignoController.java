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

import com.levm.expendienteMedico.Service.ISignoVitalService;
import com.levm.expendienteMedico.entity.SignoVital;

@RestController
@RequestMapping("/signoVital")
public class SignoController {
	
	private ISignoVitalService signoService;

	@Autowired
	public SignoController(ISignoVitalService signoService) {
		this.signoService = signoService;
	}
	@GetMapping("/all")
	public List<SignoVital> getAll() {
		return signoService.getAll();
	}
	@GetMapping("/{idSigno}")
	public Optional<SignoVital> getById(@PathVariable int idSigno) {
		return signoService.getById(idSigno);
	}
	@DeleteMapping("/{idSigno}")
	public void delete(SignoVital signo) {
		signoService.delete(signo);
	}
	@PostMapping
	public void create(@RequestBody SignoVital signo) {
		signoService.create(signo);
	}
	@PutMapping("/{idSgino}")
	public void update(@RequestBody SignoVital signo) {
		signoService.update(signo);
	}
	
	
	

}
