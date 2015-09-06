package group.exp.com.service;

import java.util.List;

import group.exp.com.dao.ServiceBookDao;
import group.exp.com.dao.ServiceCartDao;
import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.Cart;
import group.exp.com.model.Genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ServiceCart")
@Transactional
public class ServiceCartImpl implements ServiceCart{

	@Autowired
	private ServiceCartDao serviceCartDao;

	public ServiceCartImpl() {
	}
	
	public void addCart(int id_book, int id_user, int count_cart) {
		serviceCartDao.addCart(id_book, id_user, count_cart);
	}

	public List<Cart> listCartByIDuser(int id_user) {
		return serviceCartDao.listCartByIDuser(id_user);
	}

	public void deleteFromCart(int id_cart) {
		serviceCartDao.deleteFromCart(id_cart);
	}

	public List<Cart> cartByID(int id_cart) {
		return serviceCartDao.cartByID(id_cart);
	}
	
}
