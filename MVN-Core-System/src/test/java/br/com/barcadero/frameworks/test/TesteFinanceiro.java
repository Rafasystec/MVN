package br.com.barcadero.frameworks.test;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.barcadero.rule.RuleEmpresa;
import br.com.barcadero.rule.financeiro.RulePlanoContas;
import br.com.systeconline.core.handles.HandleEmpresaHomo;

public class TesteFinanceiro extends TesteSuperClass{
	
	private static RulePlanoContas planoContas;
	
	@BeforeClass
	public static void init() {
		planoContas = new RulePlanoContas(getSession());
	}
	
	@Test
	public void cargaInicial() throws Exception {
		planoContas.cargaInicial(HandleEmpresaHomo.getEmpresaHomo());
	}

}
