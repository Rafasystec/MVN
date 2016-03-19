package br.com.systeconline.nfe.xml.consulta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.systeconline.nfe.xml.Signature;

@XmlRootElement(name="ProtNFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProtNFe {
	
	@XmlAttribute
	private String versao;
	@XmlAttribute
	private InfProt infProt;
	@XmlElement(name="Signature")
	private Signature signature;
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public InfProt getInfProt() {
		return infProt;
	}
	public void setInfProt(InfProt infProt) {
		this.infProt = infProt;
	}
	public Signature getSignature() {
		return signature;
	}
	public void setSignature(Signature signature) {
		this.signature = signature;
	}
	
}
