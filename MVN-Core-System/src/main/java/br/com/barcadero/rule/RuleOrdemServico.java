package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.core.enums.EnumStatusOrdemServico;
import br.com.barcadero.dao.DaoOrdemServico;
import br.com.barcadero.dao.DaoOrdemServicoItens;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.OrdemServico;
import br.com.barcadero.tables.OrdemServicoItens;

@Service
public class RuleOrdemServico extends RuleModelo<OrdemServico> {

	@Autowired
	private DaoOrdemServico daoOrdemServico;
	@Autowired
	private DaoOrdemServicoItens daoOrdemServicoItens;
//	@Autowired
//	private RuleProduto ruleProduto;
	
//
//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		return daoOrdemServico.insert(entidade);
//	}
	
//	/**
//	 * Salvar uma ordem de servico
//	 * @param ordemServico
//	 * @param itens
//	 * @return
//	 * @throws Exception
//	 */
//	public String insert(OrdemServico ordemServico, OrdemServicoItens itens) throws Exception {
//		if(ordemServico != null){
//			Produto produto = itens.getProduto();
//			BigDecimal vlUnitario = ruleProduto.getPreco(produto);
//			itens.setValorUnitario(vlUnitario);
//			itens.setValorTotal(vlUnitario.multiply(new BigDecimal(itens.getQuantidade())));
//			itens.setOrdemServico(ordemServico);
//			daoOrdemServico.insert(ordemServico);
//			itens.setOrdemServico(ordemServico);
//			return daoOrdemServico.insert(itens);
//		}else{
//			throw new Exception("Pedido não foi criado.");
//		}
//	}

	@Override
	public String delete(long codigo) throws Exception {
		return daoOrdemServico.delete(codigo);
	}

//	@Override
//	public String update(Entidade entidade) throws Exception {
//		return daoOrdemServico.update(entidade);
//	}

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

	@Override
	public List<OrdemServico> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdemServico> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdemServico insert(OrdemServico entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdemServico update(OrdemServico entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
