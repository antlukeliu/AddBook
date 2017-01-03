package com.liu.hibernate1;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DAO {
	private static SessionFactory factory;

	private static void setupFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			;
		}
		Configuration configuration = new Configuration();
		// modify these to match your XML files
		configuration.configure("hibernate.cfg.xml");
		configuration.addResource("book.hbu.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static int addBook(Book p) {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		// save this specific record
		int i = (Integer) hibernateSession.save(p);
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return i;
	}

	
	//"FROM Book WHERE sales > 1000000 and sales <3000000"
	
	public static List<Book> getAllBooks(String filter) {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		List<Book> books = hibernateSession.createQuery(filter).list();
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return books;
	}
	public static void deleteBook(Integer p) {
		if (factory == null)
			setupFactory();
	     Session session = factory.openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Book str = 
	                   (Book)session.get(Book.class, p); 
	         session.delete(str); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }
	}

