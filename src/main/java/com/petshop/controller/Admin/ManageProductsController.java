package com.petshop.controller.Admin;

import java.time.LocalDateTime;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.petshop.dto.PaginatesDto;
import com.petshop.entity.Activity;
import com.petshop.entity.ProductCategory;
import com.petshop.entity.Products;
import com.petshop.entity.User;
import com.petshop.service.ActivityServiceImpl;
import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.PaginatesServiceImpl;
import com.petshop.service.ProductService;

@Controller
public class ManageProductsController extends AdminBaseController{
	@Autowired
	private ProductService productService;
	@Autowired
	private ActivityServiceImpl activityServiceImpl;
	@Autowired
	private CategoriesServiceImpl categoryService;
	@Autowired
	private PaginatesServiceImpl paginateService;
	@Autowired
	private HomeServiceImpl homeservice;

	@RequestMapping(value = "/admin/danh-sach-san-pham/{product_cate_id}/{currentPage}")
	public ModelAndView ProductByProductCateg(HttpSession session,@ModelAttribute("product") Products product,
			@PathVariable String product_cate_id, @PathVariable String currentPage
			,@RequestParam(name="stt",defaultValue="all") String stt) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
		mvShare.setViewName("admin/crud/list_products");
		String productCategoryNameByCateID = categoryService.GetProductCategoryNameByProductCateg_ID(product_cate_id);
		System.out.println("productCategoryNameByCateID = " + productCategoryNameByCateID);
		mvShare.addObject("categoryName", productCategoryNameByCateID);
		ProductCategory productCategory = new ProductCategory(homeservice.GetDataProductCategory(product_cate_id));
		mvShare.addObject("productCateg", productCategory);
		List<Products> productList=productService.findProductByProductCategory(productCategory.getProduct_categ_id(),stt);
		int TotalData = productList.size();
		System.out.println("here" + TotalData);
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,
				Integer.parseInt(currentPage));
		mvShare.addObject("pageinfo", pageinfo);
		mvShare.addObject("ProductPaginate", productService.findProductByProductCategoryIDPaginate(product_cate_id,stt,
				pageinfo.getStart(), totalProductPage,"price-asc"));
			}
		}
		return mvShare;
	}
	@RequestMapping(value = "/admin/chinh-sua-thong-tin-san-pham/{product_id}", method = RequestMethod.GET)
	public ModelAndView UpdateProductGET(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable String product_id, HttpSession session) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
		mvShare.addObject("dataProducts", productService.GetDataProduct());
		String productCategoryID = productService.getStringProductCategory(product_id);
		String productCategoryNameByCateID = categoryService.GetProductCategoryNameByProductCateg_ID(productCategoryID);
		mvShare.addObject("productCategoryName", productCategoryNameByCateID);
		Products product = productService.GetDataProductByProductID(product_id);
		mvShare.addObject("product", product);
		mvShare.setViewName("admin/crud/update_products");
			}
		}
		return mvShare;
	}

	@RequestMapping(value = "/admin/cap-nhat-san-pham/{product_id}", method = RequestMethod.POST)
	public String editsave(HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes,
			@ModelAttribute("product") Products product, ModelMap model, HttpSession session,
			@RequestParam(name = "product_categ_name", required = true) String product_categ_name) {
		request.setAttribute("product_categ_name", product_categ_name);
		String categoryID = categoryService.getStringProductCategoryIDByName(product_categ_name);
		product.setProduct_categ_id(categoryID);
		productService.UpdateProduct(product);
		redirectAttributes.addFlashAttribute("update", 1);
		activityHistory = "Cập nhật sản phẩm " + product.getProduct_id();
		String activity_id = "activity_id_" + System.currentTimeMillis() + "";
		User admin = (User) session.getAttribute("LoginInfo");
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(), admin.getUsername());
		activityServiceImpl.AddActivity(activity);
		// mvShare.setViewName("redirect:/home/danh-sach-san-pham");

		// return mvShare;
		return "redirect:/admin/danh-sach-san-pham/" + categoryID + "/1?stt=all";
	}

	@RequestMapping(value = "/admin/xoa-san-pham/{product_id}", method = RequestMethod.GET)
	public String DeleteProduct(HttpSession session, HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes,
			@ModelAttribute("product") Products product, ModelMap model, @PathVariable String product_id) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
		product.setProduct_id(product_id);
		productService.DeleteProduct(product);
		activityHistory = "Xóa sản phẩm " + product.getProduct_id();
		String activity_id = "activity_id_" + System.currentTimeMillis() + "";

		User admin = (User) session.getAttribute("LoginInfo");
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(), admin.getUsername());
		activityServiceImpl.AddActivity(activity);
		redirectAttributes.addFlashAttribute("abc", 1);
			}
		}
		String categoryID = productService.getStringProductCategory(product_id);
		return "redirect:/admin/danh-sach-san-pham/" + categoryID + "/1?stt=all";
	}

	@RequestMapping(value = "/admin/them-san-pham", method = RequestMethod.GET)
	public ModelAndView AddProduct(HttpSession session, HttpServletRequest request, HttpServletResponse response
			,RedirectAttributes redirectAttributes,
			Model model) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
		mvShare.addObject("productCategoryNameList", categoryService.GetDataProductCategoryNameList());
		
		mvShare.setViewName("admin/crud/list_products");
			}
		}
		return mvShare;
	}

	@RequestMapping(value = "/admin/them-san-pham", method = RequestMethod.POST)
	public String CreateProduct(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes,
			@ModelAttribute("product") Products product, ModelMap model,
			@RequestParam(name = "product_categ_name", required = true) String product_categ_name) {
		request.setAttribute("product_categ_name", product_categ_name);
		String categoryID = categoryService.getStringProductCategoryIDByName(product_categ_name);
		System.out.println("pdid = " + product.getProduct_id());
		List<String> product_idList = productService.GetDataProductID(categoryID.substring(0, 1));
		System.out.println("size=" + product_idList.size());
		int x = 0;

		String tmp1 = "";
		if (categoryID.substring(0, 1).equals("d"))
			tmp1 = "d_pd";
		else
			tmp1 = "c_pd";
		int max = 0;
		for (int i = 0; i < product_idList.size(); i++) {
			System.out.println("elm = " + product_idList.get(i));
		}

		// String tmp1 = id.substring(0, 4);
		for (String string : product_idList) {
			x = Integer.parseInt(string.substring(4));
			System.out.println("x = " + x);
			if (string.substring(4) == null)
				x = 0;
			if (x > max)
				max = x;

			System.out.println("max = " + max);

		}
		max++;
		System.out.println("max = " + max);
		String tmp = Integer.toString(max);
		if (max < 10)
			tmp = "00" + tmp;
		else if (max < 100)
			tmp = "0" + tmp;
		String tmpID = tmp1 + tmp;
		product.setProduct_id(tmpID);
		product_idList.add(tmpID);
		redirectAttributes.addFlashAttribute("addproduct", 1);
		product.setProduct_categ_id(categoryID);
//		product.setStatus(1);
		productService.AddProduct(product);
		activityHistory = "Thêm sản phẩm " + product.getProduct_id();
		String activity_id = "activity_id_" + System.currentTimeMillis() + "";

		User admin = (User) session.getAttribute("LoginInfo");
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(), admin.getUsername());
		activityServiceImpl.AddActivity(activity);
		
		return "redirect:/admin/danh-sach-san-pham/" + categoryID + "/1?stt=all";
	}
}
