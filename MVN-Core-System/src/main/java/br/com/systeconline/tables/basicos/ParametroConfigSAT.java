package br.com.systeconline.tables.basicos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PARAMETRO_CONFIG_SAT")
public class ParametroConfigSAT extends Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ParametroConfigSAT(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	String versaoLayout 	= "";
	String cnpjSoftHouse 	= "";
	String codAtivacao		="";

}
