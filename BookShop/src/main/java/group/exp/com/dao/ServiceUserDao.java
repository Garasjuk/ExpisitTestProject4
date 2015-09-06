package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.User;

import java.util.List;

public interface ServiceUserDao {
	
	
	public User listUser(String name_iser, String pass_user);
	public void addUser (User user);
	public List<User> allListUser ();
	public User listUserByID(int id_user);
	public void updateUser(User user);
	public void updateUsermoney(int id_user, int money);
	public User listProfil(int id_user);
	
	public void updataPassword(int id_user, String pass);
	public User listSearchEmail(String email);
	public void updateUserSpendMoney(int id_user, int spend_money);
	
}
