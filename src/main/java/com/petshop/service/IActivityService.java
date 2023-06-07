package com.petshop.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.entity.Activity;
@Service
public interface IActivityService {
	public List<Activity> GetDataActivity(); 
	public int AddActivity(Activity activity);
	
}
