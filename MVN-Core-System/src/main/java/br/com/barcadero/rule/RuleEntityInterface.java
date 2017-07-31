package br.com.barcadero.rule;

import java.util.List;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public interface RuleEntityInterface<T> {
	
	public String delete(long codigo) throws Exception;
	public T find(long codigo) throws Exception;
	public List<T> findByEmpresa(Empresa empresa) throws Exception;
	public List<T> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception;
	public List<T> findAll() throws Exception;
	public T insert(T entidade) throws Exception;
	public T update(T entidade) throws Exception;
}
