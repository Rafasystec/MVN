package br.com.gsind.beans;

import java.util.Date;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

import br.com.systeconline.rule.FacadeFiliado;
import br.com.systeconline.tables.basicos.Filiado;

@ManagedBean
@ApplicationScoped
public class BeanFiliado {
	
	private long codigo;
	private long matricula;
	private int sessao;
	private int zona;
	private String tipo;
	private String reservista;
	private String observacao;
	private String flCativa;
	private String raca;
	private String flCasaPropria;
	private String nmConjuge;
	private String cpfConjuge;
	private String tpSocio;
	//Filiacao do associado
	private String nmPai;
	private String nmMae;
	private String profissao;
	private String mtpSocio;
	private String flStatus;
	private String nome;
	private String grupo;
	private String delegacia;
	private String instrucao;
	private String eleitor;
	private String distrito;
	private String inss;
	private String estCivil;
	private String ocupacao;
	private String sexo;
	private String cpf;
	private String rg;
	private String emissorRg;
	private String ctps;
	private String nit;
	private String habilitacao;
	private String categoria;
	private String titulo;
	private String nacionalidade;
	private String naturalidade;
	private Date dtNascimento;
	private Date dtFiliacao;
	private Date dtSaida;
	private Date dtEmisReservista;
	private Date dtRetorno;
	private FacadeFiliado facadeFiliado;

	public BeanFiliado(Session session){
		facadeFiliado	= new FacadeFiliado(session);
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

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

	public String getReservista() {
		return reservista;
	}

	public void setReservista(String reservista) {
		this.reservista = reservista;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getFlCativa() {
		return flCativa;
	}

	public void setFlCativa(String flCativa) {
		this.flCativa = flCativa;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getFlCasaPropria() {
		return flCasaPropria;
	}

	public void setFlCasaPropria(String flCasaPropria) {
		this.flCasaPropria = flCasaPropria;
	}

	public String getNmConjuge() {
		return nmConjuge;
	}

	public void setNmConjuge(String nmConjuge) {
		this.nmConjuge = nmConjuge;
	}

	public String getCpfConjuge() {
		return cpfConjuge;
	}

	public void setCpfConjuge(String cpfConjuge) {
		this.cpfConjuge = cpfConjuge;
	}

	public String getTpSocio() {
		return tpSocio;
	}

	public void setTpSocio(String tpSocio) {
		this.tpSocio = tpSocio;
	}

	public String getNmPai() {
		return nmPai;
	}

	public void setNmPai(String nmPai) {
		this.nmPai = nmPai;
	}

	public String getNmMae() {
		return nmMae;
	}

	public void setNmMae(String nmMae) {
		this.nmMae = nmMae;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getMtpSocio() {
		return mtpSocio;
	}

	public void setMtpSocio(String mtpSocio) {
		this.mtpSocio = mtpSocio;
	}

	public String getFlStatus() {
		return flStatus;
	}

	public void setFlStatus(String flStatus) {
		this.flStatus = flStatus;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getDelegacia() {
		return delegacia;
	}

	public void setDelegacia(String delegacia) {
		this.delegacia = delegacia;
	}

	public String getInstrucao() {
		return instrucao;
	}

	public void setInstrucao(String instrucao) {
		this.instrucao = instrucao;
	}

	public String getEleitor() {
		return eleitor;
	}

	public void setEleitor(String eleitor) {
		this.eleitor = eleitor;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getInss() {
		return inss;
	}

	public void setInss(String inss) {
		this.inss = inss;
	}

	public String getEstCivil() {
		return estCivil;
	}

	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
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

	public Date getDtFiliacao() {
		return dtFiliacao;
	}

	public void setDtFiliacao(Date dtFiliacao) {
		this.dtFiliacao = dtFiliacao;
	}

	public Date getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public Date getDtEmisReservista() {
		return dtEmisReservista;
	}

	public void setDtEmisReservista(Date dtEmisReservista) {
		this.dtEmisReservista = dtEmisReservista;
	}

	public Date getDtRetorno() {
		return dtRetorno;
	}

	public void setDtRetorno(Date dtRetorno) {
		this.dtRetorno = dtRetorno;
	}
	
	public String inserir() {
		
		try {
			return "Registro salvo com sucesso!";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "";
		}
	}
}
