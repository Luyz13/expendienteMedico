package com.levm.expendienteMedico.Service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.levm.expendienteMedico.entity.Medico;
import com.levm.expendienteMedico.repository.IMedicoRepository;

@SpringBootTest
class MedicoServiceTest {
	
	@Mock
	private IMedicoRepository medicoRepository;
	
	@InjectMocks
	private MedicoService medicoService = new MedicoService(medicoRepository);
	
	@BeforeEach
	public void setUp() throws Exception{
		
		Mockito.when(medicoRepository.findAll())
		.thenReturn(
				Arrays.asList(
						new Medico("1856575",
								"UAEM",
								"Altagracia",
								"Mondragon",
								"Duran",
								"18/01/1985",
								'F'),
						new Medico("9084573",
								"UNAM",
								"Ramirez",
								"Estrada",
								"Wendolyn",
								"18/01/1984",
								'F'),
						new Medico("1856574",
								"UAEM",
								"Karla",
								"Lopez",
								"Perez",
								"18/01/1985",
								'F')
						));
	}
	@Test
	void getByUniversidadTest() {
		Mockito.when(medicoRepository.findBycedulaProfecional("9084573"))
			.thenReturn(
					Optional.of(new Medico("9084573",
							"UNAM",
							"Ramirez",
							"Estrada",
							"Wendolyn",
							"18/01/1984",
							'F')));
		Optional<Medico> medico = medicoService.getByCedula("9084573");
		assertTrue(medico.get().getCedulaProfecional().compareTo("9084573")==0);
		
	}
	@Test 
	void getByCedula(){
		List<Medico> medicoList =medicoService.getByUniversidad("UAEM");
		assertEquals(2,medicoList.size());
	}

}
