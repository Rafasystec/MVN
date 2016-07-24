package br.com.barcadero.frameworks.test;

import org.hibernate.Session;
import org.junit.BeforeClass;

import br.com.barcadero.test.db.HibernateHelper;

public class TesteSuperClass {
	private static Session session;
	public TesteSuperClass() {
		
	}
	
	@BeforeClass
	public static void init() {
		session = HibernateHelper.getSession();
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		TesteSuperClass.session = session;
	}

}
