package br.com.barcadero.module.ecf.dados;

import java.math.BigDecimal;
/**
 * CLasse para representar um item de cupom
 * @author Rafael Rocha
 * @since dia 28/08/2015 as 21:00
 */
public class Item {

	private String  codigo 	 ;
	private String descricao ;
	private String aliquota  ;
	private String tpAliquota;
	private String unidade 	 ;
	private String tpQuantidade ;
	private String tipoDesconto ;
	private double quantidade	;
	private int casaDecimais 	;
	private BigDecimal valorUnitario ;
	private BigDecimal valorDesconto ;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAliquota() {
		return aliquota;
	}
	public void setAliquota(String aliquota) {
		this.aliquota = aliquota;
	}
	public String getTpQuantidade() {
		return tpQuantidade;
	}
	public void setTpQuantidade(String tpQuantidade) {
		this.tpQuantidade = tpQuantidade;
	}
	public String getTipoDesconto() {
		return tipoDesconto;
	}
	public void setTipoDesconto(String tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public int getCasaDecimais() {
		return casaDecimais;
	}
	public void setCasaDecimais(int casaDecimais) {
		this.casaDecimais = casaDecimais;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	public String getTpAliquota() {
		return tpAliquota;
	}
	public void setTpAliquota(String tpAliquota) {
		this.tpAliquota = tpAliquota;
	}
	
}
