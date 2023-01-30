package com.levm.expendienteMedico.Service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.levm.expendienteMedico.entity.Expediente;
import com.levm.expendienteMedico.repository.IExpedienteRepository;

@SpringBootTest
class ExpedienteServiceTest {
	
	@Mock
	private IExpedienteRepository expedienteRepository;
	
	@InjectMocks
	private ExpedienteService expedienteService =
		new ExpedienteService(expedienteRepository);

	@Test
	public void getByfechaAltaLessThanEqualTest() throws ParseException
	{
		Date fechaAlta=getParseDate("2023/01/01");
		Mockito.when(expedienteRepository.findByfechaAltaLessThanEqual(fechaAlta))
		.thenReturn(
				Arrays.asList(
						new Expediente(getParseDate("2022/11/21"),getParseDate("2022/12/21")),
						new Expediente(getParseDate("2022/12/16"),getParseDate("2022/12/21"))));
		
		List<Expediente> list= expedienteRepository.findByfechaAltaLessThanEqual(fechaAlta);
		assertEquals(2,list.size());
		assertEquals(-1,list.get(1).getFechaAlta().compareTo(fechaAlta));
	}
	
	@Test
	public void getByfechaAltaGreatThanEqualTest() throws ParseException
	{
		Date fechaAlta=getParseDate("2023/01/01");
		Mockito.when(expedienteRepository.findByfechaAltaLessThanEqual(fechaAlta))
		.thenReturn(
				Arrays.asList(
						new Expediente(getParseDate("2023/01/21"),getParseDate("2023/03/21")),
						new Expediente(getParseDate("2023/01/16"),getParseDate("2023/02/21")),
						new Expediente(getParseDate("2023/02/16"),getParseDate("2023/02/21"))));
		
		List<Expediente> list= expedienteRepository.findByfechaAltaLessThanEqual(fechaAlta);
		assertEquals(3,list.size());
		assertEquals(1,list.get(1).getFechaAlta().compareTo(fechaAlta));
		
	}
	public Date getParseDate(String fecha) throws ParseException
	{
		final String[] parsers = new String[] {"yyyy'/'DDD", "yyyy'/'MM'/'dd", "yyyyMMdd"};
		return DateUtils.parseDate(fecha, parsers);
		
	}
	

}
