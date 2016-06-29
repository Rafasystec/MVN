package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleFuncionario;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.tables.Funcionario;

@ManagedBean(name="funcionario")
@RequestScoped
public class BeanFuncionario extends SuperBean {

	private static final long serialVersionUID = -199406563789273194L;
	private Funcionario funcionario;
	private Endereco endereco;
	private RuleFuncionario ruleFuncionario;
	
	public BeanFuncionario() {
		// TODO Auto-generated constructor stub
		funcionario 	= new Funcionario();
		ruleFuncionario = new RuleFuncionario(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
		endereco		= new Endereco(getUsuarioLogado());
	}
	
	
	@Override
	public String salvar() throws Exception {
		System.out.println("Salvar funcionario was called");
		List<Endereco> listEnder = new ArrayList<Endereco>();
		listEnder.add(endereco);
		funcionario.getPessoaFisica().setEnderecos(listEnder);
		ruleFuncionario.insert(funcionario);
		funcionario = new Funcionario(getUsuarioLogado());
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


	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
