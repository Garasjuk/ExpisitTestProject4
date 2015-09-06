package group.exp.com.service;

import java.util.List;

import group.exp.com.dao.ServiceAuthorDao;
import group.exp.com.dao.ServiceBookDao;
import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Genre;
import group.exp.com.model.Publishing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ServiceAuthor")
@Transactional
public class ServiceAuthorImpl implements ServiceAuthor{

	@Autowired
	private ServiceAuthorDao serviceAuthorDao;

	public ServiceAuthorImpl() {
	}
	
	public List<Author> allListAuthor() {
		return serviceAuthorDao.allListAuthor();
	}
	
	public void addAuthor(Author author){
		serviceAuthorDao.addAuthor(author);
	}
	
}
