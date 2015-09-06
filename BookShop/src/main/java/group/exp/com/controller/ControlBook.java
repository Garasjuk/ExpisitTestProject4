package group.exp.com.controller;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Cart;
import group.exp.com.model.Coments;
import group.exp.com.model.Genre;
import group.exp.com.model.Publishing;
import group.exp.com.service.ServiceAuthor;
import group.exp.com.service.ServiceBook;


import group.exp.com.service.ServiceCart;
import group.exp.com.service.ServiceComents;
import group.exp.com.service.ServiceGenre;
import group.exp.com.service.ServiceLikes;
import group.exp.com.service.ServiceOrders;
import group.exp.com.service.ServicePublishing;
import group.exp.com.service.ServiceUser;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ControlBook {

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
	
	
	@RequestMapping("/showBook")
	public ModelAndView showBook( HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		if (request.getParameter("begin") != null && request.getParameter("end") != null){
			begin = Integer.parseInt(request.getParameter("begin"));
			end = Integer.parseInt(request.getParameter("end"));
		}
		
		if  (request.getParameter("genre_book_filter") != null || request.getParameter("author_book_filter")!= null || request.getParameter("publishing_book_filter")!= null || request.getParameter("new_book_filter")!= null || request.getParameter("searchs") != null ){

			if (request.getParameter("genre_book_filter") != null){ 
				if (!request.getParameter("genre_book_filter").equals("") )
				model.put("book",  serviceBook.listBookFilterGenre(Integer.parseInt(request.getParameter("genre_book_filter"))));
			}
			else if (request.getParameter("author_book_filter")!= null){ 
				if (!request.getParameter("author_book_filter").equals(""))
				model.put("book",  serviceBook.listBookFilterAuthor(Integer.parseInt(request.getParameter("author_book_filter"))));
			}
			else if (request.getParameter("publishing_book_filter")!= null){ 
				if(!request.getParameter("publishing_book_filter").equals(""))
				model.put("book",  serviceBook.listBookFilterPublishing(Integer.parseInt(request.getParameter("publishing_book_filter"))));	
			}
			else if (request.getParameter("new_book_filter")!= null){
				if(!request.getParameter("new_book_filter").equals(""))
				model.put("book",  serviceBook.listBookFilterNew(Integer.parseInt(request.getParameter("new_book_filter"))));
			}	
		}	
		
		if (request.getParameter("searchs") != null){
			if(!request.getParameter("searchs").equals(""))
			model.put("book",  serviceBook.listBookSearch(request.getParameter("searchs")));
		}

		if (model.isEmpty() == true ){
			List list = serviceBook.listBook();
			listSise = list.size();
			request.setAttribute("listSize", listSise);
			model.put("book", list );
		}
		request.setAttribute("genre", serviceGenre.allListGenre());
		request.setAttribute("author", serviceAuthor.allListAuthor());
		request.setAttribute("publishing", servicePublishing.allListPublishing());
		
		if (request.getParameter("Last") != null){
			if(begin >= 8){
				request.setAttribute("end", end-=9);
				request.setAttribute("begin", begin-=9);
			}else{
			request.setAttribute("end", end=8);
			request.setAttribute("begin", begin=0);
			}
		}
		else if(request.getParameter("Next")!=null)
		{
			if (end >= listSise){
				request.setAttribute("begin", begin );
				request.setAttribute("end", end);
			}else{
			request.setAttribute("begin", begin+=9 );
			request.setAttribute("end", end+=9);
			}
		}
		else {
			request.setAttribute("begin", begin=0 );
			request.setAttribute("end", end=8);
		}
		
		return new ModelAndView("book", model);
	}
	
	@RequestMapping(value ="/showDetail", method = RequestMethod.GET)
	public ModelAndView showDetail(@ModelAttribute("book") Book book, 
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {
			HttpSession session = request.getSession(true);		
		
			if (request.getParameter("editBook") !=null){
				
				serviceBook.updataBook(Integer.parseInt(request.getParameter("selectDetail")), request.getParameter("edit_name_book"), Integer.parseInt(request.getParameter("edit_price_book")), Integer.parseInt(request.getParameter("edit_count_book")), Integer.parseInt(request.getParameter("edit_author_book")), Integer.parseInt(request.getParameter("edit_genre_book")), Integer.parseInt(request.getParameter("edit_publishing_book")));
			}
			if (request.getParameter("addToCart") !=null){
				Cart cart = new Cart();
			}
			if (request.getParameter("addComent") !=null){
			
				Coments coment = new Coments();

				Integer id = (Integer) session.getAttribute("idUser");
		
				coment.setId_book(Integer.parseInt(request.getParameter("selectDetail")));
				coment.setId_user(id);
				coment.setOpinion_coment(request.getParameter("add_coment_book"));
				coment.setDate_coment(new Date());
			
				serviceComents.addComent(coment);
			}
			if (request.getParameter("selectDetail")!=null  )
			{
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("showDetailBook",  serviceBook.listBookByID(Integer.parseInt(request.getParameter("selectDetail"))));
			request.setAttribute("coments",  serviceComents.listComentsByIDbook(Integer.parseInt(request.getParameter("selectDetail"))));
			request.setAttribute("countLike", serviceLikes.countLikeByIDBook(Integer.parseInt(request.getParameter("selectDetail"))));
			
			request.setAttribute("genre", serviceGenre.allListGenre());
			request.setAttribute("author", serviceAuthor.allListAuthor());
			request.setAttribute("publishing", servicePublishing.allListPublishing());
			
			return new ModelAndView("show", model);	
		}
		
		else {
			request.setAttribute("genre", serviceGenre.allListGenre());
			request.setAttribute("author", serviceAuthor.allListAuthor());
			request.setAttribute("publishing", servicePublishing.allListPublishing());
			
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("book",  serviceBook.listBook());
			return new ModelAndView("book", model);
		}	
	}
	
	@RequestMapping(value ="/addBook", method = RequestMethod.GET)
	public ModelAndView addBook(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		request.setAttribute("genre", serviceGenre.allListGenre());
		request.setAttribute("author", serviceAuthor.allListAuthor());
		request.setAttribute("publishing", servicePublishing.allListPublishing());
		
		if (request.getParameter("genre") != null){
			request.setAttribute("addGenre", true);
		}
		if (request.getParameter("author") != null){
			request.setAttribute("addAuthor", true);
		}
		if (request.getParameter("publishing") != null){
			request.setAttribute("addPublishing", true);
		}
		
		if (request.getParameter("addPublishing") != null){
			Publishing publishing = new Publishing();
			publishing.setName_publishing(request.getParameter("add_publishing"));
			servicePublishing.addPublishing(publishing);
		}
		if (request.getParameter("addAuthor") != null){
			Author author = new Author();
			author.setName_author(request.getParameter("add_author"));
			serviceAuthor.addAuthor(author);
		}
		if (request.getParameter("addGenre") != null){
			Genre genre = new Genre();
			genre.setName_genre(request.getParameter("add_genre"));
			serviceGenre.addGenre(genre);
		}
		
		if (request.getParameter("addBook")!=null){
			if (!request.getParameter("add_name_book").equals("") && !request.getParameter("add_price_book").equals("") && !request.getParameter("add_count_book").equals("")){
			
				Book book = new Book();
				book.setName_book(request.getParameter("add_name_book"));
				book.setId_genre(Integer.parseInt(request.getParameter("add_genre_book")));
				book.setId_author(Integer.parseInt(request.getParameter("add_author_book")));
				book.setId_publishing(Integer.parseInt(request.getParameter("add_publishing_book")));
				book.setPrice_book(Integer.parseInt(request.getParameter("add_price_book")));
				book.setCount_book(Integer.parseInt(request.getParameter("add_count_book")));
				book.setNew_book(1);
				serviceBook.addBook(book);
			}
			else {
				request.setAttribute("errorAddBook", true);
			}
		}
		
		return new ModelAndView("addBook", model);
	}
	
	@RequestMapping("/deleteBook")
	public String deleteBook( HttpServletRequest request, HttpServletResponse response) {
			serviceBook.deleteBook(Integer.parseInt(request.getParameter("id_book")));
		return "redirect:showBook";
	}
}
