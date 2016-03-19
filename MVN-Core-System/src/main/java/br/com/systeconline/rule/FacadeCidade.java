package br.com.systeconline.rule;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import br.com.systeconline.dao.basicos.DaoCidade;
import br.com.systeconline.tables.basicos.Cidade;
import br.com.systeconline.tables.basicos.Entidade;

public class FacadeCidade extends RuleModelo implements RuleEntityInterface {

	private DaoCidade daoCidade	;
	
	public FacadeCidade(Session session){
		super(session);
		this.daoCidade	= new DaoCidade(session);
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
	public Entidade find(long codigo) throws Exception {
		System.out.println("Procurando cidade pelo codigo: " + codigo);
		return this.daoCidade.find(codigo);
	}
		
	public List<Cidade> getCidadesByCodEstado(long codEstado) throws Exception{
		try {
			System.out.println("Procurando cidades do estado de codigo: " +codEstado);
			return this.daoCidade.getCidadesByCodEstado(codEstado);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Entidade> findAll() throws Exception{
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

}
