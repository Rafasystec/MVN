package br.com.barcadero.tables;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumUF;

/**
 * Para as aliquotas de ICMS em relaçao a cada estado. Noa somente para ICMS pode existir outros
 * impostos que dependeam do Estado de origem para o de destino
 * @author Rafael Rocha
 * @since 1.0 Dia 24/07/2016 as 19:16
 */
@Entity
@Table(name="REGRA_TRIBUTARIA")
public class RegraTributaria extends Entidade {

	/**
	 * Serial ID para serializacao 
	 */
	private static final long serialVersionUID = -8936650028941313598L;
	@Column(name="UF_ORIGEM",length=2)
	@Enumerated(EnumType.STRING)
	private EnumUF uFOrigem;
	@Column(name="UF_DESTINO",length=2)
	@Enumerated(EnumType.STRING)
	private EnumUF uFDestino;
	@Column(name="ALIQUOTA_ICMS")
	private BigDecimal aliquotaICMS;
	
	public EnumUF getuFOrigem() {
		return uFOrigem;
	}
	public void setuFOrigem(EnumUF uFOrigem) {
		this.uFOrigem = uFOrigem;
	}
	public EnumUF getuFDestino() {
		return uFDestino;
	}
	public void setuFDestino(EnumUF uFDestino) {
		this.uFDestino = uFDestino;
	}
	public BigDecimal getAliquotaICMS() {
		return aliquotaICMS;
	}
	public void setAliquotaICMS(BigDecimal aliquotaICMS) {
		this.aliquotaICMS = aliquotaICMS;
	}
	
	
	
}
