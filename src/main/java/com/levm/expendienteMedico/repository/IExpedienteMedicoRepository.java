package com.levm.expendienteMedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.levm.expendienteMedico.entity.ExpedienteMedico;

@Repository
public interface IExpedienteMedicoRepository extends JpaRepository<ExpedienteMedico,Long>{

}
