package br.com.systeconline.nfe.xml.nota.transporte;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.systeconline.nfe.xml.nota.impostos.RetTransp;
//X01
@XmlRootElement(name="infNFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transp {

	@XmlElement(required=true)
	private String modFrete;
	@XmlElement(required=false)
	private Transporta transporta;
	@XmlElement(name="retTansp",required=false)
	private RetTransp retTransp;
	@XmlElement(required=false)
	private VeicTransp veicTransp;
	@XmlElement(required=false)
	private List<Reboque> reboque;
	@XmlElements(value = {
			@XmlElement(name="vagao",type=Vagao.class),
			@XmlElement(name="balsa",type=Balsa.class)
	})
	private Object vagaoOuBalsa;
	@XmlElement(name="vol",required=false)
	private List<Volumes> vol;
	public String getModFrete() {
		return modFrete;
	}
	public void setModFrete(String modFrete) {
		this.modFrete = modFrete;
	}
	public Transporta getTransporta() {
		return transporta;
	}
	public void setTransporta(Transporta transporta) {
		this.transporta = transporta;
	}
	public RetTransp getRetTransp() {
		return retTransp;
	}
	public void setRetTransp(RetTransp retTransp) {
		this.retTransp = retTransp;
	}
	public VeicTransp getVeicTransp() {
		return veicTransp;
	}
	public void setVeicTransp(VeicTransp veicTransp) {
		this.veicTransp = veicTransp;
	}
	public List<Reboque> getReboque() {
		return reboque;
	}
	public void setReboque(List<Reboque> reboque) {
		this.reboque = reboque;
	}
	public Object getVagaoOuBalsa() {
		return vagaoOuBalsa;
	}
	public void setVagaoOuBalsa(Object vagaoOuBalsa) {
		this.vagaoOuBalsa = vagaoOuBalsa;
	}
	public List<Volumes> getVol() {
		return vol;
	}
	public void setVol(List<Volumes> vol) {
		this.vol = vol;
	}
}
