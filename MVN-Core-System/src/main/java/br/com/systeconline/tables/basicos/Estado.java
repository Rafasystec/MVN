package br.com.systeconline.tables.basicos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import br.com.systeconline.core.enums.EnumUF;

@NamedQueries({
		@NamedQuery(name=Estado.FIND,query="FROM Estado"),
		@NamedQuery(name=Estado.FIND_BY_CODE,query="FROM Estado WHERE codigo = :codigo"),
		@NamedQuery(name=Estado.FIND_BY_IBGE,query="FROM Estado WHERE codIbge = :codIbge")
		
})

@Entity
@Table(name="ESTADO")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public final class Estado extends Entidade{

	private static final long serialVersionUID = 3701487730264454049L;

	public Estado() {
		// TODO Auto-generated constructor stub
	}
	
	public Estado(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	public static final String FIND 			= "Estado.findAll";
	public static final String FIND_BY_CODE 	= "Estado.findByCode";
	public static final String FIND_BY_IBGE 	= "Estado.findByIbge";
	public static final String PARAM_IBGE 		= "codIbge";
	
	@Column(name="descricao",length=60)
	private String descricao;
	@Column(name="cod_ibge",length=14)
	private String codIbge;
	@Column(name="uf",length=2,nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumUF uf;
	
	@OneToMany(mappedBy="estado", targetEntity=Cidade.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Cidade> cidades = new ArrayList<Cidade>();
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
	}
	public String getCodIbge() {
		return codIbge;
	}
	public void setCodIbge(String codIbge) {
		this.codIbge = codIbge;
	}
	public EnumUF getUf() {
		return uf;
	}
	public void setUf(EnumUF uf) {
		this.uf = uf;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
}
