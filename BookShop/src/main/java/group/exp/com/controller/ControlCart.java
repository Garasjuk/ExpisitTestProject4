package group.exp.com.controller;

import group.exp.com.model.Orders;
import group.exp.com.model.User;
import group.exp.com.service.ServiceAuthor;
import group.exp.com.service.ServiceBook;
import group.exp.com.service.ServiceCart;
import group.exp.com.service.ServiceComents;
import group.exp.com.service.ServiceGenre;
import group.exp.com.service.ServiceLikes;
import group.exp.com.service.ServiceOrders;
import group.exp.com.service.ServicePublishing;
import group.exp.com.service.ServiceUser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ControlCart {

private static final Logger logger = Logger.getLogger(Control.class);
	
		
	@Autowired
	private ServiceBook serviceBook;
	@Autowired
	private ServiceGenre serviceGenre;
	@Autowired
	private ServiceAuthor serviceAuthor;
	@Autowired
	private ServicePublishing servicePublishing;
	@Autowired
	private ServiceOrders serviceOrders;
	@Autowired
	private ServiceLikes serviceLikes;
	@Autowired
	private ServiceCart serviceCart;
	@Autowired
	private ServiceUser serviceUser;
	@Autowired
	private ServiceComents serviceComents;
	
	
	@RequestMapping("/cart")
	public ModelAndView cart( HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Integer id = (Integer) session.getAttribute("idUser");
		
		if (request.getParameter("id_cart") !=null){
			request.setAttribute("madeOrder", serviceCart.cartByID(Integer.parseInt(request.getParameter("id_cart"))));
			request.setAttribute("id_cart", request.getParameter("id_cart"));
		}
		User user = serviceUser.listProfil(id);
		
		if (request.getParameter("addOrder") !=null){
			if (Integer.parseInt(request.getParameter("order_count_cart")) > Integer.parseInt(request.getParameter("count_in_stock"))){
				request.setAttribute("Error_stock", "stock no amount requested");
			}else if (Integer.parseInt(request.getParameter("priceBook")) * Integer.parseInt(request.getParameter("order_count_cart")) > user.getMoney_user() ){
				request.setAttribute("Error_stock", "not enough money");
			}
			else {
				
				Orders orders = new Orders();
				orders.setId_book(Integer.parseInt(request.getParameter("id_book")));
				orders.setId_user(id);
				orders.setCount_order(Integer.parseInt(request.getParameter("order_count_cart")));
				orders.setAdres_order(request.getParameter("order_adres_user"));
				orders.setDate_order(new Date());
				orders.setOther_order(request.getParameter("order_other"));
				orders.setStatus_order("in processing");

				serviceOrders.addOrder(orders);
		
				serviceCart.deleteFromCart(Integer.parseInt(request.getParameter("select_id_cart")));
				
				serviceBook.updataBookNew(Integer.parseInt(request.getParameter("id_book")), Integer.parseInt(request.getParameter("count_in_stock")) - Integer.parseInt(request.getParameter("order_count_cart")));
				
				serviceUser.updateUsermoney(id, user.getMoney_user() - Integer.parseInt(request.getParameter("priceBook")) * Integer.parseInt(request.getParameter("order_count_cart")));
				
				serviceUser.updateUserSpendMoney(id, user.getSpend_money() + Integer.parseInt(request.getParameter("priceBook")) * Integer.parseInt(request.getParameter("order_count_cart")));
				
			}
		}
		
		model.put("listCart",  serviceCart.listCartByIDuser((Integer)session.getAttribute("idUser")));
		return new ModelAndView("cart" , model);
	}
	
	@RequestMapping("/addToCart")
	public  String addToCart( HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("idUser") !=null  && request.getParameter("pageContent")!=null){
			Integer id = (Integer) session.getAttribute("idUser");
			serviceCart.addCart(Integer.parseInt(request.getParameter("selectDetail")), id, 1);
			return "redirect:likeList";
		}
		else if (session.getAttribute("idUser") !=null ){
		Integer id = (Integer) session.getAttribute("idUser");
		serviceCart.addCart(Integer.parseInt(request.getParameter("selectDetail")), id, 1);
		return "redirect:showDetail?selectDetail="+request.getParameter("selectDetail");
		}
		else{
			return "redirect:login";
		}	
	}
	
	@RequestMapping("/deleteFromCart")
	public String deleteFromCart( HttpServletRequest request, HttpServletResponse response) {
			serviceCart.deleteFromCart(Integer.parseInt(request.getParameter("id_cart")));
		return "redirect:cart";
	}
}
