package com.jsp.hibernate.emplyeedb.entity;

@Entity
public class Employee {
	
	@Id
	private int employeeId;
	private String name;
	private String email;
	private int age;
	private String desc;
	private int salary;


}
