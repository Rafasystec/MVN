package br.com.barcadero.web.functions;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import br.com.barcadero.core.enums.EnumTipoLograd;
import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.rule.RuleBairro;
import br.com.barcadero.rule.RuleCidade;
import br.com.barcadero.rule.RuleEstado;
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
	private EnumUF ufSelected;
	private RuleEstado fcdEstado;
	private RuleCidade fcdCidade;
	private RuleBairro fcdBairro;
	private long codEstado;
	private long codCidade;
	private static List<Cidade> cidades;
	private static List<Bairro> bairros;
	
	public HandleEndereco() {
		fcdEstado = new RuleEstado(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
		fcdCidade = new RuleCidade(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
		//fcdBairro = new RuleBairro(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
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

	public RuleEstado getFcdEstado() {
		return fcdEstado;
	}

	public void setFcdEstado(RuleEstado fcdEstado) {
		this.fcdEstado = fcdEstado;
	}

	public RuleCidade getFcdCidade() {
		return fcdCidade;
	}

	public void setFcdCidade(RuleCidade fcdCidade) {
		this.fcdCidade = fcdCidade;
	}

	public RuleBairro getFcdBairro() {
		return fcdBairro;
	}

	public void setFcdBairro(RuleBairro fcdBairro) {
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
		HandleEndereco.cidades = fcdCidade.getCidadesByUF(getUfSelected()); 
		return HandleEndereco.cidades; 
	}
	
	public void hendleReturnCidades(SelectEvent event) throws Exception {
		HandleEndereco.cidades = fcdCidade.getCidadesByUF(getUfSelected()); 
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
	
	public void openCadCidade(ActionEvent actionEvent){
		try {
			HandleOpenEnderDialog.openCadCidade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("cad cidade");
	}
	
	public void getOpen() {
		System.out.println("Openned");
	}
	
	
	
	public void openCadBairro(ActionEvent event){
		try {
			HandleOpenEnderDialog.openCadBairro(String.valueOf(getCodCidade()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("open popup bairro");
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public EnumUF getUfSelected() {
		return ufSelected;
	}

	public void setUfSelected(EnumUF ufSelected) {
		this.ufSelected = ufSelected;
	}
	
}
