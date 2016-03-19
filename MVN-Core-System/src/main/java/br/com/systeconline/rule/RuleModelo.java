package br.com.systeconline.rule;

import org.hibernate.Session;

import br.com.systeconline.rule.RuleEntityInterface;
import br.com.systeconline.tables.basicos.Entidade;

/**
 * Classe para servir de modelo para os facades que presisao persistir dados
 * @author Rafel Rocha
 * @since version 1.0 Beta
 */
public abstract class RuleModelo implements RuleEntityInterface{

	private Session	session;
	public RuleModelo(Session session){
		this.session = session;
	}
	public Session getSession() {
		return session;
	}
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
