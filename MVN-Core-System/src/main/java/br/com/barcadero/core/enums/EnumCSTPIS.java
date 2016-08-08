package br.com.barcadero.core.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Rafael Rocha
 *
 */
@XmlType
@XmlEnum
public enum EnumCSTPIS {

	@XmlEnumValue("01") _01("Cumulativo/não cumulativo",01),
	@XmlEnumValue("02") _02("Alíquota diferenciada",02),
	@XmlEnumValue("03") _03("Alíquota PIS Qtde",03),
	@XmlEnumValue("04") _04("Tributação monofásica(ZERO)",04),
	@XmlEnumValue("05") _05("Substituição Tributária",05),
	@XmlEnumValue("06") _06("Operação Tributável",06),
	@XmlEnumValue("07") _07("Operação Isenta da Contribuição",07),
	@XmlEnumValue("08") _08("Operação Sem Incidência da Contribuição", 8),
	@XmlEnumValue("09") _09("Operação com Suspensão da Contribuição",9),
	@XmlEnumValue("49") _49("Outras Operações de saída",49),
	@XmlEnumValue("99") _99("Outras Operações",99);
	private final String label;
	private final int cst;
	EnumCSTPIS(String label, int cst){
		this.label = label;
		this.cst   = cst;
	}
	public String getLabel() {
		return label;
	}
	public int getCst() {
		return cst;
	}
	
	
}