package br.com.barcadero.testes.beans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import static org.junit.Assert.fail;

import java.util.Random;

import br.com.barcadero.core.enums.EnumStatusCaixa;
import br.com.barcadero.rule.RuleCaixa;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.testes.util.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={
		AppConfig.class
})
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class TestBeanCaixa {
	
	@Autowired
	RuleCaixa ruleCaixa;
	
	

	@Test
	public void testInsert() {
		try {
			Caixa caixa = new Caixa();
			caixa.setCdCaixa(new Random().nextInt(600000));
			caixa.setCodAtivCfe("123456");
			caixa.setCodAtivCfeEmergen("123455678");
			caixa.setIp("127.0.0.1");
			caixa.setStatusCaixa(EnumStatusCaixa.FECHADO);
			ruleCaixa.insert(caixa);
			
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
}
