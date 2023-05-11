package com.cgi;

public class Person {

	private String name;
	private String age;
	private String mobile;
	
	Address address;
	
	public Person(Address address) {
		this.address=address;
	}
	
	public Person(String name, String age, String mobile) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", mobile=" + mobile + "]";
	}
}
