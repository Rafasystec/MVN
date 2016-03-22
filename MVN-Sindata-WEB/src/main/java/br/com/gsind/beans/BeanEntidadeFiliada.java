package br.com.gsind.beans;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BeanEntidadeFiliada implements BeanInterfaceEndereco {
	
	private String codSindical;
	private String codInterno;
	private String sigla;
	private String nome;
	private String situacao;
	private String regiaoMetropolitana;
	private String tpEntidade;
	private String mesDescTxAssitencial;
	private String mesDescTxConfer;
	private String mesDescTxSindical;
	private String federacao;//Federacao a qual a entidade pode ser filiada
	private String mes;
	private String periodoPgto;
	private Date dtFundacao;
	private Date dtFiliacao;
	private Date dtAprovFiliacao;
	private double txtAssistencial;
	private double txtConfederacao;
	private double txtsindical;
	private double txtOutras;
	private double salarioMedio;
	private double percDesconto;
	private double receitaMensal;
	private long vlBase;
	private long qtdSocios;
	private long qtdSociosQuites;
	private long qtdSociosAposent;
	private long qtdsociosAfast;
	private long qtdBase;
	
	//-----------------------------------------
	//NOTE: Atributos para o endereco
	//-----------------------------------------
	private long codBairro;
	private long codPessoa;
	private String tipo; 
	private String numero;
	private String cep;
	private String logradouro;
	private String tpLograd;
	private String complemento;
	private String referencia;
	//-----------------------------------------
	//private BeanContato beanContato;
	//Getters and Setters
	public String getCodSindical() {
		return codSindical;
	}
	public void setCodSindical(String codSindical) {
		this.codSindical = codSindical;
	}
	public String getCodInterno() {
		return codInterno;
	}
	public void setCodInterno(String codInterno) {
		this.codInterno = codInterno;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getRegiaoMetropolitana() {
		return regiaoMetropolitana;
	}
	public void setRegiaoMetropolitana(String regiaoMetropolitana) {
		this.regiaoMetropolitana = regiaoMetropolitana;
	}
	public String getTpEntidade() {
		return tpEntidade;
	}
	public void setTpEntidade(String tpEntidade) {
		this.tpEntidade = tpEntidade;
	}
	public String getMesDescTxAssitencial() {
		return mesDescTxAssitencial;
	}
	public void setMesDescTxAssitencial(String mesDescTxAssitencial) {
		this.mesDescTxAssitencial = mesDescTxAssitencial;
	}
	public String getMesDescTxConfer() {
		return mesDescTxConfer;
	}
	public void setMesDescTxConfer(String mesDescTxConfer) {
		this.mesDescTxConfer = mesDescTxConfer;
	}
	public String getMesDescTxSindical() {
		return mesDescTxSindical;
	}
	public void setMesDescTxSindical(String mesDescTxSindical) {
		this.mesDescTxSindical = mesDescTxSindical;
	}
	public String getFederacao() {
		return federacao;
	}
	public void setFederacao(String federacao) {
		this.federacao = federacao;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getPeriodoPgto() {
		return periodoPgto;
	}
	public void setPeriodoPgto(String periodoPgto) {
		this.periodoPgto = periodoPgto;
	}
	public Date getDtFundacao() {
		return dtFundacao;
	}
	public void setDtFundacao(Date dtFundacao) {
		this.dtFundacao = dtFundacao;
	}
	public Date getDtFiliacao() {
		return dtFiliacao;
	}
	public void setDtFiliacao(Date dtFiliacao) {
		this.dtFiliacao = dtFiliacao;
	}
	public Date getDtAprovFiliacao() {
		return dtAprovFiliacao;
	}
	public void setDtAprovFiliacao(Date dtAprovFiliacao) {
		this.dtAprovFiliacao = dtAprovFiliacao;
	}
	public double getTxtAssistencial() {
		return txtAssistencial;
	}
	public void setTxtAssistencial(double txtAssistencial) {
		this.txtAssistencial = txtAssistencial;
	}
	public double getTxtConfederacao() {
		return txtConfederacao;
	}
	public void setTxtConfederacao(double txtConfederacao) {
		this.txtConfederacao = txtConfederacao;
	}
	public double getTxtsindical() {
		return txtsindical;
	}
	public void setTxtsindical(double txtsindical) {
		this.txtsindical = txtsindical;
	}
	public double getTxtOutras() {
		return txtOutras;
	}
	public void setTxtOutras(double txtOutras) {
		this.txtOutras = txtOutras;
	}
	public double getSalarioMedio() {
		return salarioMedio;
	}
	public void setSalarioMedio(double salarioMedio) {
		this.salarioMedio = salarioMedio;
	}
	public double getPercDesconto() {
		return percDesconto;
	}
	public void setPercDesconto(double percDesconto) {
		this.percDesconto = percDesconto;
	}
	public double getReceitaMensal() {
		return receitaMensal;
	}
	public void setReceitaMensal(double receitaMensal) {
		this.receitaMensal = receitaMensal;
	}
	public long getVlBase() {
		return vlBase;
	}
	public void setVlBase(long vlBase) {
		this.vlBase = vlBase;
	}
	public long getQtdSocios() {
		return qtdSocios;
	}
	public void setQtdSocios(long qtdSocios) {
		this.qtdSocios = qtdSocios;
	}
	public long getQtdSociosQuites() {
		return qtdSociosQuites;
	}
	public void setQtdSociosQuites(long qtdSociosQuites) {
		this.qtdSociosQuites = qtdSociosQuites;
	}
	public long getQtdSociosAposent() {
		return qtdSociosAposent;
	}
	public void setQtdSociosAposent(long qtdSociosAposent) {
		this.qtdSociosAposent = qtdSociosAposent;
	}
	public long getQtdsociosAfast() {
		return qtdsociosAfast;
	}
	public void setQtdsociosAfast(long qtdsociosAfast) {
		this.qtdsociosAfast = qtdsociosAfast;
	}
	public long getQtdBase() {
		return qtdBase;
	}
	public void setQtdBase(long qtdBase) {
		this.qtdBase = qtdBase;
	}
	@Override
	public long getCodBairro() {
		// TODO Auto-generated method stub
		return this.codBairro;
	}
	@Override
	public long getCodPessoa() {
		// TODO Auto-generated method stub
		return this.codPessoa;
	}
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return this.tipo;
	}
	@Override
	public String getNumero() {
		// TODO Auto-generated method stub
		return this.numero;
	}
	@Override
	public String getCep() {
		// TODO Auto-generated method stub
		return this.cep;
	}
	@Override
	public String getLogradouro() {
		// TODO Auto-generated method stub
		return this.logradouro;
	}
	@Override
	public String getTpLograd() {
		// TODO Auto-generated method stub
		return this.tpLograd;
	}
	@Override
	public String getComplemento() {
		// TODO Auto-generated method stub
		return this.complemento;
	}
	@Override
	public String getReferencia() {
		// TODO Auto-generated method stub
		return this.referencia;
	}
	@Override
	public void setCodBairro(long codBairro) {
		// TODO Auto-generated method stub
		this.codBairro = codBairro;
	}
	@Override
	public void setCodPessoa(long codPessoa) {
		// TODO Auto-generated method stub
		this.codPessoa = codPessoa;
	}
	@Override
	public void setTipo(String tipo) {
		// TODO Auto-generated method stub
		this.tipo = tipo;
	}
	@Override
	public void setNumero(String numero) {
		// TODO Auto-generated method stub
		this.numero = numero;
	}
	@Override
	public void setCep(String cep) {
		// TODO Auto-generated method stub
		this.cep = cep;
	}
	@Override
	public void setLogradouro(String logradouro) {
		// TODO Auto-generated method stub
		this.logradouro = logradouro;
	}
	@Override
	public void setTpLograd(String tpLograd) {
		// TODO Auto-generated method stub
		this.tpLograd = tpLograd;
	}
	@Override
	public void setComplemento(String complemento) {
		// TODO Auto-generated method stub
		this.complemento = complemento;
	}
	@Override
	public void setReferencia(String referencia) {
		// TODO Auto-generated method stub
		this.referencia = referencia;
	}
	
}
