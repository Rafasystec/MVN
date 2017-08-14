package br.com.barcadero.web.beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.barcadero.core.enums.EnumCSTICMS;
import br.com.barcadero.core.enums.EnumCSTIPI;
import br.com.barcadero.core.enums.EnumCSTPIS;
import br.com.barcadero.core.enums.EnumOrigemCSTICMS;
import br.com.barcadero.core.enums.EnumUnidadeMedida;
import br.com.barcadero.rule.RuleProduto;
import br.com.barcadero.tables.Produto;

@ManagedBean(name="produto")
public class BeanProduto extends SuperBean<Produto> {


	private static final long serialVersionUID = 5793307604069729331L;
	private List<Produto> produtosSelecionados;
	private Produto produto;
	
	@ManagedProperty(name="ruleProduto",value="#{ruleProduto}")
	private RuleProduto ruleProduto;
	
	public BeanProduto() {
		produto		= new Produto(getSession().getEmpresaLogada(), null);
	}
	
	public EnumCSTICMS[] getCstIcms() {
		return EnumCSTICMS.values();
	}

	public EnumUnidadeMedida[] getMedidas() {
		return EnumUnidadeMedida.values();
	}

	public EnumCSTIPI[] getCstIpi() {
		return EnumCSTIPI.values();
	}
	public EnumOrigemCSTICMS[] getOrigensIcms() {
		return EnumOrigemCSTICMS.values();
	}
	public List<Produto> getProdutos() throws Exception {
		return ruleProduto.findByDataCadastro(new Date());
	}

	public List<Produto> getProdutosSelecionados() {
		return produtosSelecionados;
	}

	public void setProdutosSelecionados(List<Produto> produtosSelecionados) {
		this.produtosSelecionados = produtosSelecionados;
	}

	public EnumCSTPIS[] getCstPis() {
		return EnumCSTPIS.values();
	}
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String salvar() throws Exception {
		ruleProduto.insert(produto);
		novo();
		return null;
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ruleProduto.update(produto));
		return null;
	}

	@Override
	public String deletar() throws Exception {
		// TODO Auto-generated method stub
		for (Produto produto : produtosSelecionados) {
			String result = ruleProduto.delete(produto.getCodigo());
			System.out.println(result);
		}
		return null;
	}

	@Override
	public String novo() throws Exception {
		produto = new Produto(getSession().getEmpresaLogada(), null);
		return null;
	}



	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	public RuleProduto getRuleProduto() {
		return ruleProduto;
	}



	public void setRuleProduto(RuleProduto ruleProduto) {
		this.ruleProduto = ruleProduto;
	}

	@Override
	public boolean validar(Produto entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
