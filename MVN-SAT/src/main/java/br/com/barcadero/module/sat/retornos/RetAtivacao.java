package br.com.barcadero.module.sat.retornos;

public class RetAtivacao extends SuperSATRetorno {

	private String csr;

	public String getCsr() {
		return csr;
	}

	/**
	 * CSR arquivo (codificado em base 64)
		contendo as informações para a
		solicitação do Certificado Digital. Nota
		este campo só será retornado caso o 
		parâmetro “subComando” for igual a
		“2 ou 3”

	 * @param csr
	 */
	public void setCsr(String csr) {
		this.csr = csr;
	}
	
	public static RetAtivacao getRetorno(String retornoSAT) {
		RetAtivacao retAtivacao = new RetAtivacao();
		String[] listValues 	= toArray(retornoSAT); 
		if(listValues != null){
			retAtivacao = (RetAtivacao)getDefault(retAtivacao, listValues);
			if(retAtivacao.getCodigoRetSAT().equals("04000")){
				retAtivacao.setCsr(listValues[5]);
			}
		}
		return retAtivacao;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((csr == null) ? 0 : csr.hashCode());
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
		RetAtivacao other = (RetAtivacao) obj;
		if (csr == null) {
			if (other.csr != null)
				return false;
		} else if (!csr.equals(other.csr))
			return false;
		return true;
	}
	
}
