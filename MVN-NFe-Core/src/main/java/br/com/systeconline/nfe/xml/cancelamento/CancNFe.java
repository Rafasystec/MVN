package br.com.systeconline.nfe.xml.cancelamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cancNFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class CancNFe {

	@XmlAttribute(name="versao")
	private String versao;
	@XmlElement(name="Signature", required=true)
	private String signature;
	
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
