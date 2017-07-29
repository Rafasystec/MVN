package br.com.barcadero.web.beans;

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
	@ManagedProperty("#{ruleVendedor}")
	private RuleVendedor ruleVendedor;
	@ManagedProperty("#{ruleFuncionario}")
	private RuleFuncionario ruleFuncionario;
	private long codFuncionario;
	
	@PostConstruct
	private void init() {
		vendedor 		= new Vendedor(getEmpresaLogada(), getUsuarioLogado());
	}
	
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		vendedor.setFuncionario((Funcionario)ruleFuncionario.find(codFuncionario));
		ruleVendedor.insert(vendedor);
		vendedor = new Vendedor(getEmpresaLogada(), getUsuarioLogado());
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

}
