package com.jsp.hibernate.OneToMany;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company {

	
	@Id
	private int companyId;
	private String companyName;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	

	
	
	
}
