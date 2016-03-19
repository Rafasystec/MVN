package br.com.systeconline.core.enums.nfe;

/**
 Indicador de presença do comprador no estabelecimento comercial no momento da oepração
 (0-Não se aplica - ex.: Nota Fiscal complementar ou de ajuste;
  1-Operação presencial;
  2-Não presencial, internet;
  3-Não presencial, teleatendimento;
  4-NFC-e entrega em domicílio;
  9-Não presencial, 
  outros 
 * @author root
 *
 */
public enum EnumNFeIndPresencaComprador {
	NAO_APLICAVEL,
	PRESENCIAL,
	INTERNET,
	TELEATENDIMENTO,
	ITEM_5,
	ITEM_6,
	ITEM_7,
	ITEM_8,
	NFCE_EM_DOMICILIO,
	ITEM_10,
	ITEM_11,
	ITEM_12,
	ITEM_13,
	OUTROS
}
