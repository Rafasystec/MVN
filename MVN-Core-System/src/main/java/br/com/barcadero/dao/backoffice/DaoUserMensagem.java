package br.com.barcadero.dao.backoffice;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.systeconline.dao.basicos.DaoModelo;
import br.com.systeconline.tables.basicos.Entidade;
import br.com.systeconline.tables.basicos.Usuario;

public class DaoUserMensagem extends DaoModelo {

	public DaoUserMensagem(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entidade> findAll() throws Exception {
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
