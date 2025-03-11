package com.jsp.hibernate.sql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.jsp.hibernate.hql.Product;

public class App {

	public static void main(String[] args) {


		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();


// select all the from product
		//		NativeQuery<Product> nativeQuery = session.createNativeQuery("SELECT * FROM product  WHERE  productId = :id",Product.class);
		//
		//		nativeQuery.setParameter("id",103);
		//
		//		List<Product> products = nativeQuery.list();
		//
		//		for (Product product : products) {
		//			System.out.println(product);
		//		}

		
		// update all from the product
//		NativeQuery<Product> nativeQuery = session.createNativeQuery("UPDATE  product SET productName ='HP' WHERE  productId = :id",Product.class);
//
//		nativeQuery.setParameter("id",103);
//
//		int productsUpdate = nativeQuery.executeUpdate();
//
//		if(productsUpdate>0) {
//			
//			System.out.println(productsUpdate+"Product is Updated");
//		}else {
//			
//			System.out.println("Product is not Updated");
//		}
		
		
		NativeQuery<Product> nativeQuery = session.createNativeQuery("DELETE FROM  product  WHERE  productId = :id",Product.class);
		
		nativeQuery.setParameter("id",103);
		
		int productsUpdate = nativeQuery.executeUpdate();
		
		if(productsUpdate>0) {
			
			System.out.println(productsUpdate+"Product is Deleted");
		}else {
			
			System.out.println("Product is not Deleted");
		}

		tran.commit();
		session.close();
		sf.close();
	}




}
