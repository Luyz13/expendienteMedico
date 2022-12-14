package com.levm.expendienteMedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levm.expendienteMedico.entity.Medicamento;

public interface IMedicamentoRepository extends JpaRepository<Medicamento,Long>{

}
