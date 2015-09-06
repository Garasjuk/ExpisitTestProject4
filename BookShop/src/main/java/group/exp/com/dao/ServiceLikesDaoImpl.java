package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Likes;
import group.exp.com.model.User;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("serviceLikesDao")
public class ServiceLikesDaoImpl implements ServiceLikesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List listLike(int id_user) {
		Query query = sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						"SELECT book.id_book as '0', book.name_book as '1',"
								+ " book.count_book as '2', book.price_book as '3', book.id_genre as '4', book.id_author as '5', book.new_book as '6',"
								+ " book.id_publishing as '7',author.name_author as '8', publishing.name_publishing as '9', genre.name_genre as '10', "
								+ " likes.id_like as '11' "
								+ " FROM publishing INNER JOIN (genre INNER JOIN (author INNER JOIN book ON author.id_author = book.id_author)"
								+ " ON genre.id_genre = book.id_genre) ON publishing.id_publishing = book.id_publishing "
								+ " INNER JOIN likes ON book.id_book = likes.id_book "
								+ " WHERE likes.id_user like ?"
								+ " ORDER BY book.name_book");
		query.setInteger(0, id_user);
		List result = query.list();
		return result;
	}

	

	@SuppressWarnings("unchecked")
	public int countLikeByIDBook(int id_book) {
		return ((Number) sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						"Select count(*) FROM likes WHERE id_book like ? ")
				.setInteger(0, id_book).uniqueResult()).intValue();
	}

	// To Save the likes detail
	public void addLike(Likes likes) {
		sessionFactory.getCurrentSession().saveOrUpdate(likes);
	}

	// To Save the likes detail
	public int listLikeByIdUserBook(int id_book, int id_user) {
		return ((Number) sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						"SELECT count(*) FROM likes WHERE id_book like ? AND id_user like ?")
				.setInteger(0, id_book).setInteger(1, id_user).uniqueResult())
				.intValue();
	}

	// To Save the likes detail
	public void deleteLikeByIdUserBook(int id_book, int id_user) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(
				"DELETE FROM likes WHERE id_book like ? and id_user like ?");
		query.setInteger(0, id_book);
		query.setInteger(1, id_user);
		query.executeUpdate();
	}

}
