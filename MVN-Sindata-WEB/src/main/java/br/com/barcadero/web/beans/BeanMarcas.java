package br.com.barcadero.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.core.enums.EnumTipoMarca;
import br.com.barcadero.rule.RuleMarcas;
import br.com.barcadero.tables.Marcas;

@ManagedBean
@RequestScoped
public class BeanMarcas extends SuperBean {

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{ruleMarcas}")
	RuleMarcas ruleMarcas;
	Marcas marcas;
	private EnumTipoMarca[] tipoMarcas;
	
	@PostConstruct
	private void init() {
		marcas	= new Marcas(getEmpresaLogada(), getUsuarioLogado()); 
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		ruleMarcas.insert(marcas);
		marcas = new Marcas(getEmpresaLogada(), getUsuarioLogado());
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

	public Marcas getMarcas() {
		return marcas;
	}

	public void setMarcas(Marcas marcas) {
		this.marcas = marcas;
	}
	
	public EnumTipoMarca[] getTipoMarcas() {
		return EnumTipoMarca.values();
	}

	public RuleMarcas getRuleMarcas() {
		return ruleMarcas;
	}

	public void setRuleMarcas(RuleMarcas ruleMarcas) {
		this.ruleMarcas = ruleMarcas;
	}

}
