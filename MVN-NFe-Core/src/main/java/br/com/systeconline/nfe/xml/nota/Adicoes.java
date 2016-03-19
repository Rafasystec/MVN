package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//I25
@XmlRootElement(name="adi")
@XmlAccessorType(XmlAccessType.FIELD)
public class Adicoes {
	
	@XmlElement(required=true)
	private String nAdicao;
	@XmlElement(required=true)
	private String nSeqAdic;
	@XmlElement(required=true)
	private String cFabricante;
	@XmlElement(required=false)
	private String vDescDI;
	@XmlElement(required=false)
	private String xPed;
	@XmlElement(required=false)
	private String nItemPed;
	public String getnAdicao() {
		return nAdicao;
	}
	public void setnAdicao(String nAdicao) {
		this.nAdicao = nAdicao;
	}
	public String getnSeqAdic() {
		return nSeqAdic;
	}
	public void setnSeqAdic(String nSeqAdic) {
		this.nSeqAdic = nSeqAdic;
	}
	public String getcFabricante() {
		return cFabricante;
	}
	public void setcFabricante(String cFabricante) {
		this.cFabricante = cFabricante;
	}
	public String getvDescDI() {
		return vDescDI;
	}
	public void setvDescDI(String vDescDI) {
		this.vDescDI = vDescDI;
	}
	public String getxPed() {
		return xPed;
	}
	public void setxPed(String xPed) {
		this.xPed = xPed;
	}
	public String getnItemPed() {
		return nItemPed;
	}
	public void setnItemPed(String nItemPed) {
		this.nItemPed = nItemPed;
	}

	
}
