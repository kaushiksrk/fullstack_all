package com.cgi.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.model.Student;
import com.cgi.service.StudentService;
import com.cgi.to.ErrorTO;
import com.cgi.to.StudentTO;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorTO> handleException(Exception e) {
		ErrorTO errorTO=new ErrorTO(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis(), LocalDate.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorTO);
	}
	
	@GetMapping("/all-students") // http://localhost:9090/student/all-students
	public ResponseEntity<Collection<StudentTO>> listStudents() {
		List<StudentTO> studentsList=new ArrayList<>();

		studentService.getAllStudents().stream().forEach(student -> {
			studentsList.add(modelMapper.map(student, StudentTO.class));
		});
		
		return ResponseEntity.ok().body(studentsList);
	}
	
	@PostMapping("/create-student") // http://localhost:9090/student/create-student
	public ResponseEntity<Student> createStudent(@RequestBody StudentTO studentTo) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Student student=modelMapper.map(studentTo, Student.class);
		System.out.println(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
	}
	
	@GetMapping("/{studentId}") // http://localhost:9090/student/6
	public ResponseEntity<?> getStudentById(@PathVariable("studentId") Integer studentId) {
		Optional<Student> student = studentService.getStudent(studentId);
		System.out.println(student);

		if (student.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id: " + studentId + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(student);
		}
	}
	
	@PutMapping("/update-student")
	public ResponseEntity<?> updateStudentById(@RequestBody StudentTO studentTo) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Student student=modelMapper.map(studentTo, Student.class);
		System.out.println(student);
		return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudentByID(student));
	}
	
	@DeleteMapping("/delete-student/{studentId}")
	public ResponseEntity<?> deleteStudentById(@PathVariable("studentId") Integer studentId) {
		studentService.deleteStudent(studentId);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
	}
	
	@DeleteMapping("/delete-students")
	public ResponseEntity<?> deleteAllStudents() {
		studentService.deleteAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body("All Students Deleted Successfully");
	}
}
