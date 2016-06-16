package br.com.barcadero.core.enums;

/**
 * Para definir qual eh a atividade que um empresa faz.
 * Nao mudar a ordem, pois eh posicional
 * @author Rafael Rocha
 * @since dia 14/02/2016
 */
 public enum EnumAtividadeEmp {

	INDUSTRIA("Indústria"),
	COMERCIO("Comércio"),
	TECNOLOGIA("Tecnologia"),
	QUIMICA("Química"),
	ARMAMENTO("Armamento"),
	MEDICAMENTOS("Medicamentos"),
	COMBUSTIVEL("Combustíveis"),
	NAVAL("Naval"),
	AERONAUTICA("Aeronáutica"),
	HOSPITALAR("Hospitalar"),
	OUTRA("Outra");
	
	private final String label;
	EnumAtividadeEmp(String label){
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
	
}
