package br.com.barcadero.module.sat.retornos;

public class RetConsultarStatusOperacional extends SuperSATRetorno {
	
	private String conteudoRetorno;

	public String getConteudoRetorno() {
		return conteudoRetorno;
	}

	public void setConteudoRetorno(String conteudoRetorno) {
		this.conteudoRetorno = conteudoRetorno;
	}
	
	/**
	 * Obtem o retorno do Status operacional
	 * @param retornoSAT
	 * @return
	 */
	public static RetConsultarStatusOperacional getRetorno(String retornoSAT) {
		RetConsultarStatusOperacional retCon = new RetConsultarStatusOperacional();
		String[] listValues 	= toArray(retornoSAT); 
		if(listValues != null){
			retCon = (RetConsultarStatusOperacional) getDefault(retCon, listValues);
			if(retCon.getCodigoRetSAT().equals("10000")){
				retCon.setConteudoRetorno(listValues[5]);
			}
		}
		return retCon;
	}
}
