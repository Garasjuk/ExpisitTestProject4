package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Publishing;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("servicePublishingDao")
public class ServicePublishingDaoImpl implements ServicePublishingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Publishing> allListPublishing() {	
		Query query =  sessionFactory.getCurrentSession().createSQLQuery("Select id_publishing, name_publishing FROM publishing").addEntity(Publishing.class);
        List<Publishing> result = query.list();          
        return result;	
	}
	
	public void addPublishing(Publishing publishing) {
		sessionFactory.getCurrentSession().saveOrUpdate(publishing);
	}
	
}
