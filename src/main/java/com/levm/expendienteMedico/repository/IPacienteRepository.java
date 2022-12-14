package com.levm.expendienteMedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.levm.expendienteMedico.entity.Paciente;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Integer> {

}
