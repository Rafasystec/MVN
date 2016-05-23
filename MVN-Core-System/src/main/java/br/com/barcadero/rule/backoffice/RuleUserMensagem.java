package br.com.barcadero.rule.backoffice;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.backoffice.DaoUserMensagem;
import br.com.systeconline.rule.RuleModelo;
import br.com.systeconline.tables.basicos.Entidade;

public class RuleUserMensagem extends RuleModelo {

	private DaoUserMensagem daoMensagem;
	public RuleUserMensagem(Session session) {
		super(session);
		daoMensagem = new DaoUserMensagem(session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoMensagem.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoMensagem.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoMensagem.update(entidade);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List consultarMensagens() {
		return daoMensagem.consultarMensagens();
	}

}
