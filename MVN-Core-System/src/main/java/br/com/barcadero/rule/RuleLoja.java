package br.com.barcadero.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.barcadero.dao.DaoLoja;
import br.com.barcadero.dao.DaoPessoaJuridica;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.PessoaJuridica;
import br.com.barcadero.tables.Usuario;

@Service
public class RuleLoja extends RuleModelo<Loja> {

	@Autowired
	private DaoLoja daoLoja;
	@Autowired
	private DaoPessoaJuridica daoPessoaJuridica;
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
	
	private String retirarFormatcaoCNPJ(Loja loja) {
		String cnpj = loja.getPessoaJuridica().getCnpj();
		cnpj = cnpj.replace(".", "").replace("/", "").replace("-", "");
		return cnpj;
	}
	
	private String retirarFormatcaoFone(Loja loja) {
		String fone = loja.getPessoaJuridica().getFone();
		fone = fone.replace("-", "").replace("(", "").replace(")", "");
		return fone;
	}
	
	/**
	 * Insere uma loja matriz em uma empresa recem criada.
	 * @param pj
	 * @param empresa
	 * @return
	 * @throws Exception
	 */
	public Loja inserirLojaMatriz(Usuario usuario,PessoaJuridica pj, Empresa empresa) throws Exception{
		PessoaJuridica pJuridica = new PessoaJuridica(usuario);
		List<Endereco> listEnder = new ArrayList<Endereco>();
	
		Loja loja = new Loja(usuario);
		pJuridica.setCnaeFiscal(pj.getCnaeFiscal());
		pJuridica.setCnpj(pj.getCnpj());
		pJuridica.setCodRegTribut(pj.getCodRegTribut());
		pJuridica.setDtCadastro(pj.getDtCadastro());
		pJuridica.setDtUltAlteracao(pj.getDtUltAlteracao());
		pJuridica.setEmail(pj.getEmail());
		pJuridica.setFantasia("LOJA MATRIZ");
		pJuridica.setFone(pj.getFone());
		pJuridica.setIe(pj.getIe());
		pJuridica.setIm(pj.getIm());
		pJuridica.setRazaoSocial(pj.getRazaoSocial());
		pJuridica.setUf(pj.getUf());
		pJuridica.setWebSite(pj.getWebSite());
		pJuridica.setEnderecos(listEnder);
		pJuridica.setIeSubsTributaria(pj.getIeSubsTributaria());
		if(pj.getEnderecos() != null && pj.getEnderecos().size() > 0){
			for (Endereco endereco : pj.getEnderecos()) {
				Endereco ender = new Endereco(usuario);
				ender.setCep(endereco.getCep());
				ender.setCodBairro(endereco.getCodBairro());
				ender.setLogradouro(endereco.getLogradouro());
				ender.setNumero(endereco.getNumero());
				ender.setPessoa(pJuridica);
				ender.setTipo(endereco.getTipo());
				ender.setTpLogradouro(endereco.getTpLogradouro());
				listEnder.add(ender);
			}
		}
		daoPessoaJuridica.insert(pJuridica);
		loja.setDtInauguracao(empresa.getDtFundacao());
		loja.setEmpresa(empresa);
		loja.setPessoaJuridica(pJuridica);
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
	public Loja insert(Loja entidade) throws Exception {
		entidade.getPessoaJuridica().setCnpj(retirarFormatcaoCNPJ(entidade));
		entidade.getPessoaJuridica().setFone(retirarFormatcaoFone(entidade));
		return daoLoja.insert(entidade);
	}

	@Override
	public Loja update(Loja loja) throws Exception {
		return daoLoja.update(loja);
	}

}
