package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

//import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.event.SelectEvent;

import br.com.barcadero.core.enums.EnumAtividadeEmp;
import br.com.barcadero.core.enums.EnumRegimeTributario;
import br.com.barcadero.core.enums.EnumTipoLograd;
import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.rule.RuleBairro;
import br.com.barcadero.rule.RuleCidade;
import br.com.barcadero.rule.RuleEstado;
import br.com.barcadero.rule.RuleEmpresa;
import br.com.barcadero.rule.RuleLoja;
import br.com.barcadero.tables.Bairro;
import br.com.barcadero.tables.Cidade;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.tables.Estado;
import br.com.barcadero.tables.PessoaJuridica;
import br.com.barcadero.tables.Usuario;
import br.com.barcadero.web.functions.HandleOpenEnderDialog;
/**
 * Bean para salvar a empresa.
 * @author Rafael Rocha
 * @since 1.0 - dia 14/02/2016 as 19:31
 */
@ManagedBean(name="beanEmpresa")
@RequestScoped
public class BeanEmpresa extends SuperBean<Empresa> {

	private static final long serialVersionUID = 2807945448917304288L;
	private Empresa emp;
	private PessoaJuridica pj;
	private Endereco ender;
	private EnumRegimeTributario[] regime;
	private EnumAtividadeEmp[] atividade;
	private FileUpload fileUpload;
	//para o endereco
	private EnumUF[] uf;
	@ManagedProperty("#{ruleEmpresa}")
	private RuleEmpresa ruleEmpresa;
	@ManagedProperty("#{ruleEstado}")
	private RuleEstado ruleEstado;
	@ManagedProperty("#{ruleCidade}")
	private RuleCidade ruleCidade;
	@ManagedProperty("#{ruleBairro}")
	private RuleBairro ruleBairro;
	@ManagedProperty("#{ruleLoja}")
	private RuleLoja ruleLoja;
	private static long codEstado;
	private static long codCidade;
	private static List<Cidade> cidades;
	private static List<Bairro> bairros;
	
	public FileUpload getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(FileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}
	
	@PostConstruct
	private void init() {
		Usuario userLogado = getSession().getUsuarioLogado();
		emp 	= new Empresa(userLogado);
		pj 		= new PessoaJuridica(userLogado);
		ender 	= new Endereco(userLogado);
	}

//	public BeanEmpresa() {
//		Usuario userLogado = getSession().getUsuarioLogado();
//		emp 	= new Empresa(userLogado);
//		pj 		= new PessoaJuridica(userLogado);
//		ender 	= new Endereco(userLogado);
//		ruleEmpresa = new RuleEmpresa(getEmpresaLogada(),getLojaLogada(),getDataBaseSession());
//		fcdEstado	= new RuleEstado(getEmpresaLogada(),getLojaLogada(),getDataBaseSession());
//		fcdCidade	= new RuleCidade(getEmpresaLogada(),getLojaLogada(),getDataBaseSession());
//		//fcdBairro	= new RuleBairro(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
//		ruleLoja	= new RuleLoja(getEmpresaLogada(),getLojaLogada(),getDataBaseSession());
//		System.out.println("Bean Empresa was created.");
//	}
	
	public Empresa getEmp() {
		return emp;
	}

	public void setEmp(Empresa emp) {
		this.emp = emp;
	}

	public PessoaJuridica getPj() {
		return pj;
	}

	public void setPj(PessoaJuridica pj) {
		this.pj = pj;
	}

	public Endereco getEnder() {
		return ender;
	}

	public void setEnder(Endereco ender) {
		this.ender = ender;
	}
	
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		pj.setDtUltAlteracao(new Date());
		ender.setPessoa(pj);
		List<Endereco> listEnder = new ArrayList<Endereco>();
		listEnder.add(ender);
		pj.setEnderecos(listEnder);
		emp.setPessoaJuridica(pj);
		
		List<Usuario> users = new ArrayList<Usuario>();
		users.add(getUser());
		emp.setUsuarios(users);
		
		ruleEmpresa.insert(emp);
		incluirLojaMatriz(pj, emp);
		
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
		return ruleEstado.findAllEstados();
	}

	public EnumTipoLograd[] getTpLogradouros() {
		return EnumTipoLograd.values();
	}
	
	public EnumRegimeTributario[] getRegime() {
		return EnumRegimeTributario.values();
	}

	public void setRegime(EnumRegimeTributario[] regime) {
		this.regime = regime;
	}

	public EnumAtividadeEmp[] getAtividade() {
		return EnumAtividadeEmp.values();
	}

	public void setAtividade(EnumAtividadeEmp[] atividade) {
		this.atividade = atividade;
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
		BeanEmpresa.codEstado 		= codEstado;
		GlobalVariables.codEstado 	= codEstado;
	}
	
	public List<Cidade> getCidades() throws Exception {
		return BeanEmpresa.cidades;
	}
	
	public void setCidades(List<Cidade> cidades) throws Exception {
		if(cidades != null){
			BeanEmpresa.cidades = cidades;	
		}
		
	}
	
	public List<Bairro> getBairros() throws Exception {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		if(bairros != null){
			BeanEmpresa.bairros = bairros;
		}
	}

	public long getCodCidade() {
		return codCidade;
	}

	public void setCodCidade(long codCidade) {
		BeanEmpresa.codCidade		= codCidade;
		GlobalVariables.codCidade 	= codCidade;
	}
	
	/**
	 * Depreciado. Utilizar a classe br.com.barcadero.web.function.HandleEndereco
	 */
	@Deprecated
	public List<Cidade> obterCidades() throws Exception {
		System.out.println("Obter as cidades pelo codigo Estado: " + getCodEstado());
		BeanEmpresa.cidades = ruleCidade.getCidadesByCodEstado(getCodEstado()); 
		return BeanEmpresa.cidades; 
	}
	/**
	 * Depreciado. Utilizar a classe br.com.barcadero.web.function.HandleEndereco
	 */
	@Deprecated
	public void hendleReturnCidades(SelectEvent event) throws Exception {
		BeanEmpresa.cidades = ruleCidade.getCidadesByCodEstado(getCodEstado()); 
		System.out.println("hendleReturnCidades Evento event: " + event); 
	}
	/**
	 * Depreciado. Utilizar a classe br.com.barcadero.web.function.HandleEndereco
	 */
	@Deprecated
	public void hendleReturnBairros(SelectEvent event) throws Exception {
		BeanEmpresa.bairros = ruleBairro.getBairrosByCodCidade(getCodCidade()); 
		System.out.println("hendleReturnBairros Evento event: " + event); 
	}
	/**
	 * Depreciado. Utilizar a classe br.com.barcadero.web.function.HandleEndereco
	 */
	@Deprecated
	public List<Bairro> obterBairros() throws Exception {
		System.out.println("Obter os bairros pelo codigo da Cidade: " + getCodCidade());
		BeanEmpresa.bairros = ruleBairro.getBairrosByCodCidade(getCodCidade()); 
		return  BeanEmpresa.bairros;
	}
	/**
	 * Depreciado. Utilizar a classe br.com.barcadero.web.function.HandleEndereco
	 */
	@Deprecated
	public void openCadCidade(ActionEvent event) throws Exception {
		HandleOpenEnderDialog.openCadCidade();
		System.out.println("cad cidade");
	}
	/**
	 * Depreciado. Utilizar a classe br.com.barcadero.web.function.HandleEndereco
	 */
	@Deprecated
	public void openCadBairro(ActionEvent event) throws Exception {
		HandleOpenEnderDialog.openCadBairro();
		System.out.println("open popup bairro");
	}
	
	public Usuario getUser() {
		return SessionContext.getInstance().getUsuarioLogado();
	}
	
	private void incluirLojaMatriz(PessoaJuridica pj, Empresa empresa) throws Exception{
		ruleLoja.inserirLojaMatriz(getSession().getUsuarioLogado(), pj,empresa);
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public RuleEmpresa getRuleEmpresa() {
		return ruleEmpresa;
	}

	public void setRuleEmpresa(RuleEmpresa ruleEmpresa) {
		this.ruleEmpresa = ruleEmpresa;
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

	public RuleLoja getRuleLoja() {
		return ruleLoja;
	}

	public void setRuleLoja(RuleLoja ruleLoja) {
		this.ruleLoja = ruleLoja;
	}

	@Override
	public boolean validar(Empresa entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	
}
