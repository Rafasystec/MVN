package br.com.systeconline.core.enums.nfe;

/**
 * Processo de emissão utilizado com a seguinte codificação:
 *	0 - emissão de NF-e com aplicativo do contribuinte;
 *	1 - emissão de NF-e avulsa pelo Fisco;
 *	2 - emissão de NF-e avulsa, pelo contribuinte com seu certificado digital, através do site do Fisco;
 *	3- emissão de NF-e pelo contribuinte com aplicativo fornecido pelo Fisco.
 * @author Rafael Rocha
 *
 */
public enum EnumNFeTpProcessoEmissao {

	APP_CONTRIBUINTE,
	AVULSA_FISCO,
	AVULSA_CONTRIBUINTE,
	CONTRIBUINTE_APP_FISCO
}
