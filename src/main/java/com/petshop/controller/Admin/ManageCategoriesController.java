package com.petshop.controller.Admin;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.petshop.entity.Activity;
import com.petshop.entity.ItemType;
import com.petshop.entity.Menus;
import com.petshop.entity.ProductCategory;
import com.petshop.entity.TypeOfCategory;
import com.petshop.entity.User;
import com.petshop.service.ActivityServiceImpl;
import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.ItemTypeServiceImpl;
import com.petshop.service.TypeOfCategoryServiceImpl;
@Controller
public class ManageCategoriesController extends AdminBaseController {
	@Autowired
	private ActivityServiceImpl activityServiceImpl;
	@Autowired
	private ItemTypeServiceImpl itemTypeService;
	@Autowired
	private CategoriesServiceImpl categoryService;
	@Autowired
	private TypeOfCategoryServiceImpl typeOfCategoryServiceImpl;
	@Autowired
	private HomeServiceImpl homeServiceImpl;

	@RequestMapping(value = "/admin/them-loai-san-pham/{type_id}", method = RequestMethod.POST)
	public String AddProductCategory(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			@PathVariable String type_id, ModelMap model,
			@RequestParam(name = "productCategoryName", required = true) String productCategoryName) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
				String tmp = "";
				request.setAttribute("productCategoryName", productCategoryName);
				if (type_id.substring(0, 1).equals("d")) {
					tmp = "d_pdc";
				} else
					tmp = "c_pdc";
				tmp += categoryService.GetMaxProduct_cageID();
				ProductCategory productCategory = new ProductCategory();
				productCategory.setProduct_categ_id(tmp);
				productCategory.setProduct_categ_name(productCategoryName);
				productCategory.setType_id(type_id);
				categoryService.AddProductCategory(productCategory);
				User admin = (User) session.getAttribute("LoginInfo");
				activityHistory = "Thêm loại sản phẩm " + productCategoryName;
				String activity_id = "activity_id_" + System.currentTimeMillis() + "";

				Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),
						admin.getUsername());
				activityServiceImpl.AddActivity(activity);
			}
		}

		return "redirect:/admin/home";

	}

	@RequestMapping(value = "/admin/them-dong-san-pham/{item_id}", method = RequestMethod.POST)
	public String AddTypeOfCategory(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			@PathVariable String item_id, ModelMap model,
			@RequestParam(name = "typeOfCategoryName", required = true) String typeOfCategoryName) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
				String tmp = "";
				request.setAttribute("typeOfCategoryName", typeOfCategoryName);
				if (item_id.substring(5, 6).equals("1")) {
					tmp = "dtype";
				} else
					tmp = "ctype";
				tmp += categoryService.GetMaxTypeID();
				TypeOfCategory typeOfCategory = new TypeOfCategory();
				typeOfCategory.setType_id(tmp);
				typeOfCategory.setType_name(typeOfCategoryName);
				typeOfCategory.setItem_id(item_id);
				typeOfCategoryServiceImpl.AddTypeOfCategory(typeOfCategory);
				User admin = (User) session.getAttribute("LoginInfo");
				activityHistory = "Thêm dòng sản phẩm " + typeOfCategoryName;
				String activity_id = "activity_id_" + System.currentTimeMillis() + "";
				Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),
						admin.getUsername());
				activityServiceImpl.AddActivity(activity);
			}
		}

		return "redirect:/admin/home";

	}

	@RequestMapping(value = "/admin/them-shop", method = RequestMethod.POST)
	public String AddPet(HttpSession session, HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@RequestParam(name = "shopName", required = true) String shopName) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
				String tmp = "item";
				request.setAttribute("shopName", shopName);

				tmp += itemTypeService.GetMaxItemID();
				ItemType itemType = new ItemType();
				itemType.setItem_id(tmp);
				itemType.setName(shopName);
				Menus menu = new Menus();
				menu.setMenu_id("menu" + homeServiceImpl.GetMaxMenuID());
				menu.setMenu_name(shopName);
				menu.setItem_id(tmp);
				itemTypeService.AddItemType(itemType);
				homeServiceImpl.AddMenu(menu);
				User admin = (User) session.getAttribute("LoginInfo");
				activityHistory = "Thêm " + shopName;
				String activity_id = "activity_id_" + System.currentTimeMillis() + "";
				Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),
						admin.getUsername());
				activityServiceImpl.AddActivity(activity);
			}
		}

		return "redirect:/admin/home";

	}

}