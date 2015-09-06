package group.exp.com.service;

import java.util.List;

import group.exp.com.dao.ServiceBookDao;
import group.exp.com.dao.ServiceLikesDao;
import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Genre;
import group.exp.com.model.Likes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ServiceLikes")
@Transactional
public class ServiceLikesImpl implements ServiceLikes{

	@Autowired
	private ServiceLikesDao serviceLikesDao;

	public ServiceLikesImpl() {
	}
	
	public int countLikeByIDBook(int id_book) {
		return serviceLikesDao.countLikeByIDBook(id_book);
	}

	public void addLike(Likes likes) {
		serviceLikesDao.addLike(likes);
	}
	public int listLikeByIdUserBook(int id_book, int id_user) {
		return serviceLikesDao.listLikeByIdUserBook(id_book, id_user);
	}

	public void deleteLikeByIdUserBook(int id_book, int id_user) {
		serviceLikesDao.deleteLikeByIdUserBook(id_book, id_user);
	}

	public List listLike(int id_user){
		return serviceLikesDao.listLike(id_user);
	}
	
}
