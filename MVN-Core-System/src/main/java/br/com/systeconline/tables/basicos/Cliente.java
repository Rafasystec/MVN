package br.com.systeconline.tables.basicos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(
		{
			@NamedQuery(name=Cliente.FIND		 ,query="FROM Cliente"),
			@NamedQuery(name=Cliente.FIND_BY_CODE,query="FROM Cliente WHERE codigo = :codigo")
		}
)
@Entity
@Table(name="CLIENTE")
public class Cliente extends EntidadeEmpresa{

	private static final long serialVersionUID = 6408718672593326415L;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(Empresa empresa, Usuario usuario) {
		super(empresa, usuario);
		// TODO Auto-generated constructor stub
	}
	public final static String FIND = "Cliente.find";
	public final static String FIND_BY_CODE = "Cliente.findByCode";

	
	@Column(name="NOME_PAI",nullable=false)
	private String nomePai;
	@Column(name="NOME_MAE",nullable=false)
	private String nomeMae;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_pessoa", referencedColumnName="cod_pessoa")
	private PessoaFisica pessoaFisica;

	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
}
