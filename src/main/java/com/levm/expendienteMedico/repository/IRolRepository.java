package com.levm.expendienteMedico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levm.expendienteMedico.entity.ERol;
import com.levm.expendienteMedico.entity.Rol;

public interface IRolRepository extends JpaRepository<Rol, Integer> {
	 
	Optional<Rol> findByName(ERol name);
}
