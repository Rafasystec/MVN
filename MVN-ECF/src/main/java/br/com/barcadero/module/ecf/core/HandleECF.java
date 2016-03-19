package br.com.barcadero.module.ecf.core;

import java.math.BigDecimal;
import br.com.barcadero.module.ecf.dados.Item;
import br.com.barcadero.module.ecf.impressoras.ECF;

/**
 * Classe responsavel pela interacao com os ECF. Somente esta classe deve ser invocada para este fim.
 * @author Rafael Rocha
 * @since dia 29/08/2015 as 09:14
 */
public final class HandleECF {

	private ECF ecf = null;
	
	/*
	Relatorios fiscais 
	 */
	public void leituraX() {
		try {
			ecf.leituraX();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void reducaoZ() {
		try {
			ecf.reducaoZ();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*
	Venda com Cupom Fiscal
	 */
	public void iniciarCupom(String cpfCnpj) {
		try {
			ecf.abrirCupom(cpfCnpj);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void venderItem(Item item) {
		try {
			ecf.venderItem(item);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void iniciarFechamento(String acrescimoDesconto, String tpAcrescimoDesconto, BigDecimal valorAcrescimoDesconto) {
		try {
			ecf.iniciarFechamentoCupom(acrescimoDesconto, tpAcrescimoDesconto, valorAcrescimoDesconto);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void fecharCupom(String mensagemPromocional) {
		try {
			ecf.terminarFechamentoCupom(mensagemPromocional);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
