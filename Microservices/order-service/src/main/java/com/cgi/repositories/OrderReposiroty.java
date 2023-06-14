package com.cgi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.model.Order;

public interface OrderReposiroty extends JpaRepository<Order, Integer>{

}
