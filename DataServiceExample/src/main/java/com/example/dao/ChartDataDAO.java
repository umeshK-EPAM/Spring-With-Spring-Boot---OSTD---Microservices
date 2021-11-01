package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.ChartData;


@Repository
public class ChartDataDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<ChartData> getChartData(){
		
		Session session = sessionFactory.getCurrentSession();

		List<ChartData> chartDataList =  session.createQuery("From ChartData",ChartData.class).list();;
		
		return chartDataList;
	}
	
	public void saveChartData(ChartData chartData) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(chartData);
	}
	
	public ChartData getChartData(int id) {
		Session session = sessionFactory.getCurrentSession();
		ChartData chartData = session.get(ChartData.class, id);
		return chartData;
	}
	
	public void deleteChartData(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from CHARTDATA where id=:id").setParameter("id", id).executeUpdate();
	}

}

