package br.com.systeconline.tables.basicos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Filiacao extends Entidade{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Filiacao(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	@Column(name="nm_pai",length=100,nullable=false)
	private String nmPai;
	@Column(name="nm_mae",length=100,nullable=false)
	private String nmMae;
	@Column(name="natural_pai",length=100,nullable=false)
	private String naturalPai;
	@Column(name="natural_mae",length=100,nullable=false)
	private String naturalMae;
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
