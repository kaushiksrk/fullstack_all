package com.cgi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cgi.config.SpringConfig;
import com.cgi.model.Student;
import com.cgi.service.StudentService;
import com.cgi.service.impl.StudentServiceImpl;

/**
 * Hello world!
 *
 */
public class App  {
	
	static Scanner scanner=new Scanner(System.in);
	
	public static Date getDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    public static void main( String[] args ) {
    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    	StudentService studentService = context.getBean("studentService", StudentServiceImpl.class);
		
		System.out.println("Student Details!");
        
        System.out.println("1. Create Student");
        System.out.println("2. View All Students");
        System.out.println("3. View Student By Id");
        System.out.println("4. View Student By Name");
        System.out.println("5. View Student By Entering Date");
        System.out.println("6. Update Student By Id");
        System.out.println("7. Update Student By Name");
        System.out.println("8. Delete Student By Id");
        System.out.println("9. Delete All Students");
        System.out.println("10. Exit");
        
        System.out.println("Enter any one of the above options.");
        int option=Integer.parseInt(scanner.next());
		
        switch(option) {
	        case 1:
	        	Student createStudent=new Student();
	        	System.out.print("Enter Name: ");
	        	createStudent.setName(scanner.next());
	        	
				System.out.print("Enter Entering Date: ");
				createStudent.setEnteringDate(getDate(scanner.next()));
				
				System.out.print("Enter Nationality: ");
				createStudent.setNationality(scanner.next());
				
				System.out.print("Enter Code: ");
				createStudent.setCode(scanner.next());
				
				studentService.createStudent(createStudent);
				
				System.out.print("Student Created");
				
	        	System.exit(0);
	        case 2:
	        	System.out.println("Below are the Available Students:");
	        	System.out.println(studentService.findAllStudents());
	        case 3:
	        	Student viewStudentById=new Student();
	        	System.out.print("Enter Student Id: ");
	        	viewStudentById.setId(scanner.nextInt());
	        	
	        	System.out.println(studentService.getStudent(viewStudentById));
	        	
	        	System.exit(0);
	        case 4:
	        	Student viewStudentByName=new Student();
	        	System.out.print("Enter Student Name: ");
	        	viewStudentByName.setName(scanner.next());
	        	
	        	System.out.println(studentService.findStudentByName(viewStudentByName));
	        	
	        	System.exit(0);
	        case 5:
	        	Student viewStudentByDate=new Student();
	        	System.out.print("Enter the Date: ");
	        	viewStudentByDate.setEnteringDate(getDate(scanner.next()));
	        	
	        	System.out.println(studentService.findStudentByDate(viewStudentByDate));
	        	
	        	System.exit(0);
	        case 6:
	        	Student updateStudentById=new Student();
	        	System.out.print("Enter Student Id: ");
	        	updateStudentById.setId(scanner.nextInt());
	        	
	        	System.out.print("Enter Name: ");
	        	updateStudentById.setName(scanner.next());
	        	
				System.out.print("Enter Entering Date: ");
				updateStudentById.setEnteringDate(getDate(scanner.next()));
				
				System.out.print("Enter Nationality: ");
				updateStudentById.setNationality(scanner.next());
				
				System.out.print("Enter Code: ");
				updateStudentById.setCode(scanner.next());
	        	
				studentService.updateStudent(updateStudentById);
	        	
	        	System.exit(0);
	        case 7:
	        	Student updateStudentByName=new Student();
	        	System.out.print("Enter Student Name: ");
	        	updateStudentByName.setName(scanner.next());
	        	
	        	System.out.print("Enter Nationality: ");
	        	updateStudentByName.setNationality(scanner.next());
	        	
				System.out.print("Enter Entering Date: ");
	        	updateStudentByName.setEnteringDate(getDate(scanner.next()));
				
				System.out.print("Enter Code: ");
				updateStudentByName.setCode(scanner.next());
				
				studentService.updateStudentByName(updateStudentByName);
				
	        	System.exit(0);
	        case 8:
	        	Student deleteStudentById=new Student();
	        	System.out.print("Enter Student Id: ");
	        	deleteStudentById.setId(scanner.nextInt());
	        	
	        	studentService.deleteStudent(deleteStudentById);
	        	
	        	System.exit(0);
	        case 9:
	        	System.out.print("Are you Sure you want to delete all Students? (Y/N)");
	        	if(scanner.next().equalsIgnoreCase("Y")) {
	        		studentService.deleteAllStudents();
	        	}else {
	        		System.out.println("Exiting");
	        	}

	        	System.exit(0);
	        case 10:
	        	System.exit(0);
        }
    }
}
