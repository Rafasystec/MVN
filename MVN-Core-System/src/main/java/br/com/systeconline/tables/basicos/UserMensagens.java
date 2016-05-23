package br.com.systeconline.tables.basicos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Manter as mensagens dos usuarios
 * @author Rafael Rocha
 * @since 1.0 dia 19/05/2016 as 14:50
 */
@Entity
@Table(name="USER_MENSAGENS")
public class UserMensagens extends EntidadeEmpresa {

	@Transient
	private static final long serialVersionUID = 6224039031201562857L;
	public UserMensagens() {
		// TODO Auto-generated constructor stub
	}
	
	public UserMensagens(Empresa empresa,Usuario usuario){
		super(empresa,usuario);
	}
		
	@Column(name="MENSAGEM",nullable=false)
	private String mensagem 	= "";
	@Column(name="DT_MENSAGEM",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dtMensagem 	= new Date();
	@Column(name="HR_MENSAGEM",nullable=false)
	@Temporal(TemporalType.TIME)
	private Date hrMensagem		= new Date();
	@Column(name="CD_USER_RECEIVE",nullable=false)
	private long cdUserReceive	= 0;
	@Column(name="CD_USER_SENT",nullable=false)
	private long cdUsent		= 0;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Date getDtMensagem() {
		return dtMensagem;
	}
	public void setDtMensagem(Date dtMensagem) {
		this.dtMensagem = dtMensagem;
	}
	public Date getHrMensagem() {
		return hrMensagem;
	}
	public void setHrMensagem(Date hrMensagem) {
		this.hrMensagem = hrMensagem;
	}
	public long getCdUserReceive() {
		return cdUserReceive;
	}
	public void setCdUserReceive(long cdUserReceive) {
		this.cdUserReceive = cdUserReceive;
	}
	public long getCdUsent() {
		return cdUsent;
	}
	public void setCdUsent(long cdUsent) {
		this.cdUsent = cdUsent;
	}	
	
	
}
