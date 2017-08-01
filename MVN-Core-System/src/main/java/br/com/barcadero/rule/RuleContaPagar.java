package br.com.barcadero.rule;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.commons.util.HandleDateHour;
import br.com.barcadero.core.enums.EnumTipoCartao;
import br.com.barcadero.dao.DaoContaPagar;
import br.com.barcadero.tables.CartaoCreditoDebito;
import br.com.barcadero.tables.ContaLancamento;
import br.com.barcadero.tables.ContaPagar;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;


@Service
public class RuleContaPagar extends RuleModelo<ContaPagar> {

	public RuleContaPagar() {
		System.out.println("Auto-generated constructor stub for class " + RuleContaPagar.class.getName()); 
	}
	@Autowired
	DaoContaPagar daoContaPagar;
	public RuleContaPagar(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoContaPagar = new DaoContaPagar(empresa, loja, session);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoContaPagar.delete(codigo);
	}

	@Override
	public ContaPagar find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoContaPagar.find(codigo);
	}


	@Override
	public List<ContaPagar> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaPagar> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaPagar> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContaPagar insert(ContaPagar entidade) throws Exception {
		return daoContaPagar.insert(entidade);
	}

	@Override
	public ContaPagar update(ContaPagar entidade) throws Exception {
		return daoContaPagar.update(entidade);
	}
	
	public void gerarContaPagarCartao(ContaLancamento contaLancamento) throws Exception {
		if(contaLancamento != null){
			if(contaLancamento.getCartaoCreditoDebito() != null){
				gerarAPagarPorCartaoDeCredito(contaLancamento);
			}
		}
	}

	/**
	 * Gerar contas a receber com base em um lancamento a cartao de credito
	 * @param contaLancamento
	 * @throws Exception
	 */
	private void gerarAPagarPorCartaoDeCredito(ContaLancamento contaLancamento) throws Exception {
		CartaoCreditoDebito cartaoCreditoDebito = contaLancamento.getCartaoCreditoDebito();
		int currentYear = Integer.parseInt(HandleDateHour.getCurrentYear());
		int currentMonth= Integer.parseInt(HandleDateHour.getCurrentMonth());
		Date dataBase = new Date();
		if(cartaoCreditoDebito.getTipoCartao() == EnumTipoCartao.CREDITO ){
			int parcelas = contaLancamento.getParcelas();		
			BigDecimal totalParcela = contaLancamento.getValor().divide(new BigDecimal(parcelas));
			for (int i = 0; i < parcelas; i++) {
				ContaPagar contaPagar 	= new ContaPagar(contaLancamento.getLoja(), contaLancamento.getLoja().getUsuario());
				int diaMelhorCompra 	= cartaoCreditoDebito.getDiaMelhorCompra();
				Date dateVencimento 	= HandleDateHour.getDate(currentYear, currentMonth, diaMelhorCompra);
				int equals = dateVencimento.compareTo(dataBase);
				if(equals >= 0 ){
					//NOTE: Vai cair so no proximo mes do cartao
					dateVencimento = HandleDateHour.getDate(currentYear, currentMonth + (i + 1), cartaoCreditoDebito.getDiaPagtoCartao());
				}else{
					dateVencimento = HandleDateHour.getDate(currentYear, currentMonth +  i, cartaoCreditoDebito.getDiaPagtoCartao());
				}
				contaPagar.setDtVencimento(dateVencimento);
				contaPagar.setDtEmissao(new Date());
				contaPagar.setEmpresa(contaLancamento.getEmpresa());
				contaPagar.setObservacao("GERADO AUTOMATICAMENTE POR LANÇAMENTO EM CARTÃO DE CRÉDITO");
				contaPagar.setQtdDiasVenc(3);
				contaPagar.setTotal(totalParcela);
				contaPagar.setContaLancamento(contaLancamento);
				daoContaPagar.insert(contaPagar);
			}

		}
	}

}
