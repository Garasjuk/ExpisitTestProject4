package group.exp.com.service;

import java.util.List;

import group.exp.com.dao.ServiceBookDao;
import group.exp.com.dao.ServiceUserDao;
import group.exp.com.model.Book;
import group.exp.com.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ServiceUser")
@Transactional
public class ServiceUserImpl implements ServiceUser{

	@Autowired
	private ServiceUserDao serviceUserDao;

	public ServiceUserImpl() {
	}
	
	public User listUser(String name_user, String pass_user) {
		// TODO Auto-generated method stub
		return serviceUserDao.listUser(name_user, pass_user);
	}

	public User listUserByID(int id_user) {
		// TODO Auto-generated method stub
		return serviceUserDao.listUserByID(id_user);
	}
	
	public void addUser(User user) {
		serviceUserDao.addUser(user);
	}

	public void updateUser(User user) {
		serviceUserDao.updateUser(user);
	}

	public List<User> allListUser() {
		return serviceUserDao.allListUser();
	}
	
	public void updateUsermoney(int id_user, int money) {
		serviceUserDao.updateUsermoney(id_user, money);
	}

	public User listProfil(int id_user) {
		return serviceUserDao.listProfil(id_user);
	}
	
	public void updataPassword(int id_user, String pass){
		serviceUserDao.updataPassword(id_user, pass);
	}
	public User listSearchEmail(String email){
		return serviceUserDao.listSearchEmail(email);
	}
	public void updateUserSpendMoney(int id_user, int spend_money){
		serviceUserDao.updateUserSpendMoney(id_user, spend_money);
	}
	
	
}
