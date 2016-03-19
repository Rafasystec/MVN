package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.systeconline.nfe.xml.nota.impostos.Imposto;

//H01
@XmlRootElement(name="det")
@XmlAccessorType(XmlAccessType.FIELD)
public class Det {
	
	@XmlAttribute(name="nItem",required=true)
	private String nItem;
	@XmlElement(name="prod", required=true)
	private Prod prod;
	@XmlElement(name="imposto", required=true)
	private Imposto imposto;
	@XmlElement(name="infAdProd", required=false)
	private String infAdProd;
	public String getnItem() {
		return nItem;
	}
	public void setnItem(String nItem) {
		this.nItem = nItem;
	}
	public Prod getProd() {
		return prod;
	}
	public void setProd(Prod prod) {
		this.prod = prod;
	}
	public Imposto getImposto() {
		return imposto;
	}
	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}
	public String getInfAdProd() {
		return infAdProd;
	}
	public void setInfAdProd(String infAdProd) {
		this.infAdProd = infAdProd;
	}
	
	
}
