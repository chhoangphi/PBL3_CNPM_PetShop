package com.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.dao.ActivityDao;

import com.petshop.entity.Activity;

@Service
public class ActivityServiceImpl implements IActivityService{

	@Autowired
	private ActivityDao activityTypeDao;

	@Override
	public List<Activity> GetDataActivity() {
		// TODO Auto-generated method stub
		return activityTypeDao.GetDataActivity();
	}

	@Override
	public int AddActivity(Activity activity) {
		// TODO Auto-generated method stub
		return activityTypeDao.AddActivity(activity);
	}
	
	
	

	

}
