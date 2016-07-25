package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="COFINS")
@XmlAccessorType(XmlAccessType.FIELD)
public class COFINS
{
	@XmlElements({
		@XmlElement(name="COFINSAliq"	,type=COFINSAliq.class),
		@XmlElement(name="COFINSQtde"	,type=COFINSQtde.class),
		@XmlElement(name="COFINSNT"		,type=COFINSNT.class),
		@XmlElement(name="COFINSSN"		,type=COFINSSN.class),
		@XmlElement(name="COFINSOutr"	,type=COFINSOutr.class)
	})
	private SuperCOFINS cofins;

	public SuperCOFINS getCofins() {
		return cofins;
	}

	public void setCofins(SuperCOFINS cofins) {
		this.cofins = cofins;
	}
	
}