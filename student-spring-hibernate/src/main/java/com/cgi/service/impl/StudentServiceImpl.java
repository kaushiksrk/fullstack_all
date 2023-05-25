package com.cgi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgi.dao.StudentDao;
import com.cgi.model.Student;
import com.cgi.service.StudentService;

@Component("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	public Student createStudent(Student student) {
		return studentDao.createStudent(student);
	}
	
	@Override
	public List<Student> findAllStudents() {
	    return studentDao.findAllStudents();
	}
	
	@Override
	public List<Student> findStudentByName(Student student) {
	    return studentDao.findStudentByName(student);  
	}
	
	@Override
	public List<Student> findStudentByDate(Student student) {
	    return studentDao.findStudentByDate(student);    
	}
	
	@Override
	public Student getStudent(Student student) {
		return studentDao.getStudent(student);
	}
	
	@Override
	public Student updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}
	
	@Override
	public Student deleteStudent(Student student) {
		return studentDao.deleteStudent(student);
	}

	@Override
	public void deleteAllStudents() {
		studentDao.deleteAllStudents();
	}
	
	@Override
	public void updateStudentByName(Student student) {
		studentDao.updateStudentByName(student);
	}
}
