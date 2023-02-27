package com.levm.expendienteMedico.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.levm.expendienteMedico.entity.Usuario;
import com.levm.expendienteMedico.repository.IUsuarioRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {
	
	private final IUsuarioRepository usuarioRepository;
	
	@GetMapping 
	public List<Usuario> listaUsuarios(){
		return usuarioRepository.findAll();
	}

}
