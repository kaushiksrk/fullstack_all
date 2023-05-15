package com.cgi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.dao.OrdersDAO;
import com.cgi.model.Orders;

@Component
public class OrderDAOImpl implements OrdersDAO {

	@Autowired
	private DataSource dataSource;
	
	@Override
	public Orders createOrder(Orders orders) {
		try {
			Connection connection=dataSource.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("insert into orders values(?,?,?)");
			
			preparedStatement.setInt(1, orders.getOrderId());
			preparedStatement.setString(2, orders.getOrderName());
			preparedStatement.setDouble(3, orders.getOrderPrice());
		
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orders;
	}
	
	@Override
	public List<Orders> getAllOrders() {
		List<Orders> list=new ArrayList<Orders>();
		
		try {
			Connection connection=dataSource.getConnection();
			
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from orders");
			while(resultSet.next()) {
				Orders orders=new Orders();
				
				orders.setOrderId(resultSet.getInt("orderId"));
				orders.setOrderName(resultSet.getString("order_name"));
				orders.setOrderPrice(resultSet.getDouble("order_price"));
				
				list.add(orders);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Orders findOrderByID(Orders orders) {
		try {
			Connection connection = dataSource.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select orderId, order_name, order_price from orders where orderId=?");
			
			preparedStatement.setInt(1, orders.getOrderId());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				orders.setOrderId(resultSet.getInt("orderId"));
				orders.setOrderName(resultSet.getString("order_name"));
				orders.setOrderPrice(resultSet.getDouble("order_price"));
				
				return orders;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void deleteAllOrders() {
		
		Connection connection;
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("truncate table orders");
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteOderById(Orders orders) {
		Connection connection;

		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from orders where orderId=?");
			
			preparedStatement.setInt(1, orders.getOrderId());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateOrderByName(Orders orders) {
		Connection connection;
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("update orders set order_name=? where orderId=?");
			
			preparedStatement.setString(1, orders.getOrderName());
			preparedStatement.setInt(2, orders.getOrderId());
		
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateOrderByPrice(Orders orders) {
		Connection connection;
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("update orders set order_price=? where orderId=?");
			
			preparedStatement.setDouble(1, orders.getOrderPrice());
			preparedStatement.setInt(2, orders.getOrderId());
		
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
