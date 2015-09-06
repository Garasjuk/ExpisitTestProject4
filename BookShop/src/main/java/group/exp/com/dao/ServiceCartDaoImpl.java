package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Cart;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("serviceCartDao")
public class ServiceCartDaoImpl implements ServiceCartDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Cart> listCartByIDuser(int id_user) {	
		Query query =sessionFactory.getCurrentSession().createSQLQuery("Select cart.id_cart, cart.id_book, cart.id_user, cart.count_cart, book.name_book, book.price_book, book.count_book  FROM cart INNER JOIN book ON cart.id_book = book.id_book WHERE cart.id_user like ?  ").addEntity(Cart.class);
		List <Cart> result = query.setInteger(0, id_user).list();			 
		return result;
	}
	
	// To Save the likes detail
	public void addCart(int id_book, int id_user, int count_cart) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO cart (id_book, id_user, count_cart) VALUES (?,?,?)");
		query.setInteger(0, id_book);
		query.setInteger(1, id_user);
		query.setInteger(2, count_cart);
		query.executeUpdate();
	}
	// To Save the article detail
	public void deleteFromCart(int id_cart) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("Delete from cart where id_cart like ?");
	    query.setInteger(0, id_cart);
	    query.executeUpdate();
	    //int rowCount = query.executeUpdate();
	}

	public List<Cart> cartByID(int id_cart) {	
		Query query =sessionFactory.getCurrentSession().createSQLQuery("Select cart.id_cart, cart.id_book, cart.id_user, cart.count_cart, book.name_book, book.price_book, book.count_book  FROM cart INNER JOIN book ON cart.id_book = book.id_book WHERE cart.id_cart like ?  ").addEntity(Cart.class);
		List <Cart> result = query.setInteger(0, id_cart).list();			 
		return result;
	}
	
	
	
}
