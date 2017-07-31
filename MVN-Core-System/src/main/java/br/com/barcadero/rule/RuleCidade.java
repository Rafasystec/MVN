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
	
	/**
	 * Utilize a busca por UF
	 * @param codEstado
	 * @return
	 * @throws Exception
	 */
	@Deprecated	
	public List<Cidade> getCidadesByCodEstado(long codEstado) throws Exception{
		try {
			System.out.println("Procurando cidades do estado de codigo: " +codEstado);
			return this.daoCidade.getCidadesByCodEstado(codEstado);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cidade update(Cidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
