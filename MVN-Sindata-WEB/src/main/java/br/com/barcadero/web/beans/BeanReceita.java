package br.com.barcadero.web.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import br.com.barcadero.rule.RuleReceita;
import br.com.barcadero.tables.Receita;

@ManagedBean
@ViewScoped
public class BeanReceita extends SuperBean<Receita> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7297285727344188038L;
	@ManagedProperty("#{ruleReceita}")
	private RuleReceita ruleReceita;
	private Receita selectedReceita;
	private BigDecimal totalReceitas = new BigDecimal("0.00");
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar(Receita entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
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
	
	public void onTabChange(TabChangeEvent event) {
		FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public void onTabClose(TabCloseEvent event) {
		FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public List<Receita> getReceitasFixas() {
		try {
			List<Receita> list = ruleReceita.findByEmpresa(getEmpresaLogada());
			totalReceitas = new BigDecimal("0.00");
			for (Receita receita : list) {
				totalReceitas = totalReceitas.add(receita.getValor());
			}
			return list;
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public RuleReceita getRuleReceita() {
		return ruleReceita;
	}

	public void setRuleReceita(RuleReceita ruleReceita) {
		this.ruleReceita = ruleReceita;
	}

	public Receita getSelectedReceita() {
		return selectedReceita;
	}

	public void setSelectedReceita(Receita selectedReceita) {
		this.selectedReceita = selectedReceita;
	}

	public BigDecimal getTotalReceitas() {
		return totalReceitas;
	}

	public void setTotalReceitas(BigDecimal totalReceitas) {
		this.totalReceitas = totalReceitas;
	}

}
