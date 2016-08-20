package br.com.barcadero.rule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.core.enums.EnumRegimeTributario;
import br.com.barcadero.dao.DaoEmpresa;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.PessoaJuridica;
import br.com.barcadero.tables.Usuario;

@Service
public class RuleEmpresa extends RuleModelo<Empresa> {

	

	private DaoEmpresa daoEmpresa;
	private RuleLoja ruleLoja;
	private RulePessoaJuridica rulePessoaJuridica;
	@Autowired
	public RuleEmpresa(DaoEmpresa daoEmpresa, RuleLoja ruleLoja, RulePessoaJuridica rulePessoaJuridica) {
		System.out.println("Auto-generated constructor stub RuleEmpresa");
		this.daoEmpresa 		= daoEmpresa;
		this.ruleLoja			= ruleLoja;
		this.rulePessoaJuridica = rulePessoaJuridica;
	}
	
//	public RuleEmpresa(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		daoEmpresa  = new DaoEmpresa(empresa, loja, session);
//		ruleLoja	= new RuleLoja(empresa, loja, session);
//	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		Empresa empresa = (Empresa)entidade;
		retirarFormatcao(empresa);
		return daoEmpresa.insert(empresa);
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
	
	private void retirarFormatcao(Empresa empresa) {
		String cnpj = empresa.getPessoaJuridica().getCnpj();
		String fone = empresa.getPessoaJuridica().getFone();
		cnpj = cnpj.replace(".", "").replace("/", "").replace("-", "");
		fone = fone.replace("-", "").replace("(", "").replace(")", "");
		empresa.getPessoaJuridica().setCnpj(cnpj);
		empresa.getPessoaJuridica().setFone(fone);
	}
	
	/**
	 * Quando um usuario for inserido pela primeira vez, ele ja tera uma empresa e uma loja
	 * associado a ele, depois ele pode modficar os dados.
	 * @param usuario
	 * @throws Exception 
	 */
	public Empresa inserirEmpresaPadrao(Usuario usuario) throws Exception {
		Empresa empresa 	= new Empresa(usuario);
		PessoaJuridica pj	= new PessoaJuridica(usuario);
		empresa.setImgLogo("");
		empresa.setObservacoes("EMPRESA CRIADA JUNTO COM O USUARIO, ALTERE OS DADOS PARA OS DA SUA EMPRESA");
		//NOTE: Dados da pessoa juridica
		pj.setCnaeFiscal("");
		pj.setCnpj("00000000000000");
		pj.setCodRegTribut(EnumRegimeTributario.SIMPLES_NACIONAL);
		pj.setDtUltAlteracao(new Date());
		pj.setEmail(usuario.getEmail());
		pj.setFantasia("NOME FANTASIA");
		pj.setFone("000000000000");
		pj.setIe("0000000000");
		pj.setIeSubsTributaria("0000000000");
		pj.setIm("0000000000");
		pj.setRazaoSocial("RAZAO SOCIAL EMPRESA");
		pj.setUf("CE");
		pj.setWebSite("www.meusite.com.br");
		pj.setEnderecos(new ArrayList<Endereco>());
		rulePessoaJuridica.insert(pj);
		empresa.setPessoaJuridica(pj);
		List<Usuario> users = new ArrayList<Usuario>();
		users.add(usuario);
		empresa.setUsuarios(users);
		insert(empresa);
		List<Empresa> listEmp = new ArrayList<Empresa>();
		listEmp.add(empresa);
		usuario.setEmpresas(listEmp);
		//--------------------------------------------------------
		//NOTE: Inserir a loja Matriz
		//--------------------------------------------------------
		Loja loja = ruleLoja.inserirLojaMatriz(usuario, pj, empresa);
		List<Loja> lojas = new ArrayList<>();
		lojas.add(loja);
		empresa.setLojas(lojas);
		return empresa;
	}

	@Override
	public Empresa find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoEmpresa.find(codigo);
	}

	@Override
	public List<Empresa> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empresa> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Empresa> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
