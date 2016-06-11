package br.com.barcadero.module.sat.retornos;

import br.com.barcadero.module.sat.handle.HandleSAT;

/**
 * Classe de apoio para o Retorno
 * @author Rafael Rocha
 */
public abstract class SuperSATRetorno {
	
	private String numeroSessao;
	private String codigoRetSAT;
	private String codigoSEFAZ;
	private String msgModulo;
	private String msgSEFAZ;
	public String getNumeroSessao() {
		return numeroSessao;
	}
	public void setNumeroSessao(String numeroSessao) {
		this.numeroSessao = numeroSessao;
	}
	public String getCodigoRetSAT() {
		return codigoRetSAT;
	}
	public void setCodigoRetSAT(String codigoRetSAT) {
		this.codigoRetSAT = codigoRetSAT;
	}
	public String getCodigoSEFAZ() {
		return codigoSEFAZ;
	}
	public void setCodigoSEFAZ(String codigoSEFAZ) {
		this.codigoSEFAZ = codigoSEFAZ;
	}
	public String getMsgModulo() {
		return msgModulo;
	}
	public void setMsgModulo(String msgModulo) {
		this.msgModulo = msgModulo;
	}
	public String getMsgSEFAZ() {
		return msgSEFAZ;
	}
	public void setMsgSEFAZ(String msgSEFAZ) {
		this.msgSEFAZ = msgSEFAZ;
	}
	
	public static String[] toArray(String retorno) {
		return retorno.split(HandleSAT.getPatternPipe());
	}
	
	/**
	 * Obtem os campos padrões de retorno, que são os retornados em caso de erro ou de sucesso
	 * @param superRet
	 * @param listValues
	 * @return
	 */
	public static SuperSATRetorno getDefault(SuperSATRetorno superRet, String[] listValues) {
		superRet.setNumeroSessao(listValues[0]);
		if(superRet instanceof RetEnvioVenda){
			superRet.setCodigoRetSAT(listValues[1]);
			superRet.setMsgModulo(listValues[3]);
			superRet.setCodigoSEFAZ(listValues[4]);
			superRet.setMsgSEFAZ(listValues[5]);
		}else{
			superRet.setCodigoRetSAT(listValues[1]);
			superRet.setMsgModulo(listValues[2]);
			superRet.setCodigoSEFAZ(listValues[3]);
			superRet.setMsgSEFAZ(listValues[4]);
		}
		return superRet;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoRetSAT == null) ? 0 : codigoRetSAT.hashCode());
		result = prime * result + ((codigoSEFAZ == null) ? 0 : codigoSEFAZ.hashCode());
		result = prime * result + ((msgModulo == null) ? 0 : msgModulo.hashCode());
		result = prime * result + ((msgSEFAZ == null) ? 0 : msgSEFAZ.hashCode());
		result = prime * result + ((numeroSessao == null) ? 0 : numeroSessao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperSATRetorno other = (SuperSATRetorno) obj;
		if (codigoRetSAT == null) {
			if (other.codigoRetSAT != null)
				return false;
		} else if (!codigoRetSAT.equals(other.codigoRetSAT))
			return false;
		if (codigoSEFAZ == null) {
			if (other.codigoSEFAZ != null)
				return false;
		} else if (!codigoSEFAZ.equals(other.codigoSEFAZ))
			return false;
		if (msgModulo == null) {
			if (other.msgModulo != null)
				return false;
		} else if (!msgModulo.equals(other.msgModulo))
			return false;
		if (msgSEFAZ == null) {
			if (other.msgSEFAZ != null)
				return false;
		} else if (!msgSEFAZ.equals(other.msgSEFAZ))
			return false;
		if (numeroSessao == null) {
			if (other.numeroSessao != null)
				return false;
		} else if (!numeroSessao.equals(other.numeroSessao))
			return false;
		return true;
	}
	
}
