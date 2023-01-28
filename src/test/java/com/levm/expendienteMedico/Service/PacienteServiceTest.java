package com.levm.expendienteMedico.Service;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
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
						new Paciente(3,"Yimell","Casiano","Gonzalez","03/09/2011",'F'),
						new Paciente(4,"Alexandra","Gonzalez","Casiano","03/09/1995",'F')
						)
				);
	}
	
	@Test
	@DisplayName("Prueba listar todos los pacientes Pacientes")
	public void buscarPacientesTest()
	{
		List<Paciente> list =pacienteService.buscarPacientes();
		assertEquals(4,list.size());
	}
	@Test
	@DisplayName("Prueba  de un buscar un Paciente")
	public void buscarPacienteTest() {
		Optional<Paciente> p1=Optional.of(new Paciente(1,"Luis","Vargas","Martinez","21/11/1992",'M'));
		Mockito.when(pacienteRepository.findById(1)).thenReturn(p1);
		Paciente paciente = pacienteService.buscarPaciente(1);
		assertEquals("Luis Vargas Martinez",paciente.getNombreCompleto());
	}
	
	@Test
	@DisplayName("Prueba buscar un paciente por el sexo")
	public void findPacienteBySexoTest()
	{
		Collection<Paciente> list =pacienteService.findPacienteBySexo('F');
		System.out.print(list.toString());
		assertThat(getPersonasIds(list), CoreMatchers.is(Arrays.asList(3,4)));
	}
	
	@Test
	@DisplayName("Prueba para obtener la edad de un Paciente")
	public void getEdadTest() {
		Optional<Paciente> p1=Optional.of(new Paciente(1,"Yimell","Casiano","Gonzalez","03/09/2011",'F'));
		Mockito.when(pacienteRepository.findById(1)).thenReturn(p1);
		Paciente paciente = pacienteService.buscarPaciente(1);
		assertEquals(11,paciente.getEdad());	
	}
	
	@Test
	@DisplayName("Prueba para buscar un Paciente que no existe")
	public void buscarPacienteTest_whenIsNull()
	{
		Paciente paciente = pacienteService.buscarPaciente(1);
		assertNull(paciente);
	}
	
	@Test
	@DisplayName("Test para actualizar un Paciente")
	public void actualizarPacienteTest()
	{
		Mockito.when(pacienteRepository.existsById(3)).thenReturn(true);
		Paciente p1=new Paciente("Yimell","Casiano","Gonzalez","03/09/2010",'F');
		pacienteService.actualizarPaciente(3, p1);
		InOrder inOrder = Mockito.inOrder(pacienteRepository);
		inOrder.verify(pacienteRepository).existsById(3);	
		inOrder.verify(pacienteRepository).save(p1);	
	}
	
	@Test
	@DisplayName("Test para eliminar un paciente")
	public void eliminarPacienteTest() {
		Paciente p1=new Paciente(4);
		pacienteService.eliminarPaciente(p1);
		verify(pacienteRepository).delete(p1);
	}
	
	private List<Integer> getPersonasIds(Collection<Paciente> pacientes){
		return pacientes.stream().map(paciente -> paciente.getId()).collect(Collectors.toList());
	}
}
