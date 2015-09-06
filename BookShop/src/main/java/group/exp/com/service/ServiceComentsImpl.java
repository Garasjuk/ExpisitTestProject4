package group.exp.com.service;

import group.exp.com.dao.ServiceComentsDao;
import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Cart;
import group.exp.com.model.Coments;
import group.exp.com.model.Genre;
import group.exp.com.model.Likes;
import group.exp.com.model.Orders;
import group.exp.com.model.Publishing;
import group.exp.com.model.User;

import java.util.List;

import org.apache.bcel.generic.RETURN;
import org.apache.regexp.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("ServiceComents")
@Transactional
public class ServiceComentsImpl implements ServiceComents {

	@Autowired
	private ServiceComentsDao serviceComentsDao;

	public ServiceComentsImpl() {
	}

	public List<Coments> listComentsByIDbook(int id_book) {
		// TODO Auto-generated method stub
		return serviceComentsDao.listComentsByIDbook(id_book);
	}

	public void addComent(Coments coment) {
		serviceComentsDao.addComent(coment);
	}
	
}
