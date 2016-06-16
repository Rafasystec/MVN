package br.com.barcadero.core.enums;

public enum EnumNaturezaOperacaoISSQN {

	_01("Tributação no município;",0),
	_02("Tributação fora do município;",0),
	_03("Isenção",0),
	_04("Imune",0),
	_05("Exigibilidade suspensa por decisão judicial",0),
	_06("Exigibilidade suspensa por  procedimento administrativo;",0),
	_07("Não tributável ou não incidência;",0),
	_08("Exportação de Serviço",0);
	private final String label;
	private final int value;
	
	EnumNaturezaOperacaoISSQN(String label, int value){
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public int getValue() {
		return value;
	}
}
