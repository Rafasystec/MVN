package br.com.barcadero.rule;

import java.util.List;
import org.hibernate.Session;
import br.com.barcadero.dao.DaoBairro;
import br.com.barcadero.tables.Bairro;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
public class RuleBairro extends RuleModelo<Bairro> {
	
	
	private DaoBairro daoBairro	;
	public RuleBairro(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		this.daoBairro	= new DaoBairro(empresa, loja, session);
	}
	
	@Override
	public String insert(Entidade entidade) throws Exception {
		try{
			Bairro bairro	= (Bairro)entidade;
			if(bairro != null){
				return this.daoBairro.insert(entidade);
			}else{
				return "Entidade veio nula do Bean.";
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
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
	public Bairro find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Bairro> findAll() throws Exception{
		try {
			return this.daoBairro.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Obtem todos os bairro de uma cidade pelo codigo da mesma.
	 * @param codCidade
	 * @return
	 * @throws Exception
	 */
	public List<Bairro> getBairrosByCodCidade(long codCidade) throws Exception{
		try {
			return this.daoBairro.getBairroByCidade(codCidade);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
}
