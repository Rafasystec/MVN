package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
//B20a
@XmlRootElement(name="refNFP")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefNFP {
	
	@XmlElement(name="cUF", required=true)
	private String cUF;
	@XmlElement(name="AAMM", required=true)
	private String aamm;
	@XmlElement(name="CNPJ", required=true)
	private String cNPJ;
	@XmlElement(name="CPF", required=true)
	private String cPF;
	@XmlElement(name="IE", required=true)
	private String iE;
	@XmlElement(name="mod", required=true)
	private String mod;
	@XmlElement(name="serie", required=true)
	private String serie;
	@XmlElement(name="nNF", required=true)
	private String nNF;
	
}
