package com.jsp.hibernate.Hibernate_Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args) {

		Product p = new Product();
		p.setProductId(101);
		p.setProductName("coffee");
		p.setProductBrand("nestle");
		p.setProductPrice(1200);

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();

		// session 1

		Session session1 = sf.openSession();
		Transaction tran1 = session1.beginTransaction();

		Product product1 = session1.get(Product.class, 101);
		System.out.println(product1);

		Product product2 = session1.get(Product.class, 101);
		System.out.println(product2);

		session1.save(product1);
		session1.save(product2);
		tran1.commit();
		session1.close();

		System.out.println();

		// session 2
		Session session2 = sf.openSession();
		Transaction tran2 = session2.beginTransaction();

		Product product3 = session2.get(Product.class, 101);
		System.out.println(product3);

		Product product4 = session2.get(Product.class, 101);
		System.out.println(product4);

		session2.save(product3);
		session2.save(product4);
		tran2.commit();
		session2.close();
	}
}
