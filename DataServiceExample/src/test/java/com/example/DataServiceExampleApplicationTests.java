package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.ChartDataDAO;
import com.example.model.ChartData;
import com.example.service.ChartDataService;

@RunWith(SpringRunner.class)
@SpringBootTest
class DataServiceExampleApplicationTests {

	@Autowired
	private ChartDataService service;
	
	@MockBean
	private ChartDataDAO repository;
	Date date = new Date("10/19/2021");
	
	@Test
	public void getChartDataTest() {
		when(repository.getChartData())
		.thenReturn(Stream.of(
				new ChartData(1,"ABC","Stock1",date,(float) 250.0,"INR"),
				new ChartData(1,"XYZ","Stock2",date,(float) 250.0,"INR"))
				.collect(Collectors.toList()));
		
		assertEquals(2, service.getChartDatas().size());
	}
	
	@Test
	public void getChartDataById() {
		
		when(repository.getChartData(1))
		.thenReturn( new ChartData(1,"ABC","Stock1",date,(float) 250.0,"INR"));
		
		ChartData chartData = repository.getChartData(1);
		
		assertEquals("ABC",chartData.getSymbol());
	}
	
	@Test
	public void saveChartData() {
		ChartData chartData = new ChartData(1,"ABC","Stock1",date,(float) 250.0,"INR");
		service.saveChartData(chartData);
		verify(repository,times(1)).saveChartData(chartData);
		
	}
	
	@Test
	public void deleteUserTest() {
		service.deleteChartData(1);
		verify(repository,times(1)).deleteChartData(1);
	}

}
