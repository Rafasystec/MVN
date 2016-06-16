package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *Salvar o cadastro de entidades do sistema.
 *@author Rafael
 *@since Gsind Beta 1.0 dia 27/09/2013 as 21:50 
 */
@Entity
public class EntidadeFiliada extends Entidade{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EntidadeFiliada(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	@Column(name="cod_sindical",length=15)
	private String codSindical;
	@Column(name="cod_interno",length=10,nullable=false)
	private String codInterno;
	@Column(name="sigla",length=40,nullable=false)
	private String sigla;
	@Column(name="cnpj",length=14,nullable=false)
	private String cnpj;
	@Column(name="nome",length=60,nullable=false)
	private String nome;
	@Column(name="fl_situacao",length=60,nullable=false)
	private String situacao;
	@Column(name="regiao_metropolitana",length=60,nullable=false)
	private String regiaoMetropolitana;
	@Column(name="tp_entidade",length=3,nullable=false)
	private String tpEntidade;
	@Column(name="mes_desc_assintencial",length=30,nullable=false)
	private String mesDescTxAssitencial;
	@Column(name="mes_desc_confer",length=30,nullable=false)
	private String mesDescTxConfer;
	@Column(name="mes_desc_sindical",length=3,nullable=false)
	private String mesDescTxSindical;
	@Column(name="federacao",length=60,nullable=false)
	private String federacao;//Federacao a qual a entidade pode ser filiada
	@Column(name="mes",length=30,nullable=false)
	private String mes;
	@Column(name="periodo_pgto",length=30,nullable=false)
	private String periodoPgto;
	
	@Column(name="dt_fundacao",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtFundacao;
	@Column(name="dt_filiacao",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtFiliacao;
	@Column(name="dt_aprov_filiacao",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtAprovFiliacao;
	
	@Column(name="tx_assistencial",nullable=false)
	private double txtAssistencial;
	@Column(name="tx_confederacao",nullable=false)
	private double txtConfederacao;
	@Column(name="tx_sindical",nullable=false)
	private double txtsindical;
	@Column(name="tx_outras",nullable=false)
	private double txtOutras;
	@Column(name="salario_medio",nullable=false)
	private double salarioMedio;
	@Column(name="perc_desconto",nullable=false)
	private double percDesconto;
	@Column(name="receita_mensal",nullable=false)
	private double receitaMensal;
	
	@Column(name="vl_base",nullable=false)
	private long vlBase;
	@Column(name="qtd_socios",nullable=false)
	private long qtdsocios;
	@Column(name="qtd_socios_quites",nullable=false)
	private long qtdSociosQuites;
	@Column(name="qtd_socios_aposent",nullable=false)
	private long qtdSociosAposent;
	@Column(name="qtd_socios_afast",nullable=false)
	private long qtdsociosAfast;
	@Column(name="qtd_base",nullable=false)
	private long qtdBase;
//	@Id @GeneratedValue
//	private long codigo;
	/*
	-------------------------------------------------------------------------------------------------
	Por padrão, quando aplicamos o tipo java.util.Date ou java.util.Calendar, tanto a data
	quanto a hora serão armazenadas no banco de dados. Para mudar esse comportamento, devemos
	aplicar a anotação @Temporal escolhendo uma das três opções abaixo:
	TemporalType.DATE: Armazena apenas a data (dia, mês e ano).
	TemporalType.TIME: Armazena apenas o horário (hora, minuto e segundo).
	TemporalType.TIMESTAMP (Padrão): Armazena a data e o horário.
	------------------------------------------------------------------------------------------------- 
	 */
//	@Column(name="dt_cadastro",nullable=false)
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date dtCadastro;
//	public long getCodigo() {
//		return codigo;
//	}
//	public void setCodigo(long codigo) {
//		this.codigo = codigo;
//	}
//	public Date getDtCadastro() {
//		return dtCadastro;
//	}
//	public void setDtCadastro(Date dtCadastro) {
//		this.dtCadastro = dtCadastro;
//	}
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
	public long getQtdsocios() {
		return qtdsocios;
	}
	public void setQtdsocios(long qtdsocios) {
		this.qtdsocios = qtdsocios;
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
}
