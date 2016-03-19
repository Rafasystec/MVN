package br.com.systeconline.nfe.xml.nota.totais;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.systeconline.nfe.xml.nota.impostos.ISSQNtot;
import br.com.systeconline.nfe.xml.nota.impostos.RetTrib;

//W01
@XmlRootElement(name="total")
@XmlAccessorType(XmlAccessType.FIELD)
public class Total {

	@XmlElement(name="ICMSTot",required=true)
	private ICMSTot iCMSTot;
	@XmlElement(name="ISSQNtot",required=false)
	private ISSQNtot iSSQNtot;
	@XmlElement(name="retTrib",required=false)
	private RetTrib retTrib;
	public ICMSTot getiCMSTot() {
		return iCMSTot;
	}
	public void setiCMSTot(ICMSTot iCMSTot) {
		this.iCMSTot = iCMSTot;
	}
	public ISSQNtot getiSSQNtot() {
		return iSSQNtot;
	}
	public void setiSSQNtot(ISSQNtot iSSQNtot) {
		this.iSSQNtot = iSSQNtot;
	}
	
}
