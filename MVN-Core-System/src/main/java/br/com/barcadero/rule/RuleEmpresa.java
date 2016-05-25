package br.com.barcadero.rule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoEmpresa;
import br.com.systeconline.core.enums.EnumAtividadeEmp;
import br.com.systeconline.core.enums.EnumRegimeTributario;
import br.com.systeconline.core.enums.EnumUF;
import br.com.systeconline.rule.RuleModelo;
import br.com.systeconline.tables.basicos.Empresa;
import br.com.systeconline.tables.basicos.Endereco;
import br.com.systeconline.tables.basicos.Entidade;
import br.com.systeconline.tables.basicos.PessoaJuridica;
import br.com.systeconline.tables.basicos.Usuario;

public class RuleEmpresa extends RuleModelo {

	private DaoEmpresa daoEmpresa;
	private RuleLoja ruleLoja;
	public RuleEmpresa(Session session) {
		super(session);
		daoEmpresa  = new DaoEmpresa(session);
		ruleLoja	= new RuleLoja(session);
	}

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

	@Override
	public Entidade find(long codigo) throws Exception {
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
	public void inserirEmpresaPadrao(Usuario usuario) throws Exception {
		Empresa empresa 	= new Empresa(usuario);
		PessoaJuridica pj	= new PessoaJuridica(usuario);
		empresa.setImgLogo("");
		empresa.setObservacoes("EMPRESA CRIADA JUNCO COM O USUARIO, ALTERE OS DADOS PARA OS DA SUA EMPRESA");
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
		empresa.setPessoaJuridica(pj);
		List<Usuario> users = new ArrayList<Usuario>();
		users.add(usuario);
		empresa.setUsuarios(users);
		insert(empresa);
		List<Empresa> listEmp = new ArrayList<Empresa>();
		listEmp.add(empresa);
		usuario.setEmpresas(listEmp);
		//NOTE: Inserir a loja Matriz
		ruleLoja.inserirLojaMatriz(usuario, pj, empresa);
	}

}
