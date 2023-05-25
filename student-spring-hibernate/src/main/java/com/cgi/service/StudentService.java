package com.cgi.service;

import java.util.List;

import com.cgi.model.Student;

public interface StudentService {
	public Student createStudent(Student student);
	public List<Student> findAllStudents();
	public List<Student> findStudentByName(Student student);
	public List<Student> findStudentByDate(Student student);
	public Student getStudent(Student student);
	public Student updateStudent(Student student);
	public Student deleteStudent(Student student);
	public void deleteAllStudents();
	public void updateStudentByName(Student student);
}
