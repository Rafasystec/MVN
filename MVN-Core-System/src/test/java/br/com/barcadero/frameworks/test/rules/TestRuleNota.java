package br.com.barcadero.frameworks.test.rules;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.barcadero.core.enums.EnumCSTCOFINS;
import br.com.barcadero.core.enums.EnumCSTICMS;
import br.com.barcadero.core.enums.EnumCSTIPI;
import br.com.barcadero.core.enums.EnumCSTPIS;
import br.com.barcadero.core.enums.EnumCompeTotalNota;
import br.com.barcadero.core.enums.EnumItemCancelado;
import br.com.barcadero.core.enums.EnumModeloNota;
import br.com.barcadero.core.enums.EnumNaturezaOperacao;
import br.com.barcadero.core.enums.EnumNotaFaturada;
import br.com.barcadero.core.enums.EnumTipoMeioPgto;
import br.com.barcadero.frameworks.test.TesteSuperClass;
import br.com.barcadero.rule.RuleNota;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;
import br.com.barcadero.tables.NotaMeioPgto;
import static org.junit.Assert.fail;

public class TestRuleNota extends TesteSuperClass {

	private RuleNota ruleNota;
	public TestRuleNota() {
		// TODO Auto-generated constructor stub
		ruleNota = new RuleNota(null, null, getSession());
	}
	
	@Test
	public void insert() throws Exception{
		Nota nota = new Nota();
		nota.setCaixa(null);
		nota.setCfe(null);
		nota.setCliente(null);
		nota.setDtEmissao(new Date());
		nota.setFlFaturado(EnumNotaFaturada.NAO);
		nota.setHrEmissao(new Date());
		nota.setInfAdicionais("NOTA GERADA EM TESTES AUTOMÁTICOS.");
		nota.setItens(getItens(nota));
		nota.setMeiosPgto(getMeiosPagamento(nota));
		nota.setModelo(EnumModeloNota.MOD_59);
		nota.setNaturezaOperacao(EnumNaturezaOperacao.SAIDA);
		nota.setPedido(null);
		nota.setSerieNota("TESTE");
		try {
			ruleNota.insert(nota);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	private List<NotaItens> getItens(Nota nota) {
		List<NotaItens> itens = new ArrayList<>();
		for (int i = 1; i < 4 ; i++) {
			NotaItens item = new NotaItens();
			item.setCdProd(""+i);
			item.setCofins(3.000f);
			item.setCstCOFINS(EnumCSTCOFINS._01);
			item.setCstICMS(EnumCSTICMS._00);
			item.setCstIPI(EnumCSTIPI.ENTRADA_IMUNE_04);
			item.setCstPIS(EnumCSTPIS._01);
			item.setDescricao("PRODUTO NUMERO " + i);
			item.setFlCompoeTotNota(EnumCompeTotalNota.S);
			item.setFlCancelado(EnumItemCancelado.N);
			item.setInforAdicionais("PRODUTO GERADO AUTOMATICAMENTE EM TESTES.");
			item.setNota(nota);
			item.setNrItem(i);
			item.setPis(0.0062F);
			item.setQuantidade(i);
			item.setVlUnidade(new BigDecimal(4.14));
			itens.add(item);
		}
		return itens;
	}
	
	private List<NotaMeioPgto> getMeiosPagamento(Nota nota) {
		NotaMeioPgto meio = new NotaMeioPgto();
		meio.setCdAdministradora(000);
		meio.setNota(nota);
		meio.setQtParcelas(0);
		meio.setTipoMeioPgto(EnumTipoMeioPgto.DINHEIRO);
		meio.setValor(new BigDecimal(100.00));
		return Arrays.asList(meio);
	}
	
}
