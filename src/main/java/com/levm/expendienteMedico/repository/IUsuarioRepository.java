package com.levm.expendienteMedico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levm.expendienteMedico.entity.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{
    
	Optional<Usuario> findOneByEmail(String email);
	Optional<Usuario> findByNombre(String usuario);
	Boolean existsByNombre(String usuario);
	Boolean existsByEmail(String email);

}
