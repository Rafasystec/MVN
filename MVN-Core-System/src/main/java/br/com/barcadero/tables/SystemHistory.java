package br.com.barcadero.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * Para os hisotricos de atualizacao de versoes da aplicacao
 * @author antoniorafael
 *
 */
@Entity
@Table(name="SYSTEM_HISTORY")
public class SystemHistory extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5113059931000466301L;
	@Column(name="VERSAO",length=15)
	private String versao;
	@Column(name="NOME_COMERCIAL",length=25)
	private String nomeComercial;
	@Column(name="CNPJ_SOFTWAREHOUSE",length=14)
	private String cnpjSoftwareHouse;
	
	@ManyToOne
	@JoinColumn(name="system", referencedColumnName="codigo")
	private SystemProperties system;
	
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getNomeComercial() {
		return nomeComercial;
	}
	public void setNomeComercial(String nomeComercial) {
		this.nomeComercial = nomeComercial;
	}
	public String getCnpjSoftwareHouse() {
		return cnpjSoftwareHouse;
	}
	public void setCnpjSoftwareHouse(String cnpjSoftwareHouse) {
		this.cnpjSoftwareHouse = cnpjSoftwareHouse;
	}
	public SystemProperties getSystem() {
		return system;
	}
	public void setSystem(SystemProperties system) {
		this.system = system;
	}
	
	
}
