package br.com.barcadero.core.xml.entities;

import java.io.Serializable;

public abstract class XMLGenericEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3394421209718356519L;
	private long codigo;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
}
