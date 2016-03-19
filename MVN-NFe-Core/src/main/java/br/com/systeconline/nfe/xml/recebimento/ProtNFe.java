package br.com.systeconline.nfe.xml.recebimento;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="protNFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProtNFe {
	
	@XmlAttribute(name="versao")
	private String versao;
	@XmlElement(name="infProt")
	private  List<InfProt> infprot;
	

}
