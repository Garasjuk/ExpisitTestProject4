package group.exp.com.controller;

import group.exp.com.model.Likes;
import group.exp.com.service.ServiceComents;

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
public class ControlComment {

private static final Logger logger = Logger.getLogger(Control.class);
	
	private int begin , end, listSise;
	
	@Autowired
	private ServiceComents serviceComents; 
	
	@RequestMapping(value ="/addComent", method = RequestMethod.GET )
	public  String addComent( HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		
		return "redirect:showDetail?selectDetail="+request.getParameter("selectDetail");
	}
}
