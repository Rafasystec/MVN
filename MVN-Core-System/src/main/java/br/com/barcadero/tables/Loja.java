package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.module.sat.enums.EnumCFeXMLVersion;
import br.com.barcadero.module.sat.enums.EnumIndRatISSQN;

@NamedQueries({
	@NamedQuery(name=Loja.FIND_ALL, query="FROM Loja WHERE empresa = :empresa"),
	@NamedQuery(name=Loja.FIND_BY_EMP,query="FROM Loja WHERE empresa = :empresa")
})

@Entity
@Table(name="LOJA")
public class Loja extends EntidadeEmpresa {

	private static final long serialVersionUID = 5116884318377500706L;

	public Loja() {
	}
	
	public Loja(Usuario usuario) {
		super(usuario);
	}
	public static final String FIND_ALL 	= "Loja.findAll";
	public static final String FIND_BY_EMP	= "Loja.findByEmp";
	@Column(name="VERSAO_XML_CFE")
	private EnumCFeXMLVersion verXMLCFe = EnumCFeXMLVersion.V_0_06;
	@Column(name="SIGN_AC_SAT")
	private String signAC = "SGR-SAT SISTEMA DE GESTAO E RETAGUARDA DO SAT";
	@Column(name="IND_RAT_ISSQN_CFE")
	@Enumerated(EnumType.STRING)
	private EnumIndRatISSQN indRatISSQNSAT = EnumIndRatISSQN.NAO;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_pessoa", referencedColumnName="cod_pessoa")
	private PessoaJuridica pessoaJuridica;
	
	@Column(name="dt_inauguracao")
	@Temporal(TemporalType.DATE)
	private Date dtInauguracao = new Date();
	
	
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	public Date getDtInauguracao() {
		return dtInauguracao;
	}
	public void setDtInauguracao(Date dtInauguracao) {
		this.dtInauguracao = dtInauguracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dtInauguracao == null) ? 0 : dtInauguracao.hashCode());
		result = prime * result + ((pessoaJuridica == null) ? 0 : pessoaJuridica.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		if (dtInauguracao == null) {
			if (other.dtInauguracao != null)
				return false;
		} else if (!dtInauguracao.equals(other.dtInauguracao))
			return false;
		if (pessoaJuridica == null) {
			if (other.pessoaJuridica != null)
				return false;
		} else if (!pessoaJuridica.equals(other.pessoaJuridica))
			return false;
		return true;
	}

	public EnumCFeXMLVersion getVerXMLCFe() {
		return verXMLCFe;
	}

	public void setVerXMLCFe(EnumCFeXMLVersion verXMLCFe) {
		this.verXMLCFe = verXMLCFe;
	}

	public String getSignAC() {
		return signAC;
	}

	public void setSignAC(String signAC) {
		this.signAC = signAC;
	}

	public EnumIndRatISSQN getIndRatISSQNSAT() {
		return indRatISSQNSAT;
	}

	public void setIndRatISSQNSAT(EnumIndRatISSQN indRatISSQNSAT) {
		this.indRatISSQNSAT = indRatISSQNSAT;
	}
	
	
}
