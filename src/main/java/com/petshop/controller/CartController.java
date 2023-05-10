package com.petshop.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.petshop.dao.CartDao;
import com.petshop.dto.CartDto;
import com.petshop.entity.Order;
import com.petshop.entity.OrderDetail;
import com.petshop.entity.User;
import com.petshop.service.CartServiceImpl;
import com.petshop.service.HomeServiceImpl;
import com.petshop.service.OrderServiceImpl;

@Controller
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartService;
	@Autowired
	private OrderServiceImpl orderService;

	@RequestMapping(value = "/san-pham/add-to-cart/{product_id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void AddCart(HttpServletRequest request, HttpSession session, @PathVariable String product_id) { //
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.AddCart(product_id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("totalPrice", cartService.TotalPrice(cart));
	}
//	@RequestMapping(value = "/san-pham/add-to-cart/{product_id}", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	public void addToCart(@PathVariable String product_id, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException, UnsupportedEncodingException {
//
//	    // Lấy giỏ hàng từ cookie
//	    HashMap<String, CartDto> cart = getCartFromCookie(request);
//	    System.out.println(cart.size());
//	    // Thêm sản phẩm vào giỏ hàng
//	    cart = cartService.AddCart(product_id, cart);
//	    
//	    // Lưu giỏ hàng vào cookie
//	    saveCartToCookie(response, cart);
//	}
//	// Lấy giỏ hàng từ cookie
//	public HashMap<String, CartDto> getCartFromCookie(HttpServletRequest request) throws UnsupportedEncodingException {
//	    Cookie[] cookies = request.getCookies();
//	    HashMap<String, CartDto> cart = new HashMap<>();
//
//	    if (cookies != null) {
//	        for (Cookie cookie : cookies) {
//	            if (cookie.getName().equals("cart")) {
//	               // String value = cookie.getValue();
////	                byte[] bytes = value.getBytes(StandardCharsets.UTF_);
////	                String utf8EncodedString = new String(bytes, StandardCharsets.UTF_16);
//	            //    String encode = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
//	                String value = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8.toString());
//	                ObjectMapper mapper = new ObjectMapper();
//	                try {
//	                    cart = mapper.readValue(value, new TypeReference<HashMap<String, CartDto>>(){});
//	                
//	                } catch (IOException e) {
//	                    e.printStackTrace();
//	                }
//	                break;
//	            }
//	        }
//	    }
//
//	    return cart;
//	}
//
//	// Lưu giỏ hàng vào cookie
//	public void saveCartToCookie(HttpServletResponse response, HashMap<String, CartDto> cart) throws JsonProcessingException {
//	    ObjectMapper mapper = new ObjectMapper();
//	    String cartJson = mapper.writeValueAsString(cart);
//	    Cookie cookie = new Cookie("cart", cartJson);
//	    cookie.setMaxAge(30 * 24 * 60 * 60); // Thời gian sống của cookie là 30 ngày
//	    cookie.setPath("/");
//	    response.addCookie(cookie);
//	}

	@RequestMapping(value = "/xoa-san-pham/{product_id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable String product_id) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("cart");
		cart = cartService.DeleteCard(product_id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("totalPrice", cartService.TotalPrice(cart));
	}

	@RequestMapping(value = "/thay-doi-so-luong/{product_id}/{quantity}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void EditCard(HttpServletRequest request, HttpSession session, @PathVariable String product_id,
			@PathVariable int quantity) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("cart");
		cart = cartService.EditCard(product_id, quantity, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantity", cartService.TotalQuantity(cart));
		session.setAttribute("totalPrice", cartService.TotalPrice(cart));
		
	}

	@RequestMapping("/cart")
	public ModelAndView in() {
		mvShare.setViewName("customer/cart");
		Order order=new Order();
		mvShare.addObject("Shippingfee",order.getShippingFee());
		return mvShare;
	}

	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public String checkout(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("LoginInfo");
		
		if (user != null) {
			mvShare.setViewName("customer/checkout");
			Order order = new Order();
			order.setRecipientName(user.getFullName());
			order.setPhoneNumber(user.getPhoneNumber());
			order.setEmail(user.getEmail());
			request.setAttribute("order", order);
			request.setAttribute("menu", HomeService.GetDataMenu());
			return mvShare.getViewName();
		}
		else return "redirect:/dang-nhap";
	}

	@RequestMapping(value = "/thanh-toan", method = RequestMethod.POST)
	public String checkout(HttpSession session, HttpServletRequest request, @ModelAttribute("order") Order order) {

		Random rd = new Random();
		String orderID = System.currentTimeMillis() + rd.nextInt(1000) + "";
		order.setOrderId(orderID);
		User user = (User) session.getAttribute("LoginInfo");

		if (user != null) {
			
			order.setCustomerId(user.getUsername());
		}
		List<OrderDetail> listDetail=new ArrayList<>();
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("cart");
		if(cart!=null) {
		for (Entry<String, CartDto> item : cart.entrySet()) {
			OrderDetail orderDetail = new OrderDetail(orderID, item.getValue().getProduct(),
					item.getValue().getProduct().getProduct_name(), item.getValue().getQuantity(),
					item.getValue().getProduct().getPrice());
			listDetail.add(orderDetail);
		}
		}
		order.setOrderDetailList(listDetail);
		order.setTotalPrice();
		if (orderService.create(order) > 0) {
			for(OrderDetail item: listDetail) {
			orderService.saveOrderDetail(item);
			session.setAttribute("orderID", orderID);
		}
		}
		session.removeAttribute("cart");
		return "redirect:thong-bao";
	}

	@RequestMapping(value = "/thong-bao", method = RequestMethod.GET)
	public ModelAndView Notify(HttpSession session) {
		mvShare.setViewName("customer/thongbao");
		session.setAttribute("statusOrder","Success");
		return mvShare;
	}
}
