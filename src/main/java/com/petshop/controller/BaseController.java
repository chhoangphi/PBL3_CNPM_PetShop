package com.petshop.controller;
//hê
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.entity.Menus;
import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.ItemTypeServiceImpl;
import com.petshop.service.ProductService;
import com.petshop.service.TypeOfCategoryServiceImpl;
@Controller
public class BaseController {
	@Autowired
	HomeServiceImpl HomeService;
	@Autowired
	TypeOfCategoryServiceImpl typeOfCategoryServiceImpl;
	@Autowired 
	ProductService productService;
	@Autowired
	public CategoriesServiceImpl categoriesServiceImpl;
	public ModelAndView mvShare = new ModelAndView();
	public static final int totalProductPage = 12;
	public static  String activityHistory = "";
	
	
	@PostConstruct
	public ModelAndView Init () {
		List<Menus> menu=HomeService.GetDataMenu();
		mvShare.addObject("menu", HomeService.GetDataMenu());
		for(int i=0;i<menu.size();i++)
		{
			if (menu.get(i).getItem_id()!=null)
			{  
			   mvShare.addObject(menu.get(i).getItem_id(),typeOfCategoryServiceImpl.GetDataTypeOfCategoryList(menu.get(i).getItem_id()));
			}
		}
		return mvShare;
	}
}