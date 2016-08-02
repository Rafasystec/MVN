package br.com.barcadero.frameworks.test.rules;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.fail;
import br.com.barcadero.frameworks.test.TesteSuperClass;
import br.com.barcadero.rule.RuleSystemProperties;
import br.com.barcadero.tables.SystemProperties;


public class TestRuleSystemProperties extends TesteSuperClass {

	private RuleSystemProperties ruleSystemProperties;
	public TestRuleSystemProperties() {
		ruleSystemProperties = new RuleSystemProperties(null, null, getSession());
	}
	
	@Test
	public void testInsert() {
		SystemProperties properties = new SystemProperties();
		properties.setCnpjSoftwareHouse("38596140000123");
		properties.setDtUltimaAlteracao(new Date());
		properties.setNomeComercial("Nautilus");
		properties.setVersaoSistema("1.0-Beta");
		try {
			ruleSystemProperties.insert(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
}
