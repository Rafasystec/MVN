package br.com.barcadero.tables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
/*
-------------------------------------------------------------------------------------------------------------
Diferentemente de uma consulta dinâmica, uma Named Query é processada apenas no mo-
mento da inicialização da unidade de persistência. Além disso, os provedores JPA podem mapear
as Named Queries para Stored Procedures pre-compiladas no banco de dados melhorando a perfor-
mance das consultas.
As Named Queries são definidas através de anotações nas classes que implementam as entida-
des. Podemos aplicar a anotação @NamedQuery quando queremos definir apenas uma consulta ou
a anotação @NamedQueries quando queremos definir várias consultas.
-------------------------------------------------------------------------------------------------------------
*/
@NamedQueries(
		{
			@NamedQuery(name=Cidade.FIND_ALL,query="FROM Cidade"),
			@NamedQuery(name=Cidade.FIND_BY_ESTADO,query="FROM Cidade WHERE estado = :estado"),
			@NamedQuery(name=Cidade.FIND_BY_CODE_ESTADO,query="FROM Cidade WHERE cod_estado = :codEstado"),
			@NamedQuery(name=Cidade.FIND_BY_CODE,query="FROM Cidade WHERE codigo = :codigo"),
			@NamedQuery(name=Cidade.FIND_BY_DT_CADASTRO,query="FROM Cidade WHERE dtCadastro = :dtCadastro"),
			@NamedQuery(name=Cidade.FIND_BY_UF,query="FROM Cidade WHERE uf = :uf"),
			@NamedQuery(name=Cidade.FIND_BY_DESC_AND_UF,query="FROM Cidade WHERE uf = :uf AND descricao = :descricao")
			
		}
)
@Entity
public class Cidade extends Entidade{
	
	private static final long serialVersionUID = 1244346870047239328L;

	public Cidade() {
		// TODO Auto-generated constructor stub
	}

	public Cidade(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	public static final String FIND_BY_CODE = "Cidade.findByCode";
	public static final String FIND_ALL 	= "Cidade.findAll";
	public static final String FIND_BY_UF 	= "Cidade.findByUF";
	public static final String FIND_BY_ESTADO = "Cidade.findByEstado";
	public static final String FIND_BY_CODE_ESTADO 	= "Cidade.findByCodEstado";
	public static final String FIND_BY_DT_CADASTRO 	= "Cidade.findByDtCadastro";
	public static final String FIND_BY_DESC_AND_UF 	= "Cidade.findByDescAndUF";
	
	@Column(name="descricao",length=100)
	private String descricao;
	@Column(name="cod_ibge",length=14)
	private String codIbge;
	
	@OneToMany(mappedBy="cidade", targetEntity=Bairro.class, fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	private List<Bairro> bairros = new ArrayList<Bairro>();
	
	@ManyToOne
	@JoinColumn(name="uf", referencedColumnName="uf")
	private Estado estado ;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public List<Bairro> getBairros() {
		return bairros;
	}
	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodIbge() {
		return codIbge;
	}
	public void setCodIbge(String codIbge) {
		this.codIbge = codIbge;
	}
}
