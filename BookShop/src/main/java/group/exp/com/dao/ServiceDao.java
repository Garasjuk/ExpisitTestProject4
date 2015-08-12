package group.exp.com.dao;

import group.exp.com.model.Book;
import group.exp.com.model.Cart;
import group.exp.com.model.Coments;
import group.exp.com.model.Likes;
import group.exp.com.model.User;

import java.util.List;


public interface ServiceDao {

	public List<Book> listBook();
	public List<Book> listBookByID(int id_book);
	public User listUser(String name_iser, String pass_user);
	public List<Coments> listComentsByIDbook(int id_book);
	public int countLikeByIDBook(int id_book);
	public void addLike (Likes likes);
	public void addUser (User user);
	public List<User> allListUser ();
	public User listUserByID(int id_user);
	public void updateUser(User user);
	public void addComent(Coments coment);
	public void addCart(int id_book, int id_user, int count_cart);
	public List<Cart> listCartByIDuser(int id_user);
}
