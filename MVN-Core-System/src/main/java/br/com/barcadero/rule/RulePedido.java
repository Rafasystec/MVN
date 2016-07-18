package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.Usuario;

public class RulePedido extends RuleModelo<Pedido> {

	private RuleCaixa ruleCaixa;
	public RulePedido(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		ruleCaixa = new RuleCaixa(empresa, loja, session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @param usuario
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public Pedido createPedido(Usuario usuario, String ip) throws Exception {
		Pedido pedido = new Pedido(getLoja(), usuario);
		Caixa caixa = ruleCaixa.findByIp(getLoja().getCodigo(), ip);
		pedido.setCaixa(caixa);
		return pedido;
	}

}
