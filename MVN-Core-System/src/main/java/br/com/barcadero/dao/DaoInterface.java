package br.com.barcadero.dao;

import java.util.List;

import br.com.barcadero.tables.Entidade;

public interface DaoInterface<T> {
	public String insert(Entidade entidade) throws Exception;
	public String delete(long codigo) throws Exception;
	public String update(Entidade entidade) throws Exception;
	public T find(long codigo) throws Exception;
	//Novos metodos
	public List<T> findAll() throws Exception;

}
