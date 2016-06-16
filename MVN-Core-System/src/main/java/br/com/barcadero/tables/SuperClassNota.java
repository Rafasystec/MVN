package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class SuperClassNota extends EntidadeLoja {
	

	public SuperClassNota(){
		
	}
	
	private static final long serialVersionUID = 1L;
	public SuperClassNota(Loja loja, Usuario usuario) {
		super(loja, usuario);
		// TODO Auto-generated constructor stub
	}
//	@Column(name="CD_NOTA", nullable=false)
//	private long cdNota;
	@Column(name="SERIE_NOTA", nullable=false)
	private String serieNota;
    public String getSerieNota() {
		return serieNota;
	}
	public void setSerieNota(String serieNota) {
		this.serieNota = serieNota;
	}

//	public long getCdNota() {
//		return cdNota;
//	}
//	public void setCdNota(long cdNota) {
//		this.cdNota = cdNota;
//	}
}
