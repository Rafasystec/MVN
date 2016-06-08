package br.com.barcadero.module.sat.xml.envio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.barcadero.module.sat.xml.util.CNPJ;
import br.com.barcadero.module.sat.xml.util.CPF;

@XmlRootElement(name="dest")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dest
{

	@XmlElements(value={
			@XmlElement(name="CPF",type=CPF.class),
			@XmlElement(name="CNPJ",type=CNPJ.class)
	})
	private Object cpfCnpj;
	@XmlElement
	private String xNome;
	
	public String getXNome()
	{
		return this.xNome;
	}
	
	/**
	 * Razão Social ou Nome do destinatario
	 * @param xNome
	 */
	public void setXNome(String xNome)
	{
		this.xNome = xNome;
	}

	public Object getCpfCnpj() {
		return cpfCnpj;
	}

	/**
	 * Informar o CPF ou CNPJ do destinatario,
		preenchendo os zeros nao
		significativos. O destinatario do CF-e-SAT nao
		podera ser o seu proprio emitente. Logo, o CNPJ do
		destinatario do CF-e-SAT devera ser	diferente do
		CNPJ do	emitente.
	 * @param cpfCnpj
	 */
	public void setCpfCnpj(Object cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
}