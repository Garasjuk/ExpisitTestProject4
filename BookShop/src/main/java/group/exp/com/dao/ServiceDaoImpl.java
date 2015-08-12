package group.exp.com.dao;

import group.exp.com.model.Book;
import group.exp.com.model.Cart;
import group.exp.com.model.Coments;
import group.exp.com.model.Likes;
import group.exp.com.model.User;
import group.exp.com.utility.BaseUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("serviceDao")
public class ServiceDaoImpl implements ServiceDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
		
	@SuppressWarnings("unchecked")
	public List<Book> listBook() {	
		List <Book> book = new ArrayList<Book>();
		System.out.println("Point 3");
				
	//	Query query = sessionFactory.getCurrentSession().createSQLQuery("Select id_book, name_book, count_book, price_book, id_genre, id_author, new_book, id_publishing from book ").addEntity(Book.class);
		
		Query query =sessionFactory.getCurrentSession().createSQLQuery("Select book.id_book, book.name_book, book.count_book, book.price_book, book.id_genre, book.id_author, book.new_book, book.id_publishing,author.name_author, publishing.name_publishing, genre.name_genre from publishing INNER JOIN (genre INNER JOIN (author INNER JOIN book ON author.id_author = book.id_author) ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing").addEntity(Book.class);
		
	//	book = query.list();
//		book.set(, arg1)
		
		List<Book> result = query.list();
		
	//	book = sessionFactory.getCurrentSession().createCriteria(Book.class).list();
	//	return (List<Book>) sessionFactory.getCurrentSession().createSQLQuery("Select book.id_book, book.name_book, book.count_book, book.price_book, book.id_genre, book.id_author, book.new_book, book.id_publishing, author.name_author, publishing.name_publishing, genre.name_genre from publishing INNER JOIN (genre INNER JOIN (author INNER JOIN book ON author.id_author = book.id_author) ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing").list(); 
		return result;
	}

	/*
	public List<Book> listBook() {
		List<Book> books = new ArrayList<Book>();
		System.out.println("Point 3");
		try {
			//PreparedStatement preparedStatement = connection.prepareStatement("select groups.id_group, groups.name_group from groups INNER JOIN unionz ON groups.id_group = unionz.id_group WHERE unionz.id_user = ?");
			PreparedStatement preparedStatement = connection.prepareStatement("select id_book, name_book, count_book, price_book, id_ganre, id_author, new_book, id_publishing from book");
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				System.out.println("Point 4");
				Book book = new Book();
				book.setId_book(rs.getInt("id_book"));	
				book.setName_book(rs.getString("name_book"));
				book.setCount_book(rs.getInt("count_book"));
				book.setPrice_book(rs.getInt("price_book"));
				book.setId_genre(rs.getInt("id_ganre"));
				book.setId_author(rs.getInt("id_author"));
				book.setNew_book(rs.getInt("new_book"));
				book.setId_publishing(rs.getInt("id_publishing"));
				books.add(book);
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	*/
	
	@SuppressWarnings("unchecked")
	public User listUser(String name_user, String pass_user) {	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
                   .add(Restrictions.eq("name_user", name_user))
                   .add(Restrictions.eq("pass_user", pass_user));
         return (User) criteria.uniqueResult();
        		 
	/*	System.out.println("name_user "+ name_user);
		
		Query query =sessionFactory.getCurrentSession().createSQLQuery("SELECT user.id_user, user.name_user, user.money_user, user.adres_user, user.pass_user, user.identif FROM user WHERE user.name_user like ?  ").addEntity(User.class);
		query.setString(0, name_user);
	//	query.setString(1, pass_user);
		
		List<User> result = query.list();
		
		return result;
		*/
	}
	
	@SuppressWarnings("unchecked")
	public User listUserByID(int id_user) {	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
                   .add(Restrictions.eq("id_user", id_user));
         return (User) criteria.uniqueResult();
	}
	
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> allListUser() {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("Select * FROM user").addEntity(User.class);
        List<User> user = query.list();          
        return user;	
	}
	
	@SuppressWarnings("unchecked")
	public int countLikeByIDBook(int id_book) {	
		
		return ((Number) sessionFactory.getCurrentSession().createSQLQuery("Select count(*) FROM likes WHERE id_book like ? ")
		.setInteger(0, id_book)
		.uniqueResult()).intValue();
		/*
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Like.class)
				 .add(Restrictions.eq("id_book", id_book));
				criteria.setProjection(Projections.rowCount());
				               
				               
        int result =  (Integer)criteria.uniqueResult();       
		
			*/		 
		
	}
	
	
	// To Save the likes detail
	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
		
	
	// To Save the likes detail
	public void addLike(Likes likes) {
		//book.setStatus_book("Создано");
		//	book.setUuid_book(UUID.randomUUID().toString());
			sessionFactory.getCurrentSession().saveOrUpdate(likes);
		}
		
	@SuppressWarnings("unchecked")
	public List<Book> listBookByID(int id_book) {		
		Query query =sessionFactory.getCurrentSession().createSQLQuery("Select book.id_book, book.name_book, book.count_book, book.price_book, book.id_genre, book.id_author, book.new_book, book.id_publishing,author.name_author, publishing.name_publishing, genre.name_genre from publishing INNER JOIN (genre INNER JOIN (author INNER JOIN book ON author.id_author = book.id_author) ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing WHERE book.id_book =? ").addEntity(Book.class);
		List<Book> result = query.setInteger(0, id_book).list();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Coments> listComentsByIDbook(int id_book) {	
		Query query =sessionFactory.getCurrentSession().createSQLQuery("Select coments.id_book, coments.id_coment, coments.id_user, coments.opinion_coment, coments.date_coment,  user.name_user  FROM coments INNER JOIN user ON coments.id_user = user.id_user WHERE coments.id_book like ? ORDER BY coments.date_coment DESC  ").addEntity(Coments.class);
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
}
