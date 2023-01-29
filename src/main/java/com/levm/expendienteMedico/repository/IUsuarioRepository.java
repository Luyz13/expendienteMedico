package com.levm.expendienteMedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levm.expendienteMedico.entity.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{

}
