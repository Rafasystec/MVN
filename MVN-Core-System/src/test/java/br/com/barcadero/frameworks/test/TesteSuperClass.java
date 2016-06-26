package br.com.barcadero.frameworks.test;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import br.com.barcadero.test.db.HibernateHelper;
import br.com.barcadero.test.nota.TestNotaProcess;

public class TesteSuperClass {
	private static Session session;
	
	public TesteSuperClass() {
		
	}

//	@BeforeClass
	public static void initialize() {
		System.out.println(TestNotaProcess.class + " Init");
		session 		= HibernateHelper.getSession();
		session.beginTransaction();
	}
	
	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		TesteSuperClass.session = session;
	}
	
//	@AfterClass
	public static void commitAndClose() {
		if(session != null){
			session.getTransaction().commit();
			session.close();
		}
	}

}
