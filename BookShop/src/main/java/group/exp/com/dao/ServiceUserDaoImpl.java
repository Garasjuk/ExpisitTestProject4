package group.exp.com.dao;

import group.exp.com.model.Author;
import group.exp.com.model.Book;
import group.exp.com.model.User;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("serviceUserDao")
public class ServiceUserDaoImpl implements ServiceUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User listProfil(int id_user) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("id_user", id_user));
		return (User) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public User listUser(String name_user, String pass_user) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("name_user", name_user))
				.add(Restrictions.eq("pass_user", pass_user));
		return (User) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public User listUserByID(int id_user) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("id_user", id_user));
		return (User) criteria.uniqueResult();
	}

	public User listSearchEmail(String email) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("email", email));
		return (User) criteria.uniqueResult();
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	// To Save the likes detail
	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	public void updataPassword(int id_user, String pass) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(
				"UPDATE user SET pass_user = ? WHERE id_user = ?");
		query.setString(0, pass);
		query.setInteger(1, id_user);
		query.executeUpdate();
	}

	// To Save the likes detail
	public void updateUsermoney(int id_user, int money) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(
				"UPDATE user SET money_user = ? WHERE id_user = ?");
		query.setInteger(0, money);
		query.setInteger(1, id_user);
		query.executeUpdate();
	}

	public void updateUserSpendMoney(int id_user, int spend_money) {
		Query query = sessionFactory.getCurrentSession().createSQLQuery(
				"UPDATE user SET spend_money = ? WHERE id_user = ?");
		query.setInteger(0, spend_money);
		query.setInteger(1, id_user);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> allListUser() {
		Query query = sessionFactory
				.getCurrentSession()
				.createSQLQuery(
						"Select id_user, name_user, money_user, adres_user, pass_user, identif, email, spend_money FROM user ORDER BY name_user")
				.addEntity(User.class);
		List<User> user = query.list();
		return user;
	}

}
