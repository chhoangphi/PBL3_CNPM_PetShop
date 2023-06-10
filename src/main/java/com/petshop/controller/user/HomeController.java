package com.petshop.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.dto.PaginatesDto;
import com.petshop.entity.ItemType;
import com.petshop.entity.Products;
import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.ItemTypeServiceImpl;
import com.petshop.service.PaginatesServiceImpl;
import com.petshop.service.ProductService;



@Controller
public class HomeController extends BaseController{
	@Autowired
	private PaginatesServiceImpl paginateService;
	@Autowired
	private CategoriesServiceImpl categoryService;
	@Autowired
	private ItemTypeServiceImpl itemTypeService;
	@Autowired
	private ProductService productService;
	@RequestMapping(value = { "/trang-chu", "/" })
	public ModelAndView Index() {
		mvShare.setViewName("customer/home");
		List<ItemType> listItem=itemTypeService.GetDataItemType();
		mvShare.addObject("listItem", listItem);
		mvShare.addObject("dataProducts", productService.GetDataProduct());
		mvShare.addObject("productCategoryNameList", categoryService.GetDataProductCategoryNameList());
		mvShare.addObject("itemType",HomeService.GetDataItemType());
		mvShare.addObject("itemType01",HomeService.GetDataItemTypeByItemID(listItem.get(0).getItem_id()));
		mvShare.addObject("itemType02",HomeService.GetDataItemTypeByItemID(listItem.get(1).getItem_id()));
		mvShare.addObject("featuredCateg", categoriesServiceImpl.GetFeaturedCategory());
		mvShare.addObject("featuredCategByItem01", categoriesServiceImpl.GetFeaturedCategoryByItemId(listItem.get(0).getItem_id()));
		mvShare.addObject("featuredCategByItem02", categoriesServiceImpl.GetFeaturedCategoryByItemId(listItem.get(1).getItem_id()));
		mvShare.addObject("productLimit12ByItem01", productService.GetDataProductLimit12(listItem.get(0).getItem_id()));
		mvShare.addObject("productLimit12ByItem02", productService.GetDataProductLimit12(listItem.get(1).getItem_id()));
		mvShare.addObject("menu", HomeService.GetDataMenu());
		return mvShare;
	}
	@RequestMapping(value = { "/deny-access" })
	public ModelAndView Test() {
		mvShare.setViewName("error/denyaccess");
		mvShare.addObject("menu", HomeService.GetDataMenu());


		return mvShare;
	}
	@RequestMapping(value = { "/gioi-thieu" })
	public ModelAndView AboutUs() {
		mvShare.setViewName("customer/aboutus");
		mvShare.addObject("menu", HomeService.GetDataMenu());


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
