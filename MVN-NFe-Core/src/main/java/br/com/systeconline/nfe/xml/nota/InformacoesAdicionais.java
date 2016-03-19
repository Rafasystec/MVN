package br.com.systeconline.nfe.xml.nota;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Z01
@XmlRootElement(name="infAdic")
@XmlAccessorType(XmlAccessType.FIELD)
public class InformacoesAdicionais {

	@XmlElement(required=false)
	private String infAdFisco;
	@XmlElement(required=false)
	private String infCpl;
	@XmlElement(required=false)
	private List<ObsContribuinte> obsCont;
	@XmlElement(required=false)
	private List<ObsFisco> obsFisco;
	@XmlElement(required=false)
	private List<ProcessoReferenciado> procRef;
	public String getInfAdFisco() {
		return infAdFisco;
	}
	public void setInfAdFisco(String infAdFisco) {
		this.infAdFisco = infAdFisco;
	}
	public String getInfCpl() {
		return infCpl;
	}
	public void setInfCpl(String infCpl) {
		this.infCpl = infCpl;
	}
	public List<ObsContribuinte> getObsCont() {
		return obsCont;
	}
	public void setObsCont(List<ObsContribuinte> obsCont) {
		this.obsCont = obsCont;
	}
	public List<ObsFisco> getObsFisco() {
		return obsFisco;
	}
	public void setObsFisco(List<ObsFisco> obsFisco) {
		this.obsFisco = obsFisco;
	}
	public List<ProcessoReferenciado> getProcRef() {
		return procRef;
	}
	public void setProcRef(List<ProcessoReferenciado> procRef) {
		this.procRef = procRef;
	}
}
