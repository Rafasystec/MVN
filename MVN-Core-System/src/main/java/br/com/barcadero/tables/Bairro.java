package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(
		{
			@NamedQuery(name=Bairro.FIND		,query="FROM Bairro b"),
			@NamedQuery(name=Bairro.FIND_BY_CODE,query="FROM Bairro b WHERE b.codigo 	 = :codigo"),
			@NamedQuery(name=Bairro.FIND_BY_CID ,query="FROM Bairro WHERE cod_cidade = :codCidade"),
		}
)
@Entity
@Table(name="BAIRRO")
public final class Bairro extends Entidade{

	private static final long serialVersionUID = 4961721198356133300L;

	public Bairro() {
		// TODO Auto-generated constructor stub
	}
	public Bairro(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	public static final String FIND 			= "Bairro.findAll";
	public static final String FIND_BY_CODE 	= "Bairro.findByCode";
	public static final String FIND_BY_CID 		= "Bairro.findByCidade";
	
	@Column(length=60,nullable=false)
	private String descricao;
	@Column(name="cod_ibge",length=14)
	private String codIbge;
	@ManyToOne
	@JoinColumn(name="cod_cidade", referencedColumnName="codigo")
	private Cidade cidade;

	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
