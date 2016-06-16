package br.com.barcadero.web.beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.barcadero.core.enums.EnumCSTICMS;
import br.com.barcadero.core.enums.EnumCSTPIS;
import br.com.barcadero.core.enums.EnumOrigemCSTICMS;
import br.com.barcadero.core.enums.EnumSitTributCSTIPI;
import br.com.barcadero.core.enums.EnumUnidadeMedida;
import br.com.barcadero.rule.RuleProduto;
import br.com.barcadero.tables.Produto;

@ManagedBean(name="produto")
public class BeanProduto extends SuperBean {


	private static final long serialVersionUID = 5793307604069729331L;
	private EnumCSTICMS[] cstIcms;
	private EnumUnidadeMedida[] medidas;
	private EnumSitTributCSTIPI[] cstIpi;
	private EnumCSTPIS[] cstPis;
	private EnumOrigemCSTICMS[] origensIcms;
	private List<Produto> produtos;
	private List<Produto> produtosSelecionados;
	private Produto produto;
	private RuleProduto ruleProduto;
	
	public BeanProduto() {
		ruleProduto = new RuleProduto(getDataBaseSession());
		produto		= new Produto(getSession().getEmpresaLogada(), null);
	}
	
	
	
	public EnumCSTICMS[] getCstIcms() {
		return EnumCSTICMS.values();
	}

	public void setCstIcms(EnumCSTICMS[] cstIcms) {
		this.cstIcms = cstIcms;
	}

	public EnumUnidadeMedida[] getMedidas() {
		return EnumUnidadeMedida.values();
	}

	public void setMedidas(EnumUnidadeMedida[] medidas) {
		this.medidas = medidas;
	}

	public EnumSitTributCSTIPI[] getCstIpi() {
		return EnumSitTributCSTIPI.values();
	}

	public void setCstPis(EnumSitTributCSTIPI[] cstPis) {
		this.cstIpi = cstPis;
	}

	public EnumOrigemCSTICMS[] getOrigensIcms() {
		return EnumOrigemCSTICMS.values();
	}

	public void setOrigensIcms(EnumOrigemCSTICMS[] origensIcms) {
		this.origensIcms = origensIcms;
	}

	public List<Produto> getProdutos() throws Exception {
		return ruleProduto.findByDataCadastro(new Date());
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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



	public void setCstPis(EnumCSTPIS[] cstPis) {
		this.cstPis = cstPis;
	}



	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ruleProduto.insert(produto));
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
		// TODO Auto-generated method stub
		produto = new Produto(getSession().getEmpresaLogada(), null);
		return null;
	}

}
