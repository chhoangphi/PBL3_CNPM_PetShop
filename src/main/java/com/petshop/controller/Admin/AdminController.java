package com.petshop.controller.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.controller.BaseController;
import com.petshop.dto.PaginatesDto;
import com.petshop.entity.ProductCategory;
import com.petshop.entity.Products;
import com.petshop.entity.TypeOfCategory;
import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.IHomeService;
import com.petshop.service.ItemTypeServiceImpl;
import com.petshop.service.OrderDetailServiceImpl;
import com.petshop.service.OrderServiceImpl;
import com.petshop.service.PaginatesServiceImpl;
import com.petshop.service.ProductService;
import com.petshop.service.TypeOfCategoryServiceImpl;

@Controller
public class AdminController extends BaseController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ItemTypeServiceImpl itemTypeService;
	@Autowired
	private CategoriesServiceImpl categoryService;
	@Autowired
	private PaginatesServiceImpl paginateService;
	@Autowired
	private TypeOfCategoryServiceImpl typeOfCategoryServiceImpl;
	@Autowired
	private HomeServiceImpl homeservice;
	@Autowired
	private OrderDetailServiceImpl orderDetailService;

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView Admin(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			Model model) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		// - trường hợp role yêu cầu của method = null bỏ qua interceptor này và
		// chạy bình thường
		// - khác null tức request này chỉ được thực hiên khi đã đăng nhập
		

		// chưa đăng nhập chuyển hướng sang trang login để đăng nhập
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			// - trường hợp đã login tiến hành kiểm tra role
			// - những trường hợp chỉ yêu cầu login mà không yêu cầu cụ thể
			// role nào thì tất cả các role đều có quyền truy cập
			// - trường hợp yêu cầu cụ thể loại role sau khi đăng nhập thì
			// phải kiểm tra
			// - không thoả mãn điều kiện dưới chuyển hướng sang trang
			// denied
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
				// mvShare.setViewName("admin/index");
			} else {
				mvShare.addObject("productCategory", categoryService.GetAllDataProductCategory());
				mvShare.addObject("dataItemType", itemTypeService.GetDataItemType());
				mvShare.addObject("typeOfCategory", typeOfCategoryServiceImpl.GetDataTypeOfCategory());
				mvShare.addObject("dataProductCategory", categoryService.GetAllDataProductCategory());
				mvShare.setViewName("admin/index");
			}
		}

		return mvShare;
	}

	@RequestMapping(value = "/admin/danh-sach-san-pham/the-loai/{product_cate_id}/{currentPage}")
	public ModelAndView ProductByProductCateg(@ModelAttribute("product") Products product,
			@PathVariable String product_cate_id, @PathVariable String currentPage) {
		mvShare.setViewName("admin/crud/list_products");
		String productCategoryNameByCateID = categoryService.GetProductCategoryNameByProductCateg_ID(product_cate_id);
		System.out.println("productCategoryNameByCateID = " + productCategoryNameByCateID);
		mvShare.addObject("categoryName", productCategoryNameByCateID);
		ProductCategory productCategory = new ProductCategory(homeservice.GetDataProductCategory(product_cate_id));
		int totalProductPage = 12;
		int TotalData = productCategory.getProductList(productCategory).size();
		System.out.println("here" + TotalData);
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,
				Integer.parseInt(currentPage));
		mvShare.addObject("pageinfo", pageinfo);
		mvShare.addObject("ProductPaginate", categoryService.GetDataProductByProductCategoryIDPaginate(product_cate_id,
				pageinfo.getStart(), totalProductPage));
		return mvShare;
	}

	@RequestMapping(value = "/admin/chinh-sua-thong-tin-san-pham/{product_id}", method = RequestMethod.GET)
	public ModelAndView UpdateProductGET(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable String product_id) {
		// mv.setViewName("index")

		mvShare.addObject("dataProducts", productService.GetDataProduct());
		// mvShare.addObject("productCategoryName",
		// categoryService.GetDataProductCategoryNameList());
		// product_id = "d_pd001";
		String productCategoryID = productService.getStringProductCategory(product_id);
		String productCategoryNameByCateID = categoryService.GetProductCategoryNameByProductCateg_ID(productCategoryID);
		mvShare.addObject("productCategoryName", productCategoryNameByCateID);
		Products product = productService.GetDataProductByProductID(product_id);
		mvShare.addObject("product", product);
		mvShare.setViewName("admin/crud/update_products");
		return mvShare;
	}

	@RequestMapping(value = "/admin/cap-nhat-san-pham/{product_id}", method = RequestMethod.POST)
	public String editsave(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("product") Products product, ModelMap model,
			@RequestParam(name = "product_categ_name", required = true) String product_categ_name) {
		request.setAttribute("product_categ_name", product_categ_name);
		String categoryID = categoriesServiceImpl.getStringProductCategoryIDByName(product_categ_name);
		product.setProduct_categ_id(categoryID);
		productService.UpdateProduct(product);
		// mvShare.setViewName("redirect:/home/danh-sach-san-pham");

		// return mvShare;
		return "redirect:/admin/danh-sach-san-pham/the-loai/" + categoryID + "/1";
	}

	@RequestMapping(value = "/admin/xoa-san-pham/{product_id}", method = RequestMethod.GET)
	public String DeleteProduct(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("product") Products product, ModelMap model, @PathVariable String product_id) {
		product.setProduct_id(product_id);
		String categoryID = productService.getStringProductCategory(product_id);
		productService.DeleteProduct(product);

		return "redirect:/admin/danh-sach-san-pham/the-loai/" + categoryID + "/1";
	}

	@RequestMapping(value = "/admin/them-san-pham", method = RequestMethod.GET)
	public ModelAndView AddProduct(HttpServletRequest request, HttpServletResponse response, Model model) {
		mvShare.addObject("productCategoryNameList", categoryService.GetDataProductCategoryNameList());
		mvShare.setViewName("admin/crud/list_products");
		return mvShare;
	}

	@RequestMapping(value = "/admin/them-san-pham", method = RequestMethod.POST)
	public String CreateProduct(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("product") Products product, ModelMap model,
			@RequestParam(name = "product_categ_name", required = true) String product_categ_name) {
		request.setAttribute("product_categ_name", product_categ_name);
		String categoryID = categoriesServiceImpl.getStringProductCategoryIDByName(product_categ_name);
		System.out.println("pdid = " + product.getProduct_id());
		List<String> product_idList = productService.GetDataProductID();
		System.out.println("size=" + product_idList.size());
		int x = 0;
		String tmp1 = "d_pd";
		int max = 0;
		// String tmp1 = id.substring(0, 4);
		for (String string : product_idList) {
			x = Integer.parseInt(string.substring(4));
			System.out.println("x = " + x);
			System.out.println("elm = " + string);
			if (x > max)
				max = x;

		}
		max++;
		System.out.println("max = " + max);
		String tmp = Integer.toString(max);
		if (x < 10)
			tmp = "00" + tmp;
		else if (x < 100)
			tmp = "0" + tmp;
		String tmpID = tmp1 + tmp;
		product.setProduct_id(tmpID);
		product_idList.add(tmpID);
		System.out.println("id =" + tmpID);
		product.setProduct_categ_id(categoryID);
		productService.AddProduct(product);
		return "redirect:/admin/danh-sach-san-pham/the-loai/" + categoryID + "/1";
	}

	@RequestMapping(value = "/admin/*", method = RequestMethod.GET)
	public ModelAndView Home(HttpServletRequest request, HttpServletResponse response, Model model) {
		mvShare.addObject("productCategory", categoryService.GetAllDataProductCategory());
		mvShare.addObject("dataItemType", itemTypeService.GetDataItemType());
		mvShare.addObject("typeOfCategory", typeOfCategoryServiceImpl.GetDataTypeOfCategory());
		mvShare.addObject("dataProductCategory", categoryService.GetAllDataProductCategory());
		mvShare.setViewName("admin/index");
		return mvShare;
	}

	@RequestMapping(value = "/admin/quan-ly-don-hang/{currentPage}", method = RequestMethod.GET)
	public ModelAndView ManageOrder(@ModelAttribute("product") Products produc, HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable String currentPage) {
		mvShare.addObject("dataOrder", orderDetailService.GetDataOrderDetail());
		int totalProductPage = 12;
		int TotalData = orderDetailService.GetDataOrderDetail().size();
		System.out.println("here" + TotalData);
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,
				Integer.parseInt(currentPage));
		mvShare.addObject("pageinfo", pageinfo);
		mvShare.addObject("OrderDetailPaginate",
				orderDetailService.GetDataOrderDetailPaginate(pageinfo.getStart(), totalProductPage));
		mvShare.setViewName("admin/crud/list_order");

		return mvShare;
	}

}
