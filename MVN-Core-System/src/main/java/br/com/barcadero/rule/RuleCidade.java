package br.com.barcadero.rule;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.dao.DaoCidade;
import br.com.barcadero.tables.Cidade;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;

public class RuleCidade extends RuleModelo<Cidade> {

	
	private DaoCidade daoCidade	;
	
	public RuleCidade(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		this.daoCidade	= new DaoCidade(empresa, loja, session);
	}
	
	@Override
	public String insert(Entidade entidade) throws Exception {
		try{
			Cidade cidade	= (Cidade)entidade;
			if(cidade != null){
				if(find(cidade.getCodigo()) == null){
					return this.daoCidade.insert(entidade);
				}else{
					return "Cidade já cadastrada!";
				}
			}else{
				return "Entidade veio nula do Bean.";
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String delete(long codigo) throws Exception {
		System.out.println("Excluindo cidade com o codigo: " + codigo);
		return this.daoCidade.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		System.out.println("Update facade cidade.");
		return this.daoCidade.update(entidade);
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

}
