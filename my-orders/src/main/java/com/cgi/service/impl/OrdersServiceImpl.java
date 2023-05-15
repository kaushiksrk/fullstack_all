package com.cgi.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.dao.OrdersDAO;
import com.cgi.model.Orders;
import com.cgi.service.OrdersService;

@Component("ordersService")
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDAO ordersDAO;
	
	@Override
	public Orders createOrder(Orders orders) {
		orders.setOrderId(new Random().nextInt());
		return ordersDAO.createOrder(orders);
	}
	
	@Override
	public List<Orders> getAllOrders() {
		return ordersDAO.getAllOrders();
	}
	
	@Override
	public Orders findOrderByID(Orders orders) {
		return ordersDAO.findOrderByID(orders);
	}
	
	@Override
	public Orders findMaxOrderValue() {
		List<Orders> listOrders=ordersDAO.getAllOrders();
		return listOrders.stream().max(Comparator.comparing(Orders::getOrderPrice)).get();
	}
	
	@Override
	public Orders findMinOrderValue() {
		List<Orders> listOrders=ordersDAO.getAllOrders();
		return listOrders.stream().min(Comparator.comparing(Orders::getOrderPrice)).get();
	}

	@Override
	public void deleteAllOrders() {
		ordersDAO.deleteAllOrders();
	}

	@Override
	public void deleteOderById(Orders orders) {
		ordersDAO.deleteOderById(orders);		
	}

	@Override
	public void updateOrderByName(Orders orders) {
		ordersDAO.updateOrderByName(orders);		
	}

	@Override
	public void updateOrderByPrice(Orders orders) {
		ordersDAO.updateOrderByPrice(orders);
	}
}
