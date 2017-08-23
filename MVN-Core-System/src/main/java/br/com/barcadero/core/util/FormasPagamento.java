package br.com.barcadero.core.util;

import java.math.BigDecimal;

public class FormasPagamento {
	//---------------------------------------------
	//Descricoes das formas de pagamento
	//---------------------------------------------
	public final static String DINHEIRO 	= "DINHEIRO";
	public final static String TEF			= "TFE";
	public final static String CHEQUE		= "CHEQUE";
	public final static String CREDIARIO 	= "CREDIARIO";
	
	private BigDecimal vlTEF 			= new BigDecimal("0.00");
	private BigDecimal vlDinheiro       = new BigDecimal("0.00");
	private BigDecimal vlCheque         = new BigDecimal("0.00");
	private BigDecimal vlCrediario      = new BigDecimal("0.00");
	private BigDecimal vlTotalVenda     = new BigDecimal("0.00");
	
	public BigDecimal getVlTEF() {
		return vlTEF;
	}
	public void setVlTEF(BigDecimal vlTEF) {
		this.vlTEF = vlTEF;
	}
	public BigDecimal getVlDinheiro() {
		return vlDinheiro;
	}
	public void setVlDinheiro(BigDecimal vlDinheiro) {
		this.vlDinheiro = vlDinheiro;
	}
	public BigDecimal getVlCheque() {
		return vlCheque;
	}
	public void setVlCheque(BigDecimal vlCheque) {
		this.vlCheque = vlCheque;
	}
	public BigDecimal getVlCrediario() {
		return vlCrediario;
	}
	public void setVlCrediario(BigDecimal vlCrediario) {
		this.vlCrediario = vlCrediario;
	}
	public BigDecimal getVlTotalVenda() {
		return vlTotalVenda;
	}
	public void setVlTotalVenda(BigDecimal vlTotalVenda) {
		this.vlTotalVenda = vlTotalVenda;
	}
	
	public boolean validarTotal() {
		BigDecimal total = new BigDecimal(0.00);
		total = total.add(vlTEF).add(vlCheque);
		if(total == vlTotalVenda){
			return true;
		}else{
			return false;
		}
	}

}
