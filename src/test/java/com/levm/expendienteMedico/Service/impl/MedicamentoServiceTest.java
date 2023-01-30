package com.levm.expendienteMedico.Service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.levm.expendienteMedico.entity.Medicamento;
import com.levm.expendienteMedico.repository.IMedicamentoRepository;

@SpringBootTest
class MedicamentoServiceTest {
	
	@Mock
	private IMedicamentoRepository medicamentoRepository;
	
	@InjectMocks
	private MedicamentoService medicamentoService = new MedicamentoService(medicamentoRepository);
	
	@BeforeEach
	public void setUp() throws Exception{
		Mockito.when(medicamentoRepository.findAll())
		.thenReturn(
				Arrays.asList(
						new Medicamento(1L,"Paracetamol","Oral","Diaria","5 DIAS"),
						new Medicamento(2L,"Aspirina","Oral","Diaria","5 DIAS"),
						new Medicamento(3L,"Ibuprofeno","Oral","Topica","5 DIAS"),
						new Medicamento(4L,"Keterolaco","Oral","Diaria","5 DIAS"),
						new Medicamento(5L,"Ampicilina","Oral","Diaria","5 DIAS")
						));
	}
	
	@Test
	void getByDenominacionTest() {
		List<Medicamento> list= medicamentoService.getByDenominacion("Paracetamol");
		assertEquals("Paracetamol",list.get(0).getDenominacion());
	}
	@Test
	void getByViaAdministracionTest() {
		List<Medicamento> list=medicamentoService.getByViaAdministracion("Oral");
		assertEquals(5, list.size());
	}

}
