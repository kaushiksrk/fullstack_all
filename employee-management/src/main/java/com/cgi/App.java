package com.cgi;

import java.sql.SQLException;
import java.util.Scanner;

import com.cgi.dao.EmployeeDAO;
import com.cgi.dao.impl.EmployeeDAOImpl;
import com.cgi.model.Employee;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanner=new Scanner(System.in);
	
    public static void main( String[] args ) {
        EmployeeDAO employeeDAO=new EmployeeDAOImpl();
        
        
        System.out.println("Employee Details!");
        
        System.out.println("1. Create Employee");
        System.out.println("2. View All Emplpoyees");
        System.out.println("3. View Employee By Id");
        System.out.println("4. Update Employee By Id");
        System.out.println("5. Delete Employee By Id");
        System.out.println("6. Delete All Employee");
        System.out.println("7. Exit");
        
        System.out.println("Enter any one of the above options.");
        int option=Integer.parseInt(scanner.next());
        
        switch(option) {
	        case 1:
				try {
					System.out.print("Enter Name: ");
					String name = scanner.next();
					System.out.print("Enter Age: ");
					String age = scanner.next();
					System.out.print("Enter Address 1: ");
					String addr1= scanner.next();
					System.out.print("Enter Address 2: ");
					String addr2= scanner.next();
					System.out.print("Enter Email: ");
					String email = scanner.next();
					System.out.print("Enter Dept Id: ");
					String deptId= scanner.next();
					System.out.print("Enter Salary: ");
					String salary = scanner.next();
					
					Employee employee = employeeDAO.createEmployee(new Employee(name, Integer.parseInt(age), addr1, addr2, email, Integer.parseInt(deptId), Integer.parseInt(salary)));
					
					System.out.println("Created Employee: " + employee);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				System.exit(0);
	        case 2:
	        	System.out.println("\nBelow are the List of Customers!\n");
	        	
				try {
					employeeDAO.getEmployees().stream().forEach(emp -> {
						System.out.println(emp.getEmpId());
						System.out.println(emp.getEmpName());
						System.out.println(emp.getEmpAge());
						System.out.println(emp.getAddr1());
						System.out.println(emp.getAddr2());
						System.out.println(emp.getEmpEmail());
						System.out.println(emp.getDeptId());
						System.out.println(emp.getSalary());
						System.out.println();
					});
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				System.exit(0);
				
	        case 3:
	        	System.out.println("\nEnter the Employee Id:\n");
	        	int empId=Integer.parseInt(scanner.next());
	        	Employee employee=new Employee(empId);
	        	
				try {
					employee = employeeDAO.getEmployeeById(employee);
					
					System.out.println("Employee Detail: " + employee);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				System.exit(0);
	        case 4:
	        	System.out.println("\nEnter the Employee Id to update:\n");
	        	int updateEmpId=Integer.parseInt(scanner.next());
	        	
	        	System.out.print("Enter Name: ");
				String name = scanner.next();
				System.out.print("Enter Age: ");
				String age = scanner.next();
				System.out.print("Enter Address 1: ");
				String addr1= scanner.next();
				System.out.print("Enter Address 2: ");
				String addr2= scanner.next();
				System.out.print("Enter Email: ");
				String email = scanner.next();
				System.out.print("Enter Dept Id: ");
				String deptId= scanner.next();
				System.out.print("Enter Salary: ");
				String salary = scanner.next();
	        	
	        	Employee updateEmployee=new Employee(updateEmpId, name, Integer.parseInt(age), addr1, addr2, email, Integer.parseInt(deptId), Integer.parseInt(salary));
	        	
	        	try {
	        		updateEmployee = employeeDAO.updateEmployee(updateEmployee);
	        		
	        		System.out.println("Updated Employee Detail: " + updateEmployee);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        	
	        	System.exit(0);
	        case 5:
	        	System.out.println("\nEnter the Employee Id to Delete:\n");
	        	
	        	int deleteEmpId=Integer.parseInt(scanner.next());
	        	Employee deleteEmployee=new Employee(deleteEmpId);
	        	
	        	try {
	        		employeeDAO.deleteEmployee(deleteEmployee);
	        		System.out.println("Record Deleted with the Id: " + deleteEmpId);
	        		
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        	
	        	System.exit(0);
	        case 6:
	        	System.out.println("\nAll the employee Details will be deleted. Are you sure?\n");
	        	if(scanner.next().equalsIgnoreCase("y")) {
	        		try {
						employeeDAO.deleteAllCustomers();
						
						System.out.println("All Records Deleted!");
					} catch (SQLException e) {
						e.printStackTrace();
					}
	        	}
	        	
	        	System.exit(0);
	        case 7:
	        	System.out.println("Program Exited!");
	        	System.exit(0);
        }
    }
}
