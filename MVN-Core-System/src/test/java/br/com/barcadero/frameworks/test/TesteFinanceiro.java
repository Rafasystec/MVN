package br.com.barcadero.frameworks.test;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.barcadero.core.handles.HandleEmpresaHomo;
import br.com.barcadero.core.handles.HandleUsuarioPadrao;
import br.com.barcadero.rule.RulePlanoContas;
import br.com.barcadero.tables.Usuario;

public class TesteFinanceiro extends TesteSuperClass{
	
	private static RulePlanoContas planoContas;
	private static Usuario usuario;
	
	public TesteFinanceiro() {
		// TODO Auto-generated constructor stub
		super();
	}

	public static void init() {
		planoContas = new RulePlanoContas(getSession());
		usuario = HandleUsuarioPadrao.getUsuarioHomologacao();
	}
	

	public void cargaInicial() throws Exception {
		planoContas.cargaInicial(HandleEmpresaHomo.getEmpresaHomo(),usuario);
	}

}
