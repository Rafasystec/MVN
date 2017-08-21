package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Funcionario;
import br.com.barcadero.tables.Loja;
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

	@Override
	public List<Funcionario> findByEmpresa(Empresa empresa) throws Exception {
		TypedQuery<Funcionario> qry = getManager().createNamedQuery(Funcionario.FIND_BY_EMPRESA,Funcionario.class)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa);
		return qry.getResultList();
	}

	@Override
	public List<Funcionario> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
