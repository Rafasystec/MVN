package br.com.barcadero.tables;

/**
 * @author Rafael Rocha
 * dia 06/11/2013 as 23:03
 * Mantera os historicos dos lancamentos do sistema.
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="HISTRICO_LANCAMENTO")
public class HistoricoLancamento extends Entidade{

	private static final long serialVersionUID = 5234674210983840912L;

	public HistoricoLancamento() {
		// TODO Auto-generated constructor stub
	}
	public HistoricoLancamento(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	@Column(name="cod_externo",nullable=false)
	private long codExterno; //Codigo que sera apresentado ao usuario
	@Column(name="cod_emp",nullable=false)
	private long codEmp; //Codigo da empresa.
	@Column(name="descricao",nullable=false)
	private String descricao;
	
	private boolean podeAlterar;
	
	public boolean isPodeAlterar() {
		return podeAlterar;
	}
	public void setPodeAlterar(boolean podeAlterar) {
		this.podeAlterar = podeAlterar;
	}
	public long getCodExterno() {
		return codExterno;
	}
	public void setCodExterno(long codExterno) {
		this.codExterno = codExterno;
	}
	public long getCodEmp() {
		return codEmp;
	}
	public void setCodEmp(long codEmp) {
		this.codEmp = codEmp;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
