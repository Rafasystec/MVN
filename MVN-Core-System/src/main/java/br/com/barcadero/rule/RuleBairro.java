package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barcadero.dao.DaoBairro;
import br.com.barcadero.tables.Bairro;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

@Component
public class RuleBairro extends RuleModelo<Bairro> {
	
	
	private DaoBairro daoBairro	;
	
	@Autowired
	public RuleBairro(DaoBairro daoBairro) {
		this.daoBairro = daoBairro;
	}
	
//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		try{
//			Bairro bairro	= (Bairro)entidade;
//			if(bairro != null){
//				return this.daoBairro.insert(entidade);
//			}else{
//				return "Entidade veio nula do Bean.";
//			}
//		}catch(Exception e){
//			throw new Exception(e.getMessage());
//		}
//	}

	@Override
	public String delete(long codigo) throws Exception {
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

	@Override
	public List<Bairro> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bairro> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bairro insert(Bairro entidade) throws Exception {
		return this.daoBairro.insert(entidade);
	}

	@Override
	public Bairro update(Bairro entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
