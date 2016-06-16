package br.com.barcadero.rule;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoLoja;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.PessoaJuridica;
import br.com.barcadero.tables.Usuario;


public class RuleLoja extends RuleModelo {

	private DaoLoja daoLoja;
	public RuleLoja(Session session) {
		super(session);
		daoLoja = new DaoLoja(session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		Loja loja = (Loja)entidade;
		retirarFormatcao(loja);
		return daoLoja.insert(loja);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoLoja.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		Loja loja = (Loja)entidade;
		return daoLoja.update(loja);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return (Loja)daoLoja.find(codigo);
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
	
	private void retirarFormatcao(Loja loja) {
		String cnpj = loja.getPessoaJuridica().getCnpj();
		String fone = loja.getPessoaJuridica().getFone();
		cnpj = cnpj.replace(".", "").replace("/", "").replace("-", "");
		fone = fone.replace("-", "").replace("(", "").replace(")", "");
		loja.getPessoaJuridica().setCnpj(cnpj);
		loja.getPessoaJuridica().setFone(fone);
	}
	
	/**
	 * Insere uma loja matriz em uma empresa recem criada.
	 * @param pj
	 * @param empresa
	 * @return
	 * @throws Exception
	 */
	public String inserirLojaMatriz(Usuario usuario,PessoaJuridica pj, Empresa empresa) throws Exception{
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
		loja.setDtInauguracao(empresa.getDtFundacao());
		loja.setEmpresa(empresa);
		loja.setPessoaJuridica(pJuridica);
		return daoLoja.insert(loja);
	}
	
	public String insertLojaHomo() throws Exception {
		Loja loja = (Loja) daoLoja.find(1L);
		
		return null;
	}

}
