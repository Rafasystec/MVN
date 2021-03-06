package br.com.barcadero.rule;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import br.com.barcadero.dao.DaoModelo;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;


/**
 * Classe para servir de modelo para os facades que presisao persistir dados
 * @author Rafel Rocha
 * @since version 1.0 Beta
 */
@Transactional
public abstract class RuleModelo<T extends Entidade> implements RuleEntityInterface<T>{

	private Session	session;
	private Empresa empresa;
	private Loja loja;
	
	public RuleModelo() {
		// TODO Auto-generated constructor stub
	}
	
	public RuleModelo(DaoModelo<T> modelo) {
		// TODO Auto-generated constructor stub
	}
	
	public RuleModelo(EntityManager manager) {
		
	}
	
	public RuleModelo(Empresa empresa, Loja loja, Session session) {
		// TODO Auto-generated constructor stub
		this.session = session;
		this.empresa = empresa;
		this.loja	 = loja;
	}
	
	public RuleModelo(Session session){
		this.session = session;
	}
	public Session getSession() {
		return session;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
}
