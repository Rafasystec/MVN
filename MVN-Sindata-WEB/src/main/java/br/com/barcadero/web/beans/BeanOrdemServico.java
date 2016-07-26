package br.com.barcadero.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.rule.RuleOrdemServico;
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

}
