package com.levm.expendienteMedico.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.levm.expendienteMedico.entity.Expediente;

@Repository
public interface IExpedienteRepository extends JpaRepository<Expediente,Long>{
	
	List<Expediente> findByfechaAltaLessThanEqual(Date fechaAlta);
	List<Expediente> findByfechaAltaGreaterThanEqual(Date fechaAlta);

}
