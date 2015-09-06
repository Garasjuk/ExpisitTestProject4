package group.exp.com.controller;

import group.exp.com.model.Likes;
import group.exp.com.service.ServiceAuthor;
import group.exp.com.service.ServiceBook;
import group.exp.com.service.ServiceCart;
import group.exp.com.service.ServiceComents;
import group.exp.com.service.ServiceGenre;
import group.exp.com.service.ServiceLikes;
import group.exp.com.service.ServiceOrders;
import group.exp.com.service.ServicePublishing;
import group.exp.com.service.ServiceUser;

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
public class ControlLikes {

private static final Logger logger = Logger.getLogger(Control.class);
	
	private int begin , end, listSise;
	
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
	
	@RequestMapping("/addLike")
	public  String addLike( HttpServletRequest request, HttpServletResponse response, Likes likes) {
		HttpSession session = request.getSession(true);
		int idUser = (Integer) session.getAttribute("idUser");
		likes.setId_book(Integer.parseInt(request.getParameter("selectDetail")));
		likes.setId_user(idUser);
		
		if (serviceLikes.listLikeByIdUserBook(Integer.parseInt(request.getParameter("selectDetail")), idUser) >=1){
			serviceLikes.deleteLikeByIdUserBook(Integer.parseInt(request.getParameter("selectDetail")),idUser );
			
		}
		else{
			serviceLikes.addLike(likes);	
		}
		return "redirect:showDetail?selectDetail="+request.getParameter("selectDetail");
	}
	
	@RequestMapping(value ="/likeList", method = RequestMethod.GET)
	public ModelAndView likeList( HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		
		if (request.getParameter("selectDetail") !=null){
			Integer id = (Integer) session.getAttribute("idUser");
			serviceLikes.deleteLikeByIdUserBook(Integer.parseInt(request.getParameter("selectDetail")),id );
			model.put("likesList",  serviceLikes.listLike((Integer)session.getAttribute("idUser")));
			return  new ModelAndView("likeList", model);
		}
		if (session.getAttribute("idUser") != null){
			Integer id = (Integer) session.getAttribute("idUser");
			model.put("likesList",  serviceLikes.listLike((Integer)session.getAttribute("idUser")));
			return  new ModelAndView("likeList", model);
		}else{
			return  new ModelAndView("login");
		}
		
	}
}
