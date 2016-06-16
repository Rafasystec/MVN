package br.com.systeconline.nfe.xml.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.core.exeptions.XMLException;
import br.com.systeconline.nfe.xml.CNAEFiscal;
import br.com.systeconline.nfe.xml.CNPJ;
import br.com.systeconline.nfe.xml.CPF;
import br.com.systeconline.nfe.xml.InscricaoMunicipal;
//C01
@XmlRootElement(name="emit")
@XmlAccessorType(XmlAccessType.FIELD)
public class Emitente {
	
	@XmlElements(value={
			@XmlElement(name="CPF",type=CPF.class),
			@XmlElement(name="CNPJ",type=CNPJ.class)
	})
	private Object cpfCnpj;
	
	@XmlElement(name="xNome", required=true)
	private String xNome;
	@XmlElement(name="xFant", required=false)
	private String xFant;
	@XmlElement(name="enderEmit", required=true)
	private EnderEmitente enderEmit;
	@XmlElement(name="IE", required=true)
	private String iE;
	@XmlElement(name="IEST", required=false)
	private String iEST;
	@XmlElements(value={
		@XmlElement(name="IM",type=InscricaoMunicipal.class),
		@XmlElement(name="CNAE",type=CNAEFiscal.class)
	})
	private Object imOuCnae;	
	@XmlElement(name="CRT", required=true)
	private String cRT;
	
	public String getxNome() {
		return xNome;
	}
	public void setxNome(String xNome) {
		this.xNome = xNome;
	}
	public String getxFant() {
		return xFant;
	}
	public void setxFant(String xFant) {
		this.xFant = xFant;
	}
	public EnderEmitente getEnderEmit() {
		return enderEmit;
	}
	public void setEnderEmit(EnderEmitente enderEmit) {
		this.enderEmit = enderEmit;
	}
	public String getiE() {
		return iE;
	}
	public void setiE(String iE) {
		this.iE = iE;
	}
	public String getiEST() {
		return iEST;
	}
	/**
	 * Inscricao Estadual do Substituto Tributario
	 * @param iEST
	 */
	public void setiEST(String iEST) {
		this.iEST = iEST;
	}
	
	/**
	 * Este campo sera
		obrigatoriamente preenchido	com:
		1 – Simples Nacional;
	 	2 – Simples Nacional – excesso  de sublimite de receita bruta;
		3 – Regime Normal. 
	 * @return
	 */
	public String getcRT() {
		return cRT;
	}
	/**
	 * Este campo sera
		obrigatoriamente preenchido	com:
		1 – Simples Nacional;
	 	2 – Simples Nacional – excesso  de sublimite de receita bruta;
		3 – Regime Normal.
	 * @param cRT
	 */
	public void setcRT(String cRT) {
		this.cRT = cRT;
	}
	public Object getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(Object cpfCnpj) throws XMLException{
		if(cpfCnpj instanceof CPF  == false &&
		   cpfCnpj instanceof CNPJ == false){
			throw new XMLException("Tipo de objeto " + cpfCnpj.getClass().getName() + " incompativel com " +
		   CPF.class.getName() + " ou " + CNPJ.class.getName());
		}
		this.cpfCnpj = cpfCnpj;
	}
	public Object getImOuCnae() {
		return imOuCnae;
	}
	public void setImOuCnae(Object imOuCnae) {
		this.imOuCnae = imOuCnae;
	}

}
