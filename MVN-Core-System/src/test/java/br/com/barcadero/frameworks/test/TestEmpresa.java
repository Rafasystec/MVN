package br.com.barcadero.frameworks.test;

import org.junit.Test;

import br.com.barcadero.core.handles.HandleEmpresaHomo;
import br.com.barcadero.core.handles.HandleUsuarioPadrao;
import br.com.barcadero.rule.RuleEmpresa;
import br.com.barcadero.tables.Empresa;

public class TestEmpresa extends TesteSuperClass{
	
	
	//@Test
	public void insert() throws Exception {
		RuleEmpresa RuleEmpresa = new RuleEmpresa(getSession());
		Empresa empresa = HandleEmpresaHomo.getEmpresaHomo();
		empresa.setUsuario(HandleUsuarioPadrao.getUsuarioHomologacao());
		empresa.setCodigo(0);
		empresa.getPessoaJuridica().setCodigo(0);
		RuleEmpresa.insert(empresa);
	}
	

}
