package br.com.systeconline.nfe.xml.inutilizacao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.systeconline.nfe.xml.Signature;

@XmlRootElement(name="inutNFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class InutNFe {
	
	@XmlAttribute
	private String versao;
	@XmlElement(name="Signature")
	private Signature signature;
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public Signature getSignature() {
		return signature;
	}
	public void setSignature(Signature signature) {
		this.signature = signature;
	}
	
	

}
