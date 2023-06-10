package com.petshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.dto.RevenueStatisticsDto;

@Service
public interface IRevenueStatisticsService {
	public long GetDataTotalPriceInMonthAndYear(int month,int year);
	public long GetDataTotalOrderInMonthAndYear(int month,int year);
	public List<RevenueStatisticsDto> FindDataOrderInMonthAndYear();
}
