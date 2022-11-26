package com.levm.expendienteMedico.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.levm.expendienteMedico.entity.Paciente;

@Repository
public class PacienteRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Paciente> buscarPacientes() {
		return em.createQuery("SELECT p FROM Paciente p",Paciente.class).getResultList();
	}
	
	public Paciente buscarPaciente(int noExpediente) {
		return em.find(Paciente.class, noExpediente);	
	}
	
	@Transactional
	public void eliminarPaciente(Paciente paciente)
	{
		em.remove(em.merge(paciente));
	}
	
	@Transactional
	public void agregarPaciente(Paciente paciente)
	{
		em.persist(paciente);
	}
	
	@Transactional
	public void actualizarPaciente(Paciente paciente)
	{
		em.merge(paciente);
	}
}
