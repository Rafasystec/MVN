package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.backoffice.RuleFuncionario;
import br.com.barcadero.rule.backoffice.RuleVendedor;
import br.com.systeconline.core.enums.EnumAtivo;
import br.com.systeconline.sindata.beans.SuperBean;
import br.com.systeconline.tables.basicos.Funcionario;
import br.com.systeconline.tables.basicos.Vendedor;

@ManagedBean(name="vendedor")
@RequestScoped
public class BeanVendedor extends SuperBean {

	private static final long serialVersionUID = 8726796444540957389L;
	private Vendedor vendedor;
	private RuleVendedor ruleVendedor;
	private RuleFuncionario ruleFuncionario;
	private long codFuncionario;
	
	public BeanVendedor() {
		// TODO Auto-generated constructor stub
		vendedor 		= new Vendedor(getLojaLogada(), getUsuarioLogado());
		ruleVendedor 	= new RuleVendedor(getDataBaseSession());
		ruleFuncionario = new RuleFuncionario(getDataBaseSession());
	}
	
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		vendedor.setFuncionario((Funcionario)ruleFuncionario.find(codFuncionario));
		ruleVendedor.insert(vendedor);
		vendedor = new Vendedor(getLojaLogada(), getUsuarioLogado());
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

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public EnumAtivo[] getAtivos() {
		return EnumAtivo.values();
	}

	public long getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(long codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

}
