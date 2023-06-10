package com.petshop.controller.Admin;

import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.dto.PaginatesDto;

import com.petshop.entity.Products;

import com.petshop.service.ActivityServiceImpl;
import com.petshop.service.PaginatesServiceImpl;

@Controller
public class ManageActivityController extends AdminBaseController {
	@Autowired
	private ActivityServiceImpl activityServiceImpl;
	@Autowired
	private PaginatesServiceImpl paginateService;


	@RequestMapping(value = "/admin/quan-ly-hoat-dong/{currentPage}", method = RequestMethod.GET)
	public ModelAndView ManageOrder(@ModelAttribute("product") Products produc, HttpServletRequest request,
			HttpSession session, HttpServletResponse response, ModelMap model, @PathVariable String currentPage
			,@RequestParam(name = "month", defaultValue = "null") String month
			,@RequestParam (name = "year", defaultValue = "2023") String year) throws NullPointerException, SQLException {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
				int TotalData = 0;
				TotalData = activityServiceImpl.GetDataActivityByMonthAndYear(month,year).size();
				System.out.println("total: "+TotalData);
				PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,
						Integer.parseInt(currentPage));
				mvShare.addObject("pageinfo", pageinfo);
				mvShare.addObject("activityPaginates",
						activityServiceImpl.GetDataActivityPaginates(pageinfo.getStart(), totalProductPage,month,year));
				mvShare.setViewName("admin/crud/list_activity");
			}
		}
		return mvShare;
	}

	/*
	 * @RequestMapping(value = "/admin/xoa-don-hang/{orderId}", method =
	 * RequestMethod.GET) public String DeleteOrder(HttpSession
	 * session, @ModelAttribute("product") Products product,RedirectAttributes
	 * redirectAttributes, HttpServletRequest request, HttpServletResponse response,
	 * ModelMap model, @PathVariable String orderId) { boolean isLogined =
	 * session.getAttribute("LoginInfo") != null ? true : false; String loginRole =
	 * session.getAttribute("role") != null ? session.getAttribute("role") + "" :
	 * ""; if (isLogined == false) { mvShare.setViewName("redirect:/dang-nhap");
	 * 
	 * } else { if (!loginRole.equals("ADMIN")) {
	 * mvShare.setViewName("redirect:/deny-access"); } else { int x =
	 * orderService.DeleteOrder(orderId); activityHistory = "Xóa đơn hàng " +
	 * orderId; Random rd = new Random(); String activity_id = "activity_id_" +
	 * System.currentTimeMillis() + ""; String activityTime =
	 * System.currentTimeMillis() + "";
	 * 
	 * User admin = (User) session.getAttribute("LoginInfo"); Activity activity =
	 * new Activity(activity_id, activityHistory, LocalDateTime.now(),
	 * admin.getUsername()); int add = activityServiceImpl.AddActivity(activity);
	 * redirectAttributes.addFlashAttribute("abc", 1);
	 * mvShare.setViewName("admin/crud/list_order"); } } return
	 * "redirect:/admin/quan-ly-don-hang/all/1?year=2023&month=null"; }
	 */

	/*
	 * @RequestMapping(value = "/admin/cap-nhat-don-hang/{orderId}", method =
	 * RequestMethod.GET) public ModelAndView UpdateOrderGET(HttpSession session,
	 * HttpServletRequest request, Model model, @PathVariable String orderId) {
	 * boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
	 * String loginRole = session.getAttribute("role") != null ?
	 * session.getAttribute("role") + "" : ""; if (isLogined == false) {
	 * mvShare.setViewName("redirect:/dang-nhap");
	 * 
	 * } else { if (!loginRole.equals("ADMIN")) {
	 * mvShare.setViewName("redirect:/deny-access"); } else {
	 * mvShare.addObject("order", orderService.findOrder(orderId));
	 * mvShare.setViewName("admin/crud/update_order"); } } return mvShare; }
	 * 
	 * @RequestMapping(value = "/admin/cap-nhat-don-hang/{orderId}", method =
	 * RequestMethod.POST) public String UpdateOrderPost(HttpSession session,
	 * HttpServletRequest request, HttpServletResponse response, RedirectAttributes
	 * redirectAttributes,
	 * 
	 * @PathVariable String orderId, @ModelAttribute("order") Order order, ModelMap
	 * model,
	 * 
	 * @RequestParam(name = "status", required = true) String status,
	 * 
	 * @RequestParam(name = "address", required = true) String address) {
	 * request.setAttribute("status", status); request.setAttribute("address",
	 * address); if (status.equals("PENDING")) order.setStatus(OrderStatus.PENDING);
	 * else if (status.equals("TO_SHIP")) order.setStatus(OrderStatus.TO_SHIP); else
	 * if (status.equals("TO_RECEIVE")) order.setStatus(OrderStatus.TO_RECEIVE);
	 * else if (status.equals("COMPLETED")) order.setStatus(OrderStatus.COMPLETED);
	 * else if (status.equals("CANCELED")) order.setStatus(OrderStatus.CANCELED);
	 * order.setOrderId(orderId); order.setAddress(address); String activity_id =
	 * "activity_id_" + System.currentTimeMillis() + ""; String activityTime =
	 * System.currentTimeMillis() + "";
	 * 
	 * order.setConfirmTime(LocalDateTime.now()); orderService.UpdateOrder(order);
	 * activityHistory = "Cập nhật đơn hàng " + order.getOrderId() + "(status= " +
	 * status + ",address= " + address; Random rd = new Random();
	 * redirectAttributes.addFlashAttribute("update", 1); User admin = (User)
	 * session.getAttribute("LoginInfo"); Activity activity = new
	 * Activity(activity_id, activityHistory, LocalDateTime.now(),
	 * admin.getUsername()); int add = activityServiceImpl.AddActivity(activity);
	 * mvShare.addObject("order", orderService.findOrder(orderId));
	 * mvShare.setViewName("admin/crud/upadate_order"); return
	 * "redirect:/admin/quan-ly-don-hang/all/1?year=2023&month=null"; }
	 */
}
