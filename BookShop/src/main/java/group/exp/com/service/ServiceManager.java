package group.exp.com.service;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Books;
import group.exp.com.model.Cart;
import group.exp.com.model.Coments;
import group.exp.com.model.Genre;
import group.exp.com.model.Likes;
import group.exp.com.model.Orders;
import group.exp.com.model.Publishing;
import group.exp.com.model.User;

import java.util.List;

public interface ServiceManager {

	public List listBook();
	public List <Book> listBookByID(int id_book);
	public User listUser(String name_iser, String pass_user);
	public List <Coments> listComentsByIDbook(int id_book);
	public int countLikeByIDBook(int id_book);
	public void addLike (Likes likes);
	public void addUser (User user);
	public List<User> allListUser ();
	public User listUserByID(int id_user);
	public void updateUser(User user);
	public void addComent(Coments coment);
	public void addCart(int id_book, int id_user, int count_cart);
	public List<Cart> listCartByIDuser(int id_user);
	public void deleteFromCart(int id_cart);
	
	public void addOrder(Orders orders);
	//public void addOrder(int id_book, int id_user, int count_order, String adres_order, String other_order);
	public List<Cart> cartByID(int id_cart);
	//public List<Orders> listOrders();
	public List listOrders();
	
	public List<Genre> allListGenre();
	public List<Book> allListBook();
	public List<Books> allListBooks();
	public List<Author> allListAuthor();
	public List<Publishing> allListPublishing();
	public void updataOrder(int id_order, String selectStatus);
	public List ordersByIdUser(int idUser);
	public void addBook(Book book);
	public int listLikeByIdUserBook(int id_book, int id_user);
	public void deleteLikeByIdUserBook(int id_book, int id_user);
	public List listBookFilterGenre(int id_genre);
	public List listBookFilterAuthor(int id_author);
	public List listBookFilterPublishing(int id_publishing);
	public List listBookFilterNew(int new_book);
	public void updateUsermoney(int id_user, int money);
	public User listProfil(int id_user);
	public void updataOrderDate(int id_order, String selectStatus);
	public void updataOrderReturn(int id_order, int returnOrder);
	public Book listBook(String name_book, int id_genre, int id_author, int id_publishing, int new_book);
	public void updataBookNew(int id_book, int count_book);
}
