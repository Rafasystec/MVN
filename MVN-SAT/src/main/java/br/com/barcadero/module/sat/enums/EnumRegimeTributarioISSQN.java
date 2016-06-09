package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * 1 - Microempresa Municipal; 
 * 2 - Estimativa; 
 * 3 - Sociedade de Profissionais; 
 * 4 - Cooperativa; 
 * 5 - Microempresário Individual(MEI);
 * @author antoniorafael
 *
 */
@XmlEnum
@XmlType
public enum EnumRegimeTributarioISSQN {
	
	@XmlEnumValue("1") MIRCOEMPRESA_MUNICIPAL,
	@XmlEnumValue("2") ESTIMATIVA,
	@XmlEnumValue("3") SOCIEDADE_DE_PROFISSIONAIS,
	@XmlEnumValue("4") COOPERATIVA,
	@XmlEnumValue("5") MICROEMPRESARIO_INDIVIDUAL,

}
