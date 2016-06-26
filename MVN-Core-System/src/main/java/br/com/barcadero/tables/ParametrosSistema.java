package br.com.barcadero.tables;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
 
@Entity
@Table(name="PARAMETROS_SISTEMA")
public class ParametrosSistema extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6531796020855424277L;

	@Column(name="DESCRICAO",nullable=false)
	private String descricao;
	@Column(name="NUMERO",nullable=false)
	private int numero;
	@Column(name="DETALHE",nullable=false)
	private String detalhe = "";
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
}
