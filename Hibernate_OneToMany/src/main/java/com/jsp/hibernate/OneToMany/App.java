package com.jsp.hibernate.OneToMany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

class App 
{
	public static void main( String[] args )
	{

		Company company = new Company();
		company.setCompanyId(1);
		company.setCompanyName("Accenture");

		Employee emp1 = new Employee();
		emp1.setEmpId(101);
		emp1.setEmpName("sonu");
		emp1.setEmpSalary(800000);

		Employee emp2 = new Employee();
		emp2.setEmpId(102);
		emp2.setEmpName("Monu");
		emp2.setEmpSalary(500000);


		// adding the employee object into company
		//		List<Employee> elist = new ArrayList<Employee>();
		//		elist.add(emp1);
		//		elist.add(emp2);
		//
		//		company.setEmployees(elist);

		// adding the company object into employee
		//		
		emp1.setCompany(company);
		emp2.setCompany(company);

		Configuration cfg  =new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Company.class);
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction  trac = session.beginTransaction();

		session.save(company);
		session.save(emp1);
		session.save(emp2);

		trac.commit();
		session.close();
		sf.close();



	}
}
