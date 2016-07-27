package br.com.barcadero.web.beans;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.rule.RuleOrdemServico;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.OrdemServico;
import br.com.barcadero.tables.OrdemServicoItens;

@ManagedBean
@ViewScoped
public class BeanOrdemServico extends SuperBean {

	private static final long serialVersionUID = -8018968486074012582L;
	private OrdemServico ordemServico;
	private List<OrdemServicoItens> itens;
	private OrdemServicoItens item;
	private RuleOrdemServico ruleOrdemServico;
	private Caixa caixa;
	private BigDecimal vlSubTotal = new BigDecimal(0.00);
	private BigDecimal vlUnitario = new BigDecimal(0.00);
	private String strProduto;
	private String lastProduto;
	
	public BeanOrdemServico() {
		ruleOrdemServico = new RuleOrdemServico(getEmpresaLogada(), getLojaLogada(), getDBSessionForViewScope());
		ordemServico	 = new OrdemServico(getEmpresaLogada(), getLojaLogada(), getUsuarioLogado());
		item			 = new OrdemServicoItens(getEmpresaLogada(), getLojaLogada(), getUsuarioLogado());
	}
	
	@Override
	public String imprimir() throws Exception {
		return null;
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

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public List<OrdemServicoItens> getItens() {
		
		return itens;
	}

	public void setItens(List<OrdemServicoItens> itens) {
		this.itens = itens;
	}
	
	public String fecharOS() {
		
		return null;
	}
	
	public void salvarItem() {
		
	}

	public OrdemServicoItens getItem() {
		return item;
	}

	public void setItem(OrdemServicoItens item) {
		this.item = item;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public BigDecimal getVlSubTotal() {
		return vlSubTotal;
	}

	public void setVlSubTotal(BigDecimal vlSubTotal) {
		this.vlSubTotal = vlSubTotal;
	}

	public BigDecimal getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(BigDecimal vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	public String getStrProduto() {
		return strProduto;
	}

	public void setStrProduto(String strProduto) {
		this.strProduto = strProduto;
	}

	public String getLastProduto() {
		return lastProduto;
	}

	public void setLastProduto(String lastProduto) {
		this.lastProduto = lastProduto;
	}

}
