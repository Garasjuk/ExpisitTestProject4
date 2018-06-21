package com.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.service.Send;
import com.spring.service.SendImpl;


@Controller
@RequestMapping("/")
public class Control {
	
	private static final Logger logger = LoggerFactory.getLogger(Control.class);
	
	@RequestMapping(value = RestURIConstants.ABOUT)
	public void getAbout() {
		System.out.println("About");
	}
	
	@RequestMapping(value = RestURIConstants.SEND)
	public ModelAndView  getSend(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		Send send = new SendImpl();
		send.setSend(request.getParameter("to"), request.getParameter("title"), request.getParameter("text"));
				
		request.setAttribute("to", request.getParameter("to"));
		request.setAttribute("title", request.getParameter("title"));
		request.setAttribute("text", request.getParameter("text"));
		
		return new ModelAndView("send");
	}
}
