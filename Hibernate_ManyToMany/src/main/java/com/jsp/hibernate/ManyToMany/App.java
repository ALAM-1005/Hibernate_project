package com.jsp.hibernate.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args )
	{
		Student s1 =  new Student();
		s1.setStudentId(1);
		s1.setStudentName("Sonu");


		Student s2 =  new Student();
		s2.setStudentId(2);
		s2.setStudentName("Monu");

		Course c1  =new Course();
		c1.setCourseId(101);
		c1.setCourseName("JAVA");
		c1.setCourseFee(845002);


		Course c2  =new Course();
		c2.setCourseId(102);
		c2.setCourseName("Ajax");
		c2.setCourseFee(52140);

		// Adding the course obj into Student

		List<Course> clist = new ArrayList<Course>();
		clist.add(c1);
		clist.add(c2);

		s1.setCourses(clist);
		s2.setCourses(clist);

		// adding the students obj into couses

		List<Student> slist = new ArrayList<Student>();
		slist.add(s1);
		slist.add(s2);

		c1.setStudent(slist);
		c2.setStudent(slist);


		Configuration cfg  =new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Course.class);
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();


		session.save(c1);
		session.save(c2);
		session.save(s1);
		session.save(s2);

		tran.commit();
		session.close();
		sf.close();

	}
}
