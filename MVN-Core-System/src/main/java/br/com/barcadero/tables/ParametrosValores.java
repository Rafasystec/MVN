package br.com.barcadero.tables;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumSimNao;

@Entity
@Table(name="PARAMETROS_VALORES")
public class ParametrosValores extends EntidadeEmpresa {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2258855348967839238L;
	@Column(name="NUMERO",nullable=false)
	private int numero;
	@Column(name="COD_LOJA",nullable=false)
	private String codLoja;
	@Column(name="PARAM_GERAL",nullable=false)
	private EnumSimNao paramgeral = EnumSimNao.NAO;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCodLoja() {
		return codLoja;
	}
	public void setCodLoja(String codLoja) {
		this.codLoja = codLoja;
	}
	public EnumSimNao getParamgeral() {
		return paramgeral;
	}
	public void setParamgeral(EnumSimNao paramgeral) {
		this.paramgeral = paramgeral;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codLoja == null) ? 0 : codLoja.hashCode());
		result = prime * result + numero;
		result = prime * result + ((paramgeral == null) ? 0 : paramgeral.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParametrosValores other = (ParametrosValores) obj;
		if (codLoja == null) {
			if (other.codLoja != null)
				return false;
		} else if (!codLoja.equals(other.codLoja))
			return false;
		if (numero != other.numero)
			return false;
		if (paramgeral != other.paramgeral)
			return false;
		return true;
	}
}
