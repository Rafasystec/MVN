package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//B12a
@XmlRootElement(name="NFref")
@XmlAccessorType(XmlAccessType.FIELD)
public class NFref {

	@XmlElement(name="refNFe", required=true)
	private String refNFe;
	@XmlElement(name="refNF", required=true)
	private RefNF refNF;
	@XmlElement(name="refNFP", required=true)
	private RefNFP refNFP;
	@XmlElement(name="refCTe", required=true)
	private String refCTe;
	@XmlElement(name="refECF", required=true)
	private RefECF refECF;
	
	
}
