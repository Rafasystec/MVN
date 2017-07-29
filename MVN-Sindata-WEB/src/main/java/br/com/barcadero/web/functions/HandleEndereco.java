package br.com.barcadero.web.functions;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
public class HandleEndereco {

	private static final long serialVersionUID = -2770111081253143663L;
	private Endereco ender;
	private EnumUF[] uf;
	private EnumUF ufSelected;
	@ManagedProperty("#{ruleEstado}")
	private RuleEstado ruleEstado;
	@ManagedProperty("#{ruleCidade}")
	private RuleCidade ruleCidade;
	@ManagedProperty("#{ruleBairro}")
	private RuleBairro ruleBairro;
	private long codEstado;
	private long codCidade;
	private static List<Cidade> cidades;
	private static List<Bairro> bairros;
	
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
	
	
	public List<Estado> getEstados() throws Exception {
		return ruleEstado.findAllEstados();
	}
	
	public EnumTipoLograd[] getTpLogradouros() {
		return EnumTipoLograd.values();
	}
	
	public List<Cidade> obterCidades() throws Exception {
		HandleEndereco.cidades = ruleCidade.getCidadesByUF(getUfSelected()); 
		return HandleEndereco.cidades; 
	}
	
	public void hendleReturnCidades(SelectEvent event) throws Exception {
		HandleEndereco.cidades = ruleCidade.getCidadesByUF(getUfSelected()); 
		System.out.println("hendleReturnCidades Evento event: " + event); 
	}
	
	public void hendleReturnBairros(SelectEvent event) throws Exception {
		HandleEndereco.bairros = ruleBairro.getBairrosByCodCidade(getCodCidade()); 
		System.out.println("hendleReturnBairros Evento event: " + event); 
	}
	
	public List<Bairro> obterBairros() throws Exception {
		HandleEndereco.bairros = ruleBairro.getBairrosByCodCidade(getCodCidade()); 
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

	public EnumUF getUfSelected() {
		return ufSelected;
	}

	public void setUfSelected(EnumUF ufSelected) {
		this.ufSelected = ufSelected;
	}

	public RuleEstado getRuleEstado() {
		return ruleEstado;
	}

	public void setRuleEstado(RuleEstado ruleEstado) {
		this.ruleEstado = ruleEstado;
	}

	public RuleCidade getRuleCidade() {
		return ruleCidade;
	}

	public void setRuleCidade(RuleCidade ruleCidade) {
		this.ruleCidade = ruleCidade;
	}

	public RuleBairro getRuleBairro() {
		return ruleBairro;
	}

	public void setRuleBairro(RuleBairro ruleBairro) {
		this.ruleBairro = ruleBairro;
	}
	
}
