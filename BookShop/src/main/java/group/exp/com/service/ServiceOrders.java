package group.exp.com.service;

import group.exp.com.model.Book;
import group.exp.com.model.Orders;

import java.util.List;

public interface ServiceOrders {
	
	public void addOrder(Orders orders);
	public List listOrders();
	public void updataOrder(int id_order, String selectStatus);
	public List ordersByIdUser(int idUser);
	public void updataOrderDate(int id_order, String selectStatus);
	public void updataOrderReturn(int id_order, int returnOrder);
	public List listOrdersFilter(String status_order);
	public List listOrdersFilterNot(String status_order);
	
}
