package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ESTOQUE_DETALHE")
public class EstoqueDetalhe extends EntidadeEmpresa {
	
	private static final long serialVersionUID = 581683663726228343L;
	@Column(name="RUA")
	private String rua;
	@Column(name="PRATELEIRA")
	private String prateleira;
	@Column(name="ESTANTE")
	private String estante;
	@Column(name="ARMAZEM")
	private String armazem;
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getPrateleira() {
		return prateleira;
	}
	public void setPrateleira(String prateleira) {
		this.prateleira = prateleira;
	}
	public String getEstante() {
		return estante;
	}
	public void setEstante(String estante) {
		this.estante = estante;
	}
	public String getArmazem() {
		return armazem;
	}
	public void setArmazem(String armazem) {
		this.armazem = armazem;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((armazem == null) ? 0 : armazem.hashCode());
		result = prime * result + ((estante == null) ? 0 : estante.hashCode());
		result = prime * result + ((prateleira == null) ? 0 : prateleira.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
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
		EstoqueDetalhe other = (EstoqueDetalhe) obj;
		if (armazem == null) {
			if (other.armazem != null)
				return false;
		} else if (!armazem.equals(other.armazem))
			return false;
		if (estante == null) {
			if (other.estante != null)
				return false;
		} else if (!estante.equals(other.estante))
			return false;
		if (prateleira == null) {
			if (other.prateleira != null)
				return false;
		} else if (!prateleira.equals(other.prateleira))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}
	
	
}
