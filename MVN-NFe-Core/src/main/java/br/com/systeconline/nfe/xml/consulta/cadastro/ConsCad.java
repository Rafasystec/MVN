package br.com.systeconline.nfe.xml.consulta.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="consCad")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConsCad {
	
	@XmlAttribute
	private String versao;
	@XmlElement
	private InfCons infCons;
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public InfCons getInfCons() {
		return infCons;
	}
	public void setInfCons(InfCons infCons) {
		this.infCons = infCons;
	}

	
}
