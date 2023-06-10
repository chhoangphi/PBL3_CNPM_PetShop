package com.petshop.controller.Admin;
//hêhê
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.ItemTypeServiceImpl;
import com.petshop.service.ProductService;
import com.petshop.service.TypeOfCategoryServiceImpl;
@Controller
public class AdminBaseController {
	@Autowired
	HomeServiceImpl HomeService;
	@Autowired
	TypeOfCategoryServiceImpl typeOfCategoryServiceImpl;
	@Autowired 
	ProductService productService;
	@Autowired
	public CategoriesServiceImpl categoriesServiceImpl;
	@Autowired
	private ItemTypeServiceImpl itemTypeService;
	@Autowired
	private CategoriesServiceImpl categoryService;
	
	public ModelAndView mvShare = new ModelAndView();
	public static final int totalProductPage = 12;
	public static  String activityHistory = "";
	
	
	@PostConstruct
	public ModelAndView Init () {
		mvShare.addObject("productCategory", categoryService.GetAllDataProductCategory());
		mvShare.addObject("dataItemType", itemTypeService.GetDataItemType());
		mvShare.addObject("typeOfCategory", typeOfCategoryServiceImpl.GetDataTypeOfCategory());
		mvShare.addObject("dataProductCategory", categoryService.GetAllDataProductCategory());
		return mvShare;
	}
}