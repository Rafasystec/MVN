package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Filiacao extends Entidade{
	public Filiacao() {
		// TODO Auto-generated constructor stub
	}
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
	public String getNmPai() {
		return nmPai;
	}
	public void setNmPai(String nmPai) {
		this.nmPai = nmPai;
	}
	public String getNmMae() {
		return nmMae;
	}
	public void setNmMae(String nmMae) {
		this.nmMae = nmMae;
	}
	public String getNaturalPai() {
		return naturalPai;
	}
	public void setNaturalPai(String naturalPai) {
		this.naturalPai = naturalPai;
	}
	public String getNaturalMae() {
		return naturalMae;
	}
	public void setNaturalMae(String naturalMae) {
		this.naturalMae = naturalMae;
	}

	
}
