package br.com.systeconline.nfe.xml.cancelamento.retorno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.systeconline.nfe.xml.Signature;

@XmlRootElement(name="retCancNFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class RetCancNFe {
	
	@XmlAttribute(name="versao")
	private String versao;
	@XmlElement
	private InfCanc infCanc;
	@XmlElement(name="Signature")
	private Signature signature;
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public InfCanc getInfCanc() {
		return infCanc;
	}
	public void setInfCanc(InfCanc infCanc) {
		this.infCanc = infCanc;
	}
	public Signature getSignature() {
		return signature;
	}
	public void setSignature(Signature signature) {
		this.signature = signature;
	}
	
	

}
