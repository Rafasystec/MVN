package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;

import br.com.barcadero.core.enums.EnumAtivo;
import br.com.barcadero.core.enums.EnumEstadoCivil;
import br.com.barcadero.core.enums.EnumSexo;
import br.com.barcadero.core.enums.EnumUF;

@Entity
@PrimaryKeyJoinColumn(name="cod_pessoa")
public class PessoaFisica extends Pessoa{
	/**
	 * 
	 */
	private static final long serialVersionUID = 86665324914320987L;

	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}
	
	public PessoaFisica(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	@Column(name="email",nullable=false)
	private String email = "";
	@Column(name="matricula", nullable=false)
	private long matricula = 0;
	@Column(name="tipo",length=2,nullable=false)
	private String tipo = "";
	@Column(length=100,nullable=false)
	private String nome = "";
	@Column(nullable=false)
	private int sessao = 0;
	@Column(nullable=false)
	private int zona = 0;
	@Column(name="observacao",length=200,nullable=false)
	private String observacao = "";
	@Column(length=40,nullable=false)
	private String profissao = "";
	@Column(length=50,nullable=false)
	private String instrucao = "";
	@Column(name="estado_civil",length=20,nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private EnumEstadoCivil estCivil = EnumEstadoCivil.SOLTEIRO;
	@Column(name="sexo",length=1,nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumSexo sexo = EnumSexo.M;
	@Column(length=30)
	private String ocupacao = "";
	@Column(length=15,nullable=false)
	private String cpf = "";
	@Column(length=20,nullable=false)
	private String rg = "";
	@Column(name="emissor_rg",length=15,nullable=false)
	private String emissorRg = "";
	@Column(name="habilitacao",length=20,nullable=false)
	private String habilitacao = "";
	@Column(name="categoria",length=5,nullable=false)
	private String categoria = "";
	@Column(name="titulo",length=20,nullable=false)
	private String titulo = "";
	@Column(name="nacionalidade",length=30,nullable=false)
	private String nacionalidade = "";
	@Column(name="naturalidade",length=30,nullable=false)
	private String naturalidade = "";
	@Column(name="dt_nascimento",nullable=false)
	private Date dtNascimento;
	
	@Column(name="fl_status",length=3,nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumAtivo flStatus= EnumAtivo.S;
	
	@Column(name="telefone",nullable=false)
	private String telefone = "0";
	@Column(name="celular",nullable=false)
	private String celular = "0";
	@Column(name="uf_natural",nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumUF ufNatural = EnumUF.AC;

	
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSessao() {
		return sessao;
	}
	public void setSessao(int sessao) {
		this.sessao = sessao;
	}
	public int getZona() {
		return zona;
	}
	public void setZona(int zona) {
		this.zona = zona;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getInstrucao() {
		return instrucao;
	}
	public void setInstrucao(String instrucao) {
		this.instrucao = instrucao;
	}
	public EnumEstadoCivil getEstCivil() {
		return estCivil;
	}
	public void setEstCivil(EnumEstadoCivil estCivil) {
		this.estCivil = estCivil;
	}
	public EnumSexo getSexo() {
		return sexo;
	}
	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}
	public String getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEmissorRg() {
		return emissorRg;
	}
	public void setEmissorRg(String emissorRg) {
		this.emissorRg = emissorRg;
	}
	public String getHabilitacao() {
		return habilitacao;
	}
	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public EnumAtivo getFlStatus() {
		return flStatus;
	}
	
	public void setFlStatus(EnumAtivo flStatus) {
		this.flStatus = flStatus;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public EnumUF getUfNatural() {
		return ufNatural;
	}
	public void setUfNatural(EnumUF ufNatural) {
		this.ufNatural = ufNatural;
	}	
}
