package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Funcionario;
@Repository
public class DaoFuncionario extends DaoModelo<Funcionario> {

//	public DaoFuncionario(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		// TODO Auto-generated constructor stub
//	}
	
	public DaoFuncionario() {
		System.out.println(">>>>>Criando a dao funcionario pelo default contructor<<<<<<");
	}

	@Override
	public Funcionario find(long codigo) throws Exception {
		Query qry = manager.createNamedQuery(Funcionario.FIND_BY_CODE).setParameter("codigo", codigo);
		return (Funcionario) qry.getSingleResult();
	}

	@Override
	public List<Funcionario> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
