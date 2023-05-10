package com.petshop.service;

import org.springframework.stereotype.Service;

import com.petshop.dto.PaginatesDto;

@Service
public interface IPaginatesService {
		public PaginatesDto GetPatinates(int totalData,int limit,int currentPage);
}
