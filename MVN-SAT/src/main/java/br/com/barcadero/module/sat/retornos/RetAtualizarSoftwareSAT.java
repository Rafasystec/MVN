package br.com.barcadero.module.sat.retornos;

/**
 * Trata o retorno da atualizacao do software basico do SAT
 * @author Rafael Rocha
 * @since 1.0 dia 12/06/2016 as 11:11
 */
public class RetAtualizarSoftwareSAT extends SuperSATRetorno {
	
	public static RetAtualizarSoftwareSAT getRetorno(String retornoSAT) {
		return (RetAtualizarSoftwareSAT) getDefault(new RetAtualizarSoftwareSAT(), toArray(retornoSAT));
	}

}
