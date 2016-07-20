package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumModeloNota;
@NamedQueries({
	@NamedQuery(name=NotaSequence.FIND_BY_MOD_SERIE,query="FROM NotaSequence WHERE empresa = :empresa AND modeloNota = :modeloNota AND serie = :serie"),
	@NamedQuery(name=NotaSequence.FIND_ALL,query="FROM NotaSequence WHERE empresa = :empresa ")
})

@Entity
@Table(name="NOTA_SEQUENCE")
public class NotaSequence extends EntidadeLoja {

	public static final String FIND_ALL 				= "NotaSequence.findAll";
	public static final String FIND_BY_MOD_SERIE		= "NotaSequence.findByModSerie";	
	public NotaSequence() {
		// TODO Auto-generated constructor stub
	}
	
	public NotaSequence(Empresa empresa, Loja loja, Usuario usuario) {
		super(empresa, loja, usuario);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6483991700596894336L;
	@Column(name="MODELO_NOTA", length=15)
	private EnumModeloNota modeloNota = EnumModeloNota.MOD_59;
	@Column(name="SEQUENCE_ID")
	private long sequence 	= 0;
	@Column(name="SERIE")
	private long serie 		= 0;
	
	public EnumModeloNota getModeloNota() {
		return modeloNota;
	}
	public void setModeloNota(EnumModeloNota modeloNota) {
		this.modeloNota = modeloNota;
	}
	public long getSequence() {
		return sequence;
	}
	public void setSequence(long sequence) {
		this.sequence = sequence;
	}
	public long getSerie() {
		return serie;
	}
	public void setSerie(long serie) {
		this.serie = serie;
	}
	
	
}
