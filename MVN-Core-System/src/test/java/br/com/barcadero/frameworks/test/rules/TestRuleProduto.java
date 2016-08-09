package br.com.barcadero.frameworks.test.rules;

import static org.junit.Assert.fail;
import java.math.BigDecimal;
import org.junit.Test;
import br.com.barcadero.core.enums.EnumCSTCOFINS;
import br.com.barcadero.core.enums.EnumCSTICMS;
import br.com.barcadero.core.enums.EnumCSTIPI;
import br.com.barcadero.core.enums.EnumCSTPIS;
import br.com.barcadero.core.enums.EnumOrigemCSTICMS;
import br.com.barcadero.core.enums.EnumTipoCOFINS;
import br.com.barcadero.core.enums.EnumTipoPIS;
import br.com.barcadero.core.enums.EnumTipoProduto;
import br.com.barcadero.core.enums.EnumUnidadeMedida;
import br.com.barcadero.frameworks.test.TesteSuperClass;
import br.com.barcadero.rule.RuleProduto;
import br.com.barcadero.tables.Produto;

public class TestRuleProduto extends TesteSuperClass {

	private RuleProduto ruleProduto;
	
	public TestRuleProduto() {
		//ruleProduto = new RuleProduto(null, null, getSession());
	}
	
	//@Test
	public void produtoNormal() throws Exception{
		Produto prod = new Produto();
		prod.setAliqISSQN(new BigDecimal(5.05));
		prod.setAliquota(new BigDecimal(17.00));
		prod.setCdFornecedor(1);
		prod.setCest(3);
		prod.setCfop(5012);
		prod.setCstCOFINS(EnumCSTCOFINS._01);
		prod.setCstIcms(EnumCSTICMS._00);
		prod.setCstIpi(EnumCSTIPI.ENTRADA_IMUNE_04);
		prod.setCstPis(EnumCSTPIS._01);
		prod.setDescricao("LEITE LONGA VIDA TIPO 1");
		prod.setEan("09948588576858756");
		prod.setIppt("IAAT");
		prod.setMsgPromocional("GERADO NOS TESTES AUTOMÁTICOS");
		prod.setOrigemIcms(EnumOrigemCSTICMS.ESTRANGEIRA_IMP);
		prod.setPrecoVenda(new BigDecimal(8.49));
		prod.setTipoPis(EnumTipoPIS.PIS_ALIQUOTA);
		prod.setPrecoCusto(new BigDecimal(4.89));
		prod.setTipoCofins(EnumTipoCOFINS.COFINS_ALIQ);
		prod.setTipoProduto(EnumTipoProduto.NORMAL);
		prod.setUnidade(EnumUnidadeMedida.UNIDADE);
		prod.setUsuario(null);
		prod.setCdNcm(98987654);
		try {
			ruleProduto.insert(prod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	//@Test 
	public void produtoLente() throws Exception{
		Produto prod = new Produto();
		prod.setAliqISSQN(new BigDecimal(5.05));
		prod.setAliquota(new BigDecimal(17.00));
		prod.setCdFornecedor(1);
		prod.setCest(3);
		prod.setCfop(5012);
		prod.setCstCOFINS(EnumCSTCOFINS._02);
		prod.setCstIcms(EnumCSTICMS._10);
		prod.setCstIpi(EnumCSTIPI.ENTRADA_IMUNE_04);
		prod.setCstPis(EnumCSTPIS._01);
		prod.setDescricao("LENTE BIFOCAL ZINUD");
		prod.setEan("09948588663534334");
		prod.setIppt("IAAT");
		prod.setMsgPromocional("GERADO NOS TESTES AUTOMÁTICOS");
		prod.setOrigemIcms(EnumOrigemCSTICMS.ESTRANGEIRA_N_SIMILAR);
		prod.setPrecoVenda(new BigDecimal(80.44));
		prod.setTipoPis(EnumTipoPIS.PIS_NT);
		prod.setPrecoCusto(new BigDecimal(20.00));
		prod.setTipoCofins(EnumTipoCOFINS.COFINS_NT);
		prod.setTipoProduto(EnumTipoProduto.LENTE);
		prod.setUnidade(EnumUnidadeMedida.UNIDADE);
		prod.setUsuario(null);
		prod.setCdNcm(98987654);
		try {
			ruleProduto.insert(prod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	//@Test
	public void produtoNacional() throws Exception{
		Produto prod = new Produto();
		prod.setAliqISSQN(new BigDecimal(5.05));
		prod.setAliquota(new BigDecimal(17.00));
		prod.setCdFornecedor(1);
		prod.setCest(3);
		prod.setCfop(5012);
		prod.setCstCOFINS(EnumCSTCOFINS._03);
		prod.setCstIcms(EnumCSTICMS._10);
		prod.setCstIpi(EnumCSTIPI.ENTRADA_ISENTA_02);
		prod.setCstPis(EnumCSTPIS._01);
		prod.setDescricao("CREAM CRACKER FORTALEZA");
		prod.setEan("09948588576675765666");
		prod.setIppt("IAAT");
		prod.setMsgPromocional("GERADO NOS TESTES AUTOMÁTICOS");
		prod.setOrigemIcms(EnumOrigemCSTICMS.NACIONAL);
		prod.setPrecoVenda(new BigDecimal(3.84));
		prod.setTipoPis(EnumTipoPIS.PIS_ALIQUOTA);
		prod.setPrecoCusto(new BigDecimal(1.99));
		prod.setTipoCofins(EnumTipoCOFINS.COFINS_ALIQ);
		prod.setTipoProduto(EnumTipoProduto.NORMAL);
		prod.setUnidade(EnumUnidadeMedida.UNIDADE);
		prod.setUsuario(null);
		prod.setCdNcm(98987643);
		try {
			ruleProduto.insert(prod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
