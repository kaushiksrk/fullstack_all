package com.cgi.model;

public class Employee {

	private int empId;
	private String empName;
	private int empAge;
	private String addr1;
	private String addr2;
	private String empEmail;
	private int deptId;
	private int salary;
	
	public Employee(int empId, String empName, int empAge, String addr1, String addr2, String empEmail, int deptId,
			int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.empEmail = empEmail;
		this.deptId = deptId;
		this.salary = salary;
	}
	
	public Employee(int empId) {
		this.empId=empId;
	}
	
	public Employee(String empName, int empAge, String addr1, String addr2, String empEmail, int deptId,
			int salary) {
		super();
		this.empName = empName;
		this.empAge = empAge;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.empEmail = empEmail;
		this.deptId = deptId;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", empEmail=" + empEmail + ", deptId=" + deptId + ", salary=" + salary + "]";
	}
}
