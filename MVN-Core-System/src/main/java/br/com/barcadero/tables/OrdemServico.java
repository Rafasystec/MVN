package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumNotaAtendimento;
import br.com.barcadero.core.enums.EnumTipoOS;

/**
 * Classe para salvar a OS
 * @author antoniorafael
 */
@Entity
@Table(name="ORDEM_SERVICO")
public class OrdemServico extends EntidadeLoja {

	
	
	private static final long serialVersionUID = 8721539366117609577L;
	@Column(name="DT_ENTRADA")
	private Date dtEntrada;
	@Column(name="HR_ENTRADA")
	private Date hrEntrada;
	@Column(name="DT_SAIDA")
	private Date dtSaida;
	@Column(name="HR_SAIDA")
	private Date hrSaida;
	@Column(name="DT_PREVISAO_ENTREGA")
	private Date dtPrevisaoEntrega;
	@ManyToOne
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;
	@Column(name="TIPO_OS")
	private String tipoOS;
	@ManyToOne
	@JoinColumn(name="cod_vendedor")
	private Vendedor vendedor;
	@Column(name="")
	private EnumNotaAtendimento notaAtendimento;
	
	public Date getDtEntrada() {
		return dtEntrada;
	}
	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}
	public Date getHrEntrada() {
		return hrEntrada;
	}
	public void setHrEntrada(Date hrEntrada) {
		this.hrEntrada = hrEntrada;
	}
	public Date getDtSaida() {
		return dtSaida;
	}
	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}
	public Date getHrSaida() {
		return hrSaida;
	}
	public void setHrSaida(Date hrSaida) {
		this.hrSaida = hrSaida;
	}
	public Date getDtPrevisaoEntrega() {
		return dtPrevisaoEntrega;
	}
	public void setDtPrevisaoEntrega(Date dtPrevisaoEntrega) {
		this.dtPrevisaoEntrega = dtPrevisaoEntrega;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public EnumTipoOS getTipoOS() {

		EnumTipoOS type = EnumTipoOS.ORCAMENTO;
		if(tipoOS.equalsIgnoreCase("O")){
			type = EnumTipoOS.ORCAMENTO;
		}else if(tipoOS.equalsIgnoreCase("V")){
			type = EnumTipoOS.OS_VENDA;
		}else if(tipoOS.equalsIgnoreCase("G")){
			type = EnumTipoOS.GARANTIA;
		}else if(tipoOS.equalsIgnoreCase("T")){
			type = EnumTipoOS.ORCAMENTO;
		}if(tipoOS.equalsIgnoreCase("R")){
			type = EnumTipoOS.RESERVA;
		}
		return type;
	}
	public void setTipoOS(EnumTipoOS tipoOS) {
		this.tipoOS = tipoOS.getValue();
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public EnumNotaAtendimento getNotaAtendimento() {
		return notaAtendimento;
	}
	public void setNotaAtendimento(EnumNotaAtendimento notaAtendimento) {
		this.notaAtendimento = notaAtendimento;
	}
	
	
}
