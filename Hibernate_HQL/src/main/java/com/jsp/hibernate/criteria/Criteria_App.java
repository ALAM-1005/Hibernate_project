package com.jsp.hibernate.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;

import com.jsp.hibernate.hql.Product;


public class Criteria_App {
	
	public static void main(String[] args) {
		
		
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Product.class);  // Default select all  field
		
		//criteria.setProjection(Projections.property("productName"));
		criteria.setProjection(Projections.property("productId"));
		criteria.add(Restrictions.eq("productId", 101));
		//criteria.add(Restrictions.eq("productName", "r15"));
		//criteria.add(Restrictions.gt("productId", 101));
		//criteria.add(Restrictions.lt("productId", 101));
		
		//criteria.add(Restrictions.between("productId", 101,103));
		//criteria.add(Restrictions.like("productId", "perfume"));
		//criteria.add(Restrictions.isNotNull("productId"));
		
		List<Integer> products = criteria.list();
		
		for (int product : products) {
			System.out.println(product);
		}
//		List<String> products = criteria.list();
//		
//		for (String product : products) {
//			  System.out.println(product);
//		}
//		List<Product> products = criteria.list();
//		
//		for (Product product : products) {
//			System.out.println(product);
//		}
		
		tran.commit();
		session.close();
		sf.close();
		
		
		
	}

}
