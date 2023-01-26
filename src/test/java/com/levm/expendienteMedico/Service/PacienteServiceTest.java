package com.levm.expendienteMedico.Service;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;



import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.levm.expendienteMedico.Service.impl.PacienteService;
import com.levm.expendienteMedico.entity.Paciente;
import com.levm.expendienteMedico.repository.IExpedienteMedicoRepository;
import com.levm.expendienteMedico.repository.IPacienteRepository;


@SpringBootTest
public class PacienteServiceTest {
	
	@Mock
	private IPacienteRepository pacienteRepository;
	
	@Mock
	private IExpedienteMedicoRepository expedienteRepository;
	
	@InjectMocks
	private PacienteService pacienteService =
		new PacienteService(pacienteRepository
				,expedienteRepository);
	
	@BeforeEach
	public void setUp() throws Exception{
		
		Mockito.when(pacienteRepository.findAll())
		.thenReturn(
				Arrays.asList(
						new Paciente(1,"Luis","Vargas","Martinez","21/11/1992",'M'),
						new Paciente(2,"Eduardo","Martinez","Vargas","21/11/1993",'M'),
						new Paciente(3,"Yimell","Casiano","Gonzalez","03/09/1995",'F'),
						new Paciente(4,"Alexandra","Gonzalez","Casiano","03/09/1995",'F')
						)
				);
	}
	
	@Test
	public void buscarPacientesTest()
	{
		List<Paciente> list =pacienteService.buscarPacientes();
		assertEquals(4,list.size());
	}
	@Test
	public void buscarPacienteTest() {
		Optional<Paciente> p1=Optional.of(new Paciente(1,"Luis","Vargas","Martinez","21/11/1992",'M'));
		Mockito.when(pacienteRepository.findById(1)).thenReturn(p1);
		Paciente paciente = pacienteService.buscarPaciente(1);
		assertEquals("Luis Vargas Martinez",paciente.getNombreCompleto());
	}
	
	@Test
	public void findPacienteBySexoTest()
	{
		Collection<Paciente> list =pacienteService.findPacienteBySexo('F');
		System.out.print(list.toString());
		//assertEquals(2,getPersonasIds(list));
		assertThat(getPersonasIds(list), CoreMatchers.is(Arrays.asList(3,4)));
	}
	
	private List<Integer> getPersonasIds(Collection<Paciente> pacientes){
		return pacientes.stream().map(paciente -> paciente.getId()).collect(Collectors.toList());
	}
}
