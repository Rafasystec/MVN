package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import br.com.barcadero.tables.Bairro;
import br.com.barcadero.tables.Cidade;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
/**
 * DAO para a tabela de bairro.
 * @author Rafael Rocha
 *
 */
@Repository
public class DaoBairro extends DaoModelo<Bairro>{
	
	public DaoBairro() {
	}

	@Override
	public Bairro find(long codigo) throws Exception{
		//Query qry = getSession().getNamedQuery(Bairro.FIND_BY_CODE).setLong("codigo", codigo);
		Query qry = manager.createNamedQuery(Bairro.FIND_BY_CODE).setParameter("codigo", codigo);
		return (Bairro)qry.getSingleResult();
	}
	
	@Override
	public List<Bairro> findAll() throws Exception{
		Query qry				= null;
		try {
			//qry = getSession().getNamedQuery(Bairro.FIND);
			qry = manager.createNamedQuery(Bairro.FIND);
			return qry.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param cidade
	 * @return
	 */
	public int deleteTodosBairrosPorCidade(Cidade cidade) {
		if(cidade != null){
			String query = "DELETE FROM Bairro WHERE cod_cidade = :codCidade";
			//Query qry = getSession().createQuery(query).setParameter("codCidade", cidade.getCodigo()) ;
			Query qry = manager.createQuery(query).setParameter("codCidade", cidade.getCodigo()) ;
			//System.out.println("Executando query: " + qry.get);
			int rows = qry.executeUpdate();
			System.out.println("Quantidade de registros afetados: " + rows);
			return rows;
		}else{
			System.out.println("Cidade veio nulo");
			return 0;
		}
	}
	
	/**
	 * Obtem todos os bairro de uma cidade pelo codigo da mesma.
	 * @param codCidade
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Bairro> getBairroByCidade(long codCidade)throws Exception {
		Query qry = manager.createNamedQuery(Bairro.FIND_BY_CID)
				.setParameter("codCidade", codCidade);
		return (List<Bairro>)qry.getResultList();
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
	
}
