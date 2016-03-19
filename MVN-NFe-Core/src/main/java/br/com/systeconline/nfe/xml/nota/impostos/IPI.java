package br.com.systeconline.nfe.xml.nota.impostos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

//O01
@XmlRootElement(name="IPI")
@XmlAccessorType(XmlAccessType.FIELD)
public class IPI {
	
	@XmlElement(required=false)
	private String clEnq;
	@XmlElement(required=false)
	private String CNPJProd;
	@XmlElement(required=false)
	private String cSelo;
	@XmlElement(required=false)
	private String qSelo;
	@XmlElement(required=true)
	private String cEnq;
	@XmlElements(value={
			@XmlElement(name="IPITrib",type=IPITrib.class),
			@XmlElement(name="IPINT",type=IPINT.class)
	})
	private Object tipoIpi;
	public String getClEnq() {
		return clEnq;
	}
	public void setClEnq(String clEnq) {
		this.clEnq = clEnq;
	}
	public String getCNPJProd() {
		return CNPJProd;
	}
	public void setCNPJProd(String cNPJProd) {
		CNPJProd = cNPJProd;
	}
	public String getcSelo() {
		return cSelo;
	}
	public void setcSelo(String cSelo) {
		this.cSelo = cSelo;
	}
	public String getqSelo() {
		return qSelo;
	}
	public void setqSelo(String qSelo) {
		this.qSelo = qSelo;
	}
	public String getcEnq() {
		return cEnq;
	}
	public void setcEnq(String cEnq) {
		this.cEnq = cEnq;
	}
	public Object getTipoIpi() {
		return tipoIpi;
	}
	public void setTipoIpi(Object tipoIpi) {
		this.tipoIpi = tipoIpi;
	}

}	
