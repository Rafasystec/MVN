package br.com.barcadero.core.enums;

public enum EnumCSTCOFINS {
	
	_01 ("01", "Operação Tributável com Alíquota Básica."), 
	_02 ("02", "Operação Tributável com Alíquota Diferenciada."), 
	_03 ("03", "Operação Tributável com Alíquota por Unidade de Medida de Produto."), 
	_04 ("04", "Operação Tributável Monofásica - Revenda a Alíquota Zero."), 
	_05 ("05", "Operação Tributável por Substituição Tributária."), 
	_06 ("06", "Operação Tributável a Alíquota Zero."), 
	_07 ("07", "Operação Isenta da Contribuição."), 
	_08 ("08", "Operação sem Incidência da Contribuição."), 
	_09 ("09", "Operação com Suspensão da Contribuição."), 
	_49 ("49", "Outras Operações de Saída."), 
	_50 ("50", "Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno."), 
	_51 ("51", "Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno."), 
	_52 ("52", "Operação com Direito a Crédito - Vinculada Exclusivamente a Receita de Exportação."), 
	_53 ("53", "Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno."), 
	_54 ("54", "Operação com Direito a Crédito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportação."),
	_55 ("55", "Operação com Direito a Crédito - Vinculada a Receitas Não Tributadas no Mercado Interno e de Exportação."), 
	_56 ("56", "Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno e de Exportação."), 
	_60 ("60", "Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Tributada no Mercado Interno."), 
	_61 ("61", "Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno."), 
	_62 ("62", "Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita de Exportação."), 
	_63 ("63", "Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno."), 
	_64 ("64", "Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas no Mercado Interno e de Exportação."),
	_65 ("65", "Crédito Presumido - Operação de Aquisição Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação."), 
	_66 ("66", "Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno e de Exportação."), 
	_67 ("67", "Crédito Presumido - Outras Operações."), 
	_70 ("70", "Operação de Aquisição sem Direito a Crédito."), 
	_71 ("71", "Operação de Aquisição com Isenção."), 
	_72 ("72", "Operação de Aquisição com Suspensão."), 
	_73 ("73", "Operação de Aquisição a Alíquota Zero."), 
	_74 ("74", "Operação de Aquisição sem Incidência da Contribuição."), 
	_75 ("75", "Operação de Aquisição por Substituição Tributária."), 
	_98 ("98", "Outras Operações de Entrada."), 
	_99 ("99", "Outras Operações."); 
	private final String value;
	private final String label;
	EnumCSTCOFINS(String value, String label){
		this.value = value;
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public String getLabel() {
		return label;
	}


}
