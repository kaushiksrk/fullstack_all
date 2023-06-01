package com.cgi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cgi.model.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{

	@Query("SELECT a FROM Student a where enteringDate=date(':enteringDate')")
	public List<Student> findStudentByDate(@Param("enteringDate") String enteringDate);
}
