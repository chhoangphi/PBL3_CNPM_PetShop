package com.petshop.controller.Admin;

import java.sql.SQLException;
import java.time.LocalDateTime;
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
import com.petshop.entity.Order;
import com.petshop.entity.Products;
import com.petshop.entity.User;
import com.petshop.entity.Order.OrderStatus;
import com.petshop.service.ActivityServiceImpl;
import com.petshop.service.OrderDetailServiceImpl;
import com.petshop.service.OrderServiceImpl;
import com.petshop.service.PaginatesServiceImpl;

@Controller
public class ManageOrdersController extends AdminBaseController {
	@Autowired
	private ActivityServiceImpl activityServiceImpl;
	@Autowired
	private PaginatesServiceImpl paginateService;
	@Autowired
	private OrderServiceImpl orderService;
	@Autowired
	private OrderDetailServiceImpl orderDetailServiceImpl;

	@RequestMapping(value = "/admin/quan-ly-don-hang/{orderStatus}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView ManageOrder(@ModelAttribute("product") Products produc, HttpServletRequest request,
			HttpSession session, HttpServletResponse response, ModelMap model, @PathVariable String currentPage,
			@PathVariable String orderStatus, @RequestParam(name = "month", defaultValue = "null") String month,
			@RequestParam(name = "year", defaultValue = "2023") String year) throws NullPointerException, SQLException {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
				mvShare.addObject("status", orderStatus);
				int TotalData = 0;
				TotalData = orderService.GetDataOrderByStatus(orderStatus, month, year).size();
				System.out.println("total: " + TotalData);
				PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,
						Integer.parseInt(currentPage));
				mvShare.addObject("pageinfo", pageinfo);
				mvShare.addObject("OrderPaginate", orderService.GetDataOrderPaginate(pageinfo.getStart(),
						totalProductPage, orderStatus, month, year));
				mvShare.setViewName("admin/crud/list_order");
			}
		}
		return mvShare;
	}

	@RequestMapping(value = "/admin/xoa-don-hang/{orderId}", method = RequestMethod.GET)
	public String DeleteOrder(HttpSession session, @ModelAttribute("product") Products product,
			RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response,
			ModelMap model, @PathVariable String orderId) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
				orderService.DeleteOrder(orderId);
				activityHistory = "Xóa đơn hàng " + orderId;
				String activity_id = "activity_id_" + System.currentTimeMillis() + "";
				User admin = (User) session.getAttribute("LoginInfo");
				Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),
						admin.getUsername());
				activityServiceImpl.AddActivity(activity);
				redirectAttributes.addFlashAttribute("abc", 1);
				mvShare.setViewName("admin/crud/list_order");
			}
		}
		return "redirect:/admin/quan-ly-don-hang/all/1?year=2023&month=null";
	}

	@RequestMapping(value = "/admin/cap-nhat-don-hang/{orderId}", method = RequestMethod.GET)
	public ModelAndView UpdateOrderGET(HttpSession session, HttpServletRequest request, Model model,
			@PathVariable String orderId) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
				mvShare.addObject("order", orderService.findOrder(orderId));
				mvShare.setViewName("admin/crud/update_order");
			}
		}
		return mvShare;
	}

	@RequestMapping(value = "/admin/cap-nhat-don-hang/{orderId}", method = RequestMethod.POST)
	public String UpdateOrderPost(RedirectAttributes redirectAttributes, HttpSession session,
			HttpServletRequest request, HttpServletResponse response, @PathVariable String orderId,
			@ModelAttribute("order") Order order, ModelMap model,
			@RequestParam(name = "status", required = true) String status,
			@RequestParam(name = "address", required = true) String address) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
				boolean check = true;
				request.setAttribute("status", status);
				request.setAttribute("address", address);
				order = orderService.findOrder(orderId);
				if (status.equals("PENDING")) {
					order.setStatus(OrderStatus.PENDING);
					redirectAttributes.addFlashAttribute("update", 1);
				} else if (status.equals("TO_SHIP")) {
					order.setStatus(OrderStatus.TO_SHIP);
					order.setShipTime(LocalDateTime.now());
					redirectAttributes.addFlashAttribute("update", 1);
				} else if (status.equals("TO_RECEIVE")) {
					order.setStatus(OrderStatus.TO_RECEIVE);
					order.setReceiveTime(LocalDateTime.now());
					redirectAttributes.addFlashAttribute("update", 1);
				} else if (status.equals("COMPLETED")) {
					order.setStatus(OrderStatus.COMPLETED);
					order.setCompletedTime(LocalDateTime.now());
					for (int i = 0; i < order.getOrderDetailList().size(); i++) {
						System.out.println("index = " + i);
						orderDetailServiceImpl.UpdateSoldQuantity(order.getOrderDetailList().get(i));
					}
					redirectAttributes.addFlashAttribute("update", 1);
				} else if (status.equals("CANCELED") && order.getCompletedTime() == null
						&& order.getReceiveTime() == null) {
					redirectAttributes.addFlashAttribute("update", 1);
					order.setStatus(OrderStatus.CANCELED);
					order.setCancleTime(LocalDateTime.now());
				} else if (status.equals("CANCELED")) {
					if (order.getCompletedTime() != null || order.getReceiveTime() != null) {
						redirectAttributes.addFlashAttribute("update", 0);
						check = false;
						order.setStatus(OrderStatus.CANCELED);
						order.setCancleTime(LocalDateTime.now());
					}
				} else {
					redirectAttributes.addFlashAttribute("update", 0);
					check = false;
				}

				order.setOrderId(orderId);
				order.setAddress(address);

				order.setConfirmTime(LocalDateTime.now());
				if (check) {
					String activity_id = "activity_id_" + System.currentTimeMillis() + "";
					orderService.UpdateOrder(order);
					activityHistory = "Cập nhật đơn hàng " + order.getOrderId() + "(status= " + status + ",address= "
							+ address;

					User admin = (User) session.getAttribute("LoginInfo");
					Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),
							admin.getUsername());
					activityServiceImpl.AddActivity(activity);
				}
				mvShare.addObject("order", orderService.findOrder(orderId));
				mvShare.setViewName("admin/crud/upadate_order");
				return "redirect:/admin/quan-ly-don-hang/all/1?year=2023&month=null";

			}
		}
		return "redirect:/admin/quan-ly-don-hang/all/1?year=2023&month=null";

	}
}
