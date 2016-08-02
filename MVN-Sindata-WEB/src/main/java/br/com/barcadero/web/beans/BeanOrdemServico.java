package br.com.barcadero.web.beans;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;

import br.com.barcadero.rule.RuleOrdemServico;
import br.com.barcadero.rule.RuleProduto;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.OrdemServico;
import br.com.barcadero.tables.OrdemServicoItens;
import br.com.barcadero.tables.Produto;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean
@ViewScoped
public class BeanOrdemServico extends SuperBean {

	private static final long serialVersionUID = -8018968486074012582L;
	private OrdemServico ordemServico;
	private List<OrdemServicoItens> itens;
	private OrdemServicoItens item;
	private RuleOrdemServico ruleOrdemServico;
	private RuleProduto ruleProduto;
	private Caixa caixa;
	private BigDecimal vlSubTotal = new BigDecimal(0.00);
	private BigDecimal vlUnitario = new BigDecimal(0.00);
	private String strProduto;
	private String lastProduto;
	private Session session;
	public BeanOrdemServico() {
		session 		 = getDBSessionForViewScope();
		ruleOrdemServico = new RuleOrdemServico(getEmpresaLogada(), getLojaLogada(), getDBSessionForViewScope());
		ruleProduto		 = new RuleProduto(getEmpresaLogada(), getLojaLogada(), getDBSessionForViewScope());
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
		try {
			this.itens = ruleOrdemServico.getItensByOS(ordemServico);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itens;
	}

	public void setItens(List<OrdemServicoItens> itens) {
		this.itens = itens;
	}
	
	public String fecharOS() {
		
		return null;
	}
	
	public void salvarItem() {
		try {
			System.out.println("Save item called.");
			beginTransaction();
			if(ordemServico == null){
				ordemServico = createOrdemServico();
			}
			Produto produto = ruleProduto.find(ruleProduto.extrairCodigo(getStrProduto()));
			lastProduto = produto.getDescricao();
			item.setProduto(produto);
			item.setOrdemServico(ordemServico);
			ruleOrdemServico.insert(ordemServico,item);
			setVlUnitario(item.getValorTotal());
			totalizarSubTotal(item);
			commit();
			item = new OrdemServicoItens(getEmpresaLogada(), getLojaLogada(), getUsuarioLogado());
		} catch (Exception e) {
			HandleMessage.error("Erro ao inserir Item", e.getMessage());
		}
	}

	private OrdemServico createOrdemServico() {
		// TODO Auto-generated method stub
		return new OrdemServico(getEmpresaLogada(), getLojaLogada(), getUsuarioLogado());
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
	
	public void beginTransaction() {
		if(this.session != null){
			this.session.beginTransaction();
		}
	}
	
	private void totalizarSubTotal(OrdemServicoItens item) {
		setVlSubTotal(getVlSubTotal().add(item.getValorTotal()));
	}
	
	public void commit() {
		if(this.session != null){
			this.session.getTransaction().commit();
		}
	}

}
