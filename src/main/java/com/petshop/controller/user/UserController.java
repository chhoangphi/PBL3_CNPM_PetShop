package com.petshop.controller.user;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petshop.entity.Activity;
import com.petshop.entity.Order;
import com.petshop.entity.Role;
import com.petshop.entity.User;
import com.petshop.service.ActivityServiceImpl;
import com.petshop.service.OrderServiceImpl;
import com.petshop.service.UserServiceImpl;

@Controller
public class UserController extends BaseController {
	@Autowired
	UserServiceImpl userServiceImpl = new UserServiceImpl();
	@Autowired
	ActivityServiceImpl activityServiceImpl = new ActivityServiceImpl();
	@Autowired
	private OrderServiceImpl orderService;
	//ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView DangKy() {
		// mv.setViewName("index")
		mvShare.setViewName("customer/register");

		mvShare.addObject("user", new User());
		return mvShare;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateAcc(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "password", required = true) String password,
			@RequestParam(name = "fullName", required = true) String fullName,
			@RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "dateofbirth", required = true) String dateOfBirth,
			@RequestParam(name = "gender", required = true) String gender,
			@RequestParam(name = "phonenumber", required = true) String phoneNumber) {

		request.setAttribute("username", username);
		request.setAttribute("password", password);
		request.setAttribute("fullName", fullName);
		request.setAttribute("email", email);
		request.setAttribute("gender", gender);
		request.setAttribute("dateofbirth", dateOfBirth);
		request.setAttribute("phonenumber", phoneNumber);
		mvShare.addObject("menu", HomeService.GetDataMenu());

		Role role = new Role();
		role.setCode("USER");
		role.setName("Người dùng");
		User user = new User(username, fullName,password, 1,1,role, gender,Date.valueOf(dateOfBirth),phoneNumber, email);
		
		User check = userServiceImpl.GetUser(user);
		String baoLoi = "";
		if (check != null) {
			baoLoi = "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/> ";
			request.setAttribute("baoLoi", baoLoi);
			mvShare.addObject("status", "Đăng ký tài khoản thất bại");
			mvShare.setViewName("customer/register");

		} else {
			int count = userServiceImpl.AddUser(user);

			if (count > 0) {
				mvShare.addObject("status", "Đăng ký tài khoản thành công");
				activityHistory = "Đăng ký tài khoản " + user.getUsername();
				String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
				Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),"");
				activityServiceImpl.AddActivity(activity);
				mvShare.setViewName("redirect:dang-nhap");
				
			} else {
				mvShare.addObject("status", "Đăng ký tài khoản thất bại");
				mvShare.setViewName("customer/register");
			}
			System.out.println("count = " + count);

		}
		// mvShare.setViewName("customer/thanhcong");
		
		
		

		return mvShare;
	}

	

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String DangXuat(HttpServletRequest request, HttpSession session) {
		mvShare.addObject("menu", HomeService.GetDataMenu());

		session.removeAttribute("LoginInfo");
		return "redirect:dang-nhap";
	}
	@RequestMapping(value="/thong-tin-ca-nhan",method = RequestMethod.GET)
	public String Profile(HttpSession session,HttpServletRequest request) {
		mvShare.addObject("menu", HomeService.GetDataMenu());

		User user=(User) session.getAttribute("LoginInfo");
		if (user!=null) {
		mvShare.setViewName("customer/profile");
		request.setAttribute("menu", HomeService.GetDataMenu());
		request.setAttribute("personalInfo", user);
		session.setAttribute("page", "personalInfopage");
		request.getAttribute("changeStatus");
		User model = userServiceImpl.findByUserNameAndPasswordAndStatus(user);
		session.setAttribute("LoginInfo", userServiceImpl.GetUser(model));
		return mvShare.getViewName();
		}
		else return "redirect:/dang-nhap";
	}
	@RequestMapping(value="/thong-tin-ca-nhan",method = RequestMethod.POST)
	public String Profile(RedirectAttributes redirectAttributes,HttpSession session,HttpServletRequest request,@ModelAttribute("personalInfo") User user) {
		User infoUser=(User) session.getAttribute("LoginInfo");
		if (userServiceImpl.changeInfomation(user.getFullName(), user.getEmail(), user.getPhoneNumber(), infoUser)>0){
			redirectAttributes.addFlashAttribute("changeStatus","Thay đổi thành công");
			session.setAttribute("LoginInfo", userServiceImpl.GetUser(infoUser));
			return "redirect:"+request.getHeader("Referer");
		}
		return "redirect:"+request.getHeader("Referer");
	}
	@RequestMapping(value="/tai-khoan-va-bao-mat",method = RequestMethod.GET)
	public String Security(HttpSession session,HttpServletRequest request) {
		mvShare.addObject("menu", HomeService.GetDataMenu());
		User user=(User) session.getAttribute("LoginInfo");
		if (user!=null) {
			mvShare.setViewName("customer/profile");
		request.setAttribute("account", user);
		request.setAttribute("menu", HomeService.GetDataMenu());
		session.setAttribute("page", "accountpage");
		request.getAttribute("changeStatus");
		return mvShare.getViewName();
		}
		else return "redirect:/dang-nhap";
	}
	@RequestMapping(value="/tai-khoan-va-bao-mat",method = RequestMethod.POST)
	public String Security(RedirectAttributes redirectAttributes,HttpServletRequest request,HttpSession session
						,@RequestParam(name = "oldPassword", required = true) String oldPassword
						,@RequestParam(name = "newPassword", required = true) String newPassword) {
		User user=(User) session.getAttribute("LoginInfo");
		if (!BCrypt.checkpw(oldPassword,user.getPassword())) {
			redirectAttributes.addFlashAttribute("changeStatus","Mật khẩu cũ không chính xác");
			return "redirect:"+request.getHeader("Referer");
		} 
		else 
			{
				if (userServiceImpl.changePassword(newPassword, user)>0)
					redirectAttributes.addFlashAttribute("changeStatus","Thay đổi mật khẩu thành công");
				return "redirect:"+request.getHeader("Referer");
			}
	}
	@RequestMapping(value="/don-hang/{status}",method = RequestMethod.GET)
	public String order(HttpSession session,HttpServletRequest request,@PathVariable String status) {
		mvShare.addObject("menu", HomeService.GetDataMenu());
		User user=(User) session.getAttribute("LoginInfo");
		if (user!=null) {
			mvShare.setViewName("customer/profile");
		List<Order> orderList=orderService.findOrderByStatus(status,user.getUsername());
		List<Order> dataOrder=orderService.GetDataOrderByUsername(user.getUsername());
		System.out.println("dtaordersize=" + dataOrder.size());
		request.setAttribute("Order", orderList);
		request.setAttribute("dataOrder", dataOrder);
		request.setAttribute("customer", user);
		session.setAttribute("page", "orderpage");
		request.setAttribute("menu", HomeService.GetDataMenu());
		request.setAttribute("status", status);
		return mvShare.getViewName();
		}
		else return "redirect:/dang-nhap";
	}
	@GetMapping(value = "/chi-tiet-don-hang/{orderID}")
	public String OrderDetail(HttpServletRequest request,HttpSession session,@PathVariable String orderID) {
		mvShare.addObject("menu", HomeService.GetDataMenu());
		if (session.getAttribute("LoginInfo")==null) {
			return "redirect:/dang-nhap";
		}
		else
		{
		request.getAttribute("abc"); 
		mvShare.setViewName("customer/order_detail");
		Order order=new Order(orderService.findOrder(orderID));
		request.setAttribute("totalPriceProducts", orderService.TotalPriceProducts(order.getOrderDetailList()));
		request.setAttribute("menu", HomeService.GetDataMenu());
		request.setAttribute("Order",order);
		
		return mvShare.getViewName();
		}
	}
	@GetMapping("/huy-don-hang/{orderID}")
	public String Cancel(HttpSession session,RedirectAttributes redirectAttributes,HttpServletRequest request,@PathVariable String orderID) {
			orderService.DeleteOrder(orderID);
			activityHistory = "Hủy đơn hàng " + orderID ;
			String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
			User admin=(User) session.getAttribute("LoginInfo");
			Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),admin.getUsername());
			activityServiceImpl.AddActivity(activity);
			redirectAttributes.addFlashAttribute("abc",1);

			return "redirect:"+request.getHeader("Referer");
	}
	@RequestMapping(value = "/thong-tin-tai-khoan", method = RequestMethod.GET)
	public ModelAndView Profile(HttpSession session) {
		User user = (User) session.getAttribute("LoginInfo");
		mvShare.addObject("menu", HomeService.GetDataMenu());
		if (user != null) {
			List<Order> orderList = orderService.findAllOrder(user.getUsername());
			mvShare.addObject("orderList", orderList);
			mvShare.addObject("user", user);
		}
		mvShare.setViewName("customer/profile");
		return mvShare;
	}

	@RequestMapping(value = "/thong-tin-tai-khoan", method = RequestMethod.POST)
	public void EditProfile(HttpSession session, @ModelAttribute("user") User user) {

	}


	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView LoginGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		mvShare.addObject("menu", HomeService.GetDataMenu());
		mvShare.setViewName("customer/login");
		mvShare.addObject("user", new User());
		return mvShare;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public String Login(HttpServletRequest request, HttpServletResponse response,HttpSession session,
			@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "password", required = true) String password) throws ServletException, IOException {
		User user = new User();
		String url = "";
		mvShare.setViewName("customer/login");
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		user.setUsername(username);
		user.setPassword(password);
		user.setStatus(1);
		User model = userServiceImpl.findByUserNameAndPasswordAndStatus(user);
		if (model != null) {
			//SessionUtil.getInstance().putValue(request, "model", model);
			session.setAttribute("LoginInfo", userServiceImpl.GetUser(model));
			mvShare.addObject("statusLogin", "");
			session.setAttribute("role", model.getRole().getCode());
			System.out.println("role = " + model.getRole().getCode());
			if (model.getRole().getCode().equals("USER")) {
				//response.sendRedirect(request.getContextPath() + "/trang-chu");
				url = "redirect:trang-chu";
			} else if (model.getRole().getCode().equals("ADMIN")) {
			//	response.sendRedirect(request.getContextPath() + "/admin/home");
				url = "redirect:/admin/home";
			}
		} else {
			mvShare.addObject("statusLogin", "Đăng nhập thất bại");
			url = "redirect:dang-nhap";
		}
		
		return url;
	}
}
