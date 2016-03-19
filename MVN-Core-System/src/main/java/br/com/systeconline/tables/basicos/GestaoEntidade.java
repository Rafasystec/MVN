package br.com.systeconline.tables.basicos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
*Classe para persistir as gestoes de uma entidade
*@author Rafael Rocha
*@since Gsind 1.0 beta dia 27/09/2013 as 22:44
*/

@Entity
public class GestaoEntidade extends Entidade{

	private static final long serialVersionUID = 7510724518018725051L;
	public GestaoEntidade(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}

	@Column(name="tp_gestao",length=3,nullable=false)
	private String tpGestao;
	@Column(name="outra_gestao",length=40,nullable=false)
	private String outraGestao;
	@Column(name="fl_filiado_feder",length=1,nullable=false)
	private String flFiliadoFeder;//Indica 'S' se for filiado a uma federacao, caso contrario 'N' (nao)
	@Column(name="filiado_a",length=60,nullable=false)
	private String filiadoA;
	@Column(name="confeder_a",length=60,nullable=false)
	private String confederA;
	@Column(name="fl_filiado_confer",length=1,nullable=false)
	private String flFiliadoConfer;//Indica 'S' se for filiado a uma Confederacao, caso contrario 'N' (nao)
	
	@Column(name="dt_eleicao",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtEleicao;
	@Column(name="dt_posse",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtPosse;
	
	@Column(name="duracao_mandato",nullable=false)
	private int duracaoMandato;
	
	@Column(name="cod_entidade",nullable=false)
	private long codEntidade;
	@Id @GeneratedValue
	private long codigo;
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
	
	@Column(name="dt_cadastro",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtCadastro;
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	//Getters and Setters
	public String getTpGestao() {
		return tpGestao;
	}

	public void setTpGestao(String tpGestao) {
		this.tpGestao = tpGestao;
	}

	public String getOutraGestao() {
		return outraGestao;
	}

	public void setOutraGestao(String outraGestao) {
		this.outraGestao = outraGestao;
	}

	public String getFlFiliadoFeder() {
		return flFiliadoFeder;
	}

	public void setFlFiliadoFeder(String flFiliadoFeder) {
		this.flFiliadoFeder = flFiliadoFeder;
	}

	public String getFiliadoA() {
		return filiadoA;
	}

	public void setFiliadoA(String filiadoA) {
		this.filiadoA = filiadoA;
	}

	public String getConfederA() {
		return confederA;
	}

	public void setConfederA(String confederA) {
		this.confederA = confederA;
	}

	public String getFlFiliadoConfer() {
		return flFiliadoConfer;
	}

	public void setFlFiliadoConfer(String flFiliadoConfer) {
		this.flFiliadoConfer = flFiliadoConfer;
	}

	public Date getDtEleicao() {
		return dtEleicao;
	}

	public void setDtEleicao(Date dtEleicao) {
		this.dtEleicao = dtEleicao;
	}

	public Date getDtPosse() {
		return dtPosse;
	}

	public void setDtPosse(Date dtPosse) {
		this.dtPosse = dtPosse;
	}

	public int getDuracaoMandato() {
		return duracaoMandato;
	}

	public void setDuracaoMandato(int duracaoMandato) {
		this.duracaoMandato = duracaoMandato;
	}

	public long getCodEntidade() {
		return codEntidade;
	}

	public void setCodEntidade(long codEntidade) {
		this.codEntidade = codEntidade;
	}
	
}
