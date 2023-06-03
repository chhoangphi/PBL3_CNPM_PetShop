package com.petshop.controller.Admin;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

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

import com.petshop.controller.BaseController;
import com.petshop.dto.PaginatesDto;
import com.petshop.entity.Activity;
import com.petshop.entity.ItemType;
import com.petshop.entity.Order;
import com.petshop.entity.Order.OrderStatus;
import com.petshop.entity.ProductCategory;
import com.petshop.entity.Products;
import com.petshop.entity.Role;
import com.petshop.entity.TypeOfCategory;
import com.petshop.entity.User;
import com.petshop.service.ActivityServiceImpl;
import com.petshop.service.CategoriesServiceImpl;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.ItemTypeServiceImpl;
import com.petshop.service.OrderServiceImpl;
import com.petshop.service.PaginatesServiceImpl;
import com.petshop.service.ProductService;
import com.petshop.service.TypeOfCategoryServiceImpl;
import com.petshop.service.UserServiceImpl;

@Controller
public class AdminController extends BaseController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ActivityServiceImpl activityServiceImpl;
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
	private OrderServiceImpl orderService;
	@Autowired
	private UserServiceImpl userService;

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
		
		int TotalData = productCategory.getProductList().size();
		System.out.println("here" + TotalData);
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,
				Integer.parseInt(currentPage));
		mvShare.addObject("pageinfo", pageinfo);
		mvShare.addObject("ProductPaginate", categoryService.GetDataProductByProductCategoryIDPaginate(product_cate_id,
				pageinfo.getStart(), totalProductPage,"price-asc"));
		return mvShare;
	}

	@RequestMapping(value = "/admin/chinh-sua-thong-tin-san-pham/{product_id}", method = RequestMethod.GET)
	public ModelAndView UpdateProductGET(HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable String product_id,HttpSession session) {
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
			@ModelAttribute("product") Products product, ModelMap model,HttpSession session,
			@RequestParam(name = "product_categ_name", required = true) String product_categ_name) {
		request.setAttribute("product_categ_name", product_categ_name);
		String categoryID = categoriesServiceImpl.getStringProductCategoryIDByName(product_categ_name);
		product.setProduct_categ_id(categoryID);
		productService.UpdateProduct(product);
		activityHistory = "Cập nhật sản phẩm " + product.getProduct_id() ;
		Random rd = new Random();
		String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
		String activityTime = System.currentTimeMillis() + "";
		User admin=(User) session.getAttribute("LoginInfo");
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),admin.getUsername());
		int add = activityServiceImpl.AddActivity(activity);
		// mvShare.setViewName("redirect:/home/danh-sach-san-pham");

		// return mvShare;
		return "redirect:/admin/danh-sach-san-pham/the-loai/" + categoryID + "/1";
	}

	@RequestMapping(value = "/admin/xoa-san-pham/{product_id}", method = RequestMethod.GET)
	public String DeleteProduct(HttpSession session,HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("product") Products product, ModelMap model, @PathVariable String product_id) {
		product.setProduct_id(product_id);
		String categoryID = productService.getStringProductCategory(product_id);
		productService.DeleteProduct(product);
		activityHistory = "Xóa sản phẩm " + product.getProduct_id() ;
		Random rd = new Random();
		String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
		String activityTime = System.currentTimeMillis() + "";
		
		User admin=(User) session.getAttribute("LoginInfo");
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),admin.getUsername());
		int add = activityServiceImpl.AddActivity(activity);

		return "redirect:/admin/danh-sach-san-pham/the-loai/" + categoryID + "/1";
	}

	@RequestMapping(value = "/admin/them-san-pham", method = RequestMethod.GET)
	public ModelAndView AddProduct(HttpSession session,HttpServletRequest request, HttpServletResponse response, Model model) {
		mvShare.addObject("productCategoryNameList", categoryService.GetDataProductCategoryNameList());
		mvShare.setViewName("admin/crud/list_products");
		return mvShare;
	}

	@RequestMapping(value = "/admin/them-san-pham", method = RequestMethod.POST)
	public String CreateProduct(HttpSession session,HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("product") Products product, ModelMap model,
			@RequestParam(name = "product_categ_name", required = true) String product_categ_name) {
		request.setAttribute("product_categ_name", product_categ_name);
		String categoryID = categoriesServiceImpl.getStringProductCategoryIDByName(product_categ_name);
		System.out.println("pdid = " + product.getProduct_id());
		List<String> product_idList = productService.GetDataProductID(categoryID.substring(0,1));
		System.out.println("size=" + product_idList.size());
		int x = 0;
		
		String tmp1 = "";
		if(categoryID.substring(0,1).equals("d"))
			tmp1="d_pd";
		else tmp1="c_pd";
		int max = 0;
		for (int i = 0; i < product_idList.size();i++) {
			System.out.println("elm = " + product_idList.get(i));
		}
		
		// String tmp1 = id.substring(0, 4);
		for (String string : product_idList) {
			x = Integer.parseInt(string.substring(4));
			System.out.println("x = " + x);
			if(string.substring(4)==null)
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
		System.out.println("id =" + tmpID);
		product.setProduct_categ_id(categoryID);
		product.setStatus(1);
		productService.AddProduct(product);
		activityHistory = "Thêm sản phẩm " + product.getProduct_id() ;
		Random rd = new Random();
		String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
		String activityTime = System.currentTimeMillis() + "";
		
		User admin=(User) session.getAttribute("LoginInfo");
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),admin.getUsername());
		int add = activityServiceImpl.AddActivity(activity);
		
		return "redirect:/admin/danh-sach-san-pham/the-loai/" + categoryID + "/1";
	}

	@RequestMapping(value = "/admin/*", method = RequestMethod.GET)
	public ModelAndView Home(HttpServletRequest request, HttpServletResponse response, Model model) {
		mvShare.addObject("productCategory", categoryService.GetAllDataProductCategory());
		mvShare.addObject("dataItemType", itemTypeService.GetDataItemType());
		mvShare.addObject("typeOfCategory", typeOfCategoryServiceImpl.GetDataTypeOfCategory());
		mvShare.addObject("dataProductCategory", categoryService.GetAllDataProductCategory());
		mvShare.addObject("listTypeID",categoryService.GetDataTypeID());
		mvShare.setViewName("admin/index");
		return mvShare;
	}
//	@RequestMapping(value = "/admin/quan-ly-don-hang/{currentPage}", method = RequestMethod.GET)
//	public ModelAndView ManageOrder(@ModelAttribute("product") Products produc, HttpServletRequest request,
//			HttpServletResponse response, ModelMap model, @PathVariable String currentPage) {
//		mvShare.addObject("dataOrder", orderService.GetDataOrder());
//		int TotalData = orderService.GetDataOrder().size();
//		//int TotalData = 10;
//		System.out.println("here" + TotalData);
//		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,
//				Integer.parseInt(currentPage));
//		mvShare.addObject("pageinfo", pageinfo);
//		mvShare.addObject("OrderPaginate",
//				orderService.GetDataOrderPaginate(pageinfo.getStart(), totalProductPage));
//		mvShare.setViewName("admin/crud/list_order");
//
//		return mvShare;
//	}

	@RequestMapping(value = "/admin/quan-ly-don-hang/{orderStatus}/{currentPage}", method = RequestMethod.GET)
	public ModelAndView ManageOrder(@ModelAttribute("product") Products produc, HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable String currentPage, @PathVariable String orderStatus) throws NullPointerException, SQLException {
		mvShare.addObject("dataOrder", orderService.GetDataOrder());
		mvShare.addObject("status", orderStatus);
		int TotalData = 0;
//		if(orderStatus.equals("all")) {
//			TotalData = orderService.GetDataOrder().size();
//			System.out.println("ordersize ============" + TotalData);
//		}
		
		 TotalData = orderService.GetDataOrderByStatus(orderStatus).size();
		
		
		//int TotalData = 10;
		System.out.println("here" + TotalData);
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,
				Integer.parseInt(currentPage));
		mvShare.addObject("pageinfo", pageinfo);
		mvShare.addObject("OrderPaginate",
				orderService.GetDataOrderPaginate(pageinfo.getStart(), totalProductPage,orderStatus));
		mvShare.setViewName("admin/crud/list_order");

		return mvShare;
	}
	@RequestMapping(value = "/admin/xoa-don-hang/{orderId}", method = RequestMethod.GET)
	public String DeleteOrder(HttpSession session,@ModelAttribute("product") Products produc, HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable String orderId) {
		int x = orderService.DeleteOrder(orderId);
		activityHistory = "Xóa đơn hàng " + orderId ;
		Random rd = new Random();
		String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
		String activityTime = System.currentTimeMillis() + "";
		
		User admin=(User) session.getAttribute("LoginInfo");
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),admin.getUsername());
		int add = activityServiceImpl.AddActivity(activity);
		mvShare.setViewName("admin/crud/list_order");
		return "redirect:/admin/quan-ly-don-hang/1";
	}
	@RequestMapping(value = "/admin/cap-nhat-don-hang/{orderId}", method = RequestMethod.GET)
	public ModelAndView UpdateOrderGET(HttpSession session,HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable String orderId) {
		mvShare.addObject("order", orderService.findOrder(orderId));
		mvShare.setViewName("admin/crud/update_order");
		return mvShare;
	}

	@RequestMapping(value = "/admin/cap-nhat-don-hang/{orderId}", method = RequestMethod.POST)
	public String UpdateOrderPost(HttpSession session,HttpServletRequest request, HttpServletResponse response,@PathVariable String orderId,
			@ModelAttribute("order") Order order, ModelMap model,
			@RequestParam(name = "status", required = true) String status,
			@RequestParam(name = "address", required = true) String address){
		request.setAttribute("status", status);
		request.setAttribute("address", address);
		if(status.equals("PENDING"))
			order.setStatus(OrderStatus.PENDING);	
		else if(status.equals("TO_SHIP"))
			order.setStatus(OrderStatus.TO_SHIP);
		else if(status.equals("TO_RECEIVE"))
			order.setStatus(OrderStatus.TO_RECEIVE);
		else if(status.equals("COMPLETED"))
			order.setStatus(OrderStatus.COMPLETED);
		else if(status.equals("CANCELED")) 
			order.setStatus(OrderStatus.CANCELED);
		order.setOrderId(orderId);
		order.setAddress(address);
		String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
		String activityTime = System.currentTimeMillis() + "";
	
		order.setConfirmTime(LocalDateTime.now());
		orderService.UpdateOrder(order);
		activityHistory = "Cập nhật đơn hàng " + order.getOrderId() + "(status= " + status+",address= "+address;
		Random rd = new Random();
		
		
		User admin=(User) session.getAttribute("LoginInfo");
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),admin.getUsername());
		int add = activityServiceImpl.AddActivity(activity);
		mvShare.addObject("order",orderService.findOrder(orderId));
		mvShare.setViewName("admin/crud/upadate_order");
		return "redirect:/admin/quan-ly-don-hang/1";	
	}
	@RequestMapping(value = "/admin/quan-ly-tai-khoan/{currentPage}", method = RequestMethod.GET)
	public ModelAndView ManageUser(HttpSession session,@ModelAttribute("user") User user, HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable String currentPage) {
		//mvShare.addObject("dataUser", userService.GetDataUser());
		int TotalData = userService.GetDataUser().size();
		//int TotalData = 10;
		System.out.println("here" + TotalData);
		PaginatesDto pageinfo = paginateService.GetPatinates(TotalData, totalProductPage,
				Integer.parseInt(currentPage));
		mvShare.addObject("pageinfo", pageinfo);
		mvShare.addObject("userPaginate",
				userService.GetDataUserPaginate(pageinfo.getStart(), totalProductPage));
		mvShare.setViewName("admin/crud/list_user");
		

		return mvShare;
	}
	@RequestMapping(value = "/admin/them-tai-khoan", method = RequestMethod.POST)
	public String CreateAccount(RedirectAttributes redirectAttributes,HttpSession session,HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user, ModelMap model,
			@RequestParam(name = "gender", required = true) String gender) {
		request.setAttribute("gender", gender);
		user.setGender(gender);
		user.setStatus(1);
		user.setRoleId(1);
		User check = userService.GetUser(user);
		if (check != null) {
			//session.setAttribute("baoLoi", baoLoi);
			redirectAttributes.addFlashAttribute("registerStatus1","Tên đăng nhập " +user.getUsername()+ " đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/> ");
			
		} else {
			int count = userService.AddUser(user);
			if (count > 0) {
				mvShare.addObject("status", "Đăng ký tài khoản thành công");
				activityHistory = "Đăng ký tài khoản " + user.getUsername();
				Random rd = new Random();
				String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
				String activityTime = System.currentTimeMillis() + "";
				
				User admin=(User) session.getAttribute("LoginInfo");
				Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),admin.getUsername());
				int add = activityServiceImpl.AddActivity(activity);
				
				
			} else {
				mvShare.addObject("status", "Đăng ký tài khoản thất bại");
				//mvShare.setViewName("customer/register");
			}
			System.out.println("count = " + count);

		}
		
		
		
		return "redirect:/admin/quan-ly-tai-khoan/1";
	}
	@RequestMapping(value = "/admin/xoa-tai-khoan/{username}", method = RequestMethod.GET)
	public String DeleteUser(HttpSession session,@ModelAttribute("user") User user, HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable String username) {
		int x = userService.DeleteUser(user);
		activityHistory = "Xóa tài khoản " + user.getUsername() ;
		Random rd = new Random();
		String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
		String activityTime = System.currentTimeMillis() + "";
		
		User admin=(User) session.getAttribute("LoginInfo");
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),admin.getUsername());
		int add = activityServiceImpl.AddActivity(activity);
//		mvShare.setViewName("admin/crud/list_order");
		return "redirect:/admin/quan-ly-tai-khoan/1";
	}
	@RequestMapping(value = "/admin/cap-nhat-tai-khoan/{username}", method = RequestMethod.GET)
	public ModelAndView UpdateUserGET(HttpSession session,HttpServletRequest request, HttpServletResponse response, Model model,
			@PathVariable String username) {
		mvShare.setViewName("admin/crud/update_user");
		return mvShare;
	}
	@RequestMapping(value = "/admin/cap-nhat-tai-khoan/{username}", method = RequestMethod.POST)
	public String UpdateUser(HttpSession session,HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user, ModelMap model,
			@PathVariable String username,
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
		System.out.println("Date of birth = " + dateOfBirth);
		Role role = new Role();
		role.setCode("USER");
		role.setName("Người dùng");
		user = new User(username, fullName,password, 1,1,role, gender,Date.valueOf(dateOfBirth),phoneNumber, email);
		int x = userService.UpdateUser(user);
		activityHistory = "Cập nhật tài khoản " + user.getUsername() ;
		String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
		
		User admin=(User) session.getAttribute("LoginInfo");
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),admin.getUsername());
		int add = activityServiceImpl.AddActivity(activity);
		System.out.println(x);
//		mvShare.setViewName("admin/crud/list_order");
		return "redirect:/admin/quan-ly-tai-khoan/1";
	}
	@RequestMapping(value = "/admin/them-loai-san-pham/{type_id}", method = RequestMethod.POST)
	public String AddProductCategory(HttpSession session,HttpServletRequest request, HttpServletResponse response,@PathVariable String type_id,
			 ModelMap model,
			@RequestParam(name = "productCategoryName", required = true) String productCategoryName){
		String tmp = "";
		request.setAttribute("productCategoryName", productCategoryName);
		if(type_id.substring(0,1).equals("d")){
			tmp = "d_pdc";
		}
		else tmp = "c_pdc";
		tmp += categoryService.GetMaxProduct_cageID();
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProduct_categ_id(tmp);
		productCategory.setProduct_categ_name(productCategoryName);
		productCategory.setType_id(type_id);
		categoryService.AddProductCategory(productCategory);
		User admin=(User) session.getAttribute("LoginInfo");
		activityHistory = "Thêm loại sản phẩm " + productCategoryName ;
		String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
		
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),admin.getUsername());
		int add = activityServiceImpl.AddActivity(activity);
		return "redirect:/admin/home";
		
	}
	@RequestMapping(value = "/admin/them-dong-san-pham/{item_id}", method = RequestMethod.POST)
	public String AddTypeOfCategory(HttpSession session,HttpServletRequest request, HttpServletResponse response,@PathVariable String item_id,
			 ModelMap model,
			@RequestParam(name = "typeOfCategoryName", required = true) String typeOfCategoryName){
		String tmp = "";
		request.setAttribute("typeOfCategoryName", typeOfCategoryName);
		if(item_id.substring(5,6).equals("1")){
			tmp = "dtype";
		}
		else tmp = "ctype";
		tmp += categoryService.GetMaxTypeID();
		TypeOfCategory  typeOfCategory = new TypeOfCategory();
		typeOfCategory.setType_id(tmp);
		typeOfCategory.setType_name(typeOfCategoryName);
		typeOfCategory.setItem_id(item_id);
		typeOfCategoryServiceImpl.AddTypeOfCategory(typeOfCategory);
		User admin=(User) session.getAttribute("LoginInfo");
		activityHistory = "Thêm dòng sản phẩm " + typeOfCategoryName ;
		String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),admin.getUsername());
		int add = activityServiceImpl.AddActivity(activity);
		return "redirect:/admin/home";
		
	}
	@RequestMapping(value = "/admin/them-shop", method = RequestMethod.POST)
	public String AddPet(HttpSession session,HttpServletRequest request, HttpServletResponse response,
			 ModelMap model,
			@RequestParam(name = "shopName", required = true) String shopName){
		String tmp = "item";
		request.setAttribute("shopName", shopName);
		
		tmp += categoryService.GetMaxTypeID();
		ItemType  itemType = new ItemType();
		itemType.setItem_id(tmp);
		itemType.setName(shopName);
		itemTypeService.AddItemType(itemType);
		User admin=(User) session.getAttribute("LoginInfo");
		activityHistory = "Thêm " + shopName ;
		String activity_id = "activity_id_" + System.currentTimeMillis() +  "";
		Activity activity = new Activity(activity_id, activityHistory, LocalDateTime.now(),admin.getUsername());
		int add = activityServiceImpl.AddActivity(activity);
		return "redirect:/admin/home";
		
	}
	
	
	


}
