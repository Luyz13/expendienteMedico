package com.levm.expendienteMedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levm.expendienteMedico.entity.Receta;

public interface IRecetaRepository extends JpaRepository<Receta,Integer> {

}
