package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.barcadero.rule.RuleLoja;
import br.com.systeconline.core.enums.EnumRegimeTributario;
import br.com.systeconline.core.enums.EnumUF;
import br.com.systeconline.sindata.beans.SuperBean;
import br.com.systeconline.tables.basicos.Endereco;
import br.com.systeconline.tables.basicos.Loja;
import br.com.systeconline.tables.basicos.PessoaJuridica;
import br.com.systeconline.tables.basicos.Usuario;

@ManagedBean(name="loja")
public class BeanLoja extends SuperBean {

	private static final long serialVersionUID = 444117878813938158L;
	private PessoaJuridica pj;
	private Endereco ender;
	private RuleLoja ruleLoja;
	private Loja loja;
	private EnumRegimeTributario[] regime;
	private EnumUF[] uf;
	
	public BeanLoja() {
		Usuario userLogado = getSession().getUsuarioLogado();
		pj 		= new PessoaJuridica(userLogado);
		ender	= new Endereco(userLogado);
		loja	= new Loja(userLogado);
		ruleLoja = new RuleLoja(getDataBaseSession());
		System.out.println("BeanLoja was created!");
	}
	
	public PessoaJuridica getPj() {
		return pj;
	}

	public void setPj(PessoaJuridica pj) {
		this.pj = pj;
	}

	public Endereco getEnder() {
		return ender;
	}

	public void setEnder(Endereco ender) {
		this.ender = ender;
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
		// TODO Auto-generated method stub
		try {
			pj.setDtUltAlteracao(new Date());
			ender.setPessoa(pj);
			List<Endereco> listEnder = new ArrayList<Endereco>();
			listEnder.add(ender);
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

}
