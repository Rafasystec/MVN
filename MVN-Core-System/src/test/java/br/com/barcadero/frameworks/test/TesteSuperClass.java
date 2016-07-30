package br.com.barcadero.frameworks.test;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.com.barcadero.test.db.HibernateHelper;

public class TesteSuperClass {
	private static Session session = null;
	public TesteSuperClass() {
		
	}
	
	@BeforeClass
	public static void init() {
		if(session == null){
			session = HibernateHelper.getSession();
		}
		if(session != null){
			session.beginTransaction();
		}
	}
	@AfterClass
	public static void destroy() {
		if(session != null){
			session.getTransaction().commit();
		}
	}
	

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		TesteSuperClass.session = session;
	}
	
	

}
