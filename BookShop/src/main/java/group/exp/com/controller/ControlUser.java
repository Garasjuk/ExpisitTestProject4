package group.exp.com.controller;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ControlUser {

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
	
	@RequestMapping(value ="/addMoney", method = RequestMethod.GET)
	public ModelAndView addMoney( HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		
		if (request.getParameter("choice_pay") != null){
			if (request.getParameter("choice_pay").equals("SMS")){
				request.setAttribute("choice_pay", request.getParameter("choice_pay"));
			}
			else if (request.getParameter("choice_pay").equals("Credit_card")){
				request.setAttribute("choice_pay", request.getParameter("choice_pay"));
			}
			else if (request.getParameter("choice_pay").equals("Pay_pal")){
				request.setAttribute("choice_pay", request.getParameter("choice_pay"));
			}
			else{
				
			}		
		}
		if (request.getParameter("addNewMoney") != null){
			Integer id = (Integer) session.getAttribute("idUser");
			User user = serviceUser.listProfil(id);
						
			serviceUser.updateUsermoney(id, Integer.parseInt(request.getParameter("money")) + user.getMoney_user());
		}
		return new ModelAndView("money");
	}
	
	@RequestMapping(value ="/editPassword", method = RequestMethod.GET)
	public ModelAndView editPassword( HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Integer id = (Integer) session.getAttribute("idUser");
		if (request.getParameter("editPassword") != null){
			if (request.getParameter("pass1").equals(request.getParameter("pass2"))){
				MessageDigest md5 ;        
				StringBuffer  hexString = new StringBuffer();
				md5 = MessageDigest.getInstance("md5");
				md5.reset();
				md5.update(request.getParameter("pass1").getBytes());
				byte messageDigest[] = md5.digest();
				for (int i = 0; i < messageDigest.length; i++) {
					hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
				}
				serviceUser.updataPassword(id, hexString.toString());
			}
			else{
				request.setAttribute("errorPassword", "Password is not equal!");	
			}		
		}
			return new ModelAndView("editPassword");
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
			
			serviceUser.updateUser(user);	
		}	
		if (request.getParameter("selectUser") != null){
			User user = serviceUser.listUserByID(Integer.parseInt(request.getParameter("selectUser")));
			request.setAttribute("editUser", user);
		}
		model.put("allListUser",  serviceUser.allListUser());
		return new ModelAndView("user", model);
	}
	
	@RequestMapping(value ="/editUser", method = RequestMethod.GET)
	public ModelAndView editUser( HttpServletRequest request, HttpServletResponse response) {	
		return  new ModelAndView("user");
	}
	
	@RequestMapping(value ="/profil", method = RequestMethod.GET )
	public  ModelAndView profil( HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Map<String, Object> model = new HashMap<String, Object>();
		int idUser = (Integer) session.getAttribute("idUser");
		model.put("listProfil",  serviceUser.listProfil(idUser));
		
		return new ModelAndView("profil", model);
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
	public String listUser( HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, NoSuchProviderException {
		HttpSession session = request.getSession(true);

		Map<String, Object> model = new HashMap<String, Object>();
		
		MessageDigest md5 ;        
		StringBuffer  hexString = new StringBuffer();
		md5 = MessageDigest.getInstance("md5");
		md5.reset();
		md5.update(request.getParameter("pass_user_login").getBytes());
		byte messageDigest[] = md5.digest();
		for (int i = 0; i < messageDigest.length; i++) {
			hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
		}
		
		User user = serviceUser.listUser(request.getParameter("name_user_login"),hexString.toString());	
		
		if (user != null ){
			session.setAttribute("idUser", user.getId_user());
			session.setAttribute("nameUser", user.getName_user());
			session.setAttribute("moneyUser", user.getMoney_user());
			session.setAttribute("adresUser", user.getAdres_user());
			session.setAttribute("passUser", user.getPass_user());
			session.setAttribute("roleUser", user.getIdentif());
			session.setAttribute("emailUser", user.getEmail());
	
			request.setAttribute("loginList", user );
			return "redirect:showBook";
		}
		else{
			logger.error("Error password "+ request.getParameter("name_user_login") + " - " + request.getParameter("pass_user_login"));
			session.setAttribute("errorLogin", "Error - wrong login or password!" );
			return "redirect:login";
		}
	}
	
	@RequestMapping(value ="/addRegistration", method = RequestMethod.POST)
	public ModelAndView addRegistration(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException {
		
		
		user = serviceUser.listSearchEmail(request.getParameter("add_email_user"));
		if (user !=null){
			request.setAttribute("errorEmail", "E-Mail already exists!");
			return new ModelAndView("registration");
		}
		if (request.getParameter("add_pass1_user").equals(request.getParameter("add_pass2_user"))){
			
			MessageDigest md5 ;        
			StringBuffer  hexString = new StringBuffer();
			md5 = MessageDigest.getInstance("md5");
			md5.reset();
			md5.update(request.getParameter("add_pass1_user").getBytes());
			byte messageDigest[] = md5.digest();
			for (int i = 0; i < messageDigest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
			}
			user.setName_user(request.getParameter("add_name_user"));
			user.setPass_user(hexString.toString());
			user.setAdres_user(request.getParameter("add_adres_user"));
			user.setEmail(request.getParameter("add_email_user"));	
			
			if (request.getParameter("identif") != null){
				user.setIdentif(request.getParameter("identif"));
			}else
			{
				user.setIdentif("0");
			}
			user.setMoney_user(0);
			serviceUser.addUser(user);
		}
		else{
			request.setAttribute("errorPassword", "Password is not equal!");
		}
		return new ModelAndView("registration");
	}
	
	@RequestMapping("/login")
	public ModelAndView login( HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/registration")
	public ModelAndView registration( HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("registration");
	}
}
