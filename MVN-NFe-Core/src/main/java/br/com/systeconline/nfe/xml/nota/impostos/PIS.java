package br.com.systeconline.nfe.xml.nota.impostos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * nformar apenas um dos grupos
	Q02, Q03, Q04 ou Q05 com
	base valor atribuído ao campo
	Q06 – CST do PIS

 * @author Rafael Rocha
 */
//Q01
@XmlRootElement(name="PIS")
@XmlAccessorType(XmlAccessType.FIELD)
public class PIS {
	
	@XmlElements(value={
			@XmlElement(name="PISAliq",type=PISAliq.class),
			@XmlElement(name="PISQtde",type=PISQtde.class),
			@XmlElement(name="PISNT"  ,type=PISNT.class),
			@XmlElement(name="PISOutr",type=PISOutr.class)
	})
	private Object tpPIS;

	public Object getTpPIS() {
		return tpPIS;
	}

	public void setTpPIS(Object tpPIS) {
		this.tpPIS = tpPIS;
	}

}
