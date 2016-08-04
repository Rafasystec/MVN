package br.com.barcadero.tables;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.barcadero.commons.util.HandleDateHour;
import br.com.barcadero.core.enums.EnumStatusLista;
import br.com.barcadero.core.util.GlobalNameParam;

@Entity
@Table(name="LISTA_PRESENTE_CLIENTES")
public class ListaPresenteCliente extends EntidadeLoja {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3761482914898199161L;
	@OneToOne
	@JoinColumn(name=GlobalNameParam.PARAM_CLIENTE,referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private Cliente cliente;
	@Column(name="PREFERENCIA")
	private String preferencia = "";
	@Column(name="DT_VALIDADE")
	private Date validade = HandleDateHour.addYears(new Date(), 1);
	@Column(name="STATUS_LISTA")
	private EnumStatusLista status = EnumStatusLista.ABERTA;
	@Column(name="DESC_LOCAL_EVENTO")
	private String descLocalEvento = "";
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getPreferencia() {
		return preferencia;
	}
	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public EnumStatusLista getStatus() {
		return status;
	}
	public void setStatus(EnumStatusLista status) {
		this.status = status;
	}
	public String getDescLocalEvento() {
		return descLocalEvento;
	}
	public void setDescLocalEvento(String descLocalEvento) {
		this.descLocalEvento = descLocalEvento;
	}
	
	
	
	
}
