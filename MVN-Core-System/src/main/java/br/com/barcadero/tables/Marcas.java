package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumTipoMarca;

@NamedQueries({
	@NamedQuery(name=Marcas.FIND_ALL,query="FROM Marcas WHERE empresa = :cdEmp"),
	@NamedQuery(name=Marcas.FIND_BY_TIPO,query="FROM Marcas WHERE empresa = :cdEmp AND tipoMarca = :tipoMarca ")
})

@Entity
@Table(name="MARCAS")
public class Marcas extends EntidadeEmpresa {

	public static final String FIND_ALL 	= "Marcas.findAll";
	public static final String FIND_BY_TIPO = "Marcas.findByTipo";
	public Marcas() {
		// TODO Auto-generated constructor stub
	}
	
	public Marcas(Empresa empresa,Usuario usuario){
		super(empresa,usuario);
	}
	
	
	private static final long serialVersionUID = -8887073573849216733L;
	
	@Column(name="DESCRICAO")
	private String descricao;
	@Column(name="TIPO_MARCA")
	@Enumerated(EnumType.STRING)
	private EnumTipoMarca tipoMarca;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EnumTipoMarca getTipoMarca() {
		return tipoMarca;
	}

	public void setTipoMarca(EnumTipoMarca tipoMarca) {
		this.tipoMarca = tipoMarca;
	}
	
}
