package br.com.barcadero.local.tables;

import javax.persistence.Column;


import br.com.barcadero.tables.Entidade;

//@Entity
//@Table(name="INTEGRACAO_SAT_MFE")
public class IntegracaoSATMFe extends Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="",nullable=false)
	private String xml;
	@Column(name="",nullable=false)
	private boolean iniciou;
	@Column(name="",nullable=false)
	private boolean terminou;
	@Column(name="",nullable=false)
	private String retorno;
	@Column(name="",nullable=false)
	private String dadosENviados;

}
