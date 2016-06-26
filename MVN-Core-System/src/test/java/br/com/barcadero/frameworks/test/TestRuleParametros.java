package br.com.barcadero.frameworks.test;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.barcadero.rule.RuleParametros;
import br.com.barcadero.tables.ParametrosSistema;

public class TestRuleParametros extends TesteSuperClass{
	
	static RuleParametros rule;
	
	@BeforeClass
	public static void init() {
		rule = new RuleParametros(null);
	}
	
	@AfterClass
	public static void destroy() {
		
	}
	
	@Test
	public void testGetParametros() {
		String[] parametros = {
				"DESATIVAR AGENDAMENTO AUTOMATICO|1|",
				"CONTROLAR FOLHAS DE CHEQUE|2|",
				"CRITICAR CONCILIAÇÃO FINANCEIRA|3|"
		};
		
		try {
			List<ParametrosSistema> list = rule.getParametros(parametros);
			assertEquals(parametrosEsperados(parametros), list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	private List<ParametrosSistema> parametrosEsperados(String[] parametros) {
		List<ParametrosSistema> list = new ArrayList<>();
		ParametrosSistema sistema = new ParametrosSistema();
		sistema.setDescricao("DESATIVAR AGENDAMENTO AUTOMATICO");
		sistema.setDetalhe("");
		sistema.setNumero(1);
		list.add(sistema);
		
		ParametrosSistema sistema1 = new ParametrosSistema();
		sistema1.setDescricao("CONTROLAR FOLHAS DE CHEQUE");
		sistema1.setDetalhe("");
		sistema1.setNumero(2);
		list.add(sistema);
		
		ParametrosSistema sistema2 = new ParametrosSistema();
		sistema2.setDescricao("CRITICAR CONCILIAÇÃO FINANCEIRA");
		sistema2.setDetalhe("");
		sistema2.setNumero(3);
		list.add(sistema);
		
		return list;
		
	}

	

}
