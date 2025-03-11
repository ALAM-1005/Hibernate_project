package com.jsp.hibernate.criteriabuilder;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate.hql.Product;

public class CriteriaBuilder_App {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
																																																																																																																																										
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		// create logic using criteriaBuilder
//		CriteriaQuery<String> cq = cb.createQuery(String.class);
//		
//		Root<Product> root = cq.from(Product.class);
//		//cq.from(Product.class);
//		//cq.select(root);
//		//cq.where(cb.equal(root.get("productId"), 101));
//		//cq.where(cb.gt(root.get("productId"), 101));
//		//cq.where(cb.between(root.get("productId"), 101,103));
//		
//		cq.select(root.get("productBrand"));
//		cq.where(cb.equal(root.get("productId"), 101));
//		
//		Query<String> query = session.createQuery(cq);
//		List<String> products = query.list();
//		
//		for (String product : products) {
//			
//			
//			System.out.println(product);
//		}
	
		
		// update logic using criteriaBuilder
		//CriteriaUpdate<Product> cu = cb.createCriteriaUpdate(Product.class);
		//Root<Product> root = cu.from(Product.class);
		//cu.set(root.get("productName"), "ninja");
		//cu.where(cb.equal(root.get("productId"), 101));
		
//		Query<Product> query = session.createQuery(cu);
//		int rowsUpdate = query.executeUpdate();
//		
//		if (rowsUpdate>0) {
//			System.out.println(rowsUpdate+"data is Updates");
//			
//		}
//		else {
//			
//			System.out.println("data is Not Updates");
//		}
		
		
		// delete logic using criteriaBuilder
		CriteriaDelete<Product> cd = cb.createCriteriaDelete(Product.class);
		Root<Product> root = cd.from(Product.class);
		 
		cd.where(cb.lt(root.get("productPrice"), 11111));
		
		Query<Product> query1 = session.createQuery(cd);
		
		int rowsDelete = query1.executeUpdate();
		
		if (rowsDelete>0) {
			System.out.println(rowsDelete + "data is deleted");

		} else {

			System.out.println("data is Not deleted");
		}
		
		tran.commit();
		session.close();
		sf.close();
	}
}
