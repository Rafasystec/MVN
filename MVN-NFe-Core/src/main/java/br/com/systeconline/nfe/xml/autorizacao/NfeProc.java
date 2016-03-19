package br.com.systeconline.nfe.xml.autorizacao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="nfeProc")
@XmlAccessorType(XmlAccessType.FIELD)
public class NfeProc {

	@XmlAttribute
	private String versao;

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
	
	
	
}
