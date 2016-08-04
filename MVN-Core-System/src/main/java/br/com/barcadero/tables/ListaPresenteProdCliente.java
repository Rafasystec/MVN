package br.com.barcadero.tables;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.barcadero.core.util.GlobalNameParam;

/**
 * Produtos que compoem a lista do cliente
 * @author antoniorafael
 *
 */
@Entity
@Table(name="LISTA_PRES_PROD_CLIENTE")
public class ListaPresenteProdCliente extends EntidadeLoja {
	
	@OneToOne
	@JoinColumn(name=GlobalNameParam.PARAM_PRODUTO, referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private Produto produto;

}
