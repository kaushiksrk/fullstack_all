package com.cgi.service;

import java.util.List;

import com.cgi.model.Orders;

public interface OrdersService {
	
	public Orders createOrder(Orders orders);
	public List<Orders> getAllOrders();
	public Orders findOrderByID(Orders orders);
	public Orders findMaxOrderValue();
	public Orders findMinOrderValue();
	public void deleteAllOrders();
	public void deleteOderById(Orders orders);
	public void updateOrderByName(Orders orders);
	public void updateOrderByPrice(Orders orders);
}
