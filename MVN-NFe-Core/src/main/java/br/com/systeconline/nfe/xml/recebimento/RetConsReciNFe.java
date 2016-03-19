package br.com.systeconline.nfe.xml.recebimento;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Retorno: Estrutura XML com o resultado do processamento da mensagem de envio de lote
 * de NF-e. Retorno quando se consulta o lote
 * @author rafael
 *
 */
@XmlRootElement(name="retConsReciNFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class RetConsReciNFe {
	@XmlAttribute(name="versao")
	private String versao;
	@XmlElement(name="tpAmb")
	private String tpAmb;
	@XmlElement(name="verAplic")
	private String verAplic;
	@XmlElement(name="nRec")
	private String nRec;
	@XmlElement(name="cStat")
	private String cStat;
	@XmlElement(name="xMotivo")
	private String xMotivo;
	@XmlElement(name="cUF")
	private String cUF;
	@XmlElement(name="cMsg")
	private String cMsg;
	@XmlElement(name="xMsg")
	private String xMsg;
	@XmlElement(name="protNFe")
	private List<ProtNFe> protNFe;
	
	
	public List<ProtNFe> getProtNFe() {
		return protNFe;
	}
	public void setProtNFe(List<ProtNFe> protNFe) {
		this.protNFe = protNFe;
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
	public String getVerAplic() {
		return verAplic;
	}
	public void setVerAplic(String verAplic) {
		this.verAplic = verAplic;
	}
	public String getnRec() {
		return nRec;
	}
	public void setnRec(String nRec) {
		this.nRec = nRec;
	}
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
}
