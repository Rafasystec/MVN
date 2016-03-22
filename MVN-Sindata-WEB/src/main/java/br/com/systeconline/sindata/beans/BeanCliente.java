package br.com.systeconline.sindata.beans;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.systeconline.core.enums.EnumEstadoCivil;
import br.com.systeconline.core.enums.EnumTipoLograd;
import br.com.systeconline.rule.FacadeCliente;
import br.com.systeconline.tables.basicos.Cliente;
import br.com.systeconline.tables.basicos.Endereco;
import br.com.systeconline.tables.basicos.PessoaFisica;

@ManagedBean(name="cliente")
@RequestScoped
public class BeanCliente extends SuperBean {

	private static final long serialVersionUID = 5470117896075103063L;
	private Cliente	cliente		= null;
	private PessoaFisica pFisica= null;
	private FacadeCliente fcdCliente;
	private Endereco endereco	= null;

	public BeanCliente() {
		// TODO Auto-generated constructor stub
		fcdCliente  = new FacadeCliente(getDataBaseSession());
		cliente		= new Cliente(getSession().getEmpresaLogada(), getSession().getUsuarioLogado());
		endereco	= new Endereco(getSession().getUsuarioLogado());
		pFisica		= new PessoaFisica(getSession().getUsuarioLogado());
		System.out.println("Bean cliente was created.");
	}
	
	public EnumTipoLograd[] getTpLogradouros() {
		return EnumTipoLograd.values();
	}

	public PessoaFisica getpFisica() {
		return pFisica;
	}

	public void setpFisica(PessoaFisica pFisica) {
		this.pFisica = pFisica;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String salvar() throws Exception {
		List<Endereco> listEnder = new ArrayList<Endereco>();
		listEnder.add(endereco);
		pFisica.setEnderecos(listEnder);
		cliente.setPessoaFisica(pFisica);
		endereco.setPessoa(pFisica);
		System.out.println(fcdCliente.insert(cliente));
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
	
}
