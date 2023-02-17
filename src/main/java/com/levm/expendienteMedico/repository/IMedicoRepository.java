package com.levm.expendienteMedico.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levm.expendienteMedico.entity.Medico;

public interface IMedicoRepository extends JpaRepository<Medico,Integer> {
	
	Optional<Medico> findBycedulaProfecional(String cedulaProfesional);

}
