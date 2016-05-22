package br.com.barcadero.frameworks.test;

import org.hibernate.Session;

import br.com.systeconline.test.db.HibernateHelper;
import br.com.systeconline.test.nota.TestNotaProcess;

public class TesteSuperClass {
	private static Session session;
	
	public TesteSuperClass() {
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
	
	

}
