package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class SuperClassNota extends EntidadeLoja {
	

	public SuperClassNota(){
		
	}
	
	private static final long serialVersionUID = 1L;
	public SuperClassNota(Empresa empresa, Loja loja, Usuario usuario) {
		super(empresa,loja, usuario);
	}

	@Column(name="SERIE_NOTA", nullable=false)
	private String serieNota = "";
    public String getSerieNota() {
		return serieNota;
	}
	public void setSerieNota(String serieNota) {
		this.serieNota = serieNota;
	}

}
