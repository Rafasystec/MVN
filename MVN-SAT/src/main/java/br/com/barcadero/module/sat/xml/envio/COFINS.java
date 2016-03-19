package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="COFINS")
@XmlAccessorType(XmlAccessType.FIELD)
public class COFINS
{
	@XmlElement
	private COFINSAliq COFINSAliq;
	@XmlElement
	private COFINSQtde COFINSQtde;
	@XmlElement
	private COFINSNT COFINSNT;
	@XmlElement
	private COFINSSN COFINSSN;
	@XmlElement
	private COFINSOutr COFINSOutr;

	public COFINSAliq getCOFINSAliq()
	{
		return this.COFINSAliq;
	}

	public void setCOFINSAliq(COFINSAliq aliq)
	{
		this.COFINSAliq = aliq;
	}

	public COFINSQtde getCOFINSQtde()
	{
		return this.COFINSQtde;
	}

	public void setCOFINSQtde(COFINSQtde qtde)
	{
		this.COFINSQtde = qtde;
	}

	public COFINSNT getCOFINSNT()
	{
		return this.COFINSNT;
	}

	public void setCOFINSNT(COFINSNT cofinsnt)
	{
		this.COFINSNT = cofinsnt;
	}

	public COFINSSN getCOFINSSN()
	{
		return this.COFINSSN;
	}

	public void setCOFINSSN(COFINSSN cofinssn)
	{
		this.COFINSSN = cofinssn;
	}

	public COFINSOutr getCOFINSOutr()
	{
		return this.COFINSOutr;
	}

	public void setCOFINSOutr(COFINSOutr outr)
	{
		this.COFINSOutr = outr;
	}
}