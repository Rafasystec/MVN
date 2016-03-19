package br.com.systeconline.nfe.xml.nota.impostos.icms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//N04
@XmlRootElement(name="ICMS20")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMS20 extends ICMSSuperClass00{

	@XmlElement(name="pRedBC", required=true)
	private String pRedBC;

	public String getpRedBC() {
		return pRedBC;
	}

	public void setpRedBC(String pRedBC) {
		this.pRedBC = pRedBC;
	}
}
