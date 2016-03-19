package br.com.systeconline.nfe.xml.nota.impostos.icms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//N03
@XmlRootElement(name="ICMS10")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMS10 extends ICMSSuperClass00{
	@XmlElement(name="pMVAST", required=false)
	private String pMVAST;
	@XmlElement(name="pRedBCST", required=false)
	private String pRedBCST;
	@XmlElement(name="vBCST", required=false)
	private String vBCST;
	@XmlElement(name="pICMSST", required=false)
	private String pICMSST;
	public String getpMVAST() {
		return pMVAST;
	}
	public void setpMVAST(String pMVAST) {
		this.pMVAST = pMVAST;
	}
	public String getpRedBCST() {
		return pRedBCST;
	}
	public void setpRedBCST(String pRedBCST) {
		this.pRedBCST = pRedBCST;
	}
	public String getvBCST() {
		return vBCST;
	}
	public void setvBCST(String vBCST) {
		this.vBCST = vBCST;
	}
	public String getpICMSST() {
		return pICMSST;
	}
	public void setpICMSST(String pICMSST) {
		this.pICMSST = pICMSST;
	}
	

}
