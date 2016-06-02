package br.com.barcadero.frameworks.test;

import org.junit.Test;

import br.com.barcadero.rule.RuleEmpresa;
import br.com.systeconline.core.handles.HandleEmpresaHomo;
import br.com.systeconline.core.handles.HandleUsuarioPadrao;
import br.com.systeconline.tables.basicos.Empresa;

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
