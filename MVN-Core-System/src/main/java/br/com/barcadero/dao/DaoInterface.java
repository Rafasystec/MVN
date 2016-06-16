package br.com.barcadero.dao;

import br.com.barcadero.tables.Entidade;

public interface DaoInterface {
	public String insert(Entidade entidade) throws Exception;
	public String delete(long codigo) throws Exception;
	public String update(Entidade entidade) throws Exception;
	public Entidade find(long codigo) throws Exception;

}
