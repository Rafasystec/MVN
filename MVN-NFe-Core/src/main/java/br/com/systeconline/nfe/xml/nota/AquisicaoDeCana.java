package br.com.systeconline.nfe.xml.nota;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//ZC01
@XmlRootElement(name="cana")
@XmlAccessorType(XmlAccessType.FIELD)
public class AquisicaoDeCana {
	@XmlElement(required=true)
	private String safra;
	@XmlElement(required=true)
	private String ref;
	@XmlElement(required=true)
	private List<FornecDiarioCana> forDia;
	@XmlElement(required=true)
	private String qTotMes;
	@XmlElement(required=true)
	private String qTotAnt;
	@XmlElement(required=true)
	private String qTotGer;
	@XmlElement(required=false)
	private List<DeducoesCana> deduc;
	public String getSafra() {
		return safra;
	}
	public void setSafra(String safra) {
		this.safra = safra;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public List<FornecDiarioCana> getForDia() {
		return forDia;
	}
	public void setForDia(List<FornecDiarioCana> forDia) {
		this.forDia = forDia;
	}
	public String getqTotMes() {
		return qTotMes;
	}
	public void setqTotMes(String qTotMes) {
		this.qTotMes = qTotMes;
	}
	public String getqTotAnt() {
		return qTotAnt;
	}
	public void setqTotAnt(String qTotAnt) {
		this.qTotAnt = qTotAnt;
	}
	public String getqTotGer() {
		return qTotGer;
	}
	public void setqTotGer(String qTotGer) {
		this.qTotGer = qTotGer;
	}
	public List<DeducoesCana> getDeduc() {
		return deduc;
	}
	public void setDeduc(List<DeducoesCana> deduc) {
		this.deduc = deduc;
	}
}
