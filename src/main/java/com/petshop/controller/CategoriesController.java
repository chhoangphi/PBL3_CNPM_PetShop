package com.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@RequestMapping(value = "/san-pham")
	public ModelAndView Product(@RequestParam(name = "shop", defaultValue = "item_01") String item_id) {
	
		mvShare.setViewName("customer/productByItem");

		ItemType itemType=new ItemType(HomeService.GetDataItemTypeByItemID(item_id));
		mvShare.addObject("ItemType",itemType);
		List<Products> productList=new ArrayList<>();
		
		for (TypeOfCategory item: itemType.getTypeOfCategoryList())
		{
			List<Products> tmpList=CategoriesService.GetDataProductByTypeIDLimit9(item.getType_id(),"price-asc");
			productList.addAll(tmpList);
		}
		mvShare.addObject("productByTypeID",productList);
		return mvShare;
	}

	@RequestMapping(value = "/san-pham/{type_id}")
	public ModelAndView ProductByTypeID(@PathVariable String type_id
			                           ,@RequestParam(name="sort",defaultValue="price-asc") String sort
			                           ,@RequestParam(name="currentPage",defaultValue="1") String currentPage) {
		mvShare.setViewName("customer/productByType");
		
		List<Products> productList=	CategoriesService.GetDataProductByTypeID(type_id,sort);
		TypeOfCategory typeOfCategory=new TypeOfCategory(HomeService.GetDataTypeOfCategory(type_id));
		mvShare.addObject("typeOfCategory", typeOfCategory);
		
			
		int TotalData = productList.size();
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,Integer.parseInt(currentPage));
		mvShare.addObject("pageinfo", pageinfo);
		mvShare.addObject("ProductPaginate",CategoriesService.GetDataProductByTypeIDPaginate(type_id, pageinfo.getStart(), totalProductPage,sort));
		return mvShare;
	}
	@RequestMapping(value = "/san-pham/the-loai/{product_cate_id}")
	public ModelAndView ProductByProductCateg(@PathVariable String product_cate_id,@RequestParam(name = "currentPage", defaultValue = "1") String currentPage
			,@RequestParam(name = "sort", defaultValue = "price-asc") String sort) {
		mvShare.setViewName("customer/productByProductcateg");
		ProductCategory productCategory=new ProductCategory(HomeService.GetDataProductCategory(product_cate_id));
		mvShare.addObject("productCategory", productCategory);
		System.out.println(currentPage);
		int TotalData = productCategory.getProductList(productCategory).size();
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,Integer.parseInt(currentPage));
		mvShare.addObject("pageinfo", pageinfo);
		mvShare.addObject("ProductPaginate",CategoriesService.GetDataProductByProductCategoryIDPaginate(product_cate_id, pageinfo.getStart(), totalProductPage,sort));
		return mvShare;
	}
}
