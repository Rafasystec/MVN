package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.UserMensagens;
import br.com.barcadero.tables.Usuario;
@Repository
public class DaoUserMensagem extends DaoModelo <UserMensagens>{

	public DaoUserMensagem() {
		System.out.println("Auto-generated constructor stub DaoUserMensagem");
	}
//	public DaoUserMensagem(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public UserMensagens find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserMensagens> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List consultarMensagens(Usuario usuario) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT u.nome, um.mensagem, um.dtMensagem, um.hrMensagem FROM UserMensagens um "); 
		query.append("inner join Usuario u on u.codigo = um.usuario.codigo");
		query.append(" WHERE um.cdUserReceive = :codigo");
		Query qry = manager.createQuery(query.toString()).setParameter("codigo", usuario.getCodigo());
		return qry.getResultList();
	}

	@Override
	public List<UserMensagens> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserMensagens> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
