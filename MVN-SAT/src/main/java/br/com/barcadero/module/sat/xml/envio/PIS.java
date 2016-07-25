package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PIS")
@XmlAccessorType(XmlAccessType.FIELD)
public class PIS
{

	
	@XmlElements({
		@XmlElement(name="PISAliq"	,type=PISAliq.class),
		@XmlElement(name="PISQtde"	,type=PISQtde.class),
		@XmlElement(name="PISNT"	,type=PISNT.class),
		@XmlElement(name="PISSN"	,type=PISSN.class),
		@XmlElement(name="PISOutr"	,type=PISOutr.class)
	})
	/**
	 * Informar apenas um dos grupos
		Q02, Q03, Q04, Q05 ou Q06
		com base valor atribuído ao
	 	campo Q07 – CST do PIS
	 */
	private PISGroup pisGroup;

	public PISGroup getPisGroup() {
		return pisGroup;
	}

	public void setPisGroup(PISGroup pisGroup) {
		this.pisGroup = pisGroup;
	}
   
}      