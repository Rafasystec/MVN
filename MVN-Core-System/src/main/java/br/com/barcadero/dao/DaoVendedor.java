package br.com.barcadero.dao;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Vendedor;

@Repository
public class DaoVendedor extends DaoModelo <Vendedor>{

	
	public DaoVendedor() {
		System.out.println("Auto-generated constructor stub DaoVendedor");
	}

	@Override
	public List<Vendedor> findAll() throws Exception {
		Query qry = manager.createNamedQuery(Vendedor.FIND_ALL)
				.setParameter(Empresa.EMPRESA, empresa.getCodigo());
		return qry.getResultList();
	}

	@Override
	public Vendedor find(long codigo) throws Exception {
		Query qry = manager.createNamedQuery(Vendedor.FIND_BY_CODE)
				.setParameter(Empresa.EMPRESA, empresa.getCodigo())
				.setParameter("codigo", codigo);
		return (Vendedor) qry.getSingleResult();
	}
	
	public List<Vendedor> getByCodeOrApelido(long codigo, String apelido) {
		Query qry = manager.createNamedQuery(Vendedor.FIND_BY_COD_OR_DESC)
				.setParameter(Empresa.EMPRESA, empresa.getCodigo())
				.setParameter("codigo", codigo)
				.setParameter("apelido", apelido);
		return qry.getResultList();
	}

}
