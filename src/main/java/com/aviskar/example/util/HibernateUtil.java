package com.aviskar.example.util;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static Session openSession() {
		return getSessionFactory().openSession();
	}

	public static EntityManager createEntityManager() {
		return getSessionFactory().createEntityManager();
	}

	public static void closeSessionFactory() throws SQLException {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
