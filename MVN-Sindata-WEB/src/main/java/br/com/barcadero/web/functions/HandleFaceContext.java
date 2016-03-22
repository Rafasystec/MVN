package br.com.barcadero.web.functions;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class HandleFaceContext {
	
	public static String getHostName() throws UnknownHostException {
		String ipAddress = getIpAddress();
		InetAddress addr = InetAddress.getByName(ipAddress);  // DOMAIN NAME from IP
		String host 	 = addr.getHostName();
		return host;
	}
	
	public static String getIpAddress() throws UnknownHostException {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null){ 
			ipAddress = request.getRemoteAddr();  // IP
		}
		return ipAddress;
	}

}
