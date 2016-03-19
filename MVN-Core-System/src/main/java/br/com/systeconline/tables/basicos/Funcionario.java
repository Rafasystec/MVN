package br.com.systeconline.tables.basicos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe criada para persistir os funcionarios do sistema
 * @author Rafael Rocha
 * @since Gsind 1.0 Beta 24/09/2013 as 06:38
 */
@Entity
@Table(name="FUNCIONARIO")
public class Funcionario extends Entidade{
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = -3927665040219416759L;
	public Funcionario(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	@Column(name="cod_interno")
	private long codInterno;
	@Column(name="cod_filiacao")
	private long codFiliacao;
	@Column(name="cod_centro_custo")
	private long codCentroCusto;
	@Column(name="pis",length=15)
	private String pis;
	@Column(name="fgts",length=15)
	private String fgts;
	@Column(name="cart_trabalho",length=15)
	private String cartTrabalho;
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
}
