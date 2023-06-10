package com.petshop.controller.Admin;

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
import com.petshop.entity.User;
import com.petshop.service.ActivityServiceImpl;
import com.petshop.service.PaginatesServiceImpl;
import com.petshop.service.UserServiceImpl;

@Controller
public class ManageAccountController extends AdminBaseController {
	@Autowired
	private ActivityServiceImpl activityServiceImpl;
	@Autowired
	private PaginatesServiceImpl paginateService;
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/admin/quan-ly-tai-khoan", method = RequestMethod.GET)
	public ModelAndView ManageUser(HttpServletRequest request, HttpSession session, HttpServletResponse response,
			@ModelAttribute("user") User user, @RequestParam(name = "code", defaultValue = "user") String code,
			@RequestParam(name = "currentPage", defaultValue = "1") String currentPage,
			@RequestParam(name = "stt", defaultValue = "all") String stt) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
				int TotalData = userService.GetDataUser(code, stt).size();
				System.out.println(TotalData);
				PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,
						Integer.parseInt(currentPage));
				mvShare.addObject("pageinfo", pageinfo);
				mvShare.addObject("userPaginate",
						userService.GetDataUserPaginate(code, stt, pageinfo.getStart(), totalProductPage));
				mvShare.setViewName("admin/crud/list_user");
			}
		}
		return mvShare;
	}

	@RequestMapping(value = "/admin/them-tai-khoan", method = RequestMethod.POST)
	public String CreateAccount(RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("user") User user, ModelMap model,
			@RequestParam(name = "gender", required = true) String gender) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
				request.setAttribute("gender", gender);
				user.setGender(gender);
				user.setStatus(1);
				User check = userService.GetUser(user);
				if (check != null) {
					// session.setAttribute("baoLoi", baoLoi);
					redirectAttributes.addFlashAttribute("addaccount", "Tên đăng nhập " + "'"+user.getUsername()+"'"
							+ " đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/> ");

				} else {
					int count = userService.AddUser(user);
					if (count > 0) {
						mvShare.addObject("status", "Đăng ký tài khoản thành công");
						activityHistory = "Đăng ký tài khoản " + user.getUsername();
						String activity_id = "activity_id_" + System.currentTimeMillis() + "";
						User admin = (User) session.getAttribute("LoginInfo");
						Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),
								admin.getUsername());
						activityServiceImpl.AddActivity(activity);
						redirectAttributes.addFlashAttribute("addaccount", "Thêm tài khoản thành công");
					} else {
						mvShare.addObject("addaccount", "Đăng ký tài khoản thất bại");
						// mvShare.setViewName("customer/register");
					}
					System.out.println("count = " + count);

				}
				if (user.getRoleId() == 0) {
					return "redirect:/admin/quan-ly-tai-khoan?code=admin&stt=all";
				}
			}
		}
		return "redirect:/admin/quan-ly-tai-khoan?code=user&stt=all";
	}

	@RequestMapping(value = "/admin/xoa-tai-khoan/{username}", method = RequestMethod.GET)
	public String DeleteUser(HttpSession session, RedirectAttributes redirectAttributes,
			@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response, ModelMap model,
			@PathVariable String username) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
				User u = userService.findUserByUsername(username);
				userService.DeleteUser(user);
				activityHistory = "Xóa tài khoản " + user.getUsername();
				String activity_id = "activity_id_" + System.currentTimeMillis() + "";

				User admin = (User) session.getAttribute("LoginInfo");
				Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),
						admin.getUsername());
				activityServiceImpl.AddActivity(activity);
				redirectAttributes.addFlashAttribute("abc", 1);
				if (u.getRoleId() == 0) {
					return "redirect:/admin/quan-ly-tai-khoan?code=admin&stt=all";
				}
			}
		}
		return "redirect:/admin/quan-ly-tai-khoan?code=user&stt=all";

	}

	@RequestMapping(value = "/admin/cap-nhat-tai-khoan/{username}", method = RequestMethod.GET)
	public ModelAndView UpdateUserGET(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			Model model, @PathVariable String username) {
		boolean isLogined = session.getAttribute("LoginInfo") != null ? true : false;
		String loginRole = session.getAttribute("role") != null ? session.getAttribute("role") + "" : "";
		if (isLogined == false) {
			mvShare.setViewName("redirect:/dang-nhap");

		} else {
			if (!loginRole.equals("ADMIN")) {
				mvShare.setViewName("redirect:/deny-access");
			} else {
				mvShare.setViewName("admin/crud/update_user");
				User user = userService.findUserByUsername(username);
				request.setAttribute("user", user);
			}
		}
		return mvShare;
	}

	@RequestMapping(value = "/admin/cap-nhat-tai-khoan/{username}", method = RequestMethod.POST)
	public String UpdateUser(RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("user") User user, ModelMap model,
			@PathVariable String username) {
		request.setAttribute("username", username);
		User u = userService.findUserByUsername(username);
		if (userService.UpdateUser(user) > 0) {
			System.out.println(1111);
			activityHistory = "Cập nhật tài khoản " + user.getUsername();
			String activity_id = "activity_id_" + System.currentTimeMillis() + "";
			redirectAttributes.addFlashAttribute("update", 1);
			User admin = (User) session.getAttribute("LoginInfo");
			Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(), admin.getUsername());
			activityServiceImpl.AddActivity(activity);
		} else {
			redirectAttributes.addFlashAttribute("changeStatus", "Cập nhật tài khoản " + username + " thất bại");
		}
		if (u.getRoleId() == 0) {
			return "redirect:/admin/quan-ly-tai-khoan?code=admin&stt=all";
		}
		return "redirect:/admin/quan-ly-tai-khoan?code=user&stt=all";
	}
}
