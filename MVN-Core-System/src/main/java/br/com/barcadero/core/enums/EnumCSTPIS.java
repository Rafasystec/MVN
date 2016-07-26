package br.com.barcadero.core.enums;

public enum EnumCSTPIS {

	_01("Cumulativo/não cumulativo",01),
	_02("Alíquota diferenciada",02),
	_03("Alíquota PIS Qtde",03),
	_04("Tributação monofásica(ZERO)",04),
	_05("Substituição Tributária",05),
	_06("Operação Tributável",06),
	_07("Operação Isenta da Contribuição",07),
	_08("Operação Sem Incidência da Contribuição", 8),
	_09("Operação com Suspensão da Contribuição",9),
	_49("Outras Operações de saída",49),
	_99("Outras Operações",99);
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