package group.exp.com.service;

import group.exp.com.dao.ServiceDao;
import group.exp.com.model.Book;
import group.exp.com.model.Coments;
import group.exp.com.model.Likes;
import group.exp.com.model.User;

import java.util.List;

import org.apache.bcel.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("ServiceManager")
@Transactional
public class ServiceManagerImpl implements ServiceManager {

	@Autowired
	private ServiceDao serviceDao;

	public ServiceManagerImpl() {
	}

	public List<Book> listBook() {
		// TODO Auto-generated method stub
		System.out.println("Point 2");
		return serviceDao.listBook();
	}

	public List<Book> listBookByID(int id_book) {
		// TODO Auto-generated method stub
		return serviceDao.listBookByID(id_book);
	}

	public User listUser(String name_user, String pass_user) {
		// TODO Auto-generated method stub
		return serviceDao.listUser(name_user, pass_user);
	}
	
	public User listUserByID(int id_user) {
		// TODO Auto-generated method stub
		return serviceDao.listUserByID(id_user);
	}
	

	public List<Coments> listComentsByIDbook(int id_book) {
		// TODO Auto-generated method stub
		return serviceDao.listComentsByIDbook(id_book);
	}

	public int countLikeByIDBook(int id_book) {
		return serviceDao.countLikeByIDBook(id_book);
	}

	public void addLike(Likes likes) {
		serviceDao.addLike(likes);
	}

	public void addUser(User user) {
		serviceDao.addUser(user);
	}
	
	public void updateUser(User user){
		serviceDao.updateUser(user);
	}
	
	public List<User> allListUser (){
		return serviceDao.allListUser();
	}
}
