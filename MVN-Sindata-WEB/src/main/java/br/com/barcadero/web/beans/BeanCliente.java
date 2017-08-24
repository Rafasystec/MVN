package br.com.barcadero.web.beans;


import java.util.ArrayList; 
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import br.com.barcadero.core.enums.EnumEstadoCivil;
import br.com.barcadero.core.enums.EnumTipoLograd;
import br.com.barcadero.rule.RuleCliente;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean(name="cliente")
@ViewScoped
public class BeanCliente extends SuperBean <Cliente>{

	private static final long serialVersionUID = 5470117896075103063L;
	private Cliente	cliente			= null;
	private List<Cliente> clientes 	= null;
	@ManagedProperty("#{ruleCliente}")
	private RuleCliente ruleCliente = null;
	private Endereco endereco		= null;
	private Cliente selectedClie	= null;
	
	@PostConstruct
	public void init() {
		try {
			cliente		= new Cliente(getSession().getEmpresaLogada(), getSession().getUsuarioLogado());
			endereco	= new Endereco(getSession().getUsuarioLogado());
			clientes 	= ruleCliente.findByEmpresa(getEmpresaLogada());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			clientes = new ArrayList<Cliente>();
		}
	}
	
	public EnumTipoLograd[] getTpLogradouros() {
		return EnumTipoLograd.values();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if(cliente != null){
			this.cliente = cliente;
		}
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String salvar() throws Exception {
		cliente.setEndereco(endereco);
		ruleCliente.insert(cliente);
		HandleMessage.info("Salvo com sucesso!");
		return null;
	}
	
	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public	String deletar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public	String novo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public EnumEstadoCivil[] getEstadoCivil() {
		return EnumEstadoCivil.values();
	}
	
	public String teste() {
		System.out.println("Metodo teste");
		return null;
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void onRowSelect(SelectEvent event) {
       long codigo = ((Cliente)event.getObject()).getCodigo();
       System.out.println("Codigo do cliente selecionado " + codigo);
    }

	public Cliente getSelectedClie() {
		return selectedClie;
	}

	public void setSelectedClie(Cliente selectedClie) {
		this.selectedClie = selectedClie;
	}
	
	 public void buttonAction(ActionEvent actionEvent) {
		 System.out.println("Chamou action");
	 }

	public RuleCliente getRuleCliente() {
		return ruleCliente;
	}

	public void setRuleCliente(RuleCliente ruleCliente) {
		this.ruleCliente = ruleCliente;
	}

	@Override
	public boolean validar(Cliente entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<Cliente> getClientesCadastradosHoje() {
		return ruleCliente.conasultarClientesCadastradosDoDia(getEmpresaLogada());
	}
	
	
}
