package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PIS")
@XmlAccessorType(XmlAccessType.FIELD)
public class PIS
{
	@XmlElement
	private PISAliq PISAliq;
	@XmlElement
	private PISQtde PISQtde;
	@XmlElement
	private PISNT PISNT;
	@XmlElement
	private PISSN PISSN;
	@XmlElement
	private PISOutr PISOutr;

	public PISAliq getPISAliq()
	{
		return this.PISAliq;
	}

	public void setPISAliq(PISAliq aliq)
	{
		this.PISAliq = aliq;
	}

	public PISQtde getPISQtde()
	{
		return this.PISQtde;
	}

	public void setPISQtde(PISQtde qtde)
	{
		this.PISQtde = qtde;
	}

	public PISNT getPISNT()
	{
		return this.PISNT;
	}

	public void setPISNT(PISNT pisnt)
	{
		this.PISNT = pisnt;
	}

	public PISSN getPISSN()
	{
		return this.PISSN;
	}

	public void setPISSN(PISSN pissn)
	{
		this.PISSN = pissn;
	}

	public PISOutr getPISOutr()
	{
		return this.PISOutr;
	}

	public void setPISOutr(PISOutr outr)
	{
		this.PISOutr = outr;
	}
}