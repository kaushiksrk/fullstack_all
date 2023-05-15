package com.cgi.dao;

import java.util.List;

import com.cgi.model.Orders;

public interface OrdersDAO {

	public Orders createOrder(Orders orders);
	public List<Orders> getAllOrders();
	public Orders findOrderByID(Orders orders);
	public void deleteAllOrders();
	public void deleteOderById(Orders orders);
	public void updateOrderByName(Orders orders);
	public void updateOrderByPrice(Orders orders);
}
