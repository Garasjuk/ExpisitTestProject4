package group.exp.com.controller;

import group.exp.com.model.Book;
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
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
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

public class ControlOrders {

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
	
	
	@RequestMapping(value ="/returnOrder", method = RequestMethod.GET)
	public ModelAndView returnOrder(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Integer id = (Integer) session.getAttribute("idUser");
		
		GregorianCalendar date2 = new GregorianCalendar();
		
		int orderDay = Integer.parseInt(request.getParameter("dateDelivered").substring(0, 4));
		int orderMonth = Integer.parseInt(request.getParameter("dateDelivered").substring(5, 7));
		int orderYear =Integer.parseInt(request.getParameter("dateDelivered").substring(8, 10));
		
		int newDay = date2.get(date2.YEAR);
		int newMonth = 1+date2.get(date2.MONTH);
		int newYear = date2.get(date2.DAY_OF_MONTH);
		
		User user = serviceUser.listProfil(id);
		
		
		if ((orderYear - newYear) == 0){
			System.out.println("Year "+ (orderYear - newYear));
			if((orderMonth - newMonth) ==0){
				System.out.println("Year "+ (orderMonth - newMonth));
				if((orderDay - newDay) ==0){
					serviceUser.updateUsermoney(id, (Integer.parseInt(request.getParameter("priceBook"))*70) /100 + user.getMoney_user());
				}
			}
			else if (newDay + (30 - orderDay) > 30 ) {
				serviceUser.updateUsermoney(id, (Integer.parseInt(request.getParameter("priceBook"))*40) /100 + user.getMoney_user());
			}
			else if (newDay + (30 - orderDay) <= 30 ){
				serviceUser.updateUsermoney(id, (Integer.parseInt(request.getParameter("priceBook"))*70) /100 + user.getMoney_user());
			}
		}

		serviceOrders.updataOrderReturn(Integer.parseInt(request.getParameter("idOrder")), 1);
				
		Book book1 = serviceBook.listBook(request.getParameter("nameBook"), Integer.parseInt(request.getParameter("idGenre")), Integer.parseInt(request.getParameter("idAuthor")), Integer.parseInt(request.getParameter("idPublishing")), 0);
		Book book = new Book();
		if (book1 != null){
			serviceBook.updataBookNew(book1.getId_book(),book1.getCount_book() + Integer.parseInt(request.getParameter("countOrder")));
		}
		else {
		
			book.setName_book(request.getParameter("nameBook"));
			book.setId_genre(Integer.parseInt(request.getParameter("idGenre")));
			book.setId_author(Integer.parseInt(request.getParameter("idAuthor")));
			book.setId_publishing(Integer.parseInt(request.getParameter("idPublishing")));
			book.setPrice_book((Integer.parseInt(request.getParameter("priceBook"))*80) /100);
			book.setCount_book(1);
			book.setNew_book(0);
			serviceBook.addBook(book);
		}
		return new ModelAndView("orderUser");
		
	}
	
	@RequestMapping(value ="/orders", method = RequestMethod.GET)
	public ModelAndView orders(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		
		if (request.getParameter("selectIdOrder")!=null){
			if (request.getParameter("selectStatus").equals("delivered")){
				serviceOrders.updataOrderDate(Integer.parseInt(request.getParameter("selectIdOrder")), request.getParameter("selectStatus"));
			}else{
				serviceOrders.updataOrder(Integer.parseInt(request.getParameter("selectIdOrder")), request.getParameter("selectStatus"));
			}
		}
		if (request.getParameter("radioFilter") != null){
			if (request.getParameter("radioFilter").equals("all")){
				model.put("listOrders",  serviceOrders.listOrders());
			}
			else if(request.getParameter("radioFilter").equals("done")){
				model.put("listOrders",  serviceOrders.listOrdersFilter("delivered"));
			}
			else if(request.getParameter("radioFilter").equals("notDone")){
				model.put("listOrders",  serviceOrders.listOrdersFilterNot("delivered"));
			}else{
				model.put("listOrders",  serviceOrders.listOrders());
			}
		}else{
			model.put("listOrders",  serviceOrders.listOrders());
		}
		
		return new ModelAndView("orders", model);
		
	}
	
	@RequestMapping(value ="/orderUser", method = RequestMethod.GET )
	public  ModelAndView orderUser( HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Map<String, Object> model = new HashMap<String, Object>();
		int idUser = (Integer) session.getAttribute("idUser");
		model.put("ordersUser",  serviceOrders.ordersByIdUser(idUser));
		
		return new ModelAndView("orderUser", model);
	}
}
