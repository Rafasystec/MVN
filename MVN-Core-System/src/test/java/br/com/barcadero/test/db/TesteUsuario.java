package br.com.barcadero.test.db;

import org.junit.Test;
	
import br.com.barcadero.core.enums.EnumTipoUser;
import br.com.barcadero.dao.DaoUsuario;
import br.com.barcadero.frameworks.test.TesteSuperClass;
import br.com.barcadero.rule.RuleUsuario;
import br.com.barcadero.tables.Usuario;

public class TesteUsuario extends TesteSuperClass{
	
	RuleUsuario ruleUsuario;
	public TesteUsuario() {
		// TODO Auto-generated constructor stub
		ruleUsuario = new RuleUsuario(new DaoUsuario());
	}
	
	@Test
	public void teste() {
		try {
			Usuario user = (Usuario)getSession().createQuery("FROM Usuario WHERE codigo = 13").uniqueResult();
			System.out.println(user);
			if(user!=null){
				user.setNome("Ellen Mady 23");
				getSession().merge(user);
				getSession().update(user);
			}
			Usuario user1 = new Usuario();
			user1.setEmail("email@email");
			user1.setNome("FULANO");
			user1.setPassWord("123456");
			user1.setTipoUser(EnumTipoUser.INVITED);
			getSession().persist(user1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ruleUsuario.insert(user);
	}

}
