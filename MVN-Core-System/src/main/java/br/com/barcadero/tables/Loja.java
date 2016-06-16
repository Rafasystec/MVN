package br.com.barcadero.tables;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.barcadero.core.util.GlobalNameParam;


@NamedQueries({
	@NamedQuery(name=Loja.FIND_ALL, query="FROM Loja"),
	@NamedQuery(name=Loja.FIND_BY_EMP,query="FROM Loja WHERE cod_emp = :"+GlobalNameParam.PARAM_COD_EMP)
})

@Entity
@Table(name="LOJA")
public class Loja extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5116884318377500706L;



	public Loja() {
		// TODO Auto-generated constructor stub
	}
	
	public Loja(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}
	public static final String FIND_ALL 	= "Loja.findAll";
	public static final String FIND_BY_EMP	= "Loja.findByEmp";
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_pessoa", referencedColumnName="cod_pessoa")
	private PessoaJuridica pessoaJuridica;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_emp", referencedColumnName="codigo")
	private Empresa empresa;
	
//	@OneToMany(cascade=CascadeType.ALL,mappedBy="loja",fetch=FetchType.EAGER,targetEntity=Loja.class)
//	private List<Caixa> caixas;
	
	@Column(name="dt_inauguracao")
	@Temporal(TemporalType.DATE)
	private Date dtInauguracao = new Date();
	
	
	
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
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
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (pessoaJuridica == null) {
			if (other.pessoaJuridica != null)
				return false;
		} else if (!pessoaJuridica.equals(other.pessoaJuridica))
			return false;
		return true;
	}
	
//	public List<Caixa> getCaixas() {
//		return caixas;
//	}
//	public void setCaixas(List<Caixa> caixas) {
//		this.caixas = caixas;
//	}
	
	
	
}
