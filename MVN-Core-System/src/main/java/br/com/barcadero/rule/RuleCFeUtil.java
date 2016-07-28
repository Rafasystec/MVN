package br.com.barcadero.rule;

import br.com.barcadero.module.sat.handle.HandleRetornoSAT;
/**
 * Utilidade para o CF-e
 * @author Rafael Rocha
 *
 */
public class RuleCFeUtil {
	/**
	 * Manipula a mensagem de retorno do SAT.
	 * @param retornoSAT
	 * @return
	 */
	public static String getMessage(HandleRetornoSAT retornoSAT) {
		StringBuilder resultBuilder = new StringBuilder("");
		if(retornoSAT != null){
			 resultBuilder.append(retornoSAT.getCodigoRetorno2())
			 .append(" - ").append(retornoSAT.getMensagem());
			 if(!retornoSAT.getCod().trim().isEmpty()){
				 resultBuilder.append(" - SEFAZ Informa: ").append(retornoSAT.getCodigoRetorno2())
				 .append(" - ").append(retornoSAT.getMensagemSEFAZ());
			 }
			 if(!retornoSAT.getCodigoRetorno2().trim().isEmpty()){
				 resultBuilder.append(" - Infor. Adicional: ")
				 	.append(retornoSAT.getCodigoRetorno2());
			 }
			 return resultBuilder.toString();
		}else{
			return "Retorno do SAT veio com valor nulo.";
		}
	}

}
