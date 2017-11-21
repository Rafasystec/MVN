package br.com.barcadero.module.sat.devices.integrador.vfpe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Resposta")
@XmlAccessorType(XmlAccessType.FIELD)
public class Resposta {
	@XmlElement(name="CodigoAutorizacao")    private String codigoAutorizacao;    
	@XmlElement(name="Bin")                  private String bin;                  
	@XmlElement(name="DonoCartao")           private String donoCartao;           
	@XmlElement(name="DataExpiracao")        private String dataExpiracao;        
	@XmlElement(name="InstituicaoFinanceira")private String instituicaoFinanceira;
	@XmlElement(name="Parcelas")             private String parcelas;             
	@XmlElement(name="UltimosQuatroDigitos") private String ultimosQuatroDigitos; 
	@XmlElement(name="CodigoPagamento")      private String codigoPagamento;      
	@XmlElement(name="ValorPagamento")		 private String valorPagamento;       
	@XmlElement(name="idFila")               private String idFila;               
	@XmlElement(name="Tipo")				 private String tipo;
	public String getCodigoAutorizacao() {
		return codigoAutorizacao;
	}
	public void setCodigoAutorizacao(String codigoAutorizacao) {
		this.codigoAutorizacao = codigoAutorizacao;
	}
	public String getBin() {
		return bin;
	}
	public void setBin(String bin) {
		this.bin = bin;
	}
	public String getDonoCartao() {
		return donoCartao;
	}
	public void setDonoCartao(String donoCartao) {
		this.donoCartao = donoCartao;
	}
	public String getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}
	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}
	public String getParcelas() {
		return parcelas;
	}
	public void setParcelas(String parcelas) {
		this.parcelas = parcelas;
	}
	public String getUltimosQuatroDigitos() {
		return ultimosQuatroDigitos;
	}
	public void setUltimosQuatroDigitos(String ultimosQuatroDigitos) {
		this.ultimosQuatroDigitos = ultimosQuatroDigitos;
	}
	public String getCodigoPagamento() {
		return codigoPagamento;
	}
	public void setCodigoPagamento(String codigoPagamento) {
		this.codigoPagamento = codigoPagamento;
	}
	public String getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(String valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public String getIdFila() {
		return idFila;
	}
	public void setIdFila(String idFila) {
		this.idFila = idFila;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}                 	
	
	
	
}
