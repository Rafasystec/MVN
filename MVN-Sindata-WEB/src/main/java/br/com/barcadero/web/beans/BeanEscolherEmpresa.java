package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleLoja;
import br.com.systeconline.controller.SessionContext;
import br.com.systeconline.sindata.beans.SuperBean;
import br.com.systeconline.tables.basicos.Empresa;
import br.com.systeconline.tables.basicos.Loja;
import br.com.systeconline.tables.basicos.PessoaJuridica;
import br.com.systeconline.tables.basicos.Usuario;

@ManagedBean(name="escolherEmp")
@RequestScoped
public class BeanEscolherEmpresa extends SuperBean {
	
	private static final long serialVersionUID = -2187058014897135548L;
	private List<Loja> lojas;
	private long codEmp;
	private long codLoja;
	private RuleLoja ruleLoja;
	
	public BeanEscolherEmpresa() {
		// TODO Auto-generated constructor stub
		ruleLoja = new RuleLoja(getDataBaseSession());
		System.out.println("Instanciou o bean: " + BeanEscolherEmpresa.class.getName());
		
	}
	
	private Usuario user;
	private PessoaJuridica pJuridica;
	
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
	
	
	public List<Empresa> getEmpresa() {
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
		lojas = ruleLoja.getLojasDaEmpresa(getCodEmp());
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
		}
	}
	
	public String entrar() throws Exception{
		
		System.out.println("Entrar no sistema pela empresa!");
		Empresa emp = null;
		for (Empresa empresa : getEmpresa()) {
			if(empresa.getCodigo() == getCodEmp()){
				emp = empresa;
			}
		}
		if(emp == null){
			return null;
		}
		getSession().setEmpresa(emp);
		return "index";
	}

	public long getCodLoja() {
		return codLoja;
	}

	public void setCodLoja(long codLoja) {
		this.codLoja = codLoja;
	}
	

}
