package br.com.barcadero.dao;

import java.util.List;

/**
 * 
 * @author Rafael Rocha
 * Criada dia 07/11/2013  as 11:19
 */

public abstract class DaoSuperClasse {
	//Constatens para as Menssagens
	public final String MSG_SAVE_SUCESS = "Resgistro salvo com sucesso!";
	public final String MSG_SAVE_FAILED = "Problema ao tentar inserir o registro!";
	public final String MSG_EXCL_SUCESS = "Registro excluido com sucesso!";
	
	public 	DaoSuperClasse()throws Exception{
		
	}

	public String salvar(Object entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String excluir(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String alterar(Object entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Object consultar(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> consultarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
