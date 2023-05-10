package com.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.dto.PaginatesDto;
import com.petshop.entity.ItemType;
import com.petshop.entity.ProductCategory;
import com.petshop.entity.Products;
import com.petshop.entity.TypeOfCategory;
import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.PaginatesServiceImpl;

@Controller
public class CategoriesController extends BaseController {
	@Autowired
	private CategoriesServiceImpl CategoriesService;
	@Autowired
	private PaginatesServiceImpl paginateService;

	
	@RequestMapping(value = "/san-pham/{item_id}")
	public ModelAndView Product(@PathVariable String item_id) {
	
		mvShare.setViewName("customer/productByItem");

		ItemType itemType=new ItemType(HomeService.GetDataItemTypeByItemID(item_id));
		mvShare.addObject("ItemType",itemType);
		List<Products> productList=new ArrayList<>();
		
		for (TypeOfCategory item: itemType.getTypeOfCategoryList())
		{
			List<Products> tmpList=CategoriesService.GetDataProductByTypeIDLimit9(item.getType_id());
			productList.addAll(tmpList);
		}
		mvShare.addObject("productByTypeID",productList);
		return mvShare;
	}

	@RequestMapping(value = "/san-pham/{type_id}/{currentPage}")
	public ModelAndView ProductByTypeID(@PathVariable String type_id, @PathVariable String currentPage) {
		mvShare.setViewName("customer/productByType");
		
		List<Products> productList=	CategoriesService.GetDataProductByTypeID(type_id);
		TypeOfCategory typeOfCategory=new TypeOfCategory(HomeService.GetDataTypeOfCategory(type_id));
		mvShare.addObject("typeOfCategory", typeOfCategory);
		
		int totalProductPage = 12;	
		int TotalData = productList.size();
		System.out.println(TotalData);
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,Integer.parseInt(currentPage));
		mvShare.addObject("pageinfo", pageinfo);
		mvShare.addObject("ProductPaginate",CategoriesService.GetDataProductByTypeIDPaginate(type_id, pageinfo.getStart(), totalProductPage));
		return mvShare;
	}
	@RequestMapping(value = "/san-pham/the-loai/{product_cate_id}/{currentPage}")
	public ModelAndView ProductByProductCateg(@PathVariable String product_cate_id, @PathVariable String currentPage) {
		mvShare.setViewName("customer/productByProductcateg");
		
		ProductCategory productCategory=new ProductCategory(HomeService.GetDataProductCategory(product_cate_id));
		mvShare.addObject("productCategory", productCategory);
		
		int totalProductPage = 12;
		int TotalData = productCategory.getProductList(productCategory).size();
		System.out.println("here"+TotalData);
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,Integer.parseInt(currentPage));
		mvShare.addObject("pageinfo", pageinfo);
		mvShare.addObject("ProductPaginate",CategoriesService.GetDataProductByProductCategoryIDPaginate(product_cate_id, pageinfo.getStart(), totalProductPage));
		return mvShare;
	}
}
