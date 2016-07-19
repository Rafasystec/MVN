package br.com.barcadero.frameworks.test;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class HandleEmpresaLoja {
	
	public static Empresa getEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setCodigo(1L);
		return empresa;
	}
	
	public static Loja getLoja() {
		Loja loja = new Loja();
		loja.setCodigo(1L);
		loja.setEmpresa(getEmpresa());
		return loja;
	}

}
