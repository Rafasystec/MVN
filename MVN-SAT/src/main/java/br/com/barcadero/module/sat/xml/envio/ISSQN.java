package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ISSQN")
@XmlAccessorType(XmlAccessType.FIELD)
public class ISSQN
{
	@XmlElement(required=true)
	private String vDeducISSQN;
	@XmlElement(required=true)
	private String vAliq;
	@XmlElement
	private String cMunFG;
	@XmlElement
	private String cListServ;
	@XmlElement
	private String cServTribMun;
	@XmlElement
	private String cNatOp;
	@XmlElement(required=true)
	private String indIncFisc;

	public String getVDeducISSQN()
	{
		return this.vDeducISSQN;
	}

	public void setVDeducISSQN(String vDeducISSQN)
	{
		this.vDeducISSQN = vDeducISSQN;
	}

	public String getVAliq()
	{
		return this.vAliq;
	}

	public void setVAliq(String vAliq)
	{
		this.vAliq = vAliq;
	}

	public String getCMunFG()
	{
		return this.cMunFG;
	}

	public void setCMunFG(String cMunFG)
	{
		this.cMunFG = cMunFG;
	}

	public String getCListServ()
	{
		return this.cListServ;
	}

	public void setCListServ(String cListServ)
	{
		this.cListServ = cListServ;
	}

	public String getCServTribMun()
	{
		return this.cServTribMun;
	}

	public void setCServTribMun(String cServTribMun)
	{
		this.cServTribMun = cServTribMun;
	}

	public String getCNatOp()
	{
		return this.cNatOp;
	}

	public void setCNatOp(String cNatOp)
	{
		this.cNatOp = cNatOp;
	}

	public String getIndIncFisc()
	{
		return this.indIncFisc;
	}

	public void setIndIncFisc(String indIncFisc)
	{
		this.indIncFisc = indIncFisc;
	}
}