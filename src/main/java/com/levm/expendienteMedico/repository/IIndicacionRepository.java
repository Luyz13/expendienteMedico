package com.levm.expendienteMedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levm.expendienteMedico.entity.Indicacion;

public interface IIndicacionRepository extends JpaRepository<Indicacion,Integer> {

}
