package br.com.barcadero.rule;

import java.util.List;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;

public interface RuleEntityInterface<T> {
	public String insert(Entidade entidade) throws Exception;
	public String delete(long codigo) throws Exception;
	public String update(Entidade entidade) throws Exception;
	public T find(long codigo) throws Exception;
	public List<T> findByEmpresa(Empresa empresa) throws Exception;
	public List<T> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception;
	public List<T> findAll() throws Exception;
}
