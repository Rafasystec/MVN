package br.com.barcadero.tables;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name="AUDIT_TABLE")
@Audited
public class AuditedTable extends Entidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1487539958796354317L;
	private String description;
	private String url;
	private String userName;

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
