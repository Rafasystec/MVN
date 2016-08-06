package br.com.barcadero.core.xml.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class RSGenericResponse {
	private boolean status;
    private String message;
    private String errorCode;
    private XMLGenericEntity entity;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public XMLGenericEntity getEntity() {
		return entity;
	}
	public void setEntity(XMLGenericEntity entity) {
		this.entity = entity;
	}
}
