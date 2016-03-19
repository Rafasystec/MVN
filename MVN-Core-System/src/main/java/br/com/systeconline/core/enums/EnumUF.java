package br.com.systeconline.core.enums;

/**
 * Enum para as UF brasileiras
 * @author Rafael Rocha
 */
public enum EnumUF {
	
	AC("Acre",12),
	AL("Alagoas",27),
	AP("Amapá",16),
	AM("Amazonas",13),
	BA("Bahia",29),
	CE("Ceará",23),
	DF("Distrito Federal",53),
	ES("Espírito Santo",32),
	GO("Goiás",52),
	MA("Maranhão",21),
	MT("Mato Grosso",51),
	MS("Mato Grosso do Sul",50),
	MG("Minas Gerais",31),
	PA("Pará",15),
	PB("Paraíba",25),
	PR("Paraná",41),
	PE("Pernambuco",26),
	PI("Piauí",22),
	RJ("Rio de Janeiro",33),
	RN("Rio Grande do Norte",24),
	RS("Rio Grande do Sul",43),
	RO("Rondônia",11),
	RR("Roraima",14),
	SC("Santa Catarina",42),
	SP("São Paulo",35),
	SE("Sergipe",28),
	TO("Tocantins",17);
	
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
