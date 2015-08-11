package group.exp.com.controller;


import group.exp.com.model.Book;
import group.exp.com.model.Likes;
import group.exp.com.model.User;
import group.exp.com.service.ServiceManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		model.put("book",  serviceManager.listBook());
		
	//	List <Book> books = new ArrayList<Book>();
		
//				books = serviceManager.listBook();
		
	//	System.out.println("name_book " + books.get model.get etName_book);
		/*
		try{
			System.out.println("Point 1");
			List <Book> book  =  serviceManager.listBook();
			request.setAttribute("book", book);	
		}catch (Exception e)
		{System.out.println("Exception: " + e);}
		*/
		
		request.setAttribute("name", name = "Val");
		request.setAttribute("message", message = "Hellow!");
		//request.setAttribute("book", books);	
		return new ModelAndView("book", model);
	}
	
	@RequestMapping(value ="/showUser", method = RequestMethod.GET)
	public ModelAndView showUser( HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		
		if (request.getParameter("editUser") != null){
			
			System.out.println("ID user :"+request.getParameter("edit_id_user"));
			System.out.println("edit name :" + request.getParameter("edit_name_user"));
			System.out.println("edit money :" + request.getParameter("edit_money_user"));
			System.out.println("edit adres :" + request.getParameter("edit_adres_user"));
			System.out.println("edit email :" + request.getParameter("edit_email_user"));
			System.out.println("edit role :" + request.getParameter("identif"));
			System.out.println("edit pass :" + request.getParameter("edit_pass_user"));
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
	
	@RequestMapping("/registration")
	public ModelAndView registration( HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("registration");
	}
	
	@RequestMapping(value ="/addRegistration", method = RequestMethod.POST)
	public ModelAndView addRegistration(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response) {
		
		
		System.out.println(" name : "+ request.getParameter("add_name_user"));
		System.out.println(" pass : " + request.getParameter("add_pass_user"));
		System.out.println(" adres : " + request.getParameter("add_adres_user"));
		System.out.println(" email : "+ request.getParameter("add_email_user"));
		System.out.println(" role : "+ request.getParameter("identif"));
		
		
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
	
	@RequestMapping("/addLike")
	public  String addLike( HttpServletRequest request, HttpServletResponse response, Likes likes) {
		HttpSession session = request.getSession(true);
		likes.setId_book(Integer.parseInt(request.getParameter("selectDetail")));
		int idUser = (Integer) session.getAttribute("idUser");
		likes.setId_user(idUser);
		System.out.println("likes.getId_book() "+likes.getId_book());
		System.out.println("likes.getId_user() "+likes.getId_user());
		
		serviceManager.addLike(likes);
		
		return "redirect:showDetail?selectDetail="+request.getParameter("selectDetail");
	}
	
	@RequestMapping("/logout")
	public  String logout( HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		session.removeAttribute("nameUser");
		session.removeAttribute("idUser");
		session.removeAttribute("errorLogin");
		
		
		session.invalidate();
		return "redirect:showBook";
	}
	
	@RequestMapping("/listUser")
	public String listUser( HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);

		Map<String, Object> model = new HashMap<String, Object>();
		
		
		User user = serviceManager.listUser(request.getParameter("name_user_login"),request.getParameter("pass_user_login"));
				
	//System.out.println("name_user "+ user.getName_user());
	//	System.out.println("pass_user "+ user.getPass_user());
		
		
		//model.put("loginList",  serviceManager.listUser(request.getParameter("name_user_login"),request.getParameter("pass_user_login") ));
		request.setAttribute("name", name = "Val");
		request.setAttribute("message", message = "Hellow!");
		
		if (user != null ){
			session.setAttribute("nameUser", user.getName_user());
			session.setAttribute("idUser", user.getId_user());
			session.setAttribute("roleUser", user.getIdentif());
			
		//	System.out.println("model get  "+user.get() );
			request.setAttribute("loginList", user );
			return "redirect:showBook";
		}
		else{
			session.setAttribute("errorLogin", "Error - wrong login or password!" );
			return "redirect:login";
		}

	}
	
	@RequestMapping("/showDetail")
	public ModelAndView showDetail(@ModelAttribute("book") Book book, 
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {
	
		
		if (request.getParameter("selectDetail")!=null)
		{
			//System.out.println(request.getParameter("hidden_id_book"));
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("showDetail",  serviceManager.listBookByID(Integer.parseInt(request.getParameter("selectDetail"))));
			request.setAttribute("countLike", serviceManager.countLikeByIDBook(Integer.parseInt(request.getParameter("selectDetail"))));
			return new ModelAndView("show", model);
			
		}
		else if (request.getParameter("Edit")!=null){
			
			
		}
		else if(request.getParameter("Book")!=null){
			
		}
		else if(request.getParameter("Show")!=null){
			System.out.println(request.getParameter("hidden_id_book"));
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("showDetail",  serviceManager.listBook());
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
