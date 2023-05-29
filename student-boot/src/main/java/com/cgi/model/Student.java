package com.cgi.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "entering_date")
	private Date enteringDate;
	
	@Column(name = "natinality")
	private String nationality;
	
	@Column(name = "code")
	private String code;
	
	public Student() {
		super();
	}
	
	public Student(int id) {
		this.id = id;
	}
	
	public Student(int id, String name, Date enteringDate, String nationality, String code) {
		super();
		this.id = id;
		this.name = name;
		this.enteringDate = enteringDate;
		this.nationality = nationality;
		this.code = code;
	}
	
	public Student(String name, Date enteringDate, String nationality, String code) {
		this.name = name;
		this.enteringDate = enteringDate;
		this.nationality = nationality;
		this.code = code;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEnteringDate() {
		return enteringDate;
	}
	public void setEnteringDate(Date enteringDate) {
		this.enteringDate = enteringDate;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", enteringDate=" + enteringDate + ", nationality="
				+ nationality + ", code=" + code + "]";
	}
}
