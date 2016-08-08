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
public enum EnumCSTCOFINS {
	
	@XmlEnumValue("01") _01 ("01", "Operação Tributável com Alíquota Básica."), 
	@XmlEnumValue("02") _02 ("02", "Operação Tributável com Alíquota Diferenciada."), 
	@XmlEnumValue("03") _03 ("03", "Operação Tributável com Alíquota por Unidade de Medida de Produto."), 
	@XmlEnumValue("04") _04 ("04", "Operação Tributável Monofásica - Revenda a Alíquota Zero."), 
	@XmlEnumValue("05") _05 ("05", "Operação Tributável por Substituição Tributária."), 
	@XmlEnumValue("06") _06 ("06", "Operação Tributável a Alíquota Zero."), 
	@XmlEnumValue("07") _07 ("07", "Operação Isenta da Contribuição."), 
	@XmlEnumValue("08") _08 ("08", "Operação sem Incidência da Contribuição."), 
	@XmlEnumValue("09") _09 ("09", "Operação com Suspensão da Contribuição."), 
	@XmlEnumValue("49") _49 ("49", "Outras Operações de Saída."), 
	@XmlEnumValue("50") _50 ("50", "Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno."), 
	@XmlEnumValue("51") _51 ("51", "Operação com Direito a Crédito - Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno."), 
	@XmlEnumValue("52") _52 ("52", "Operação com Direito a Crédito - Vinculada Exclusivamente a Receita de Exportação."), 
	@XmlEnumValue("53") _53 ("53", "Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno."), 
	@XmlEnumValue("54") _54 ("54", "Operação com Direito a Crédito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportação."),
	@XmlEnumValue("55") _55 ("55", "Operação com Direito a Crédito - Vinculada a Receitas Não Tributadas no Mercado Interno e de Exportação."), 
	@XmlEnumValue("56") _56 ("56", "Operação com Direito a Crédito - Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno e de Exportação."), 
	@XmlEnumValue("60") _60 ("60", "Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Tributada no Mercado Interno."), 
	@XmlEnumValue("61") _61 ("61", "Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita Não-Tributada no Mercado Interno."), 
	@XmlEnumValue("62") _62 ("62", "Crédito Presumido - Operação de Aquisição Vinculada Exclusivamente a Receita de Exportação."), 
	@XmlEnumValue("63") _63 ("63", "Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno."), 
	@XmlEnumValue("64") _64 ("64", "Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas no Mercado Interno e de Exportação."),
	@XmlEnumValue("65") _65 ("65", "Crédito Presumido - Operação de Aquisição Vinculada a Receitas Não-Tributadas no Mercado Interno e de Exportação."), 
	@XmlEnumValue("66") _66 ("66", "Crédito Presumido - Operação de Aquisição Vinculada a Receitas Tributadas e Não-Tributadas no Mercado Interno e de Exportação."), 
	@XmlEnumValue("67") _67 ("67", "Crédito Presumido - Outras Operações."), 
	@XmlEnumValue("70") _70 ("70", "Operação de Aquisição sem Direito a Crédito."), 
	@XmlEnumValue("71") _71 ("71", "Operação de Aquisição com Isenção."), 
	@XmlEnumValue("72") _72 ("72", "Operação de Aquisição com Suspensão."), 
	@XmlEnumValue("73") _73 ("73", "Operação de Aquisição a Alíquota Zero."), 
	@XmlEnumValue("74") _74 ("74", "Operação de Aquisição sem Incidência da Contribuição."), 
	@XmlEnumValue("75") _75 ("75", "Operação de Aquisição por Substituição Tributária."), 
	@XmlEnumValue("98") _98 ("98", "Outras Operações de Entrada."), 
	@XmlEnumValue("99") _99 ("99", "Outras Operações."); 
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
