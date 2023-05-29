package com.cgi.service;

import java.util.List;
import java.util.Optional;

import com.cgi.model.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	public Student createStudent(Student student);
	public Optional<Student> getStudent(int theId);
	public void deleteStudent(int theId);
	public List<Student> findStudentByDate(Student student);
}
