package group.exp.com.service;

import java.util.List;

import group.exp.com.dao.ServiceBookDao;
import group.exp.com.dao.ServiceOrdersDao;
import group.exp.com.model.Book;
import group.exp.com.model.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ServiceOrders")
@Transactional
public class ServiceOrdersImpl implements ServiceOrders{

	@Autowired
	private ServiceOrdersDao serviceOrdersDao;

	public ServiceOrdersImpl() {
	}
	
	public void addOrder(Orders orders) {
		serviceOrdersDao.addOrder(orders);
	}
	
	public List listOrders() {
		return serviceOrdersDao.listOrders();
	}
	
	public void updataOrder(int id_order, String selectStatus) {
		serviceOrdersDao.updataOrder(id_order, selectStatus);
	}

	public List ordersByIdUser(int idUser) {
		return serviceOrdersDao.ordersByIdUser(idUser);
	}
	
	public void updataOrderDate(int id_order, String selectStatus) {
		serviceOrdersDao.updataOrderDate(id_order, selectStatus);
	}

	public void updataOrderReturn(int id_order, int returnOrder) {
		serviceOrdersDao.updataOrderReturn(id_order, returnOrder);
	}
	
	public List listOrdersFilter(String status_order){
		return serviceOrdersDao.listOrdersFilter(status_order);
	}
	
	public List listOrdersFilterNot(String status_order){
		return serviceOrdersDao.listOrdersFilterNot(status_order);
	}
		
	
}
