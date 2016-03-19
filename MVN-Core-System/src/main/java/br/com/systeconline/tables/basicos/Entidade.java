package br.com.systeconline.tables.basicos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@MappedSuperclass
public abstract class Entidade implements Serializable {
	
	private static final long serialVersionUID = -4937210358058008264L;

	public Entidade() {
		// TODO Auto-generated constructor stub
	}
	public Entidade(Usuario usuario) {
		// TODO Auto-generated constructor stub
		if(usuario != null){
			this.setUsuario(usuario);
		}
		
	}
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO", nullable=false)
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
	@Column(name="DT_CADASTRO",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtCadastro = new Date();
	@Column(name="HR_CADASTRO",nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hrCadastro = new Date();
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name="cd_user",referencedColumnName="codigo")
	private Usuario usuario;
	
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		if(dtCadastro == null){
			dtCadastro = new Date();
		}
		this.dtCadastro = dtCadastro;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Date getHrCadastro() {
		return hrCadastro;
	}
	public void setHrCadastro(Date hrCadastro) {
		this.hrCadastro = hrCadastro;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
