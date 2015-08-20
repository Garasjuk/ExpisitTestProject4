package group.exp.com.controller;


import group.exp.com.model.Book;
import group.exp.com.model.Cart;
import group.exp.com.model.Coments;
import group.exp.com.model.Likes;
import group.exp.com.model.Orders;
import group.exp.com.model.User;
import group.exp.com.service.ServiceManager;

import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;









@Controller
public class Control {

	private String name = "" ,message = "";
	
	@Autowired
	private ServiceManager serviceManager; 
	
	@RequestMapping("/showBook")
	public ModelAndView showBook( HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		
		
		if (request.getParameter("genre_book_filter") != null){
			model.put("book",  serviceManager.listBookFilterGenre(Integer.parseInt(request.getParameter("genre_book_filter"))));
		}
		else if(request.getParameter("author_book_filter") != null){
			model.put("book",  serviceManager.listBookFilterAuthor(Integer.parseInt(request.getParameter("author_book_filter"))));
		}
		else if(request.getParameter("publishing_book_filter") != null){
			model.put("book",  serviceManager.listBookFilterPublishing(Integer.parseInt(request.getParameter("publishing_book_filter"))));
		}
		else if(request.getParameter("new_book_filter") != null){
			model.put("book",  serviceManager.listBookFilterNew(Integer.parseInt(request.getParameter("new_book_filter"))));
		}
		else{
			model.put("book",  serviceManager.listBook());
		}
		request.setAttribute("genre", serviceManager.allListGenre());
		request.setAttribute("author", serviceManager.allListAuthor());
		request.setAttribute("publishing", serviceManager.allListPublishing());
		
		
		return new ModelAndView("book", model);
	}
	
	@RequestMapping(value ="/addMoney", method = RequestMethod.GET)
	public ModelAndView addMoney( HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		
		if (request.getParameter("choice_pay") != null){
			if (request.getParameter("choice_pay").equals("SMS")){
	//			System.out.println("choice_pay = " + request.getParameter("choice_pay"));
				request.setAttribute("choice_pay", request.getParameter("choice_pay"));
			}
			else if (request.getParameter("choice_pay").equals("Credit_card")){
	//			System.out.println("choice_pay = " + request.getParameter("choice_pay"));
				request.setAttribute("choice_pay", request.getParameter("choice_pay"));
			}
			else if (request.getParameter("choice_pay").equals("Pay_pal")){
	//			System.out.println("choice_pay = " + request.getParameter("choice_pay"));
				request.setAttribute("choice_pay", request.getParameter("choice_pay"));
			}
			else{
				
			}		
		}
		if (request.getParameter("addNewMoney") != null){
			Integer id = (Integer) session.getAttribute("idUser");
			User user = serviceManager.listProfil(id);
						
			serviceManager.updateUsermoney(id, Integer.parseInt(request.getParameter("money")) + user.getMoney_user());
		}
		
		return new ModelAndView("money");
	}
	
	@RequestMapping(value ="/showUser", method = RequestMethod.GET)
	public ModelAndView showUser( HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		
		if (request.getParameter("editUser") != null){
			
			
			User user = new User();
			user.setName_user(request.getParameter("edit_name_user"));
			user.setMoney_user(Integer.parseInt(request.getParameter("edit_money_user")));
			user.setAdres_user(request.getParameter("edit_adres_user"));
			user.setEmail(request.getParameter("edit_email_user"));
			user.setIdentif(request.getParameter("identif"));
			user.setPass_user(request.getParameter("edit_pass_user"));
			user.setId_user(Integer.parseInt(request.getParameter("edit_id_user")));
			
			serviceManager.updateUser(user);
		
			
		}
			
		if (request.getParameter("selectUser") != null){
			User user = serviceManager.listUserByID(Integer.parseInt(request.getParameter("selectUser")));
			request.setAttribute("editUser", user);
		}
		
		model.put("allListUser",  serviceManager.allListUser());
		return new ModelAndView("user", model);
	}
	
	@RequestMapping(value ="/editUser", method = RequestMethod.GET)
	public ModelAndView editUser( HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("chech ID :  "+request.getParameter("selectUser"));
		
		
		return  new ModelAndView("user");
	}
	
	@RequestMapping("/cart")
	public ModelAndView cart( HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Integer id = (Integer) session.getAttribute("idUser");
		
		if (request.getParameter("id_cart") !=null){
	//		System.out.println("id_cart: " + request.getParameter("id_cart"));
			request.setAttribute("madeOrder", serviceManager.cartByID(Integer.parseInt(request.getParameter("id_cart"))));
			request.setAttribute("id_cart", request.getParameter("id_cart"));
		}
		User user = serviceManager.listProfil(id);
		
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

				serviceManager.addOrder(orders);
		
				serviceManager.deleteFromCart(Integer.parseInt(request.getParameter("select_id_cart")));
				
				serviceManager.updataBookNew(Integer.parseInt(request.getParameter("id_book")), Integer.parseInt(request.getParameter("count_in_stock")) - Integer.parseInt(request.getParameter("order_count_cart")));
				
				serviceManager.updateUsermoney(id, user.getMoney_user() - Integer.parseInt(request.getParameter("priceBook")) * Integer.parseInt(request.getParameter("order_count_cart")));
				
			}
		}
		
		model.put("listCart",  serviceManager.listCartByIDuser((Integer)session.getAttribute("idUser")));
		return new ModelAndView("cart" , model);
	}
	
	@RequestMapping("/registration")
	public ModelAndView registration( HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("registration");
	}
	
	@RequestMapping(value ="/addBook", method = RequestMethod.GET)
	public ModelAndView addBook(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		
		request.setAttribute("genre", serviceManager.allListGenre());
		request.setAttribute("author", serviceManager.allListAuthor());
		request.setAttribute("publishing", serviceManager.allListPublishing());
		
		if (request.getParameter("addBook")!=null){
			
			
			Book book = new Book();
			book.setName_book(request.getParameter("add_name_book"));
			book.setId_genre(Integer.parseInt(request.getParameter("add_genre_book")));
			book.setId_author(Integer.parseInt(request.getParameter("add_author_book")));
			book.setId_publishing(Integer.parseInt(request.getParameter("add_publishing_book")));
			book.setPrice_book(Integer.parseInt(request.getParameter("add_price_book")));
			book.setCount_book(Integer.parseInt(request.getParameter("add_count_book")));
			book.setNew_book(1);
			serviceManager.addBook(book);
		}
		
		//model.put("listOrders",  serviceManager.listOrders());
		return new ModelAndView("addBook", model);
	}
	
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
		
		User user = serviceManager.listProfil(id);
		
		
		if ((orderYear - newYear) == 0){
			System.out.println("Year "+ (orderYear - newYear));
			if((orderMonth - newMonth) ==0){
				System.out.println("Year "+ (orderMonth - newMonth));
				if((orderDay - newDay) ==0){
					
				}
			}
			else if (newDay + (30 - orderDay) > 30 ) {
				serviceManager.updateUsermoney(id, (Integer.parseInt(request.getParameter("priceBook"))*40) /100 + user.getMoney_user());
			}
			else if (newDay + (30 - orderDay) <= 30 ){
				serviceManager.updateUsermoney(id, (Integer.parseInt(request.getParameter("priceBook"))*70) /100 + user.getMoney_user());
			}
		}

		serviceManager.updataOrderReturn(Integer.parseInt(request.getParameter("idOrder")), 1);
				
		Book book1 = serviceManager.listBook(request.getParameter("nameBook"), Integer.parseInt(request.getParameter("idGenre")), Integer.parseInt(request.getParameter("idAuthor")), Integer.parseInt(request.getParameter("idPublishing")), 0);
		Book book = new Book();
		if (book1 != null){
			serviceManager.updataBookNew(book1.getId_book(),book1.getCount_book() + Integer.parseInt(request.getParameter("countOrder")));
		}
		else {
		
			book.setName_book(request.getParameter("nameBook"));
			book.setId_genre(Integer.parseInt(request.getParameter("idGenre")));
			book.setId_author(Integer.parseInt(request.getParameter("idAuthor")));
			book.setId_publishing(Integer.parseInt(request.getParameter("idPublishing")));
			book.setPrice_book((Integer.parseInt(request.getParameter("priceBook"))*80) /100);
			book.setCount_book(1);
			book.setNew_book(0);
			serviceManager.addBook(book);
		}
		return new ModelAndView("orderUser");
		
	}
	
	
	@RequestMapping(value ="/orders", method = RequestMethod.GET)
	public ModelAndView orders(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		
		if (request.getParameter("selectIdOrder")!=null){
			if (request.getParameter("selectStatus").equals("delivered")){
				serviceManager.updataOrderDate(Integer.parseInt(request.getParameter("selectIdOrder")), request.getParameter("selectStatus"));
			}else{
				serviceManager.updataOrder(Integer.parseInt(request.getParameter("selectIdOrder")), request.getParameter("selectStatus"));
			}
		}
		
		model.put("listOrders",  serviceManager.listOrders());
		
		return new ModelAndView("orders", model);
		
	}
	
	@RequestMapping(value ="/addRegistration", method = RequestMethod.POST)
	public ModelAndView addRegistration(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response) {
		
		
		user.setName_user(request.getParameter("add_name_user"));
		user.setPass_user(request.getParameter("add_pass_user"));
		user.setAdres_user(request.getParameter("add_adres_user"));
		user.setEmail(request.getParameter("add_email_user"));
		if (request.getParameter("identif") != null){
			user.setIdentif(request.getParameter("identif"));
		}else
		{
			user.setIdentif("0");
		}
		
		user.setMoney_user(0);
		serviceManager.addUser(user);
	
		return new ModelAndView("registration");
	}
	
	
	@RequestMapping("/login")
	public ModelAndView login( HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/deleteFromCart")
	public String deleteFromCart( HttpServletRequest request, HttpServletResponse response) {
			serviceManager.deleteFromCart(Integer.parseInt(request.getParameter("id_cart")));
		return "redirect:cart";
	}
	
	@RequestMapping("/addToCart")
	public  String addToCart( HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("idUser") !=null ){
		Integer id = (Integer) session.getAttribute("idUser");
		serviceManager.addCart(Integer.parseInt(request.getParameter("selectDetail")), id, 1);
		return "redirect:showDetail?selectDetail="+request.getParameter("selectDetail");
		}
		else{
			return "redirect:login";
		}	
	}
	
	
	@RequestMapping("/addLike")
	public  String addLike( HttpServletRequest request, HttpServletResponse response, Likes likes) {
		HttpSession session = request.getSession(true);
		int idUser = (Integer) session.getAttribute("idUser");
		likes.setId_book(Integer.parseInt(request.getParameter("selectDetail")));
		likes.setId_user(idUser);
		
		if (serviceManager.listLikeByIdUserBook(Integer.parseInt(request.getParameter("selectDetail")), idUser) >=1){
			serviceManager.deleteLikeByIdUserBook(Integer.parseInt(request.getParameter("selectDetail")),idUser );
			
		}
		else{
			serviceManager.addLike(likes);
			
		}

		return "redirect:showDetail?selectDetail="+request.getParameter("selectDetail");
	}
	
	@RequestMapping(value ="/addComent", method = RequestMethod.GET )
	public  String addComent( HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		
		return "redirect:showDetail?selectDetail="+request.getParameter("selectDetail");
	}
	
	@RequestMapping(value ="/profil", method = RequestMethod.GET )
	public  ModelAndView profil( HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Map<String, Object> model = new HashMap<String, Object>();
		int idUser = (Integer) session.getAttribute("idUser");
		model.put("listProfil",  serviceManager.listProfil(idUser));
		
		return new ModelAndView("profil", model);
	}
	
	@RequestMapping(value ="/orderUser", method = RequestMethod.GET )
	public  ModelAndView orderUser( HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Map<String, Object> model = new HashMap<String, Object>();
		int idUser = (Integer) session.getAttribute("idUser");
		model.put("ordersUser",  serviceManager.ordersByIdUser(idUser));
		
		return new ModelAndView("orderUser", model);
	}
	
	@RequestMapping("/logout")
	public  String logout( HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("nameUser");
		session.removeAttribute("idUser");
		session.removeAttribute("moneyUser");
		session.removeAttribute("adresUser");
		session.removeAttribute("passUser");
		session.removeAttribute("roleUser");
		session.removeAttribute("emailUser");
		session.removeAttribute("errorLogin");
		
		session.invalidate();
		return "redirect:showBook";
	}
	
	@RequestMapping("/listUser")
	public String listUser( HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);

		Map<String, Object> model = new HashMap<String, Object>();
		
		
		User user = serviceManager.listUser(request.getParameter("name_user_login"),request.getParameter("pass_user_login"));
				
	
		//model.put("loginList",  serviceManager.listUser(request.getParameter("name_user_login"),request.getParameter("pass_user_login") ));
		request.setAttribute("name", name = "Val");
		request.setAttribute("message", message = "Hellow!");
		
		if (user != null ){
			session.setAttribute("idUser", user.getId_user());
			session.setAttribute("nameUser", user.getName_user());
			session.setAttribute("moneyUser", user.getMoney_user());
			session.setAttribute("adresUser", user.getAdres_user());
			session.setAttribute("passUser", user.getPass_user());
			session.setAttribute("roleUser", user.getIdentif());
			session.setAttribute("emailUser", user.getEmail());
			
		//	System.out.println("model get  "+user.get() );
			request.setAttribute("loginList", user );
			return "redirect:showBook";
		}
		else{
			session.setAttribute("errorLogin", "Error - wrong login or password!" );
			return "redirect:login";
		}

	}
	
	@RequestMapping(value ="/showDetail", method = RequestMethod.GET)
	public ModelAndView showDetail(@ModelAttribute("book") Book book, 
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(true);
		
		
			if (request.getParameter("addToCart") !=null){
				Cart cart = new Cart();
				
			}
			if (request.getParameter("addComent") !=null){
			
				Coments coment = new Coments();
				
				//String str = (String) session.getAttribute("idUser");
				Integer id = (Integer) session.getAttribute("idUser");
		
				coment.setId_book(Integer.parseInt(request.getParameter("selectDetail")));
				coment.setId_user(id);
				coment.setOpinion_coment(request.getParameter("add_coment_book"));
				coment.setDate_coment(new Date());
			
				serviceManager.addComent(coment);
			//	request.setAttribute("selectDetail",id_book);
			}
			if (request.getParameter("selectDetail")!=null )
			{
			
			//System.out.println(request.getParameter("hidden_id_book"));
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("showDetailBook",  serviceManager.listBookByID(Integer.parseInt(request.getParameter("selectDetail"))));
			request.setAttribute("coments",  serviceManager.listComentsByIDbook(Integer.parseInt(request.getParameter("selectDetail"))));
			request.setAttribute("countLike", serviceManager.countLikeByIDBook(Integer.parseInt(request.getParameter("selectDetail"))));
			return new ModelAndView("show", model);
			
		}
		
		
		else {
			
		}
		
		System.out.println(request.getParameter("selectDetail"));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("book",  serviceManager.listBook());
		return new ModelAndView("book", model);
		
	}
	
}
