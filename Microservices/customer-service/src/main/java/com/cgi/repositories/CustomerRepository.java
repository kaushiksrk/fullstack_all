package com.cgi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}


