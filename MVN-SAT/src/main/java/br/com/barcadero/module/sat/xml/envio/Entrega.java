package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.enums.EnumUF;

@XmlRootElement(name="entrega")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entrega
{
	@XmlElement(required=true)
	private String xLgr;
	@XmlElement(required=true)
	private String nro;
	@XmlElement
	private String xCpl;
	@XmlElement(required=true)
	private String xBairro;
	@XmlElement(required=true)
	private String xMun;
	@XmlElement(required=true)
	private EnumUF UF;

	public String getXLgr()
	{
		return this.xLgr;
	}

	public void setXLgr(String xLgr)
	{
		this.xLgr = xLgr;
	}

	public String getNro()
	{
		return this.nro;
	}

	public void setNro(String nro)
	{
		this.nro = nro;
	}

	public String getXCpl()
	{
		return this.xCpl;
	}

	public void setXCpl(String xCpl)
	{
		this.xCpl = xCpl;
	}

	public String getXBairro()
	{
		return this.xBairro;
	}

	public void setXBairro(String xBairro)
	{
		this.xBairro = xBairro;
	}

	public String getXMun()
	{
		return this.xMun;
	}

	public void setXMun(String xMun)
	{
		this.xMun = xMun;
	}

	public EnumUF getUF()
	{
		return this.UF;
	}

	public void setUF(EnumUF uf)
	{
		this.UF = uf;
	}
}