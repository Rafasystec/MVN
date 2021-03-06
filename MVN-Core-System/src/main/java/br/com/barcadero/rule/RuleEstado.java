package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoEstado;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Estado;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;

@Service
public class RuleEstado extends RuleModelo<Estado> {

	@Autowired
	private DaoEstado daoEstado ;

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoEstado.delete(codigo);
	}

	@Override
	public Estado find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoEstado.find(codigo);
	}
	
	public List<Estado> findAll() throws Exception{
		try {
			return this.daoEstado.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Estado> findAllEstados() throws Exception {
		return daoEstado.findAllEstados();
	}
	
	/**
	 * Realiza a carga inicial dos estados na tabela
	 * @throws Exception
	 * @author Rafael Rocha
	 */
	public void carregarEstados() throws Exception{
		if(daoEstado.findAll().size() == 0){
			System.out.println("Realizando a carga dos Estados no Sistema.");
			daoEstado.carregarEstados();
		}
	}

	@Override
	public List<Estado> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estado> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estado insert(Estado entidade) throws Exception {
		return daoEstado.insert(entidade);
	}

	@Override
	public Estado update(Estado entidade) throws Exception {
		return daoEstado.update(entidade);
	}

}
