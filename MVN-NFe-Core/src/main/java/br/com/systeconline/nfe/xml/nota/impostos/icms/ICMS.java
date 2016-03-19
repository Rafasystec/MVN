package br.com.systeconline.nfe.xml.nota.impostos.icms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

//N01
@XmlRootElement(name="ICMS")
@XmlAccessorType(XmlAccessType.FIELD)
public class ICMS {
	/**
	 * 	Informar apenas um dos grupos
		N02, N03, N04, N05, N06, N07,
		N08, N09, N10, N10a, N10b ou
		N10c com base no conteúdo
		informado na TAG Tributação
		do ICMS. (v2.0)
	 */
	@XmlElements(value = {
			@XmlElement(name="ICMS00",	type=ICMS00.class),
			@XmlElement(name="ICMS10",	type=ICMS10.class),
			@XmlElement(name="ICMS20",	type=ICMS20.class),
			@XmlElement(name="ICMS30",	type=ICMS30.class),
			@XmlElement(name="ICMS40",	type=ICMS40.class),
			@XmlElement(name="ICMS51",	type=ICMS51.class),
			@XmlElement(name="ICMS60",	type=ICMS60.class),
			@XmlElement(name="ICMS70",	type=ICMS70.class),
			@XmlElement(name="ICMS90",	type=ICMS90.class),
			@XmlElement(name="ICMSPart",type=ICMSPart.class),
			@XmlElement(name="ICMSST",	type=ICMSST.class),
			@XmlElement(name="ICMSSN101",	type=ICMSSN101.class),
			@XmlElement(name="ICMSSN102",	type=ICMSSN102.class),
			@XmlElement(name="ICMSSN202",	type=ICMSSN202.class),
			@XmlElement(name="ICMSSN500",	type=ICMSSN500.class),
			@XmlElement(name="ICMSSN900",	type=ICMSSN900.class)
	})
	private Object icms;

	public Object getIcms() {
		return icms;
	}

	public void setIcms(Object icms) {
		this.icms = icms;
	}
	
}
