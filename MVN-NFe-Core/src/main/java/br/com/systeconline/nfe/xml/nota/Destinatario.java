package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import br.com.systeconline.nfe.xml.CNPJ;
import br.com.systeconline.nfe.xml.CPF;
import br.com.systeconline.nfe.xml.IdEstrangeiro;

//E01
@XmlRootElement(name="dest")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"cpfCnpjIdEstrangeiro","xNome","enderDest","indIEDest", "iE","iSUF","email"})
public class Destinatario {
	
	public static final String CONTRIB_ICMS_A_VISTA = "1";
	public static final String CONTRIB_ISENT_INSCRI = "2";
	public static final String NAO_CONTRIBUINTE_ICM = "9";
	
	@XmlElements(value = {
			@XmlElement(name="CPF", type=CPF.class),
			@XmlElement(name="CNPJ",type=CNPJ.class),
			@XmlElement(name="idEstrangeiro",type=IdEstrangeiro.class)
			
	})
	private Object cpfCnpjIdEstrangeiro;
	
	@XmlElement(name="xNome", required=true)
	private String xNome;
	@XmlElement(name="enderDest", required=true)
	private EnderDestinatario enderDest;
	@XmlElement(name="indIEDest", required=true)
	private String indIEDest;
	@XmlElement(name="IE", required=true)
	private String iE;
	@XmlElement(name="ISUF", required=false)
	private String iSUF;
	@XmlElement(name="email", required=false)
	private String email;

	public String getxNome() {
		return xNome;
	}
	public void setxNome(String xNome) {
		this.xNome = xNome;
	}
	public EnderDestinatario getEnderDest() {
		return enderDest;
	}
	public void setEnderDest(EnderDestinatario enderDest) {
		this.enderDest = enderDest;
	}
	public String getiE() {
		return iE;
	}
	public void setiE(String iE) {
		this.iE = iE;
	}
	public String getiSUF() {
		return iSUF;
	}
	public void setiSUF(String iSUF) {
		this.iSUF = iSUF;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Object getCpfCnpjIdEstrangeiro() {
		return cpfCnpjIdEstrangeiro;
	}
	public void setCpfCnpjIdEstrangeiro(Object cpfCnpjIdEstrangeiro) {
		this.cpfCnpjIdEstrangeiro = cpfCnpjIdEstrangeiro;
	}
	public String getIndIEDest() {
		return indIEDest;
	}
	/**
	 * Indicador da IE do destinatário:
		1 – Contribuinte ICMSpagamento à vista;
		2 – Contribuinte isento de inscrição;
		9 – Não Contribuinte
	 * @param indIEDest
	 */
	public void setIndIEDest(String indIEDest) {
		this.indIEDest = indIEDest;
	}

}
