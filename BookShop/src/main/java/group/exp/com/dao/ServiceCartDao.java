package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Cart;

import java.util.List;

public interface ServiceCartDao {
	
	public List<Cart> listCartByIDuser(int id_user);
	public void deleteFromCart(int id_cart);
	public List<Cart> cartByID(int id_cart);
	public void addCart(int id_book, int id_user, int count_cart);
	
	
	
}
