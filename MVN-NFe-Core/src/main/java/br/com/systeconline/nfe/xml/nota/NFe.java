package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import br.com.systeconline.nfe.xml.Signature;
//TAG raiz da NF-e
@XmlRootElement(name="NFe", namespace="http://www.portalfiscal.inf.br/nfe")
@XmlAccessorType(XmlAccessType.FIELD)
public class NFe {

	@XmlElement(name="infNFe", required=true)
	private InfNFe infNFe;
	@XmlElement(required=false)
	private InfNFeSupl infNFeSupl;
	@XmlElement(name="Signature", required=true)
	private Signature signature;

	public InfNFe getInfNFe() {
		return infNFe;
	}

	public void setInfNFe(InfNFe infNFe) {
		this.infNFe = infNFe;
	}

	public InfNFeSupl getInfNFeSupl() {
		return infNFeSupl;
	}

	public void setInfNFeSupl(InfNFeSupl infNFeSupl) {
		this.infNFeSupl = infNFeSupl;
	}

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}
}
