package br.com.systeconline.nfe.xml.nota;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Y02
@XmlRootElement(name="fat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fatura {
	@XmlElement(required=false)
	private String nFat;
	@XmlElement(required=false)
	private String vOrig;
	@XmlElement(required=false)
	private String vDesc;
	@XmlElement(required=false)
	private String vLiq;
	@XmlElement(required=false)
	private List<Duplicata> dup;
	public String getnFat() {
		return nFat;
	}
	public void setnFat(String nFat) {
		this.nFat = nFat;
	}
	public String getvOrig() {
		return vOrig;
	}
	public void setvOrig(String vOrig) {
		this.vOrig = vOrig;
	}
	public String getvDesc() {
		return vDesc;
	}
	public void setvDesc(String vDesc) {
		this.vDesc = vDesc;
	}
	public String getvLiq() {
		return vLiq;
	}
	public void setvLiq(String vLiq) {
		this.vLiq = vLiq;
	}
	public List<Duplicata> getDup() {
		return dup;
	}
	public void setDup(List<Duplicata> dup) {
		this.dup = dup;
	}
}
