package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumStatusLista;
import br.com.barcadero.core.util.GlobalNameParam;

@Entity
@Table(name="LISTA_PRESENTE_CLIENTES")
public class ListaPresenteCliente extends EntidadeLoja {

	@OneToOne
	@JoinColumn(name=GlobalNameParam.PARAM_CLIENTE,referencedColumnName=GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN)
	private Cliente cliente;
	
	private String preferencia;
	private Date validade = null;
	private EnumStatusLista status = EnumStatusLista.ABERTA;
	private String descLocalEvento = "";
	
	
	
	
}
