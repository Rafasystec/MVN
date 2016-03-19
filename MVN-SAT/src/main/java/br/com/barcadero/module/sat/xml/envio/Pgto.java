package br.com.barcadero.module.sat.xml.envio;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pgto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pgto
{
	@XmlElement(name="MP", required=true)
	private List<MP> mps;

	public List<MP> getMPs()
	{
		return this.mps;
	}

	public void setMPs(List<MP> mps)
	{
		this.mps = mps;
	}
}