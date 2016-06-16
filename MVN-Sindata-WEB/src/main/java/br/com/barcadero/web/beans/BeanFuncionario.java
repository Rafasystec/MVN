package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleFuncionario;
import br.com.barcadero.tables.Funcionario;

@ManagedBean(name="funcionario")
@RequestScoped
public class BeanFuncionario extends SuperBean {

	private static final long serialVersionUID = -199406563789273194L;
	private Funcionario funcionario;
	private RuleFuncionario ruleFuncionario;
	
	public BeanFuncionario() {
		// TODO Auto-generated constructor stub
		funcionario = new Funcionario();
		ruleFuncionario = new RuleFuncionario(getDataBaseSession());
	}
	
	
	@Override
	public String salvar() throws Exception {
		System.out.println("Salvar funcionario was called");
		ruleFuncionario.insert(funcionario);
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


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
