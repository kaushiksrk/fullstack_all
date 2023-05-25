package com.cgi.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.config.SpringAbstract;
import com.cgi.dao.StudentDao;
import com.cgi.model.Student;

@Component("studentDao")
public class StudentDaoImpl extends SpringAbstract implements StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public static String getDBDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		return formatter.format(date);
	}

	@Override
	public Student createStudent(Student student) {
		return create(student);
	}
	
	@Override
	public List<Student> findAllStudents() {
	    return (List<Student>) getAll(Student.class, "SELECT a FROM Student a");      
	}
	
	@Override
	public List<Student> findStudentByName(Student student) {
	    return (List<Student>) getAll(Student.class, "SELECT a FROM Student a where name='"+student.getName()+"'");      
	}
	
	@Override
	public List<Student> findStudentByDate(Student student) {
	    return (List<Student>) getAll(Student.class, "SELECT a FROM Student a where enteringDate=date('"+getDBDate(student.getEnteringDate())+"')");      
	}
	
	@Override
	public Student getStudent(Student student) {
		return get(Student.class, student);
	}
	
	@Override
	public Student updateStudent(Student student) {
		return update(student);
	}
	
	@Override
	public Student deleteStudent(Student student) {
		return delete(student);
	}

	@Override
	public void deleteAllStudents() {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("delete from Student");
		int result=query.executeUpdate();
		
		System.out.println("Rows Affected: " + result);
		session.getTransaction().commit();
	}
	
	@Override
	public void updateStudentByName(Student student) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("UPDATE Student SET nationality=:nationality, enteringDate=:enteringDate, code=:code where name=:name");
		
		query.setParameter("name", student.getName());
		query.setParameter("nationality", student.getNationality());
		query.setParameter("enteringDate", student.getEnteringDate());
		query.setParameter("code", student.getCode());
		
		int result=query.executeUpdate();
		
		System.out.println("Rows Affected: " + result);
		
		session.getTransaction().commit();
	}
}
