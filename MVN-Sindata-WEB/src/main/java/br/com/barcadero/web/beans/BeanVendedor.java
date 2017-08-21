package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import br.com.barcadero.core.enums.EnumAtivo;
import br.com.barcadero.rule.RuleFuncionario;
import br.com.barcadero.rule.RuleVendedor;
import br.com.barcadero.tables.Funcionario;
import br.com.barcadero.tables.Vendedor;

@ManagedBean(name="vendedor")
@RequestScoped
public class BeanVendedor extends SuperBean<Vendedor> {

	private static final long serialVersionUID = 8726796444540957389L;
	private Vendedor vendedor;
	private Vendedor selectedVendedor;
	@ManagedProperty("#{ruleVendedor}")
	private RuleVendedor ruleVendedor;
	@ManagedProperty("#{ruleFuncionario}")
	private RuleFuncionario ruleFuncionario;
	private long codFuncionario;
	
	@PostConstruct
	private void init() {
		novoVendedor();
	}

	private void novoVendedor() {
		vendedor 		= new Vendedor(getEmpresaLogada(), getUsuarioLogado());
	}
	
	@Override
	public String salvar() throws Exception {
		vendedor.setFuncionario(ruleFuncionario.find(codFuncionario));
		ruleVendedor.insert(vendedor);
		novoVendedor();
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
		novoVendedor();
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

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar(Vendedor entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public RuleVendedor getRuleVendedor() {
		return ruleVendedor;
	}

	public void setRuleVendedor(RuleVendedor ruleVendedor) {
		this.ruleVendedor = ruleVendedor;
	}

	public RuleFuncionario getRuleFuncionario() {
		return ruleFuncionario;
	}

	public void setRuleFuncionario(RuleFuncionario ruleFuncionario) {
		this.ruleFuncionario = ruleFuncionario;
	}
	
	public List<Vendedor> getFindAll() {
		try {
			getRuleVendedor().setEmpresa(getEmpresaLogada());
			return getRuleVendedor().findAll();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public Vendedor getSelectedVendedor() {
		return selectedVendedor;
	}

	public void setSelectedVendedor(Vendedor selectedVendedor) {
		this.selectedVendedor = selectedVendedor;
	}

}
