package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Genre;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("serviceGenreDao")
public class ServiceGenreDaoImpl implements ServiceGenreDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Genre> allListGenre() {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("Select id_genre, name_genre  FROM genre").addEntity(Genre.class);
        List<Genre> result = query.list();          
        return result;	
	}
	
	public void addGenre(Genre genre) {
		sessionFactory.getCurrentSession().saveOrUpdate(genre);
	}
	
}
