package group.exp.com.service;

import java.util.List;

import group.exp.com.dao.ServiceBookDao;
import group.exp.com.dao.ServicePublishingDao;
import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Genre;
import group.exp.com.model.Publishing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ServicePublishing")
@Transactional
public class ServicePublishingImpl implements ServicePublishing{

	@Autowired
	private ServicePublishingDao servicePublishingDao;

	public ServicePublishingImpl() {
	}
	
	public List<Publishing> allListPublishing() {
		return servicePublishingDao.allListPublishing();
	}
	public void addPublishing(Publishing publishing){
		servicePublishingDao.addPublishing(publishing);
	}
	
}
