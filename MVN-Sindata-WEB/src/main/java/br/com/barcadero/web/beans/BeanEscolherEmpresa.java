package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleEmpresa;
import br.com.barcadero.rule.RuleLoja;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.PessoaJuridica;
import br.com.barcadero.tables.Usuario;

@ManagedBean(name="escolherEmp")
@RequestScoped
public class BeanEscolherEmpresa extends SuperBean {
	
	private static final long serialVersionUID = -2187058014897135548L;
	private List<Loja> lojas;
	private long codEmp;
	private long codLoja;
	@ManagedProperty("#{ruleLoja}")
	private RuleLoja ruleLoja;
	@ManagedProperty("#{ruleEmpresa}")
	private RuleEmpresa ruleEmpresa; 
	private Usuario user;
	private PessoaJuridica pJuridica;
	private Empresa empresa;
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
	
	public Usuario obterUsuario() {
		user = SessionContext.getInstance().getUsuarioLogado();
		return user;
	}
	
	
	public List<Empresa> getEmpresas() {
		user = SessionContext.getInstance().getUsuarioLogado();
		List<Empresa> list = user.getEmpresas();
		if(list != null){
			for (Empresa empresa : list) {
				System.out.println("Empresa: " + empresa.getPessoaJuridica().getFantasia());
			}
		}else{
			list = new ArrayList<Empresa>();
		}
		return list;
	}

	public PessoaJuridica getpJuridica() {
		return pJuridica;
	}

	public void setpJuridica(PessoaJuridica pJuridica) {
		this.pJuridica = pJuridica;
	}

	public List<Loja> getLojas() throws Exception {
		//lojas = ruleLoja.getLojasDaEmpresa(getCodEmp());
		lojas = ruleLoja.getLojasDaEmpresa(getEmpresa());
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		if(lojas != null){
			this.lojas = lojas;
		}
	}

	public long getCodEmp() {
		return getSession().getTempCodEmp();
	}

	public void setCodEmp(long codEmp) {
		if(codEmp != 0){
			this.codEmp = codEmp;
			getSession().setTempCodEmp(codEmp);
			try {
				Empresa empresa = ruleEmpresa.find(codEmp);
				setEmpresa(empresa);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String entrar() throws Exception{
		
		System.out.println("Entrar no sistema pela empresa!");
		Empresa emp 	= null;
		Loja lojaLog	= null;
		for (Empresa empresa : getEmpresas()) {
			if(empresa.getCodigo() == getCodEmp()){
				emp = empresa;
			}
		}
		if(emp == null){
			return null;
		}
		
		setEmpresa(emp);
		
		for (Loja loja : getLojas()) {
			if(loja.getCodigo() == getCodLoja()){
				lojaLog = loja;
				continue;
			}
		}
		
		if(lojaLog == null){
			return null;
		}
		
		getSession().setLojaLogada(lojaLog);
		getSession().setEmpresa(emp);
		return "index";
	}

	public long getCodLoja() {
		return codLoja;
	}

	public void setCodLoja(long codLoja) {
		this.codLoja = codLoja;
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

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public RuleEmpresa getRuleEmpresa() {
		return ruleEmpresa;
	}

	public void setRuleEmpresa(RuleEmpresa ruleEmpresa) {
		this.ruleEmpresa = ruleEmpresa;
	}
	

}
