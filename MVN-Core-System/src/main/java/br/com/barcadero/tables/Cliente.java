package br.com.barcadero.tables;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.barcadero.core.enums.EnumTipoPessoa;

@NamedQueries({
			@NamedQuery(name=Cliente.FIND		 			,query="FROM Cliente WHERE empresa = :empresa"),
			@NamedQuery(name=Cliente.FIND_BY_CODE			,query="FROM Cliente WHERE codigo = :codigo"),
			@NamedQuery(name=Cliente.FIND_BY_NAME_OR_CODIGO	,query="FROM Cliente c WHERE c.empresa = :empresa AND (c.codigo = :codigo OR c.pessoaFisica.nome LIKE :nome)")
			
})
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
	public final static String FIND 					= "Cliente.find";
	public final static String FIND_BY_CODE 			= "Cliente.findByCode";
	public final static String FIND_BY_NAME_OR_CODIGO 	= "Cliente.findByNameOrCodigo";

	
	@Column(name="NOME_PAI",nullable=false)
	private String nomePai = "";
	@Column(name="NOME_MAE",nullable=false)
	private String nomeMae = "";
	@Column(name="TIPO_PESSOA")
	@Enumerated(EnumType.STRING)
	private EnumTipoPessoa tipoPessoa = EnumTipoPessoa.FISICA;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_pessoa", referencedColumnName="cod_pessoa")
	private PessoaFisica pessoaFisica;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pessoa_juridica", referencedColumnName="cod_pessoa")
	private PessoaJuridica pessoaJuridica;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="cliente", targetEntity=OrdemServico.class)
	private List<OrdemServico> ordensServicos;

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

	public List<OrdemServico> getOrdensServicos() {
		return ordensServicos;
	}

	public void setOrdensServicos(List<OrdemServico> ordensServicos) {
		this.ordensServicos = ordensServicos;
	}

	public EnumTipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(EnumTipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
}
