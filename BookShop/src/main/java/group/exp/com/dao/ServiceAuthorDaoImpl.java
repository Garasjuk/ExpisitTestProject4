package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("serviceAuthorDao")
public class ServiceAuthorDaoImpl implements ServiceAuthorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Author> allListAuthor() {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("Select id_author, name_author FROM author").addEntity(Author.class);
        List<Author> result = query.list();          
        return result;	
	}
	
	public void addAuthor(Author author) {
		sessionFactory.getCurrentSession().saveOrUpdate(author);
	}
	
}
