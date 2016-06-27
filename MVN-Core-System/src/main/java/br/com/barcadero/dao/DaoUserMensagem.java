package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.UserMensagens;
import br.com.barcadero.tables.Usuario;

public class DaoUserMensagem extends DaoModelo <UserMensagens>{

	public DaoUserMensagem(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

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
		Query qry = getSession().createQuery(query.toString()).setLong("codigo", usuario.getCodigo());
		return qry.list();
	}

}
