package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Lancamentos")
public class Lancamento {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigo;
	@Column(name="",nullable=false)
	private long codEmp;
	@Column(name="",nullable=false)
	private long codContaLanc;
	@Column(name="",nullable=false)
	private long codContaPart; 
	@Column(name="",nullable=false)
	private long codHistorico;
	@Column(name="",nullable=false)
	private long codContaDebito;
	@Column(name="",nullable=false)
	private long codContaCredito;
	@Column(name="",nullable=false)
	private long codLocalDebito;
	@Column(name="",nullable=false)
	private long codLocalCredito;
	@Column(name="",nullable=false)
	private int nmov;
	@Column(name="",nullable=false)
	private int numero;
	@Column(name="",nullable=false)
	private int locdev;
	@Column(name="",nullable=false)
	private int dcl;
	@Column(name="",nullable=false)
	private int dtLancamento;
	@Column(name="",nullable=false)
	private int horaLancamento;
	@Column(name="",nullable=false)
	private int ocorrencia;
	@Column(name="",nullable=false)
	private String padrao;
	@Column(name="",nullable=false)
	private String complemento;
	@Column(name="",nullable=false)
	private String consilia;
	@Column(name="",nullable=false)
	private double valor;
	@Column(name="",nullable=false)
	public long getCodigo() {		
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getCodEmp() {
		return codEmp;
	}
	public void setCodEmp(long codEmp) {
		this.codEmp = codEmp;
	}
	public long getCodContaLanc() {
		return codContaLanc;
	}
	public void setCodContaLanc(long codContaLanc) {
		this.codContaLanc = codContaLanc;
	}
	public long getCodContaPart() {
		return codContaPart;
	}
	public void setCodContaPart(long codContaPart) {
		this.codContaPart = codContaPart;
	}
	public long getCodHistorico() {
		return codHistorico;
	}
	public void setCodHistorico(long codHistorico) {
		this.codHistorico = codHistorico;
	}
	public long getCodContaDebito() {
		return codContaDebito;
	}
	public void setCodContaDebito(long codContaDebito) {
		this.codContaDebito = codContaDebito;
	}
	public long getCodContaCredito() {
		return codContaCredito;
	}
	public void setCodContaCredito(long codContaCredito) {
		this.codContaCredito = codContaCredito;
	}
	public long getCodLocalDebito() {
		return codLocalDebito;
	}
	public void setCodLocalDebito(long codLocalDebito) {
		this.codLocalDebito = codLocalDebito;
	}
	public long getCodLocalCredito() {
		return codLocalCredito;
	}
	public void setCodLocalCredito(long codLocalCredito) {
		this.codLocalCredito = codLocalCredito;
	}
	public int getNmov() {
		return nmov;
	}
	public void setNmov(int nmov) {
		this.nmov = nmov;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getLocdev() {
		return locdev;
	}
	public void setLocdev(int locdev) {
		this.locdev = locdev;
	}
	public int getDcl() {
		return dcl;
	}
	public void setDcl(int dcl) {
		this.dcl = dcl;
	}
	public int getDtLancamento() {
		return dtLancamento;
	}
	public void setDtLancamento(int dtLancamento) {
		this.dtLancamento = dtLancamento;
	}
	public int getHoraLancamento() {
		return horaLancamento;
	}
	public void setHoraLancamento(int horaLancamento) {
		this.horaLancamento = horaLancamento;
	}
	public int getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(int ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	public String getPadrao() {
		return padrao;
	}
	public void setPadrao(String padrao) {
		this.padrao = padrao;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getConsilia() {
		return consilia;
	}
	public void setConsilia(String consilia) {
		this.consilia = consilia;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
