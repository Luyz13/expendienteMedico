package com.levm.expendienteMedico.Service;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.levm.expendienteMedico.entity.Paciente;
import com.levm.expendienteMedico.repository.PacienteRepository;


@SpringBootTest
public class PacienteServiceTest {
	
	@Mock
	private PacienteRepository pacienteRepository;
	
	@InjectMocks
	private PacienteService pacienteService = new PacienteService();
	
	@Test
	public void buscarPacientesTest()
	{
		Mockito.when(pacienteRepository.buscarPacientes())
			.thenReturn(
					Arrays.asList(
							new Paciente(1,"Luis","Vargas","Martinez","21/11/1992",'M'),
							new Paciente(2,"Eduardo","Martinez","Vargas","21/11/1993",'M')
							)
					);
		
		List<Paciente> list =pacienteService.buscarPacientes();
		assertEquals(2,list.size());
	}
	@Test
	public void buscarPacienteTest() {
		Mockito.when(pacienteRepository.buscarPaciente(1))
			.thenReturn(
					new Paciente(1,"Luis","Vargas","Martinez","21/11/1992",'M'));
		
		Paciente paciente = pacienteService.buscarPaciente(1);
		assertEquals("Luis Vargas Martinez",paciente.getNombreCompleto());
	}
}
