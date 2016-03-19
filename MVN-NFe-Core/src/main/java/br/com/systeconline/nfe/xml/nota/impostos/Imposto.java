package br.com.systeconline.nfe.xml.nota.impostos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.systeconline.nfe.xml.nota.impostos.icms.ICMS;
import br.com.systeconline.nfe.xml.nota.impostos.icms.ICMSUFDest;

//M01
@XmlRootElement(name="imposto")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"vTotTrib","tpTrib","pis","pist","cofins","cofinsst","iCMSUfDest"})
public class Imposto {
	
	@XmlElement(name="vTotTrib", required=false)
	private String vTotTrib;
	@XmlElements(value={
			@XmlElement(name="ICMS", type=ICMS.class),
			@XmlElement(name="IPI",  type=IPI.class),
			@XmlElement(name="II",   type=ImpostoImportacao.class),
			@XmlElement(name="ISSQN",type=ISSQN.class)
	})
	private Object tpTrib;
	@XmlElement(name="PIS", required=true)
	private PIS pis;
	@XmlElement(name="PISST", required=false)
	private PISST pist;
	@XmlElement(name="COFINS", required=true)
	private COFINS cofins;
	@XmlElement(name="COFINSST", required=true)
	private COFINSST cofinsst;
	@XmlElement(name="ICMSUFDest", required=false)
	private ICMSUFDest iCMSUfDest;
	public String getvTotTrib() {
		return vTotTrib;
	}
	public void setvTotTrib(String vTotTrib) {
		this.vTotTrib = vTotTrib;
	}
	public Object getTpTrib() {
		return tpTrib;
	}
	public void setTpTrib(Object tpTrib) {
		this.tpTrib = tpTrib;
	}
	public PIS getPis() {
		return pis;
	}
	public void setPis(PIS pis) {
		this.pis = pis;
	}
	public PISST getPist() {
		return pist;
	}
	public void setPist(PISST pist) {
		this.pist = pist;
	}
	public COFINS getCofins() {
		return cofins;
	}
	public void setCofins(COFINS cofins) {
		this.cofins = cofins;
	}
	public COFINSST getCofinsst() {
		return cofinsst;
	}
	public void setCofinsst(COFINSST cofinsst) {
		this.cofinsst = cofinsst;
	}
	public ICMSUFDest getiCMSUfDest() {
		return iCMSUfDest;
	}
	public void setiCMSUfDest(ICMSUFDest iCMSUfDest) {
		this.iCMSUfDest = iCMSUfDest;
	}
	
	
	
}
