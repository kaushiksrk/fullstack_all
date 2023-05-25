package com.cgi.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class Base {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session beginTransaction() {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		return session;
	}
	
	public void commitTransaction(Session session) {
		session.getTransaction().commit();
	}
}
