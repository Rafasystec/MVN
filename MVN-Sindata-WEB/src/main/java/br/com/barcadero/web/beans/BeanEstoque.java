package br.com.barcadero.web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleEstoque;
import br.com.barcadero.rule.RuleProduto;
import br.com.barcadero.tables.Estoque;
import br.com.barcadero.tables.Produto;

@ManagedBean
@RequestScoped
public class BeanEstoque extends SuperBean {

	private static final long serialVersionUID = 2638846429735720878L;
	private String paramProd;
	private List<Estoque> estoques;
	private Estoque selectedEstoque;
	private Estoque estoque;
	private Produto produto;
	private long codProduto;
	@ManagedProperty("#{ruleProduto}")
	private RuleProduto ruleProduto;
	@ManagedProperty("#{ruleEstoque}")
	private RuleEstoque ruleEstoque;
	
	@PostConstruct
	private void init() {
		estoque		= new Estoque(getEmpresaLogada(), getUsuarioLogado());
	}
//	public BeanEstoque() {
//		//ruleProduto = new RuleProduto(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
//		ruleEstoque	= new RuleEstoque(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
//		estoque		= new Estoque(getEmpresaLogada(), getUsuarioLogado());
//	}
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		codProduto = ruleProduto.extrairCodigo(paramProd);
		produto = ruleProduto.find(codProduto);
		estoque.setProduto(produto);
		ruleEstoque.insert(estoque);
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

	public String getParamProd() {
		return paramProd;
	}

	public void setParamProd(String paramProd) {
		this.paramProd = paramProd;
	}
	
	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(long codProduto) {
		this.codProduto = codProduto;
	}

	public List<Estoque> getEstoques() throws Exception {
		return ruleEstoque.findAll();
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque getSelectedEstoque() {
		return selectedEstoque;
	}

	public void setSelectedEstoque(Estoque selectedEstoque) {
		this.selectedEstoque = selectedEstoque;
	}
}
