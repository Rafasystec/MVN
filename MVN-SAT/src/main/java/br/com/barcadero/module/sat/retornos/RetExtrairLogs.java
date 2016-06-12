package br.com.barcadero.module.sat.retornos;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import br.com.barcadero.commons.util.HandleFiles;

public class RetExtrairLogs extends SuperSATRetorno {

	private String arquivoBase64;
	
	public String getArquivoBase64() {
		return arquivoBase64;
	}
	
	/**
	 * Obtem o arquivo em base 64 decodificado caso o mesmo exista. Se nao retorna vazio.
	 * @return
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public String getArquivoBase64Decod() throws UnsupportedEncodingException, IOException {
		if(this.arquivoBase64 == null || this.arquivoBase64.isEmpty()){
			return "";
		}else{
			return HandleFiles.decodeBase64(arquivoBase64);
		}
	}

	public void setArquivoBase64(String arquivoBase64) {
		this.arquivoBase64 = arquivoBase64;
	}
	
	/**
	 * Obtem o retorno da funcao extrair logs.
	 * @param retornoSAT
	 * @return
	 */
	public static RetExtrairLogs getRetorno(String retornoSAT) {
		RetExtrairLogs extLogs = (RetExtrairLogs) getDefault(new RetExtrairLogs(), toArray(retornoSAT));
		if(extLogs.getCodigoRetSAT().equals("15000")){
			String list[] = toArray(retornoSAT);
			extLogs.setArquivoBase64(list[5]);
		}
		return extLogs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((arquivoBase64 == null) ? 0 : arquivoBase64.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RetExtrairLogs other = (RetExtrairLogs) obj;
		if (arquivoBase64 == null) {
			if (other.arquivoBase64 != null)
				return false;
		} else if (!arquivoBase64.equals(other.arquivoBase64))
			return false;
		return true;
	}
	
	
}
