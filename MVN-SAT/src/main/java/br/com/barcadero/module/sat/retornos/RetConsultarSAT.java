package br.com.barcadero.module.sat.retornos;

/**
 * Tratar o retorno da função ConsultarSAT
 * @author Rafael Rocha
 * @since dia 11/06/2016 as 12:39
 */
public class RetConsultarSAT extends SuperSATRetorno {
	
	/**
	 * Obtem o retorno da funcao ConsultarSAT
	 * @param retornoSAT
	 * @return
	 */
	public static RetConsultarSAT getRetorno(String retornoSAT) {
		String[] listValues 	= toArray(retornoSAT);
		RetConsultarSAT retCon	= new RetConsultarSAT();
		return (RetConsultarSAT) getDefault(retCon, listValues);
	}

}
