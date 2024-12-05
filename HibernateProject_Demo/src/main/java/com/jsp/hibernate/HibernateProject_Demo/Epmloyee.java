package com.jsp.hibernate.HibernateProject_Demo;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Epmloyee {

	@Id
	private  int employeeId;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
}
