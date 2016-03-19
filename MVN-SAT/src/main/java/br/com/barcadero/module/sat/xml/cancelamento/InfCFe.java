package br.com.barcadero.module.sat.xml.cancelamento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="InfCFe")
@XmlAccessorType(XmlAccessType.FIELD)
public class InfCFe
{
	@XmlAttribute(required=true)
	private String chCanc;
	@XmlElement(required=true)
	private Ide ide;
	@XmlElement(required=true)
	private Emit emit;
	@XmlElement(required=true)
	private Dest dest;
	@XmlElement(required=true)
	private Total total;
	@XmlElement
	private InfAdic infAdic;

	public String getChCanc()
	{
		return this.chCanc;
	}

	public void setChCanc(String chCanc)
	{
		this.chCanc = chCanc;
	}

	public Ide getIde()
	{
		return this.ide;
	}

	public void setIde(Ide ide)
	{
		this.ide = ide;
	}

	public Emit getEmit()
	{
		return this.emit;
	}

	public void setEmit(Emit emit)
	{
		this.emit = emit;
	}

	public Dest getDest()
	{
		return this.dest;
	}

	public void setDest(Dest dest)
	{
		this.dest = dest;
	}

	public Total getTotal()
	{
		return this.total;
	}

	public void setTotal(Total total)
	{
		this.total = total;
	}

	public InfAdic getInfAdic()
	{
		return this.infAdic;
	}

	public void setInfAdic(InfAdic infAdic)
	{
		this.infAdic = infAdic;
	}
}