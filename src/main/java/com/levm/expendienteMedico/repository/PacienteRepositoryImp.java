package com.levm.expendienteMedico.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.levm.expendienteMedico.entity.Paciente;

@Repository
public class PacienteRepositoryImp implements PacienteRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Paciente> findAll() {
		return em.createQuery("SELECT p FROM Paciente p",Paciente.class).getResultList();
	}
	
	public Paciente findById(int noExpediente) {
		return em.find(Paciente.class, noExpediente);	
	}
	
	@Transactional
	public void delete(Paciente paciente)
	{
		em.remove(em.merge(paciente));
	}
	
	@Transactional
	public void save(Paciente paciente)
	{
		em.persist(paciente);
	}
	
	@Transactional
	public void update(Paciente paciente)
	{
		em.merge(paciente);
	}
}
