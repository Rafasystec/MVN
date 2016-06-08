package br.com.barcadero.module.sat.xml.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class CPF {
	
	@XmlValue
	private final String cpf;
	
	public CPF(String cpf){
		this.cpf = cpf;
	}
	
	public String getCPF(){
		return this.cpf;
	}

}
