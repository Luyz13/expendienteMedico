package com.levm.expendienteMedico.Service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.levm.expendienteMedico.entity.Indicacion;
import com.levm.expendienteMedico.entity.Receta;
import com.levm.expendienteMedico.repository.IIndicacionRepository;
import com.levm.expendienteMedico.repository.IRecetaRepository;

@SpringBootTest
class IndicacionServiceTest {
	
	@Mock
	private IIndicacionRepository indicacionRepository;
	@Mock
	private IRecetaRepository recetaRepository;
	
	@InjectMocks
	private IndicacionService indicacionService=
		new IndicacionService(
				indicacionRepository,
				recetaRepository);

	@Test
	@DisplayName("Test para añadir una receta a una indicación")
	void addRecetaToTest() {
		Mockito.when(indicacionRepository.existsById(1)).thenReturn(true);
		Indicacion indicacion = new Indicacion(1,"Algo");
		Receta receta = new Receta(1);
		indicacionService.update(1, indicacion);
		verify(indicacionRepository).existsById(1);
		verify(indicacionRepository).save(indicacion);
	}



}
