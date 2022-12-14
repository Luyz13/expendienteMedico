package com.levm.expendienteMedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levm.expendienteMedico.entity.Medico;

public interface IMedicoRepository extends JpaRepository<Medico,String> {

}
