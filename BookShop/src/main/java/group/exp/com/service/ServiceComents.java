package group.exp.com.service;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Cart;
import group.exp.com.model.Coments;
import group.exp.com.model.Genre;
import group.exp.com.model.Likes;
import group.exp.com.model.Orders;
import group.exp.com.model.Publishing;
import group.exp.com.model.User;

import java.util.List;

public interface ServiceComents {

	
	public List <Coments> listComentsByIDbook(int id_book);	
	public void addComent(Coments coment);
		
}
