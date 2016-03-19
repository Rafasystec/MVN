package br.com.systeconline.nfe.xml.consulta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="consReciNFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConsReciNFe {
	
	@XmlAttribute
	private String versao;
	@XmlElement
	private String tpAmb;
	@XmlElement
	private String nRec;
	@XmlElement
	private String cStat;
	@XmlElement
	private String xMotivo;
	@XmlElement
	private String cUF;
	@XmlElement
	private String cMsg;
	@XmlElement
	private String xMsg;
	
	
	public String getcStat() {
		return cStat;
	}
	public void setcStat(String cStat) {
		this.cStat = cStat;
	}
	public String getxMotivo() {
		return xMotivo;
	}
	public void setxMotivo(String xMotivo) {
		this.xMotivo = xMotivo;
	}
	public String getcUF() {
		return cUF;
	}
	public void setcUF(String cUF) {
		this.cUF = cUF;
	}
	public String getcMsg() {
		return cMsg;
	}
	public void setcMsg(String cMsg) {
		this.cMsg = cMsg;
	}
	public String getxMsg() {
		return xMsg;
	}
	public void setxMsg(String xMsg) {
		this.xMsg = xMsg;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getTpAmb() {
		return tpAmb;
	}
	public void setTpAmb(String tpAmb) {
		this.tpAmb = tpAmb;
	}
	
	/**
	 * Número do Recibo
		Número gerado pelo Portal da Secretaria de
		Fazenda Estadual

	 * @return
	 */
	public String getnRec() {
		return nRec;
	}
	
	/**
	 * Número do Recibo
		Número gerado pelo Portal da Secretaria de
		Fazenda Estadual

	 * @param nRec : Numero do recibo
	 */
	public void setnRec(String nRec) {
		this.nRec = nRec;
	}

}
