package group.exp.com.dao;

import group.exp.com.model.Book;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zkoss.zhtml.B;


@Repository("serviceBookDao")
public class ServiceBookDaoImpl implements ServiceBookDao {

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
	public List listBookSearch(String search) {		
		Query query =sessionFactory.getCurrentSession().createSQLQuery("SELECT book.id_book as '0', book.name_book as '1',"+
		" book.count_book as '2', book.price_book as '3', book.id_genre as '4', book.id_author as '5', book.new_book as '6',"+
		" book.id_publishing as '7',author.name_author as '8', publishing.name_publishing as '9', genre.name_genre as '10' "+
		" FROM publishing INNER JOIN (genre INNER JOIN (author INNER JOIN book ON author.id_author = book.id_author)"+
		" ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing "+
		" WHERE book.name_book like ? "+
		" ORDER BY book.name_book");
		query.setString(0, '%'+search+'%');
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
	public List<Book> allListBook() {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("Select book.id_book, book.name_book, book.count_book, book.price_book, book.id_genre, book.id_author, book.new_book, book.id_publishing FROM book").addEntity(Book.class);
        List<Book> result = query.list();          
        return result;	
	}

	// To Save the likes detail
	public void addBook(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
	}

	public void deleteBook(int id_book) {
		Book book = (Book) sessionFactory.getCurrentSession().createCriteria(Book.class)
		.add(Restrictions.eq("id_book",id_book))
		.uniqueResult();
		sessionFactory.getCurrentSession().delete(book);
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
	
}
