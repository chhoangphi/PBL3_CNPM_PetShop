package com.petshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.dto.PaginatesDto;
import com.petshop.entity.Products;
import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.PaginatesServiceImpl;



@Controller
public class HomeController extends BaseController{
	@Autowired
	private PaginatesServiceImpl paginateService;
	@Autowired
	private CategoriesServiceImpl categoryService;
	@RequestMapping(value = { "/trang-chu", "/" })
	public ModelAndView Index() {
		mvShare.setViewName("customer/home");
		mvShare.addObject("dataProducts", productService.GetDataProduct());
		mvShare.addObject("productCategoryNameList", categoryService.GetDataProductCategoryNameList());

		return mvShare;
	}
	@RequestMapping(value = { "/deny-access" })
	public ModelAndView Test() {
		mvShare.setViewName("error/denyaccess");

		return mvShare;
	}
//	@RequestMapping(value= {"/tim-kiem-san-pham/{currentPage}"},method = RequestMethod.GET)
//	public ModelAndView Search( @PathVariable String currentPage, HttpServletRequest request)
//	{
//		request.setAttribute("productNameToSearch", productName);
//		System.out.println(" productNameToSearch " + productName);
//		List<Products> listProducts = productService.SearchProducts(productName);
//		mvShare.addObject("listProducts", listProducts);
//		mvShare.addObject("searchCondition", productName);
//		int totalProductPage = 12;	
//		int TotalData = listProducts.size();
//		System.out.println(TotalData);
//		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,Integer.parseInt(currentPage));
//		mvShare.addObject("pageinfo", pageinfo);
//		mvShare.addObject("ProductPaginate",productService.GetDataProductPaginate(pageinfo.getStart(), totalProductPage));
//		mvShare.setViewName("customer/searchProducts");
//		return mvShare;
//	}
	@RequestMapping(value= {"/tim-kiem-san-pham/{currentPage}"},method = RequestMethod.POST)
	public ModelAndView SearchMethodPost( @PathVariable String currentPage, HttpServletRequest request,@RequestParam(name = "productNameToSearch", required = true) String productName)
	{
		request.setAttribute("productNameToSearch", productName);
		System.out.println(" productNameToSearch " + productName);
		List<Products> listProducts = productService.SearchProducts(productName);
		mvShare.addObject("listProducts", listProducts);
		mvShare.addObject("searchCondition", productName);
		int totalProductPage = 12;	
		int TotalData = listProducts.size();
		System.out.println(TotalData);
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,Integer.parseInt(currentPage));
		mvShare.addObject("pageinfo", pageinfo);
		mvShare.addObject("ProductPaginate",productService.GetDataProductPaginateInSearchFeature(pageinfo.getStart(), totalProductPage,productName));
		mvShare.setViewName("customer/searchProducts");
		return mvShare;
	}
}
