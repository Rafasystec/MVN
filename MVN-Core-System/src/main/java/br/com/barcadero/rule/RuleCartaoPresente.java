package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.commons.util.HandleDateHour;
import br.com.barcadero.commons.util.HandleString;
import br.com.barcadero.dao.DaoCartaoPresente;
import br.com.barcadero.tables.CartaoPresente;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;

public class RuleCartaoPresente extends RuleModelo<CartaoPresente> {

	private DaoCartaoPresente daoCartaoPresente;
	public RuleCartaoPresente(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoCartaoPresente = new DaoCartaoPresente(empresa, loja, session);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCartaoPresente.delete(codigo);
	}

	@Override
	public CartaoPresente find(long codigo) throws Exception {
		return daoCartaoPresente.find(codigo);
	}

	@Override
	public List<CartaoPresente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return daoCartaoPresente.findAll();
	}
	/**
	 * 
	 * @param serie
	 * @param qtdeCartoes
	 * @param usuario
	 * @throws Exception
	 */
	public void gerarCartoes(int serie, int qtdeCartoes, Usuario usuario) throws Exception {
		for (int i = 0; i < qtdeCartoes; i++) {
			CartaoPresente cartaoPresente = new CartaoPresente(getEmpresa(), getLoja(), usuario);
			daoCartaoPresente.insert(cartaoPresente);
			String ano 		= HandleDateHour.getCurrentYear();
			String empresa	= HandleString.zerosLeft(String.valueOf(getEmpresa().getCodigo()), 3);
			String strSerie	= HandleString.zerosLeft(String.valueOf(serie), 4);
			String seqCard	= HandleString.zerosLeft(String.valueOf(cartaoPresente.getCodigo()), 6);
			String numero	= ano + empresa + strSerie + seqCard;
			cartaoPresente.setNumero(numero);
			daoCartaoPresente.update(cartaoPresente);
		}
	}

	@Override
	public List<CartaoPresente> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartaoPresente> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartaoPresente insert(CartaoPresente entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartaoPresente update(CartaoPresente entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
