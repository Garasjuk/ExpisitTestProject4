package group.exp.com.service;

import java.util.List;

import group.exp.com.dao.ServiceBookDao;
import group.exp.com.dao.ServiceGenreDao;
import group.exp.com.model.Book;
import group.exp.com.model.Genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ServiceGenre")
@Transactional
public class ServiceGenreImpl implements ServiceGenre{

	@Autowired
	private ServiceGenreDao serviceGenreDao;

	public ServiceGenreImpl() {
	}
	
	public List<Genre> allListGenre() {
		return serviceGenreDao.allListGenre();

	}
	
	public void addGenre(Genre genre){
		serviceGenreDao.addGenre(genre);
	}
}
