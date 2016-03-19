package br.com.barcadero.tables.audit.web;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Para logs da WEB
 * @author Rafael Rocha
 */
@Entity
@Table(name="AUDITORIA_LOG")
public class AuditoriaLog implements Serializable{

	@Transient
	private static final long serialVersionUID = 4453602256065970141L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigo;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTimeReq;
	@Column
	private String cdUser;
	@Column
	private String currentPage;
	@Column
	private String lastPage;
	@Column
	private String httpSessionId;
	@Column
	private String hostIp;
	@Column
	private String contextPath;
	@Column
	private String method;
	@Column
	private String protocol;
	@Column
	private String remoteAddress;
	@Column
	private String remotePort;
	@Column
	private String requestURI;
	@Column
	private String requestURL;
	@Column
	private String serverName;
	@Column
	private String serverPort;
	@Column
	private String locale;
	@Column
	private String isSecure;
	@Column
	private String servletPath;
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public Date getDateTimeReq() {
		return dateTimeReq;
	}
	public void setDateTimeReq(Date dateTimeReq) {
		this.dateTimeReq = dateTimeReq;
	}
	public String getCdUser() {
		return cdUser;
	}
	public void setCdUser(String cdUser) {
		this.cdUser = cdUser;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public String getLastPage() {
		return lastPage;
	}
	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}
	public String getHttpSessionId() {
		return httpSessionId;
	}
	public void setHttpSessionId(String httpSessionId) {
		this.httpSessionId = httpSessionId;
	}
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public String getContextPath() {
		return contextPath;
	}
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getRemoteAddress() {
		return remoteAddress;
	}
	public void setRemoteAddress(String remoteAddress) {
		this.remoteAddress = remoteAddress;
	}
	public String getRemotePort() {
		return remotePort;
	}
	public void setRemotePort(String remotePort) {
		this.remotePort = remotePort;
	}
	public String getRequestURI() {
		return requestURI;
	}
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}
	public String getRequestURL() {
		return requestURL;
	}
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public String getServerPort() {
		return serverPort;
	}
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getIsSecure() {
		return isSecure;
	}
	public void setIsSecure(String isSecure) {
		this.isSecure = isSecure;
	}
	public String getServletPath() {
		return servletPath;
	}
	public void setServletPath(String servletPath) {
		this.servletPath = servletPath;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdUser == null) ? 0 : cdUser.hashCode());
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		result = prime * result + ((contextPath == null) ? 0 : contextPath.hashCode());
		result = prime * result + ((currentPage == null) ? 0 : currentPage.hashCode());
		result = prime * result + ((dateTimeReq == null) ? 0 : dateTimeReq.hashCode());
		result = prime * result + ((hostIp == null) ? 0 : hostIp.hashCode());
		result = prime * result + ((httpSessionId == null) ? 0 : httpSessionId.hashCode());
		result = prime * result + ((isSecure == null) ? 0 : isSecure.hashCode());
		result = prime * result + ((lastPage == null) ? 0 : lastPage.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
		result = prime * result + ((remoteAddress == null) ? 0 : remoteAddress.hashCode());
		result = prime * result + ((remotePort == null) ? 0 : remotePort.hashCode());
		result = prime * result + ((requestURI == null) ? 0 : requestURI.hashCode());
		result = prime * result + ((requestURL == null) ? 0 : requestURL.hashCode());
		result = prime * result + ((serverName == null) ? 0 : serverName.hashCode());
		result = prime * result + ((serverPort == null) ? 0 : serverPort.hashCode());
		result = prime * result + ((servletPath == null) ? 0 : servletPath.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuditoriaLog other = (AuditoriaLog) obj;
		if (cdUser == null) {
			if (other.cdUser != null)
				return false;
		} else if (!cdUser.equals(other.cdUser))
			return false;
		if (codigo != other.codigo)
			return false;
		if (contextPath == null) {
			if (other.contextPath != null)
				return false;
		} else if (!contextPath.equals(other.contextPath))
			return false;
		if (currentPage == null) {
			if (other.currentPage != null)
				return false;
		} else if (!currentPage.equals(other.currentPage))
			return false;
		if (dateTimeReq == null) {
			if (other.dateTimeReq != null)
				return false;
		} else if (!dateTimeReq.equals(other.dateTimeReq))
			return false;
		if (hostIp == null) {
			if (other.hostIp != null)
				return false;
		} else if (!hostIp.equals(other.hostIp))
			return false;
		if (httpSessionId == null) {
			if (other.httpSessionId != null)
				return false;
		} else if (!httpSessionId.equals(other.httpSessionId))
			return false;
		if (isSecure == null) {
			if (other.isSecure != null)
				return false;
		} else if (!isSecure.equals(other.isSecure))
			return false;
		if (lastPage == null) {
			if (other.lastPage != null)
				return false;
		} else if (!lastPage.equals(other.lastPage))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (protocol == null) {
			if (other.protocol != null)
				return false;
		} else if (!protocol.equals(other.protocol))
			return false;
		if (remoteAddress == null) {
			if (other.remoteAddress != null)
				return false;
		} else if (!remoteAddress.equals(other.remoteAddress))
			return false;
		if (remotePort == null) {
			if (other.remotePort != null)
				return false;
		} else if (!remotePort.equals(other.remotePort))
			return false;
		if (requestURI == null) {
			if (other.requestURI != null)
				return false;
		} else if (!requestURI.equals(other.requestURI))
			return false;
		if (requestURL == null) {
			if (other.requestURL != null)
				return false;
		} else if (!requestURL.equals(other.requestURL))
			return false;
		if (serverName == null) {
			if (other.serverName != null)
				return false;
		} else if (!serverName.equals(other.serverName))
			return false;
		if (serverPort == null) {
			if (other.serverPort != null)
				return false;
		} else if (!serverPort.equals(other.serverPort))
			return false;
		if (servletPath == null) {
			if (other.servletPath != null)
				return false;
		} else if (!servletPath.equals(other.servletPath))
			return false;
		return true;
	}
	
	

	
	
}
