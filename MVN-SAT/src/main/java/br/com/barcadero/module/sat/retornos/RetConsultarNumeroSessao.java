package br.com.barcadero.module.sat.retornos;

/**
 * Trata o retorno do comando ConsultarNumeroSessao
 * @author Antonio Rafael
 * @since 12/06/2016
 */
public class RetConsultarNumeroSessao extends SuperSATRetorno {

	/**
	 * Retorna a ultima operacao realizada.
	 * @param retornoSAT
	 * @return
	 */
	public static SuperSATRetorno getRetorno(String retornoSAT) {
		RetConsultarNumeroSessao retConNum = new RetConsultarNumeroSessao();
		String[] listValues 	= toArray(retornoSAT); 
		if(listValues != null){
			retConNum = (RetConsultarNumeroSessao) getDefault(retConNum, listValues);
//			if(retConNum.getCodigoRetSAT().equals("10000")){
//				return RetConsultarStatusOperacional.getRetorno(retornoSAT);
//			}
		}
		return retConNum;
	}
}
