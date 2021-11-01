package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ChartDataDAO;
import com.example.model.ChartData;

@Service
public class ChartDataService {
	
	@Autowired
	ChartDataDAO chartDataDAO;
	
	public List<ChartData> getChartDatas(){
		return chartDataDAO.getChartData();
	}
	
	@Transactional
	public void saveChartData(ChartData chartData) {
		chartDataDAO.saveChartData(chartData);
	}
	
	public ChartData getChartData(int id) {
		return chartDataDAO.getChartData(id);
	}
	
	@Transactional
	public void deleteChartData(int id) {
		chartDataDAO.deleteChartData(id);
	}
	
}
