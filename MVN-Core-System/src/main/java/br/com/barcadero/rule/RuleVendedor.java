package br.com.barcadero.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoVendedor;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Vendedor;

@Service
public class RuleVendedor extends RuleModelo<Vendedor> {

	

	private DaoVendedor daoVendedor;
	@Autowired
	public RuleVendedor(DaoVendedor daoVendedor) {
		// TODO Auto-generated constructor stub
		this.daoVendedor = daoVendedor;
	}


	@Override
	public String delete(long codigo) throws Exception {
		return daoVendedor.delete(codigo);
	}

	@Override
	public List<Vendedor> findAll() throws Exception {
		daoVendedor.setEmpresa(getEmpresa());
		return daoVendedor.findAll();
	}

	@Override
	public Vendedor find(long codigo) throws Exception {
		return null;
	}
	/**
	 * Obter os vendedores por codigo ou apelido
	 * @param value
	 * @return
	 */
	public List<String> getAutoComplet(String value) {
		List<Vendedor> list 		= getByCodeOrApelido(value);
		List<String> listStrings	= new ArrayList<>();
		for(Vendedor vendedor : list){
			String patter = vendedor.getCodigo() + " | " + vendedor.getApelido();
			listStrings.add(patter);
		}
		return listStrings;
	}
	
	/**
	 * Procura por codigo ou apelido do vendedor
	 * @param value
	 * @return
	 */
	public List<Vendedor> getByCodeOrApelido(String value) {
		long codigo = 0;
		try {
			codigo = Long.parseLong(value);
		} catch (Exception e) {
			codigo = 0;
		}
		return daoVendedor.getByCodeOrApelido(codigo, "%"+value+"%");
	}

	@Override
	public List<Vendedor> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendedor> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendedor insert(Vendedor entidade) throws Exception {
		return daoVendedor.insert(entidade);
	}

	@Override
	public Vendedor update(Vendedor entidade) throws Exception {
		return daoVendedor.update(entidade);
	}

}
