package br.com.barcadero.core.enums;
/**
 * Forma de emissão da NF-e
 *	1 - Normal;
 *	2 - Contingência FS
 *	3 - Contingência SCAN
 *	4 - Contingência DPEC
 *	5 - Contingência FSDA
 *	6 - Contingência SVC - AN
 *	7 - Contingência SVC - RS
 *	9 - Contingência off-line NFC-e
 * @author Rafael Rocha
 * @since versao 1.0 26/02/2016 as 10:52
 * Por favor nao mudar a ordem
 */
public enum EnumNFeTpEmissao {
	NAO_INFORMADO,
	NORMAL,
	CONTINGENCIA_FS,
	CONTINGENCIA_SCAN,
	CONTINGENCIA_DPEC,
	CONTINGENCIA_FSDA,		
	CONTINGENCIA_SVC_AN,
	CONTINGENCIA_SVC_RS,
	CONTINGENCIA_OFFLINE_NFCE
}
