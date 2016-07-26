package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumRegimePISCOFINS;

@Entity
@Table(name="ALIQUOTAS_PIS_COFINS")
public class AliquotasPISCOFINS extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 642965318548362118L;
	@Column(name="REGIME")
	@Enumerated(EnumType.STRING)
	private EnumRegimePISCOFINS regime;
	@Column(name="PIS",precision=20, scale=4)
	private float pis 	= 0.0000f;
	@Column(name="COFINS",precision=20, scale=4)
	private float cofins= 0.0000f;
	public EnumRegimePISCOFINS getRegime() {
		return regime;
	}
	public void setRegime(EnumRegimePISCOFINS regime) {
		this.regime = regime;
	}
	public float getPis() {
		return pis;
	}
	public void setPis(float pis) {
		this.pis = pis;
	}
	public float getCofins() {
		return cofins;
	}
	public void setCofins(float cofins) {
		this.cofins = cofins;
	}
	
	
}
