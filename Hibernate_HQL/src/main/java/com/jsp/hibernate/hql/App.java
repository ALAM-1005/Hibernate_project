package com.jsp.hibernate.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
// select all from the 	product table	
//		Query<Product> query = session.createQuery("FROM Product");
//		List<Product> products = query.list();
//		
//		for (Product product : products) {
//			
//			System.out.println(product);
//		}

		
		// update  the all from product
		//Query<Product> query = session.createQuery("UPDATE Product p set p.productPrice =10000 WHERE p.productId = 101");
		
//		Query<Product> query = session.createQuery("UPDATE Product p set p.productPrice =?1 WHERE p.productId BETWEEN :firstId AND :lastId");
//		query.setParameter(1, 25000);
//		query.setParameter("firstId", 102);
//		query.setParameter("lastId",103 );
//		int rowsUpdate = query.executeUpdate();
//		if (rowsUpdate > 0) {
//
//			System.out.println(rowsUpdate + "data Updated !!");
//
//		} else {
//
//			System.out.println("data not upadated");
//		}
		
		// deleted from the product table 
		Query<Product> query = session.createQuery("DELETE FROM Product p  WHERE p.productId = ?2");
		query.setParameter(2,102);
		int rowsDelete = query.executeUpdate();
		if (rowsDelete> 0) {
			
			System.out.println(rowsDelete + "data Deleted !!");
			
		} else {
			
			System.out.println("data not Deleted");
		}

		tran.commit();
		session.close();
		sf.close();
	}
}
