package com.petshop.controller.admin;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;
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

import com.petshop.controller.user.BaseController;
import com.petshop.dao.UserDao;
import com.petshop.dto.PaginatesDto;
import com.petshop.entity.Activity;
import com.petshop.entity.ItemType;
import com.petshop.entity.Order;
import com.petshop.entity.Order.OrderStatus;
import com.petshop.entity.ProductCategory;
import com.petshop.entity.Products;
import com.petshop.entity.TypeOfCategory;
import com.petshop.entity.User;
import com.petshop.service.ActivityServiceImpl;
import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.ItemTypeServiceImpl;
import com.petshop.service.OrderServiceImpl;
import com.petshop.service.PaginatesServiceImpl;
import com.petshop.service.ProductService;
import com.petshop.service.RevenueStatisticsServiceImpl;
import com.petshop.service.TypeOfCategoryServiceImpl;
import com.petshop.service.UserServiceImpl;

@Controller
public class AdminController extends AdminBaseController {
	@Autowired
	private RevenueStatisticsServiceImpl  RevenueStatisticService;
	@Autowired OrderDetailServiceImpl orderDetailServiceImpl;
	@RequestMapping(value = {"/admin/home", "/admin/"}, method = RequestMethod.GET)
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
		        mvShare.addObject("monthOfActivity",activityServiceImpl.FindDataActivityInMonthAndYear());

				 Calendar calendar = Calendar.getInstance();
			        int currentMonth = calendar.get(Calendar.MONTH) + 1;
			        int currentYear = calendar.get(Calendar.YEAR);
			        mvShare.addObject("currentMonth",currentMonth);
			        mvShare.addObject("currentYear",currentYear);
			        mvShare.addObject("totalPriceInMonth",RevenueStatisticService.GetDataTotalPriceInMonthAndYear(currentMonth, currentYear));
			        mvShare.addObject("totalOrderInMonth",RevenueStatisticService.GetDataTotalOrderInMonthAndYear(currentMonth, currentYear));
			        mvShare.addObject("dataOrder",RevenueStatisticService.FindDataOrderInMonthAndYear());
				mvShare.setViewName("admin/index");
			}
		}
		return mvShare;
	}
}
