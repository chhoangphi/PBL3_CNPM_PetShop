package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dao.RevenueStatisticsDao;
import com.petshop.dto.RevenueStatisticsDto;

@Service
public class RevenueStatisticsServiceImpl implements IRevenueStatisticsService{
	@Autowired
	private RevenueStatisticsDao revenueStatisticsDao;
	
	public long GetDataTotalPriceInMonthAndYear(int month, int year) {
		// TODO Auto-generated method stub
		return revenueStatisticsDao.GetDataTotalPriceInMonthAndYear(month, year);
	}

	public long GetDataTotalOrderInMonthAndYear(int month, int year) {
		// TODO Auto-generated method stub
		return revenueStatisticsDao.GetDataTotalOrderInMonthAndYear(month, year);
	}
	public List<RevenueStatisticsDto> FindDataOrderInMonthAndYear() {
		// TODO Auto-generated method stub
		return revenueStatisticsDao.FindDataOrderInMonthAndYear();
	}
		
}
