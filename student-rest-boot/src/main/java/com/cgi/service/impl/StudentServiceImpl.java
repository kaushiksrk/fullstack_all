package com.cgi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.dao.StudentDAO;
import com.cgi.model.Student;
import com.cgi.service.StudentService;
import com.cgi.utils.DateUtils;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDao;
	
	
	
	@Override
	public List<Student> getAllStudents() {
		return studentDao.findAll() ;
	}
	
	@Override
	public Student createStudent(Student student) {
		return studentDao.save(student);
	}

	@Override
	public Optional<Student> getStudent(int theId) {
		Optional<Student> student= studentDao.findById(theId);
		return student;
	}
	
	@Override
	public Student updateStudentByID(Student student) {
		return studentDao.save(student);
	}

	@Override
	public void deleteStudent(int theId) {
		studentDao.deleteById(theId);
	}
	
	@Override
	public List<Student> findStudentByDate(Student student) {
		return studentDao.findStudentByDate(DateUtils.getDBDate(student.getEnteringDate()));
	}
	
	@Override
	public void deleteAllStudents() {
		studentDao.deleteAll();
	}
}
