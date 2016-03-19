package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//B14
@XmlRootElement(name="refNF")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefNF {

	@XmlElement(name="cUF",required=true)
	private String cUF;
	@XmlElement(name="AAMM",required=true)
	private String aamm;
	@XmlElement(name="CNPJ",required=true)
	private String cNPJ;
	@XmlElement(name="mod",required=true)
	private String mod;
	@XmlElement(name="serie",required=true)
	private String serie;
	@XmlElement(name="nNF",required=true)
	private String nNF;
}
