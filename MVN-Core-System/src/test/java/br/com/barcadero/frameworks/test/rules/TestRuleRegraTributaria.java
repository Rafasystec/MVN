package br.com.barcadero.frameworks.test.rules;

import org.junit.Test;
import static org.junit.Assert.fail;
import br.com.barcadero.frameworks.test.TesteSuperClass;
import br.com.barcadero.rule.RuleRegraTributaria;

public class TestRuleRegraTributaria extends TesteSuperClass{

	private RuleRegraTributaria regraTributaria;
	public TestRuleRegraTributaria() {
		// TODO Auto-generated constructor stub
		regraTributaria = new RuleRegraTributaria(null, null, getSession());
	}
	@Test
	public void testeCargaRegrasICMS() {
		try {
			getSession().beginTransaction();
			regraTributaria.cargaDasRegras(null);
			getSession().getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
