package com.cgi.dao;

import java.util.List;

import com.cgi.model.Student;

public interface StudentDao {

	public Student createStudent(Student student);
	public Student getStudent(Student student);
	public Student updateStudent(Student student);
	public Student deleteStudent(Student student);
	public List<Student> findAllStudents();
	public List<Student> findStudentByName(Student student);
	public List<Student> findStudentByDate(Student student);
	public void updateStudentByName(Student student);
	public void deleteAllStudents();
}
