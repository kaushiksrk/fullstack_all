package com.cgi.config;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.cgi.base.Base;
import com.cgi.model.Model;
import com.cgi.model.Student;

@Component
public abstract class SpringAbstract extends Base {

	@SuppressWarnings("unchecked")
	public <T extends Model> T create(Model model) {
		Session session=beginTransaction();
		session.save(model);
		commitTransaction(session);
		return (T) model;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Model> T update(Model model) {
		Session session=beginTransaction();
		session.merge(model);
		commitTransaction(session);
		return (T) model;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Model> T delete(Model model) {
		Session session=beginTransaction();
		session.delete(model);
		commitTransaction(session);
		return (T) model;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Model> T get(Class<T> cls, Model model) {
		Session session=beginTransaction();
		model = session.get(cls, model.getId());
		commitTransaction(session);
		return (T) model;
	}
	
	public List<? extends Model> getAll(Class<? extends Model> cls, String query) {
		Session session=beginTransaction();
		return session.createQuery(query, cls).getResultList();
	}
}