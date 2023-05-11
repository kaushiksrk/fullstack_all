package com.cgi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cgi.model.Department;
import com.cgi.model.Employee;
import com.cgi.model.Location;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Employee employee=context.getBean("employee",Employee.class);
        employee.setEmpId(100);
        employee.setName("John");
        employee.setEmail("john@email.com");
        
        Department department= employee.getDepartment();
        department.setDeptId(200);
        department.setDeptName("Sales");
        
        Location location=employee.getDepartment().getLocation();
        location.setLocationId(200);
        location.setCity("Kolkata");
        location.setCountry("India");
        
        department.setLocation(location);
        
        employee.setDepartment(department);
        
        System.out.println(employee);
    }
}
