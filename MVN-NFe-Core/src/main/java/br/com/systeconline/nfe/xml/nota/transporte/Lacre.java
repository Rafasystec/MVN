package br.com.systeconline.nfe.xml.nota.transporte;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
//X33
@XmlRootElement(name="lacres")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lacre {

	@XmlElement(required=true)
	private String nLacre;
}
