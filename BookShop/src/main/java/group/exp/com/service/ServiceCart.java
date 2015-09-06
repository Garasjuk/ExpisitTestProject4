package group.exp.com.service;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Cart;
import group.exp.com.model.Genre;

import java.util.List;

public interface ServiceCart {
	
	public void addCart(int id_book, int id_user, int count_cart);
	public List<Cart> listCartByIDuser(int id_user);
	public void deleteFromCart(int id_cart);
	public List<Cart> cartByID(int id_cart);
	
}
