package br.com.barcadero.module.sat.xml.cancelamento;

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

	public Object getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(Object cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
}