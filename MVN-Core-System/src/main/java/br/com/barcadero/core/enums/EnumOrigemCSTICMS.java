package br.com.barcadero.core.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Enum ordinal de acordo com a especificacao do SAT
 * @author antoniorafael
 *
 */
@XmlType
@XmlEnum
public enum EnumOrigemCSTICMS {
	
	@XmlEnumValue("00") NACIONAL("Nacional"),
	@XmlEnumValue("01") ESTRANGEIRA_IMP("Estrangeira - Importação direta"),
	@XmlEnumValue("02") ESTRANGEIRA_INT("Estrangeira - Adquirida no mercado interno"),
	@XmlEnumValue("03") NACIONAL_40("Nacional, conteudo superior 40% e inferior ou igual a 70%"),
	@XmlEnumValue("04") NACIONAL_BASICO("Nacional, processos produtivos básicos"),
	@XmlEnumValue("05") NACIONAL_INF_40("Nacional, conteudo inferior 40%"),
	@XmlEnumValue("06") ESTRANGEIRA_SIMILAR("Estrangeira - Importação direta, com similar nacional, lista CAMEX"),
	@XmlEnumValue("07") ESTRANGEIRA_N_SIMILAR("Estrangeira - mercado interno, sem simular,lista CAMEX"),
	@XmlEnumValue("08") NACIONAL_SUP_70("Nacional, Conteúdo de Importação superior a 70%");
	
	private final String label;
	EnumOrigemCSTICMS(String label){
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
}

