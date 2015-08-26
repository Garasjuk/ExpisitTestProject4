package group.exp.com.service;

import group.exp.com.dao.ServiceDao;
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

import org.apache.bcel.generic.RETURN;
import org.apache.regexp.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("ServiceManager")
@Transactional
public class ServiceManagerImpl implements ServiceManager {

	@Autowired
	private ServiceDao serviceDao;

	public ServiceManagerImpl() {
	}

	public List listBook() {
		// TODO Auto-generated method stub
		System.out.println("Point 2");
		return serviceDao.listBook();
	}

	public List<Book> listBookByID(int id_book) {
		// TODO Auto-generated method stub
		return serviceDao.listBookByID(id_book);
	}

	public User listUser(String name_user, String pass_user) {
		// TODO Auto-generated method stub
		return serviceDao.listUser(name_user, pass_user);
	}

	public User listUserByID(int id_user) {
		// TODO Auto-generated method stub
		return serviceDao.listUserByID(id_user);
	}

	public List<Coments> listComentsByIDbook(int id_book) {
		// TODO Auto-generated method stub
		return serviceDao.listComentsByIDbook(id_book);
	}

	public int countLikeByIDBook(int id_book) {
		return serviceDao.countLikeByIDBook(id_book);
	}

	public void addLike(Likes likes) {
		serviceDao.addLike(likes);
	}

	public void addComent(Coments coment) {
		serviceDao.addComent(coment);
	}

	public void addCart(int id_book, int id_user, int count_cart) {
		serviceDao.addCart(id_book, id_user, count_cart);
	}

	public void addUser(User user) {
		serviceDao.addUser(user);
	}

	public void updateUser(User user) {
		serviceDao.updateUser(user);
	}

	public List<User> allListUser() {
		return serviceDao.allListUser();
	}

	public List<Cart> listCartByIDuser(int id_user) {
		return serviceDao.listCartByIDuser(id_user);
	}

	public void deleteFromCart(int id_cart) {
		serviceDao.deleteFromCart(id_cart);
	}

	public void addOrder(Orders orders) {
		serviceDao.addOrder(orders);
	}

	/*
	 * public void addOrder(int id_book, int id_user, int count_order, String
	 * adres_order, String other_order) { serviceDao.addOrder(id_book, id_user,
	 * count_order, adres_order, other_order); }
	 */
	public List<Cart> cartByID(int id_cart) {
		return serviceDao.cartByID(id_cart);
	}

	// public List<Orders> listOrders() {
	// return serviceDao.listOrders();
	// }

	public List listOrders() {
		return serviceDao.listOrders();
	}

	public List<Genre> allListGenre() {
		return serviceDao.allListGenre();

	}
	
	public List<Book> allListBook() {
		return serviceDao.allListBook();
	}

	public List<Author> allListAuthor() {
		return serviceDao.allListAuthor();
	}

	public List<Publishing> allListPublishing() {
		return serviceDao.allListPublishing();
	}

	public void updataOrder(int id_order, String selectStatus) {
		serviceDao.updataOrder(id_order, selectStatus);
	}

	public List ordersByIdUser(int idUser) {
		return serviceDao.ordersByIdUser(idUser);
	}

	public void addBook(Book book) {
		serviceDao.addBook(book);
	}

	public int listLikeByIdUserBook(int id_book, int id_user) {
		return serviceDao.listLikeByIdUserBook(id_book, id_user);
	}

	public void deleteLikeByIdUserBook(int id_book, int id_user) {
		serviceDao.deleteLikeByIdUserBook(id_book, id_user);
	}

	public List listBookFilterGenre(int id_genre) {
		return serviceDao.listBookFilterGenre(id_genre);
	}

	public List listBookFilterAuthor(int id_author) {
		return serviceDao.listBookFilterAuthor(id_author);
	}

	public List listBookFilterPublishing(int id_publishing) {
		return serviceDao.listBookFilterPublishing(id_publishing);
	}

	public List listBookFilterNew(int new_book) {
		return serviceDao.listBookFilterNew(new_book);
	}

	public void updateUsermoney(int id_user, int money) {
		serviceDao.updateUsermoney(id_user, money);
	}

	public User listProfil(int id_user) {
		return serviceDao.listProfil(id_user);
	}

	public void updataOrderDate(int id_order, String selectStatus) {
		serviceDao.updataOrderDate(id_order, selectStatus);
	}

	public void updataOrderReturn(int id_order, int returnOrder) {
		serviceDao.updataOrderReturn(id_order, returnOrder);
	}

	public Book listBook(String name_book, int id_genre, int id_author,
			int id_publishing, int new_book) {
		return serviceDao.listBook(name_book, id_genre, id_author,
				id_publishing, new_book);
	}

	public void updataBookNew(int id_book, int count_book) {
		serviceDao.updataBookNew(id_book, count_book);
	}
	
	public List listOrdersFilter(String status_order){
		return serviceDao.listOrdersFilter(status_order);
	}
	
	public List listOrdersFilterNot(String status_order){
		return serviceDao.listOrdersFilterNot(status_order);
	}
	public void updataPassword(int id_user, String pass){
		serviceDao.updataPassword(id_user, pass);
	}
	public User listSearchEmail(String email){
		return serviceDao.listSearchEmail(email);
	}
	public void updateUserSpendMoney(int id_user, int spend_money){
		serviceDao.updateUserSpendMoney(id_user, spend_money);
	}
	public void updataBook(int id_book, String name_book, int price_book, int count_book, int author_book, int genre_book, int publishing_book){
		serviceDao.updataBook(id_book, name_book, price_book, count_book, author_book, genre_book, publishing_book);
	}
}
