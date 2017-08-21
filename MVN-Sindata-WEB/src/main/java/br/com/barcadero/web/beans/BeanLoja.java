package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.core.enums.EnumRegimeTributario;
import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.rule.RuleLoja;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.PessoaJuridica;
import br.com.barcadero.tables.Usuario;

@ManagedBean(name="loja")
@ViewScoped
public class BeanLoja extends SuperBean<Loja> {

	private static final long serialVersionUID = 444117878813938158L;
	private PessoaJuridica pj;
	@ManagedProperty("#{ruleLoja}")
	private RuleLoja ruleLoja;
	private Loja loja;
	private Loja selectedLoja;
	private Endereco endereco		= null;
	private EnumRegimeTributario[] regime;
	private EnumUF[] uf;
	private long codEmpresa;
	
	@PostConstruct
	private void init() {
		Usuario userLogado = getSession().getUsuarioLogado();
		pj 		= new PessoaJuridica(userLogado);
		endereco	= new Endereco(getUsuarioLogado());
		loja	= new Loja(userLogado);
	}
	
	
//	public BeanLoja() {
//		Usuario userLogado = getSession().getUsuarioLogado();
//		pj 		= new PessoaJuridica(userLogado);
//		ender	= new Endereco(userLogado);
//		loja	= new Loja(userLogado);
//		ruleLoja = new RuleLoja(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
//		System.out.println("BeanLoja was created!");
//	}
	
	public PessoaJuridica getPj() {
		return pj;
	}

	public void setPj(PessoaJuridica pj) {
		this.pj = pj;
	}
	
	public EnumRegimeTributario[] getRegime() {
		return EnumRegimeTributario.values();
	}

	public void setRegime(EnumRegimeTributario[] regime) {
		this.regime = regime;
	}
	
	public EnumUF[] getUf() {
		return EnumUF.values();
	}

	public void setUf(EnumUF[] uf) {
		this.uf = uf;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	@Override
	public String salvar() throws Exception {
		try {
			System.out.println("Salvar method involked");
			pj.setDtUltAlteracao(new Date());
			endereco.setPessoa(pj);
			List<Endereco> listEnder = new ArrayList<Endereco>();
			listEnder.add(endereco);
			pj.setEnderecos(listEnder);
			loja.setPessoaJuridica(pj);
			loja.setEmpresa(getSession().getEmpresaLogada());
			ruleLoja.insert(loja);
			return "";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public long getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(long codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	
	public List<Loja> getLojasPorEmpresa() throws Exception {
		return ruleLoja.getLojasDaEmpresa(getCodEmpresa());
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public RuleLoja getRuleLoja() {
		return ruleLoja;
	}

	public void setRuleLoja(RuleLoja ruleLoja) {
		this.ruleLoja = ruleLoja;
	}


	@Override
	public boolean validar(Loja entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Loja> getLojasDaEmpresa() {
		getRuleLoja().setEmpresa(getEmpresaLogada());
		try {
			return getRuleLoja().findAll();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}


	public Loja getSelectedLoja() {
		return selectedLoja;
	}


	public void setSelectedLoja(Loja selectedLoja) {
		this.selectedLoja = selectedLoja;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
