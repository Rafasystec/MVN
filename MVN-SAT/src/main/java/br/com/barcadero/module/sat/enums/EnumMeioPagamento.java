package br.com.barcadero.module.sat.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * 
01 - Dinheiro
02 - Cheque
03 - Cartão de Crédito
04 - Cartão de Débito
05 - Crédito Loja
10 - Vale Alimentação
11 - Vale Refeição
12 - Vale Presente
13 - Vale Combustível
99 - Outros
 * @author root
 *
 */
@XmlType
@XmlEnum
public enum EnumMeioPagamento {

	@XmlEnumValue("01") DINHEIRO,
	@XmlEnumValue("02") CHEQUE,
	@XmlEnumValue("03") CARTAO_CREDITO,
	@XmlEnumValue("04") CARTAO_DEBITO,
	@XmlEnumValue("05") CREDITO_LOJA,
	@XmlEnumValue("10") VALE_ALIMENTACAO,
	@XmlEnumValue("11") VALE_REFEICAO,
	@XmlEnumValue("12") VALE_PRESENTE,
	@XmlEnumValue("13") VALE_COMBUSTIVEL,
	@XmlEnumValue("99") OUTROS 
}

