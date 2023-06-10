package com.petshop.controller.user;

import java.sql.Date;

import java.util.List;
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
import com.petshop.dao.ProductsDao;
import com.petshop.entity.Menus;
import com.petshop.entity.OrderDetail;
import com.petshop.entity.Products;
import com.petshop.entity.Reviews;
import com.petshop.entity.User;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.OrderDetailServiceImpl;
import com.petshop.service.ProductService;
import com.petshop.service.ReviewsServiceImpl;

@Controller
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ReviewsServiceImpl reviewsServiceImpl;
	@Autowired
	private HomeServiceImpl HomeService;
	@Autowired
	private ProductsDao productsDao;
	@Autowired
	private OrderDetailServiceImpl orderDetailServiceImpl;

	@RequestMapping(value = "/chi-tiet-san-pham/{product_id}", method = RequestMethod.GET)
	public ModelAndView Product(@PathVariable String product_id, ModelMap model,
			@ModelAttribute("reviews") Reviews reviews,HttpSession session) {
		try {
			mvShare.setViewName("customer/product_detail");
//		mv.addObject("menu", menu);
			Products productdetail =  productService.GetDataProductByProductID(product_id);
			mvShare.addObject("product", productdetail);
			String product_categ_id = productService.getStringProductCategory(product_id);
			System.out.println("product_id=" + product_id);
			 Double avgRating = (double) Math.round(reviewsServiceImpl.AvgRating(product_id) * 10) / 10;
			System.out.println("avgRating=" + avgRating);
			System.out.println("product_id=" + product_id);
			reviews.setProduct_id(product_id);
			User user = new User();
			user = (User) session.getAttribute("LoginInfo");
			
			reviews.setProduct_id(product_id);
			String username ="";
			if(user != null)
				 username = (user.getUsername()==null)? ""  : user.getUsername();// 1

			List<OrderDetail> listOrderDetail = orderDetailServiceImpl.GetDataOrderDetailByIsReviewed(product_id,username, 0);
			mvShare.addObject("listOrderDetail", listOrderDetail);
			List<Reviews> dataReviews = reviewsServiceImpl.GetDataReviewsByProductID(product_id);
			mvShare.addObject("avgRating", avgRating);
			mvShare.addObject("intAvgRating", avgRating.intValue());
			mvShare.addObject("amountOfReviews", reviewsServiceImpl.GetAmountOfReviews(product_id));
			mvShare.addObject("productName", productsDao.getStringProductNameByProductID(product_id));
			mvShare.addObject("dataReviewsByProductID", dataReviews);
			mvShare.addObject("productByCategory", productService.GetDataProductByProductCategoryID(product_categ_id));
			return mvShare;
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return mvShare;
		}
	}

	@RequestMapping(value = "/chi-tiet-san-pham/{product_id}", method = RequestMethod.POST)
	public ModelAndView ProductPost(@PathVariable String product_id, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, @ModelAttribute("reviews") Reviews reviews,
			ModelMap model, @RequestParam(name = "rating", required = true) double rating) {
		request.setAttribute("rating", rating);
		mvShare.addObject("rating", rating);
		System.out.println("rating = " + rating);
		mvShare.setViewName("customer/product_detail");
		try {
			List<Menus> menu = HomeService.GetDataMenu();
			mvShare.addObject("menu", menu);
			Products productdetail = (Products) productService.GetDataProductByProductID(product_id);
			mvShare.addObject("product", productdetail);
			Double avgRating = (double) Math.round(reviewsServiceImpl.AvgRating(product_id) * 10) / 10;
			System.out.println("avgRating=" + avgRating);
			
			List<Reviews> dataReviews = reviewsServiceImpl.GetDataReviewsByProductID(product_id);
			mvShare.addObject("avgRating", avgRating);
			mvShare.addObject("intAvgRating", avgRating.intValue());

			mvShare.addObject("amountOfReviews", reviewsServiceImpl.GetAmountOfReviews(product_id));
			mvShare.addObject("productName", productsDao.getStringProductNameByProductID(product_id));
			mvShare.addObject("dataReviewsByProductID", dataReviews);
			String product_categ_id = productService.getStringProductCategory(product_id);
			long millis = System.currentTimeMillis();
			System.out.println("Millis=" + millis);
			Date currentDate = new Date(millis);
			
			System.out.println(currentDate);
			reviews.setReviewDate(currentDate);
			String reviewID = product_id + "_" + System.currentTimeMillis() + "";
			reviews.setReviewID(reviewID);
			User user = new User();
			user = (User) session.getAttribute("LoginInfo");
			reviews.setProduct_id(product_id);
			String username = user.getUsername();// 1
			reviews.setCustomerID(username);
			List<OrderDetail> listOrderDetail = orderDetailServiceImpl.GetDataOrderDetailByIsReviewed(product_id,username, 0);
			mvShare.addObject("listOrderDetail", listOrderDetail);
			
			reviews.setRating(rating);

			int x = reviewsServiceImpl.Add(reviews);
			
			System.out.println(x);
			orderDetailServiceImpl.updateOrderDetail(listOrderDetail.get(0));
			mvShare.addObject("productByCategory", productService.GetDataProductByProductCategoryID(product_categ_id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mvShare;
	}

}
