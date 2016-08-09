package br.com.barcadero.rule;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumStatusOrdemServico;
import br.com.barcadero.dao.DaoOrdemServico;
import br.com.barcadero.dao.DaoOrdemServicoItens;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.OrdemServico;
import br.com.barcadero.tables.OrdemServicoItens;
import br.com.barcadero.tables.Produto;

public class RuleOrdemServico extends RuleModelo<OrdemServico> {

	private DaoOrdemServico daoOrdemServico;
	private DaoOrdemServicoItens daoOrdemServicoItens;
	private RuleProduto ruleProduto;
	public RuleOrdemServico(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoOrdemServico 		= new DaoOrdemServico(empresa, loja, session);
		daoOrdemServicoItens 	= new DaoOrdemServicoItens(empresa, loja, session);
		//ruleProduto				= new RuleProduto(empresa, loja, session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		return daoOrdemServico.insert(entidade);
	}
	
	/**
	 * Salvar uma ordem de servico
	 * @param ordemServico
	 * @param itens
	 * @return
	 * @throws Exception
	 */
	public String insert(OrdemServico ordemServico, OrdemServicoItens itens) throws Exception {
		if(ordemServico != null){
			Produto produto = itens.getProduto();
			BigDecimal vlUnitario = ruleProduto.getPreco(produto);
			itens.setValorUnitario(vlUnitario);
			itens.setValorTotal(vlUnitario.multiply(new BigDecimal(itens.getQuantidade())));
			itens.setOrdemServico(ordemServico);
			daoOrdemServico.insert(ordemServico);
			itens.setOrdemServico(ordemServico);
			return daoOrdemServico.insert(itens);
		}else{
			throw new Exception("Pedido não foi criado.");
		}
	}

	@Override
	public String delete(long codigo) throws Exception {
		return daoOrdemServico.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		return daoOrdemServico.update(entidade);
	}

	@Override
	public OrdemServico find(long codigo) throws Exception {
		return daoOrdemServico.find(codigo);
	}

	@Override
	public List<OrdemServico> findAll() throws Exception {
		return daoOrdemServico.findAll();
	}
	
	public List<OrdemServicoItens> getItensByOS(OrdemServico ordemServico) throws Exception {
		return daoOrdemServicoItens.findByOS(ordemServico);
	}
	/**
	 * Fecha a ordem de serviço
	 * @param ordemServico
	 * @throws Exception 
	 */
	public void fecharOS(OrdemServico ordemServico) throws Exception {
		if(ordemServico != null){
			ordemServico.setStatus(EnumStatusOrdemServico.FECHADA);
			update(ordemServico);
		}
	}
	

}
