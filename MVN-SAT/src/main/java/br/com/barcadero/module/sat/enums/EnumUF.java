package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Enum para as UF brasileiras
 * @author Rafael Rocha
 */
@XmlType
@XmlEnum
public enum EnumUF {
	
	@XmlEnumValue("AC") AC("Acre",12),
	@XmlEnumValue("AL") AL("Alagoas",27),
	@XmlEnumValue("AP") AP("Amapá",16),
	@XmlEnumValue("AM") AM("Amazonas",13),
	@XmlEnumValue("BA") BA("Bahia",29),
	@XmlEnumValue("CE") CE("Ceará",23),
	@XmlEnumValue("DF") DF("Distrito Federal",53),
	@XmlEnumValue("ES") ES("Espírito Santo",32),
	@XmlEnumValue("GO") GO("Goiás",52),
	@XmlEnumValue("MA") MA("Maranhão",21),
	@XmlEnumValue("MT") MT("Mato Grosso",51),
	@XmlEnumValue("MS") MS("Mato Grosso do Sul",50),
	@XmlEnumValue("MG") MG("Minas Gerais",31),
	@XmlEnumValue("PA") PA("Pará",15),
	@XmlEnumValue("PB") PB("Paraíba",25),
	@XmlEnumValue("PR") PR("Paraná",41),
	@XmlEnumValue("PE") PE("Pernambuco",26),
	@XmlEnumValue("PI") PI("Piauí",22),
	@XmlEnumValue("RJ") RJ("Rio de Janeiro",33),
	@XmlEnumValue("RN") RN("Rio Grande do Norte",24),
	@XmlEnumValue("RS") RS("Rio Grande do Sul",43),
	@XmlEnumValue("RO") RO("Rondônia",11),
	@XmlEnumValue("RR") RR("Roraima",14),
	@XmlEnumValue("SC") SC("Santa Catarina",42),
	@XmlEnumValue("SP") SP("São Paulo",35),
	@XmlEnumValue("SE") SE("Sergipe",28),
	@XmlEnumValue("TO") TO("Tocantins",17);
	
	private final String label;
	private final int cdIbge;
	EnumUF(String label, int cdIbge){
		this.label 	= label;
		this.cdIbge = cdIbge;
	}
	public String getLabel() {
		return label;
	}
	public int getCdIbge() {
		return cdIbge;
	}
}
