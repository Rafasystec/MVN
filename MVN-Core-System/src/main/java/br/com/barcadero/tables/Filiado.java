package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/*
-------------------------------------------------------------------------------------------------------------
Diferentemente de uma consulta dinâmica, uma Named Query é processada apenas no mo-
mento da inicialização da unidade de persistência. Além disso, os provedores JPA podem mapear
as Named Queries para Stored Procedures pre-compiladas no banco de dados melhorando a perfor-
mance das consultas.
As Named Queries são definidas através de anotações nas classes que implementam as entida-
des. Podemos aplicar a anotação @NamedQuery quando queremos definir apenas uma consulta ou
a anotação @NamedQueries quando queremos definir várias consultas.
-------------------------------------------------------------------------------------------------------------
*/
@NamedQueries(
		{
			@NamedQuery(name="Filiado.findAll",			query="SELECT f FROM Filiado f"),
			@NamedQuery(name="Filiado.findByCodigo",	query="SELECT f FROM Filiado f WHERE f.codigo = :codigo"),
			//@NamedQuery(name="Filiado.findByNome",		query="SELECT f FROM Filiado f WHERE f.nome LIKE %:nome%"),
			@NamedQuery(name="Filiado.findByMatricula",	query="SELECT f FROM Filiado f WHERE f.matricula = :matricula")
		}
)
@Entity
public class Filiado extends PessoaFisica{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Filiado() {
		// TODO Auto-generated constructor stub
	}
	public Filiado(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}

	@Column(nullable=false)
	private String reservista;
	@Column(name="fl_cativa",length=3,nullable=false)
	private String flCativa;
	@Column(name="raca",length=30,nullable=false)
	private String raca;
	@Column(name="fl_casapropria",length=2,nullable=false)
	private String flCasaPropria;
	@Column(name="nm_conjuge",length=100,nullable=false)
	private String nmConjuge;
	@Column(name="cpf_conjuge",length=15,nullable=false)
	private String cpfConjuge;
	@Column(name="tp_socio",length=3,nullable=false)
	private String tpSocio;
	@Column(name="mtp_socio",length=50,nullable=false)
	private String mtpSocio;
	@Column(length=50,nullable=false)
	private String grupo;
	@Column(length=50,nullable=false)
	private String delegacia;
	@Column(length=3,nullable=false)
	private String eleitor;
	@Column(length=30,nullable=false)
	private String distrito;
	@Column(name="nit",length=50,nullable=false)
	private String nit;
	@Column(name="dt_filiacao",nullable=false)
	private Date dtFiliacao;
	@Column(name="dt_saida",nullable=false)
	private Date dtSaida;
	@Column(name="dt_emis_reser",nullable=false)
	private Date dtEmisReservista;
	@Column(name="dt_retornor",nullable=false)
	private Date dtRetorno;
	
	public String getReservista() {
		return reservista;
	}

	public void setReservista(String reservista) {
		this.reservista = reservista;
	}

	public String getFlCativa() {
		return flCativa;
	}

	public void setFlCativa(String flCativa) {
		this.flCativa = flCativa;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getFlCasaPropria() {
		return flCasaPropria;
	}

	public void setFlCasaPropria(String flCasaPropria) {
		this.flCasaPropria = flCasaPropria;
	}

	public String getNmConjuge() {
		return nmConjuge;
	}

	public void setNmConjuge(String nmConjuge) {
		this.nmConjuge = nmConjuge;
	}

	public String getCpfConjuge() {
		return cpfConjuge;
	}

	public void setCpfConjuge(String cpfConjuge) {
		this.cpfConjuge = cpfConjuge;
	}

	public String getTpSocio() {
		return tpSocio;
	}

	public void setTpSocio(String tpSocio) {
		this.tpSocio = tpSocio;
	}
	
	public String getMtpSocio() {
		return mtpSocio;
	}

	public void setMtpSocio(String mtpSocio) {
		this.mtpSocio = mtpSocio;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getDelegacia() {
		return delegacia;
	}

	public void setDelegacia(String delegacia) {
		this.delegacia = delegacia;
	}

	public String getEleitor() {
		return eleitor;
	}

	public void setEleitor(String eleitor) {
		this.eleitor = eleitor;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Date getDtFiliacao() {
		return dtFiliacao;
	}

	public void setDtFiliacao(Date dtFiliacao) {
		this.dtFiliacao = dtFiliacao;
	}

	public Date getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public Date getDtEmisReservista() {
		return dtEmisReservista;
	}

	public void setDtEmisReservista(Date dtEmisReservista) {
		this.dtEmisReservista = dtEmisReservista;
	}

	public Date getDtRetorno() {
		return dtRetorno;
	}

	public void setDtRetorno(Date dtRetorno) {
		this.dtRetorno = dtRetorno;
	}	
}
