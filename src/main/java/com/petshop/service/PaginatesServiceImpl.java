package com.petshop.service;

import org.springframework.stereotype.Service;

import com.petshop.dto.PaginatesDto;

@Service
public class PaginatesServiceImpl {
	public PaginatesDto GetPatinates(int totalData, int limit, int currentPage) {
		PaginatesDto paginatesDto = new PaginatesDto();
		paginatesDto.setTotalPage(FindTotalPage(totalData, limit));
		paginatesDto.setLimit(limit);

		paginatesDto.setCurrentPage(CheckCurrentPage(currentPage, paginatesDto.getTotalPage()));
		int start = FindStart(currentPage, limit);
		paginatesDto.setStart(start);
		int end = FindEnd(paginatesDto.getStart(), limit,totalData);
		paginatesDto.setEnd(end);
		return paginatesDto;
	}

	private int FindEnd(int start, int limit, int totalData) {

		return start + limit > totalData ? totalData : start + limit - 1;
	}

	public int FindStart(int currentPage, int limit) {
		return ((currentPage - 1) * limit) ;
	}

	public int FindTotalPage(int totalData, int limit) {
		int total = totalData / limit;
		total = total * limit < totalData ? total+1  : total;
		return total;
	}

	public int CheckCurrentPage(int currentPage, int totalPage) {
		if (currentPage < 1)
			return 1;
		if (currentPage > totalPage)
			return totalPage;
		return currentPage;
	}

}
