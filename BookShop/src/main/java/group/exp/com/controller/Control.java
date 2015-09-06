package group.exp.com.controller;


import group.exp.com.model.Book;
import group.exp.com.model.Cart;
import group.exp.com.model.Coments;
import group.exp.com.model.Likes;
import group.exp.com.model.Orders;
import group.exp.com.model.User;
import group.exp.com.service.ServiceComents;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Control {

	private static final Logger logger = Logger.getLogger(Control.class);
	
	private int begin , end, listSise;
	
	@Autowired
	private ServiceComents serviceComents; 
	
	
	@RequestMapping("/about")
	public ModelAndView about( HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("about");
	}
	
	@RequestMapping("/aboutbook")
	public ModelAndView aboutbook( HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("aboutbook");
	}
	
}
