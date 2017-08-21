package br.com.barcadero.rule;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.dao.DaoCidade;
import br.com.barcadero.tables.Cidade;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Estado;
import br.com.barcadero.tables.Loja;

@Service
public class RuleCidade extends RuleModelo<Cidade> {

	@Autowired
	private DaoCidade daoCidade	;
	
	
	@Override
	public String delete(long codigo) throws Exception {
		System.out.println("Excluindo cidade com o codigo: " + codigo);
		return this.daoCidade.delete(codigo);
	}
	
	@Override
	public Cidade find(long codigo) throws Exception {
		System.out.println("Procurando cidade pelo codigo: " + codigo);
		return this.daoCidade.find(codigo);
	}
	
	public List<Cidade> findAll() throws Exception{
		return daoCidade.findAll();
	}
	
	/**
	 * Carrega as cidades cadastradas hoje
	 * @return
	 * @throws Exception
	 */
	public List<Entidade> findAllCadToday() throws Exception{
		return daoCidade.findAllCadToday();
	}
	
	/**
	 * Encontra as cidades pela data de cadastro.
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public List<Entidade> findAllByDtCadastro(Date date) throws Exception{
		return daoCidade.findAllByDtCadastro(date);
	}
	
	/**
	 * 
	 * @param uf
	 * @return
	 * @throws Exception
	 */
	public List<Cidade> getCidadesByUF(EnumUF uf) throws Exception{
		return daoCidade.getCidadesByUF(uf);
	}
	
	public List<Cidade> getCidadeByEstado(Estado estado) {
		return daoCidade.getCidadeByEstado(estado);
	}

	@Override
	public List<Cidade> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cidade> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cidade insert(Cidade entidade) throws Exception {
		return daoCidade.insert(entidade);
	}

	@Override
	public Cidade update(Cidade entidade) throws Exception {
		return daoCidade.update(entidade);
	}

}
