package br.com.barcadero.module.sat.retornos;

public class RetCancelarUltimaVenda extends RetEnvioVenda {
	
	public static final String RETORNO_COM_SUCESSO = "07000";
	
	/**
	 * Obtem o objeto de retorno de acordo com o que veio do SAT 
	 * @param retornoSAT
	 * @return
	 */
	public static RetCancelarUltimaVenda getRetorno(String retornoSAT) {
		RetCancelarUltimaVenda retCan 	= new RetCancelarUltimaVenda();
		String[] listValues 	= toArray(retornoSAT); 
		if(listValues != null){
			//Note: aqui atenderemos tanto o retorno da venda como o do cancelamento
			retCan = (RetCancelarUltimaVenda) getDefault(retCan, listValues);
			if( retCan.getCodigoRetSAT().equals("07000")	){
				retCan.setCodigoAlerta(listValues[2]);
				retCan.setArquivoBase64(listValues[6]);
				retCan.setDataHoraTransm(listValues[7]);
				retCan.setChaveConsulta(listValues[8]);
				retCan.setValorTotal(listValues[9]);
				retCan.setCpfCnpjValue(listValues[10]);
				retCan.setAssinaturaQRCode(listValues[11]);
			}
		}
		return retCan;
	}
}
