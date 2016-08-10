package br.com.barcadero.frameworks.test.rules;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.barcadero.frameworks.test.TesteSuperClass;
import br.com.barcadero.rule.RulePedido;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.PedidoItens;

public class TestRulePedido extends TesteSuperClass{
	
	private static RulePedido rulePedido;
	
	
	public TestRulePedido() {
		//rulePedido = new RulePedido(null, null, null,null);
	}
		
	
	
	//@Test
	public void totalizarPedidos() {
		Pedido pedido = new Pedido();
		List<PedidoItens> itens = new ArrayList<>();
		PedidoItens item = new PedidoItens();
		item.setVlTotal(new BigDecimal(10.00));
		itens.add(item);
		item = new PedidoItens();
		item.setVlTotal(new BigDecimal(12.99));
		itens.add(item);
		item = new PedidoItens();
		item.setVlTotal(new BigDecimal(15.25));
		itens.add(item);
		pedido.setItens(itens);
		BigDecimal total 		= rulePedido.totalizarPedido(pedido);
		total = total.round(MathContext.DECIMAL32);
		BigDecimal totalExp		= new BigDecimal(38.24);
		totalExp = totalExp.round(MathContext.DECIMAL32);
		assertEquals(totalExp, total);
	}

}
