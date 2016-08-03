package br.com.barcadero.rule;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoCliente;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Vendedor;

public class RuleCliente extends RuleModelo<Cliente> {

	

	private final DaoCliente daoCliente;
	
	public RuleCliente(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoCliente = new DaoCliente(empresa, loja, session);
	}
	
	@Override
	public String insert(Entidade entidade) throws Exception {
		Cliente cliente = (Cliente)entidade;
		return daoCliente.insert(cliente);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCliente.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoCliente.update(entidade);
	}

	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return daoCliente.findAll();
	}

	@Override
	public Cliente find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCliente.find(codigo);
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public List<String> getAutoComplet(String value) {
		List<Cliente> list 		= getByCodeOrName(value);
		List<String> listStrings	= new ArrayList<>();
		for(Cliente cliente : list){
			String patter = cliente.getCodigo() + " | " + cliente.getPessoaFisica().getNome();
			listStrings.add(patter);
		}
		return listStrings;
	}
	
	/**
	 * Procura por codigo ou apelido do vendedor
	 * @param value
	 * @return
	 */
	public List<Cliente> getByCodeOrName(String value) {
		long codigo = 0;
		try {
			codigo = Long.parseLong(value);
		} catch (Exception e) {
			codigo = 0;
		}
		return daoCliente.findByCodeOrName(codigo, "%"+value+"%");
	}

}
