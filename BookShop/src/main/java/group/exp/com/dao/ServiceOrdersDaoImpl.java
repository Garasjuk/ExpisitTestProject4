package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Orders;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("serviceOrdersDao")
public class ServiceOrdersDaoImpl implements ServiceOrdersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addOrder(Orders orders) {
		sessionFactory.getCurrentSession().save(orders);
		
	}

	
	
	@SuppressWarnings("unchecked")
	public List listOrders() {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("SELECT orders.id_order as '0', book.name_book as '1',"+
			" author.name_author as '2', publishing.name_publishing as '3', genre.name_genre as '4', orders.id_book as '5',"+
			" orders.id_user as '6', orders.count_order as '7', orders.adres_order as '8', user.name_user as '9', orders.status_order as '10', " +
			" orders.date_order as '11' "+
			" FROM publishing INNER JOIN "+ 
			"(genre INNER JOIN "+
			"(author INNER JOIN "+
			"((orders INNER JOIN "+
			"book ON orders.id_book = book.id_book) INNER JOIN "+
			"user ON orders.id_user = user.id_user) ON author.id_author = book.id_author) ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing "+
			"ORDER BY orders.date_order DESC");
		List result = query.list();          
        return result;	
	}

	
	public List listOrdersFilter(String status_order) {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("SELECT orders.id_order as '0', book.name_book as '1',"+
			" author.name_author as '2', publishing.name_publishing as '3', genre.name_genre as '4', orders.id_book as '5',"+
			" orders.id_user as '6', orders.count_order as '7', orders.adres_order as '8', user.name_user as '9', orders.status_order as '10', " +
			" orders.date_order as '11' "+
			"FROM publishing INNER JOIN "+ 
			"(genre INNER JOIN "+
			"(author INNER JOIN "+
			"((orders INNER JOIN "+
			"book ON orders.id_book = book.id_book) INNER JOIN "+
			"user ON orders.id_user = user.id_user) ON author.id_author = book.id_author) ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing"+
			" WHERE orders.status_order like ? "+
			"ORDER BY orders.date_order DESC ");
			query.setString(0, status_order);
		List result = query.list();          
        return result;	
	}
	
	public List listOrdersFilterNot(String status_order) {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("SELECT orders.id_order as '0', book.name_book as '1',"+
			" author.name_author as '2', publishing.name_publishing as '3', genre.name_genre as '4', orders.id_book as '5',"+
			" orders.id_user as '6', orders.count_order as '7', orders.adres_order as '8', user.name_user as '9', orders.status_order as '10', " +
			" orders.date_order as '11' "+
			"FROM publishing INNER JOIN "+ 
			"(genre INNER JOIN "+
			"(author INNER JOIN "+
			"((orders INNER JOIN "+
			"book ON orders.id_book = book.id_book) INNER JOIN "+
			"user ON orders.id_user = user.id_user) ON author.id_author = book.id_author) ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing"+
			" WHERE orders.status_order NOT LIKE ? "+
			"ORDER BY orders.date_order DESC");
			query.setString(0, status_order);
		List result = query.list();          
        return result;	
	}
	
	// To Save the likes detail
	public void updataOrder(int id_order, String selectStatus) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("UPDATE orders SET status_order = ? WHERE id_order = ?");
		query.setString(0, selectStatus);
		query.setInteger(1, id_order);
		query.executeUpdate();
	}
	
	
	public void updataOrderReturn(int id_order, int returnOrder) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("UPDATE orders SET return_order = ? WHERE id_order = ?");
		query.setInteger(0, returnOrder);
		query.setInteger(1, id_order);
		query.executeUpdate();
	}
	
	public void updataOrderDate(int id_order, String selectStatus) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("UPDATE orders SET status_order = ?, date_delivered = ? WHERE id_order = ?");
		query.setString(0, selectStatus);
		query.setDate(1, new Date());
		query.setInteger(2, id_order);
		query.executeUpdate();
	}		
	
	public List ordersByIdUser(int idUser) {
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("SELECT orders.id_order as '0', book.name_book as '1', "+
				"author.name_author as '2', publishing.name_publishing as '3', genre.name_genre as '4', orders.id_book as '5', orders.id_user as '6',"+
				" orders.count_order as '7', orders.adres_order as '8', user.name_user as '9', orders.status_order as '10', orders.date_order as '11',"+
				" orders.date_delivered as '12', orders.return_order as '13', book.price_book as '14', book.id_genre as '15', book.id_author as '16', "+
				" book.id_publishing as '17'" +
				"FROM publishing INNER JOIN "+ 
				"(genre INNER JOIN "+
				"(author INNER JOIN "+
				"((orders INNER JOIN "+
				"book ON orders.id_book = book.id_book) INNER JOIN "+
				"user ON orders.id_user = user.id_user) ON author.id_author = book.id_author) ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing "+
				"WHERE  orders.id_user like ?");
		query.setInteger(0, idUser);	
		List result = query.list();          
        return result;	
	}
	
	
	
	
}
