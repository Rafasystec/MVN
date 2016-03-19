package br.com.systeconline.nfe.xml.nota;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.systeconline.nfe.xml.nota.transporte.VeicProd;

//I01
@XmlRootElement(name="prod")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prod {
	
	@XmlElement(required=true)
	private String cProd;
	@XmlElement(required=true)
	private String cEAN;
	@XmlElement(required=true)
	private String xProd;
	@XmlElement(required=true)
	private String NCM;
	@XmlElement(required=true)
	private String EXTIPI;
	@XmlElement(required=true)
	private String CFOP;
	@XmlElement(required=true)
	private String uCom;
	@XmlElement(required=true)
	private String qCom;
	@XmlElement(required=true)
	private String vUnCom;
	@XmlElement(required=true)
	private String vProd;
	@XmlElement(required=true)
	private String cEANTrib;
	@XmlElement(required=true)
	private String uTrib;
	@XmlElement(required=true)
	private String qTrib;
	@XmlElement(required=true)
	private String vUnTrib;
	@XmlElement(required=true)
	private String vFret;
	@XmlElement(required=true)
	private String vSeg;
	@XmlElement(required=true)
	private String vDesc;
	@XmlElement(required=true)
	private String vOutro;
	@XmlElement(required=true)
	private String indTot;
	@XmlElement(required=false)
	private List<DeclaracaoDeImportacao> DI;
	@XmlElements(value = {
			@XmlElement(name="veicProd", type=VeicProd.class),
			@XmlElement(name="med", type=Medicamento.class),
			@XmlElement(name="arma", type=Armamento.class),
			@XmlElement(name="comb", type=Combustiveis.class)
	})
	private Object detalhamentoEspecifico;
	public String getcProd() {
		return cProd;
	}
	public void setcProd(String cProd) {
		this.cProd = cProd;
	}
	public String getcEAN() {
		return cEAN;
	}
	public void setcEAN(String cEAN) {
		this.cEAN = cEAN;
	}
	public String getxProd() {
		return xProd;
	}
	public void setxProd(String xProd) {
		this.xProd = xProd;
	}
	public String getNCM() {
		return NCM;
	}
	public void setNCM(String nCM) {
		NCM = nCM;
	}
	public String getEXTIPI() {
		return EXTIPI;
	}
	public void setEXTIPI(String eXTIPI) {
		EXTIPI = eXTIPI;
	}
	public String getCFOP() {
		return CFOP;
	}
	public void setCFOP(String cFOP) {
		CFOP = cFOP;
	}
	public String getuCom() {
		return uCom;
	}
	public void setuCom(String uCom) {
		this.uCom = uCom;
	}
	public String getqCom() {
		return qCom;
	}
	public void setqCom(String qCom) {
		this.qCom = qCom;
	}
	public String getvUnCom() {
		return vUnCom;
	}
	public void setvUnCom(String vUnCom) {
		this.vUnCom = vUnCom;
	}
	public String getvProd() {
		return vProd;
	}
	public void setvProd(String vProd) {
		this.vProd = vProd;
	}
	public String getcEANTrib() {
		return cEANTrib;
	}
	public void setcEANTrib(String cEANTrib) {
		this.cEANTrib = cEANTrib;
	}
	public String getuTrib() {
		return uTrib;
	}
	public void setuTrib(String uTrib) {
		this.uTrib = uTrib;
	}
	public String getqTrib() {
		return qTrib;
	}
	public void setqTrib(String qTrib) {
		this.qTrib = qTrib;
	}
	public String getvUnTrib() {
		return vUnTrib;
	}
	public void setvUnTrib(String vUnTrib) {
		this.vUnTrib = vUnTrib;
	}
	public String getvFret() {
		return vFret;
	}
	public void setvFret(String vFret) {
		this.vFret = vFret;
	}
	public String getvSeg() {
		return vSeg;
	}
	public void setvSeg(String vSeg) {
		this.vSeg = vSeg;
	}
	public String getvDesc() {
		return vDesc;
	}
	public void setvDesc(String vDesc) {
		this.vDesc = vDesc;
	}
	public String getvOutro() {
		return vOutro;
	}
	public void setvOutro(String vOutro) {
		this.vOutro = vOutro;
	}
	public String getIndTot() {
		return indTot;
	}
	public void setIndTot(String indTot) {
		this.indTot = indTot;
	}
	public List<DeclaracaoDeImportacao> getDI() {
		return DI;
	}
	public void setDI(List<DeclaracaoDeImportacao> dI) {
		DI = dI;
	}
	public Object getDetalhamentoEspecifico() {
		return detalhamentoEspecifico;
	}
	public void setDetalhamentoEspecifico(Object detalhamentoEspecifico) {
		this.detalhamentoEspecifico = detalhamentoEspecifico;
	}
	
}
