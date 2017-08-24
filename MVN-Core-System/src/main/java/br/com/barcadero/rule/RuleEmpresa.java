package br.com.barcadero.rule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.core.enums.EnumRegimeTributario;
import br.com.barcadero.dao.DaoEmpresa;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;

@Service
public class RuleEmpresa extends RuleModelo<Empresa> {

	

	@Autowired
	private DaoEmpresa daoEmpresa;
	@Autowired
	private RuleLoja ruleLoja;

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void retirarFormatcao(Empresa empresa) {
		String cnpj = empresa.getCnpj();
		String fone = empresa.getFone();
		cnpj = cnpj.replace(".", "").replace("/", "").replace("-", "");
		fone = fone.replace("-", "").replace("(", "").replace(")", "");
		empresa.setCnpj(cnpj);
		empresa.setFone(fone);
	}
	
	/**
	 * Quando um usuario for inserido pela primeira vez, ele ja tera uma empresa e uma loja
	 * associado a ele, depois ele pode modficar os dados.
	 * @param usuario
	 * @throws Exception 
	 */
	public Empresa inserirEmpresaPadrao(Usuario usuario) throws Exception {
		Empresa empresa 	= new Empresa(usuario);
		
		empresa.setImgLogo("");
		empresa.setObservacoes("EMPRESA CRIADA JUNTO COM O USUARIO, ALTERE OS DADOS PARA OS DA SUA EMPRESA");
		//NOTE: Dados da pessoa juridica
		empresa.setCnaeFiscal("");
		empresa.setCnpj("00000000000000");
		empresa.setCodRegTribut(EnumRegimeTributario.SIMPLES_NACIONAL);
		empresa.setDtUltAlteracao(new Date());
		empresa.setEmail(usuario.getEmail());
		empresa.setFantasia("NOME FANTASIA");
		empresa.setFone("000000000000");
		empresa.setIe("0000000000");
		empresa.setIeSubsTributaria("0000000000");
		empresa.setIm("0000000000");
		empresa.setRazaoSocial("RAZAO SOCIAL EMPRESA");
		empresa.setUf("CE");
		empresa.setWebSite("www.meusite.com.br");
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
		Loja loja = ruleLoja.inserirLojaMatriz(usuario, empresa);
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


	@Override
	public Empresa insert(Empresa empresa) throws Exception {
		if(empresa != null){
			retirarFormatcao(empresa);
			if(empresa.getCodigo() > 0){
				return daoEmpresa.update(empresa);
			}else{
				return daoEmpresa.insert(empresa);
			}
		}else{
			return new Empresa();
		}
	}

	@Override
	public Empresa update(Empresa empresa) throws Exception {
		return daoEmpresa.update(empresa);
	}

}
