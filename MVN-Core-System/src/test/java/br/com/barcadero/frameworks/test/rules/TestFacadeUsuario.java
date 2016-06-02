package br.com.barcadero.frameworks.test.rules;

import static org.junit.Assert.fail;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import br.com.systeconline.rule.FacadeUsuario;
import br.com.systeconline.test.db.HibernateHelper;

public class TestFacadeUsuario {
	
	private static Session session ;
	private static FacadeUsuario fcdUsuario;
	
	//@BeforeClass
	public static void init() {
		System.out.println("Init JUnit case for Usuario process");
		System.out.println(TestRuleCaixa.class + " Init");
		session 		= HibernateHelper.getSession();
		session.beginTransaction();
		fcdUsuario	= new FacadeUsuario(session);
	}
	
	//@AfterClass
	public static void destroy() {
		System.out.println("After class destroy invoked " + TestFacadeUsuario.class);
		if(session != null){
			session.getTransaction().commit();
			session.close();
		}
	}
	
	//@Test
	public void inserirUsuarioPadrao() {
		try {
			fcdUsuario.inserirUsuarioHomo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
