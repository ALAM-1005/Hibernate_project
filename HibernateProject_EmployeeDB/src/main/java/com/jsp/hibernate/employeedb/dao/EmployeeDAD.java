package com.jsp.hibernate.employeedb.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate.employeedb.entity.Employee;

public class EmployeeDAD {

	public static Session getSession() {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		return session;

	}

	public static void addEpmloyee() {

		Scanner sc = new Scanner(System.in);

		Employee emp = new Employee();
		emp.setEmpID(101);
		emp.setEmpName("Juned");
		emp.setEmpAge(23);
		emp.setEmpEmail("mdjunedalam220@gmail.com");
		emp.setEmpDesc("Developer");
		emp.setEmpSalary(80000);

		Session session = getSession();
		Transaction tran = session.beginTransaction();
		session.save(emp);

		tran.commit();
		session.close();

	}
}
