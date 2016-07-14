package br.com.barcadero.tables;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import br.com.barcadero.core.enums.EnumAtividadeEmp;
/**
 * Classe de pesistencia para o cadastro das empresas no sistema.
 * @author Rafael Rocha
 * Nao foi datado o momento da criacao dessa classe pois veio do projeto gsind.
 */

@NamedQueries({
	@NamedQuery(name=Empresa.FIND_ALL		,query="FROM Empresa"),
	@NamedQuery(name=Empresa.FIND_BY_CODE	,query="FROM Empresa e WHERE e.codigo = :empresa")
})

@Entity
public class Empresa extends Entidade {
	public static final String EMPRESA = "empresa";
	private static final long serialVersionUID = 6135467736845199870L;

	public Empresa() {
	}
	
	public Empresa(Usuario usuario) {
		super(usuario);
	}
	public final static String FIND_ALL 	= "Empresa.FindAll";
	public final static String FIND_BY_CODE	= "Empresa.findByCode";
	
	@Column(name="atividade", nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumAtividadeEmp atividade = EnumAtividadeEmp.COMERCIO;
	@Column(name="img_logo", nullable=false)
	private String imgLogo = "";
	@Column(name="dt_fundacao", nullable=false)
	private Date dtFundacao = new Date();
	@Column(name="observacoes", nullable=false)
	private String observacoes = "";
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_pessoa", referencedColumnName="cod_pessoa")
	private PessoaJuridica pessoaJuridica;
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="empresa_usuario",joinColumns={
		@JoinColumn(name="empresa_id",nullable=false, updatable=false)
	}, inverseJoinColumns = {@JoinColumn(name="user_id",nullable=false, updatable=false)})
	private List<Usuario> usuarios;
	@OneToMany(mappedBy="empresa", targetEntity=Loja.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Loja> lojas;
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public EnumAtividadeEmp getAtividade() {
		return atividade;
	}
	public void setAtividade(EnumAtividadeEmp atividade) {
		this.atividade = atividade;
	}
	public String getImgLogo() {
		return imgLogo;
	}
	public void setImgLogo(String imgLogo) {
		this.imgLogo = imgLogo;
	}
	public Date getDtFundacao() {
		return dtFundacao;
	}
	public void setDtFundacao(Date dtFundacao) {
		this.dtFundacao = dtFundacao;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public List<Loja> getLojas() {
		return lojas;
	}

	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

}
