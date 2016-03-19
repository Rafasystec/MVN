package br.com.barcadero.module.sat.xml.envio;

import java.util.List;
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
	private String versaoDadosEnt;
	@XmlElement(required=true)
	private Ide ide;
	@XmlElement(required=true)
	private Emit emit;
	@XmlElement(required=true)
	private Dest dest;
	@XmlElement
	private Entrega entrega;
	@XmlElement(name="det", required=true)
	private List<Det> dets;
	@XmlElement(required=true)
	private Total total;
	@XmlElement(required=true)
	private Pgto pgto;
	@XmlElement
	private InfAdic infAdic;
  
	public String getVersaoDadosEnt()
	{
		return this.versaoDadosEnt;
	}
	  
	public void setVersaoDadosEnt(String versaoDadosEnt)
	{
		this.versaoDadosEnt = versaoDadosEnt;
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
	
	public Entrega getEntrega()
	{
	  return this.entrega;
	}
	
	public void setEntrega(Entrega entrega)
	{
	  this.entrega = entrega;
	}
	
	public List<Det> getDets()
	{
	  return this.dets;
	}
	
	public void setDets(List<Det> dets)
	{
	  this.dets = dets;
	}
	
	public Total getTotal()
	{
	  return this.total;
	}
	
	public void setTotal(Total total)
	{
	  this.total = total;
	}
	
	public Pgto getPgto()
	{
	  return this.pgto;
	}
	
	public void setPgto(Pgto pgto)
	{
	  this.pgto = pgto;
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
