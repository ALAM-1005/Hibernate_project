package com.jsp.hibernate.HibernateProject_Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    
    
    {
    	Epmloyee emp = new Epmloyee();
    	
    	emp.setEmployeeId(10);
    	
    	Configuration cfg = new Configuration();
    	
    	cfg.configure();
    	
    	cfg.addAnnotatedClass(Epmloyee.class);
    	
    	SessionFactory sf  = cfg.buildSessionFactory();
    	
    	Session session = sf.openSession();
    	
    	Transaction tf = session.beginTransaction();
    	
    	session.save(emp);
    	tf.commit();
    	sf.close();
    	session.close();
        
    }
}
