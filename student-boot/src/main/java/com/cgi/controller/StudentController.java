package com.cgi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cgi.model.Student;
import com.cgi.service.StudentService;
import com.cgi.utils.DateUtils;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public String listStudents(Model theModel) {
		List<Student> thestudents = studentService.getAllStudents();
		theModel.addAttribute("students", thestudents);
		return "list-students";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Student thestudent = new Student();
		theModel.addAttribute("student", thestudent);
		return "student-form";
	}

	@PostMapping("/saveCustomer")
	public String saveStudent(@ModelAttribute("student") Student thestudent) {
		studentService.createStudent(thestudent);
		return "redirect:/";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
	Optional<Student> thestudent = studentService.getStudent(theId);
		theModel.addAttribute("student", thestudent);
		return "student-form";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		studentService.deleteStudent(theId);
		return "redirect:/";
	}
	
	@GetMapping("/searchForm")
	public String searchForm(Model theModel) {
		return "search";
	}
	
	@GetMapping("/search")
	public String getStudentByDate(@RequestParam("enteringDate") String enteringDate, Model theModel) {
		Student student=new Student();
		student.setEnteringDate(DateUtils.getDate(enteringDate));
		List<Student> thestudents = studentService.findStudentByDate(student);
		theModel.addAttribute("students", thestudents);
		return "list-students";
	}
}
