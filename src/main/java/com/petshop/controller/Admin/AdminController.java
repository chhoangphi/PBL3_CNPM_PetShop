package com.petshop.controller.Admin;

import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.petshop.service.ActivityServiceImpl;
import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.ItemTypeServiceImpl;
import com.petshop.service.RevenueStatisticsServiceImpl;


@Controller
public class AdminController extends AdminBaseController {
	@Autowired
	private RevenueStatisticsServiceImpl  RevenueStatisticService;
	@Autowired
	private CategoriesServiceImpl categoryService;
	@Autowired
	private ActivityServiceImpl activityServiceImpl;
	@Autowired
	private ItemTypeServiceImpl itemTypeService;
	
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
			        mvShare.addObject("monthOfActivity",activityServiceImpl.FindDataActivityInMonthAndYear());

				mvShare.setViewName("admin/index");
			}
		}
		return mvShare;
	}
}
