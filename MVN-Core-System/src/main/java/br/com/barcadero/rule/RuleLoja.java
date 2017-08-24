package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.barcadero.dao.DaoLoja;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;

@Service
public class RuleLoja extends RuleModelo<Loja> {

	@Autowired
	private DaoLoja daoLoja;

	private Empresa empresa;

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoLoja.delete(codigo);
	}


	@Override
	public Loja find(long codigo) throws Exception {
		return daoLoja.find(codigo);
	}
	
	/**
	 * Procura uma loja pelo codigo.
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	public Loja findLoja(long codigo)  throws Exception {
		return (Loja)daoLoja.find(codigo);
	}
	
	/**
	 * Obter todas as lojas de uma determinada empresa.
	 * @param cdEmp
	 * @return
	 * @throws Exception
	 */
	public List<Loja> getLojasDaEmpresa(long cdEmp) throws Exception{
		return daoLoja.getLojasDaEmpresa(cdEmp);
	}
	
	public List<Loja> getLojasDaEmpresa(Empresa empresa) throws Exception{
		return daoLoja.getLojasDaEmpresa(empresa);
	}
	
	/**
	 * Insere uma loja matriz em uma empresa recem criada.
	 * @param pj
	 * @param empresa
	 * @return
	 * @throws Exception
	 */
	public Loja inserirLojaMatriz(Usuario usuario, Empresa empresa) throws Exception{
	
		Loja loja = new Loja(usuario);
		loja.setCnaeFiscal(empresa.getCnaeFiscal());
		//loja.setCnempresa(empresa.getCnaeF);
		loja.setCodRegTribut(empresa.getCodRegTribut());
		loja.setDtCadastro(empresa.getDtCadastro());
		loja.setDtUltAlteracao(empresa.getDtUltAlteracao());
		loja.setEmail(empresa.getEmail());
		loja.setFantasia("LOJA MATRIZ");
		loja.setFone(empresa.getFone());
		loja.setIe(empresa.getIe());
		loja.setIm(empresa.getIm());
		loja.setRazaoSocial(empresa.getRazaoSocial());
		loja.setUf(empresa.getUf());
		loja.setWebSite(empresa.getWebSite());
		loja.setIeSubsTributaria(empresa.getIeSubsTributaria());
		loja.setDtInauguracao(empresa.getDtFundacao());
		loja.setEmpresa(empresa);
		System.out.println("Inserção de loja: " + daoLoja.insert(loja));
		return loja;
	}

	/**
	 * Tras todas as lojas da empresa
	 */
	public List<Loja> findAll() throws Exception {
		daoLoja.setEmpresa(getEmpresa());
		return daoLoja.findAll();
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public List<Loja> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loja> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public Loja insert(Loja loja) throws Exception {
		return daoLoja.insert(loja);
	}

	@Override
	public Loja update(Loja loja) throws Exception {
		return daoLoja.update(loja);
	}

}
