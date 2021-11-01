package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.DataNotFoundException;
import com.example.model.ChartData;
import com.example.service.ChartDataService;

@RestController
public class ChartDataRestController {
	
	@Autowired
	ChartDataService chartDataService;
	
	@GetMapping("/chartdata")
	public List<ChartData> getChartDatas(){
		return chartDataService.getChartDatas();
	}
	
	@GetMapping("/chartdata/{id}")
	public ChartData getChartData(@PathVariable int id) throws DataNotFoundException {
		ChartData chartData = chartDataService.getChartData(id);
		if(chartData == null) {
			throw new DataNotFoundException("Data with id not found: "+id);
		}
		return chartData;
	}
	
	@PostMapping("/chartdata")
	public ChartData addChartData(@RequestBody ChartData chartData) {
		chartDataService.saveChartData(chartData);
		return chartData;
	}
	
	@PutMapping("/chartdata")
	public ChartData updateChartData(@RequestBody ChartData chartData) {
		chartDataService.saveChartData(chartData);
		return chartData;
	}
	
	@DeleteMapping("chartdata/{id}")
	public String deleteChartData(@PathVariable int id) throws DataNotFoundException {
		ChartData chartData = chartDataService.getChartData(id);
		
		if(chartData==null)
			throw new DataNotFoundException("ChartData id not found: "+id);
		chartDataService.deleteChartData(id);
		return "Deleted ChartData id: "+id;
	}
	
	
}
