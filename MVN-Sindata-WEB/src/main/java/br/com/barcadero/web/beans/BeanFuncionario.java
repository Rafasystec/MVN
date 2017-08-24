package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.rule.RuleFuncionario;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.tables.Funcionario;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean(name="funcionario")
@ViewScoped
public class BeanFuncionario extends SuperBean<Funcionario> {

	private static final long serialVersionUID = -199406563789273194L;
	private Funcionario funcionario;
	private Endereco endereco;
	@ManagedProperty("#{ruleFuncionario}")
	private RuleFuncionario ruleFuncionario;
	
	@PostConstruct
	private void init() {
		novoFuncionario();
		endereco		= new Endereco(getUsuarioLogado());
	}

	private void novoFuncionario() {
		funcionario 	= new Funcionario(getUsuarioLogado(),getEmpresaLogada());
	}
	
	@Override
	public String salvar() throws Exception {
		funcionario.setEndereco(endereco);
		ruleFuncionario.insert(funcionario);
		novoFuncionario();
		HandleMessage.info("Funcionário salvo com sucesso!");
		return null;
	}
	
	public List<Funcionario> getAll() {
		try {
			return ruleFuncionario.findByEmpresa(getEmpresaLogada());
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar() throws Exception {
		return ruleFuncionario.delete(funcionario.getCodigo());
	}

	@Override
	public String novo() throws Exception {
		novoFuncionario();
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

	public RuleFuncionario getRuleFuncionario() {
		return ruleFuncionario;
	}

	public void setRuleFuncionario(RuleFuncionario ruleFuncionario) {
		this.ruleFuncionario = ruleFuncionario;
	}

	@Override
	public boolean validar(Funcionario entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
