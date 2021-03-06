package br.com.barcadero.tables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import br.com.barcadero.core.listener.ExempleListener;

@Entity
@Table(name="REVISIONS")
@RevisionEntity(ExempleListener.class)
public class CustonAudit implements Serializable{

	private static final long serialVersionUID = -5795250349471044629L;
	
	@Id
	@GeneratedValue
	@RevisionNumber
	private int id;

	@RevisionTimestamp
	private long timestamp;
	
	
	private String userName;
	
	private String why;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getWhy() {
		return why;
	}

	public void setWhy(String why) {
		this.why = why;
	}

	
	
}
