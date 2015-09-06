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


@Repository("serviceComentsDao")
public class ServiceComentsDaoImpl implements ServiceComentsDao {

	
	@Autowired
	private SessionFactory sessionFactory;
		
	@SuppressWarnings("unchecked")
	public List<Coments> listComentsByIDbook(int id_book) {	
		Query query =sessionFactory.getCurrentSession().createSQLQuery("Select coments.id_book as '0', coments.id_coment as '1',"+
		" coments.id_user as '2', coments.opinion_coment as '3', coments.date_coment as '4',  user.name_user as '5' "+
		" FROM coments INNER JOIN user ON coments.id_user = user.id_user "+
		" WHERE coments.id_book like ? ORDER BY coments.date_coment DESC  ");
		List <Coments> result = query.setInteger(0, id_book).list();			 
		return result;
	}
	
	// To Save the likes detail
	public void addComent(Coments coment) {
		sessionFactory.getCurrentSession().save(coment);
	}
	
}
