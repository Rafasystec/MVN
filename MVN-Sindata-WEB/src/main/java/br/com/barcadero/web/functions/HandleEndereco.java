package br.com.barcadero.web.functions;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import br.com.barcadero.core.enums.EnumTipoLograd;
import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.rule.FacadeBairro;
import br.com.barcadero.rule.FacadeCidade;
import br.com.barcadero.rule.FacadeEstado;
import br.com.barcadero.tables.Bairro;
import br.com.barcadero.tables.Cidade;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.tables.Estado;
import br.com.barcadero.web.beans.SuperBean;

@ManagedBean(name="ender")
@RequestScoped	
public class HandleEndereco extends SuperBean{

	private static final long serialVersionUID = -2770111081253143663L;
	private Endereco ender;
	private EnumUF[] uf;
	private FacadeEstado fcdEstado;
	private FacadeCidade fcdCidade;
	private FacadeBairro fcdBairro;
	private long codEstado;
	private long codCidade;
	private static List<Cidade> cidades;
	private static List<Bairro> bairros;
	
	public HandleEndereco() {
		fcdEstado = new FacadeEstado(getDataBaseSession());
		fcdCidade = new FacadeCidade(getDataBaseSession());
		fcdBairro = new FacadeBairro(getDataBaseSession());
	}
	
	public Endereco getEnder() {
		return ender;
	}

	public void setEnder(Endereco ender) {
		this.ender = ender;
	}

	public EnumUF[] getUf() {
		return EnumUF.values();
	}

	public void setUf(EnumUF[] uf) {
		this.uf = uf;
	}

	public FacadeEstado getFcdEstado() {
		return fcdEstado;
	}

	public void setFcdEstado(FacadeEstado fcdEstado) {
		this.fcdEstado = fcdEstado;
	}

	public FacadeCidade getFcdCidade() {
		return fcdCidade;
	}

	public void setFcdCidade(FacadeCidade fcdCidade) {
		this.fcdCidade = fcdCidade;
	}

	public FacadeBairro getFcdBairro() {
		return fcdBairro;
	}

	public void setFcdBairro(FacadeBairro fcdBairro) {
		this.fcdBairro = fcdBairro;
	}

	public long getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(long codEstado) {
		this.codEstado = codEstado;
		
	}

	public long getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(long codCidade) {
		this.codCidade = codCidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		HandleEndereco.cidades = cidades;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		HandleEndereco.bairros = bairros;
	}
	
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
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
	
	public List<Estado> getEstados() throws Exception {
		return fcdEstado.findAllEstados();
	}
	
	public EnumTipoLograd[] getTpLogradouros() {
		return EnumTipoLograd.values();
	}
	
	public List<Cidade> obterCidades() throws Exception {
		HandleEndereco.cidades = fcdCidade.getCidadesByCodEstado(getCodEstado()); 
		return HandleEndereco.cidades; 
	}
	
	public void hendleReturnCidades(SelectEvent event) throws Exception {
		HandleEndereco.cidades = fcdCidade.getCidadesByCodEstado(getCodEstado()); 
		System.out.println("hendleReturnCidades Evento event: " + event); 
	}
	
	public void hendleReturnBairros(SelectEvent event) throws Exception {
		HandleEndereco.bairros = fcdBairro.getBairrosByCodCidade(getCodCidade()); 
		System.out.println("hendleReturnBairros Evento event: " + event); 
	}
	
	public List<Bairro> obterBairros() throws Exception {
		HandleEndereco.bairros = fcdBairro.getBairrosByCodCidade(getCodCidade()); 
		return  HandleEndereco.bairros;
	}
	
	public void openCadCidade(ActionEvent event) throws Exception {
		HandleOpenEnderDialog.openCadCidade();
		System.out.println("cad cidade");
	}
	
	public void openCadBairro(ActionEvent event) throws Exception {
		HandleOpenEnderDialog.openCadBairro(String.valueOf(getCodCidade()));
		System.out.println("open popup bairro");
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
