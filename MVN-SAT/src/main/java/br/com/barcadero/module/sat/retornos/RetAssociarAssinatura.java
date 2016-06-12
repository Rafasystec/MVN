package br.com.barcadero.module.sat.retornos;

/**
 * Obter Assinatura
 * @author Rafael Rocha
 *
 */
public class RetAssociarAssinatura extends SuperSATRetorno {
	
	/**
	 * Retorna o retorno da funcao AssociarAssinatura em forma de objeto
	 * @param retornoSAT
	 * @return
	 */
	public static RetAssociarAssinatura getRetorno(String retornoSAT) {
		return (RetAssociarAssinatura) getDefault(new RetAssociarAssinatura(), toArray(retornoSAT));
	}

}
