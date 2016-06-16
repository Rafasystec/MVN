package br.com.barcadero.dao;

import java.util.List;

public interface DaoPersistivel {
	public String salvar(Object entidade)throws Exception;
	public String excluir(long codigo)throws Exception;
	public String alterar(Object entidade)throws Exception;
	public Object consultar(long codigo)throws Exception;
	public List<Object> consultarTodos()throws Exception;
}
