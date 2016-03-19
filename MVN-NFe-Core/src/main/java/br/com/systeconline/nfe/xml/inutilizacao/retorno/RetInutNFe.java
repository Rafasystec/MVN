package br.com.systeconline.nfe.xml.inutilizacao.retorno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.systeconline.nfe.xml.Signature;


@XmlRootElement(name="retInutNFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class RetInutNFe {
	
	@XmlAttribute
	private String versao;
	@XmlElement
	private InfInut infInut;
	@XmlElement(name="Signature")
	private Signature signature;
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public InfInut getInfInut() {
		return infInut;
	}
	public void setInfInut(InfInut infInut) {
		this.infInut = infInut;
	}
	public Signature getSignature() {
		return signature;
	}
	public void setSignature(Signature signature) {
		this.signature = signature;
	}
	
	
}
