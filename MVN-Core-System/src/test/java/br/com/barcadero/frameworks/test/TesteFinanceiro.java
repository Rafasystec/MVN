package br.com.barcadero.frameworks.test;

import org.junit.BeforeClass;
import org.junit.Test;
import br.com.barcadero.rule.financeiro.RulePlanoContas;
import br.com.systeconline.core.handles.HandleEmpresaHomo;
import br.com.systeconline.core.handles.HandleUsuarioPadrao;
import br.com.systeconline.tables.basicos.Usuario;

public class TesteFinanceiro extends TesteSuperClass{
	
	private static RulePlanoContas planoContas;
	private static Usuario usuario;
	
	public TesteFinanceiro() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeClass
	public static void init() {
		planoContas = new RulePlanoContas(getSession());
		usuario = HandleUsuarioPadrao.getUsuarioHomologacao();
	}
	
	@Test
	public void cargaInicial() throws Exception {
		planoContas.cargaInicial(HandleEmpresaHomo.getEmpresaHomo(),usuario);
	}

}
