package br.com.barcadero.tables;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumSimNao;
 
@NamedQueries({
	@NamedQuery(name=ParametrosSistema.FIND_ALL,query="FROM ParametrosSistema")
})

@Entity
@Table(name="PARAMETROS_SISTEMA")
public class ParametrosSistema extends Entidade {

	public static final String FIND_ALL = "ParametrosSistema.findAll";
	private static final long serialVersionUID = -6531796020855424277L;

	@Column(name="DESCRICAO",nullable=false)
	private String descricao;
	@Column(name="NUMERO",nullable=false)
	private int numero;
	@Column(name="DETALHE",nullable=false)
	private String detalhe = "";
	@Column(name="VALOR",nullable=true)
	@Enumerated(EnumType.STRING)
	private EnumSimNao valor;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((detalhe == null) ? 0 : detalhe.hashCode());
		result = prime * result + numero;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		ParametrosSistema other = (ParametrosSistema) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (detalhe == null) {
			if (other.detalhe != null)
				return false;
		} else if (!detalhe.equals(other.detalhe))
			return false;
		if (numero != other.numero)
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}
	public EnumSimNao getValor() {
		return valor;
	}
	public void setValor(EnumSimNao valor) {
		this.valor = valor;
	}
	
	
}
