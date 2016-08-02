package br.com.barcadero.tables;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * Para as propriedades principais do Sistema
 * @author antoniorafael
 */
@NamedQueries({
	@NamedQuery(name=SystemProperties.FIND,query="FROM SystemProperties")
})
@Entity
@Table(name="SYSTEM_PROPERTIES")
public class SystemProperties extends Entidade {
	
	public static final String FIND = "SystemProperties.find"; 
	/**
	 * 
	 */
	private static final long serialVersionUID = -1932900202058900146L;
	@Column(name="VERSAO_SISTEMA",length=15)
	private String versaoSistema;
	@Column(name="NOME_COMERCIAL",length=25)
	private String nomeComercial;
	@Column(name="DT_ULTIMA_ALTERACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtUltimaAlteracao;
	@Column(name="CNPJ_SOFTWARE_HOUSE",length=14)
	private String cnpjSoftwareHouse;
	
	@OneToMany(mappedBy="system", targetEntity=SystemDevelopers.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<SystemDevelopers> developers = new ArrayList<>();
	@OneToMany(mappedBy="system", targetEntity=SystemHistory.class, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<SystemHistory> histories = new ArrayList<>();
	
	
	public String getVersaoSistema() {
		return versaoSistema;
	}
	public void setVersaoSistema(String versaoSistema) {
		this.versaoSistema = versaoSistema;
	}
	public String getNomeComercial() {
		return nomeComercial;
	}
	public void setNomeComercial(String nomeComercial) {
		this.nomeComercial = nomeComercial;
	}
	public Date getDtUltimaAlteracao() {
		return dtUltimaAlteracao;
	}
	public void setDtUltimaAlteracao(Date dtUltimaAlteracao) {
		this.dtUltimaAlteracao = dtUltimaAlteracao;
	}
	public String getCnpjSoftwareHouse() {
		return cnpjSoftwareHouse;
	}
	public void setCnpjSoftwareHouse(String cnpjSoftwareHouse) {
		this.cnpjSoftwareHouse = cnpjSoftwareHouse;
	}
	public List<SystemDevelopers> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<SystemDevelopers> developers) {
		this.developers = developers;
	}
	public List<SystemHistory> getHistories() {
		return histories;
	}
	public void setHistories(List<SystemHistory> histories) {
		this.histories = histories;
	}

}
