package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.barcadero.dao.DaoVeiculoCliente;
import br.com.barcadero.tables.VeiculoCliente;

@ManagedBean
public class BeanVeiculoCliente extends SuperBean<VeiculoCliente> {

	private static final long serialVersionUID = 4902274005698592024L;

	private VeiculoCliente veiculoCliente;
	
	public BeanVeiculoCliente() {
		// TODO Auto-generated constructor stub
		veiculoCliente = new VeiculoCliente();
	}
	
	@ManagedProperty(name="daoVeiculo",value="#{daoVeiculoCliente}")
	private DaoVeiculoCliente daoVeiculo;
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		daoVeiculo.insert(veiculoCliente);
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

	public DaoVeiculoCliente getDaoVeiculo() {
		return daoVeiculo;
	}

	public void setDaoVeiculo(DaoVeiculoCliente daoVeiculo) {
		this.daoVeiculo = daoVeiculo;
	}

	public VeiculoCliente getVeiculoCliente() {
		return veiculoCliente;
	}

	public void setVeiculoCliente(VeiculoCliente veiculoCliente) {
		this.veiculoCliente = veiculoCliente;
	}

	@Override
	public boolean validar(VeiculoCliente entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
