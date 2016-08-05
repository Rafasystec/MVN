package br.com.barcadero.local.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateHelper {
	
	private static final SessionFactory sessionFac = builcSessionFactory();
	private static SessionFactory builcSessionFactory() {
		try {
			Configuration conf = new Configuration();
			conf.configure("local.cfg.xml");
			return conf.buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Erro ao contrui a configuracao: " + e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFac;
	}
	
	public static Session getSession() {
		return getSessionFactory().openSession();
	}

}
