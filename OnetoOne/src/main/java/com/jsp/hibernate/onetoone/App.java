package com.jsp.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args ) {

		
//		Person p = new Person();
//		p.setPersonId(101);
//		p.setPersonName("Golu");
//		
//		Aadhar a = new Aadhar();
//		a.setAadharId(1);
//		a.setAadharNo(9876543210l);
		
		// Adding the aadhar obj inside person
		
//		p.setAadhar(a);
		
		
		 // adding the person obj inside Aadhar
//		a.setPerson(p);
		
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Aadhar.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Transaction trac = session.beginTransaction();
		
		Person person = session.get(Person.class, 101);
		System.out.println(person.getPersonId());
		System.out.println(person.getPersonName());
		System.out.println(person.getAadhar().getAadharId());
		System.out.println(person.getAadhar().getAadharNo());

//		session.save(p);
//		session.save(a);
		trac.commit();
		sf.close();
	}
}
