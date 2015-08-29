package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Cart;
import group.exp.com.model.Coments;
import group.exp.com.model.Genre;
import group.exp.com.model.Likes;
import group.exp.com.model.Orders;
import group.exp.com.model.Publishing;
import group.exp.com.model.User;
import group.exp.com.utility.BaseUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("serviceDao")
public class ServiceDaoImpl implements ServiceDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
		
	@SuppressWarnings("unchecked")
	public List listBook() {	
	
		Query query =sessionFactory.getCurrentSession().createSQLQuery("SELECT book.id_book as '0', book.name_book as '1',"+
		" book.count_book as '2', book.price_book as '3', book.id_genre as '4', book.id_author as '5', book.new_book as '6',"+
		" book.id_publishing as '7',author.name_author as '8', publishing.name_publishing as '9', genre.name_genre as '10' "+
		" FROM publishing INNER JOIN (genre INNER JOIN (author INNER JOIN book ON author.id_author = book.id_author)"+
		" ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing "+
		" ORDER BY book.name_book");
		List result = query.list();
		return result;
	}

	public List listBookFilterGenre(int id_genre) {		
		Query query =sessionFactory.getCurrentSession().createSQLQuery("SELECT book.id_book as '0', book.name_book as '1',"+
		" book.count_book as '2', book.price_book as '3', book.id_genre as '4', book.id_author as '5', book.new_book as '6',"+
		" book.id_publishing as '7',author.name_author as '8', publishing.name_publishing as '9', genre.name_genre as '10' "+
		" FROM publishing INNER JOIN (genre INNER JOIN (author INNER JOIN book ON author.id_author = book.id_author)"+
		" ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing "+
		" WHERE genre.id_genre like ? "+
		" ORDER BY book.name_book");
		query.setInteger(0, id_genre);
		List result = query.list();
		return result;
	}
	
	public List listBookFilterAuthor(int id_author) {		
		Query query =sessionFactory.getCurrentSession().createSQLQuery("SELECT book.id_book as '0', book.name_book as '1',"+
		" book.count_book as '2', book.price_book as '3', book.id_genre as '4', book.id_author as '5', book.new_book as '6',"+
		" book.id_publishing as '7',author.name_author as '8', publishing.name_publishing as '9', genre.name_genre as '10' "+
		" FROM publishing INNER JOIN (genre INNER JOIN (author INNER JOIN book ON author.id_author = book.id_author)"+
		" ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing "+
		" WHERE author.id_author like ? "+
		" ORDER BY book.name_book");
		query.setInteger(0, id_author);
		List result = query.list();
		return result;
	}
	public List listBookFilterPublishing(int id_publishing) {		
		Query query =sessionFactory.getCurrentSession().createSQLQuery("SELECT book.id_book as '0', book.name_book as '1',"+
		" book.count_book as '2', book.price_book as '3', book.id_genre as '4', book.id_author as '5', book.new_book as '6',"+
		" book.id_publishing as '7',author.name_author as '8', publishing.name_publishing as '9', genre.name_genre as '10' "+
		" FROM publishing INNER JOIN (genre INNER JOIN (author INNER JOIN book ON author.id_author = book.id_author)"+
		" ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing "+
		" WHERE publishing.id_publishing like ? "+
		" ORDER BY book.name_book");
		query.setInteger(0, id_publishing);
		List result = query.list();
		return result;
	}
	public List listBookFilterNew(int new_book) {		
		Query query =sessionFactory.getCurrentSession().createSQLQuery("SELECT book.id_book as '0', book.name_book as '1',"+
		" book.count_book as '2', book.price_book as '3', book.id_genre as '4', book.id_author as '5', book.new_book as '6',"+
		" book.id_publishing as '7',author.name_author as '8', publishing.name_publishing as '9', genre.name_genre as '10' "+
		" FROM publishing INNER JOIN (genre INNER JOIN (author INNER JOIN book ON author.id_author = book.id_author)"+
		" ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing "+
		" WHERE book.new_book like ? "+
		" ORDER BY book.name_book");
		query.setInteger(0, new_book);
		List result = query.list();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public User listProfil(int id_user) {	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
                   .add(Restrictions.eq("id_user", id_user));
         return (User) criteria.uniqueResult();   		 
	}
	
	public Book listBook(String name_book, int id_genre, int id_author, int id_publishing, int new_book) {	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class)
					.add(Restrictions.eq("name_book", name_book))
					.add(Restrictions.eq("id_genre", id_genre))
					.add(Restrictions.eq("id_author", id_author))
					.add(Restrictions.eq("id_publishing", id_publishing))
					.add(Restrictions.eq("new_book", new_book));
         return (Book) criteria.uniqueResult();		 
	}
		
	@SuppressWarnings("unchecked")
	public User listUser(String name_user, String pass_user) {	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
                   .add(Restrictions.eq("name_user", name_user))
                   .add(Restrictions.eq("pass_user", pass_user));
         return (User) criteria.uniqueResult();	 
	}
	
	@SuppressWarnings("unchecked")
	public User listUserByID(int id_user) {	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
                   .add(Restrictions.eq("id_user", id_user));
         return (User) criteria.uniqueResult();
	}
	
	public User listSearchEmail(String email){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("email", email));
      return (User) criteria.uniqueResult();
	}
	
	
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
	
	public List listLike(int id_user) {		
		Query query =sessionFactory.getCurrentSession().createSQLQuery("SELECT book.id_book as '0', book.name_book as '1',"+
		" book.count_book as '2', book.price_book as '3', book.id_genre as '4', book.id_author as '5', book.new_book as '6',"+
		" book.id_publishing as '7',author.name_author as '8', publishing.name_publishing as '9', genre.name_genre as '10', "+
		" likes.id_like as '11' "+
		" FROM publishing INNER JOIN (genre INNER JOIN (author INNER JOIN book ON author.id_author = book.id_author)"+
		" ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing "+
		" INNER JOIN likes ON book.id_book = likes.id_book "+
		" WHERE likes.id_user like ?"+
		" ORDER BY book.name_book");
		query.setInteger(0, id_user);
		List result = query.list();
		return result;
	}
	
	public void updataBookNew(int id_book, int count_book) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("UPDATE book SET count_book = ? WHERE id_book = ?");
		query.setInteger(0, count_book);
		query.setInteger(1, id_book);
		query.executeUpdate();
	}	
	
	@SuppressWarnings("unchecked")
	public List<User> allListUser() {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("Select id_user, name_user, money_user, adres_user, pass_user, identif, email, spend_money FROM user ORDER BY name_user").addEntity(User.class);
        List<User> user = query.list();          
        return user;	
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> allListBook() {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("Select book.id_book, book.name_book, book.count_book, book.price_book, book.id_genre, book.id_author, book.new_book, book.id_publishing FROM book").addEntity(Book.class);
        List<Book> result = query.list();          
        return result;	
	}
	
	@SuppressWarnings("unchecked")
	public List<Genre> allListGenre() {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("Select id_genre, name_genre  FROM genre").addEntity(Genre.class);
        List<Genre> result = query.list();          
        return result;	
	}
	@SuppressWarnings("unchecked")
	public List<Author> allListAuthor() {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("Select id_author, name_author FROM author").addEntity(Author.class);
        List<Author> result = query.list();          
        return result;	
	}
	@SuppressWarnings("unchecked")
	public List<Publishing> allListPublishing() {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("Select id_publishing, name_publishing FROM publishing").addEntity(Publishing.class);
        List<Publishing> result = query.list();          
        return result;	
	}
	@SuppressWarnings("unchecked")
	public int countLikeByIDBook(int id_book) {	
		return ((Number) sessionFactory.getCurrentSession().createSQLQuery("Select count(*) FROM likes WHERE id_book like ? ")
		.setInteger(0, id_book)
		.uniqueResult()).intValue();
	}
		
	// To Save the likes detail
	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
		
	// To Save the likes detail
	public void addLike(Likes likes) {
		sessionFactory.getCurrentSession().saveOrUpdate(likes);
	}
		
	// To Save the likes detail
	public int listLikeByIdUserBook(int id_book, int id_user) {
		return ((Number)  sessionFactory.getCurrentSession().createSQLQuery("SELECT count(*) FROM likes WHERE id_book like ? AND id_user like ?")
				.setInteger(0, id_book)
				.setInteger(1, id_user)
				.uniqueResult()).intValue();		
	}
		
	// To Save the likes detail
	public void deleteLikeByIdUserBook(int id_book, int id_user) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM likes WHERE id_book like ? and id_user like ?");
	    query.setInteger(0, id_book);
	    query.setInteger(1, id_user);	    
	    query.executeUpdate();
	}
		
	
	@SuppressWarnings("unchecked")
	public List listBookByID(int id_book) {		
		Query query =sessionFactory.getCurrentSession().createSQLQuery("Select book.id_book as '0', book.name_book as '1',"+
		" book.count_book as '2', book.price_book as '3', book.id_genre as '4', book.id_author as '5', book.new_book as '6', book.id_publishing as '7', "+
		" author.name_author as '8', publishing.name_publishing as '9', genre.name_genre as '10', "+
		" author.id_author as '11', publishing.id_publishing as '12', genre.id_genre as '13' "+
		" FROM publishing INNER JOIN "+
		" (genre INNER JOIN "+
		" (author INNER JOIN "+
		" book ON author.id_author = book.id_author)"+
		" ON genre.id_genre = book.id_genre) "+
		"ON publishing.id_publishing = book.id_publishing WHERE book.id_book =? ");
		List result = query.setInteger(0, id_book).list();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Coments> listComentsByIDbook(int id_book) {	
		Query query =sessionFactory.getCurrentSession().createSQLQuery("Select coments.id_book as '0', coments.id_coment as '1',"+
		" coments.id_user as '2', coments.opinion_coment as '3', coments.date_coment as '4',  user.name_user as '5' "+
		" FROM coments INNER JOIN user ON coments.id_user = user.id_user "+
		" WHERE coments.id_book like ? ORDER BY coments.date_coment DESC  ");
		List <Coments> result = query.setInteger(0, id_book).list();			 
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cart> listCartByIDuser(int id_user) {	
		Query query =sessionFactory.getCurrentSession().createSQLQuery("Select cart.id_cart, cart.id_book, cart.id_user, cart.count_cart, book.name_book, book.price_book, book.count_book  FROM cart INNER JOIN book ON cart.id_book = book.id_book WHERE cart.id_user like ?  ").addEntity(Cart.class);
		List <Cart> result = query.setInteger(0, id_user).list();			 
		return result;
	}
	
	// To Save the likes detail
	public void addComent(Coments coment) {
		sessionFactory.getCurrentSession().save(coment);
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
	
	// To Save the likes detail
	public void addOrder(Orders orders) {
		sessionFactory.getCurrentSession().save(orders);
		
	}

	public List<Cart> cartByID(int id_cart) {	
		Query query =sessionFactory.getCurrentSession().createSQLQuery("Select cart.id_cart, cart.id_book, cart.id_user, cart.count_cart, book.name_book, book.price_book, book.count_book  FROM cart INNER JOIN book ON cart.id_book = book.id_book WHERE cart.id_cart like ?  ").addEntity(Cart.class);
		List <Cart> result = query.setInteger(0, id_cart).list();			 
		return result;
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
	
	public void updataPassword(int id_user, String pass) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("UPDATE user SET pass_user = ? WHERE id_user = ?");
		query.setString(0, pass);
		query.setInteger(1, id_user);
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
	
	public void updataBook(int id_book, String name_book, int price_book, int count_book, int author_book, int genre_book, int publishing_book) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("UPDATE book SET name_book = ?, count_book = ?, price_book = ?, id_genre = ?, id_author = ?, id_publishing = ? WHERE id_book = ?");
		query.setString(0, name_book);
		query.setInteger(1, count_book);
		query.setInteger(2, price_book);
		query.setInteger(3, genre_book);
		query.setInteger(4, author_book);
		query.setInteger(5, publishing_book);
		query.setInteger(6, id_book);
		
		query.executeUpdate();
	}
	
	// To Save the likes detail
	public void addBook(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
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
	
	// To Save the likes detail
		public void updateUsermoney(int id_user, int money) {	
			Query query = sessionFactory.getCurrentSession().createSQLQuery("UPDATE user SET money_user = ? WHERE id_user = ?");
			query.setInteger(0, money);
			query.setInteger(1, id_user);
			query.executeUpdate();
		}
		
	public void updateUserSpendMoney(int id_user, int spend_money) {	
		Query query = sessionFactory.getCurrentSession().createSQLQuery("UPDATE user SET spend_money = ? WHERE id_user = ?");
		query.setInteger(0, spend_money);
		query.setInteger(1, id_user);
		query.executeUpdate();
	}
}
