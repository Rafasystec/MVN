package br.com.barcadero.rule;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoCliente;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
/**
 * Classe de negocio para o cliente
 * @author Rafael Rocha
 *
 */
@Service
public class RuleCliente extends RuleModelo<Cliente> {

	public RuleCliente() {
		System.out.println("Auto-generated constructor stub " + RuleCliente.class.getName()); 
	}

	@Autowired
	private DaoCliente daoCliente;
	
	public RuleCliente(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		//daoCliente = new DaoCliente(empresa, loja, session);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCliente.delete(codigo);
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

	@Override
	public List<Cliente> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		if(empresa != null){
			return daoCliente.findByEmpresa(empresa);
		}else{
			return new ArrayList<>();
		}
	}

	@Override
	public List<Cliente> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente insert(Cliente entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente update(Cliente entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
