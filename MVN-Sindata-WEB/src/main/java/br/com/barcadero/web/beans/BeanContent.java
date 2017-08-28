package br.com.barcadero.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.web.attributes.Attributs;
import br.com.barcadero.web.functions.HandleHttpSession;

@ManagedBean
@ViewScoped
public class BeanContent {

	private String realIp = "";
	
	public String getRealIp() {
		return realIp;
	}

	public void setRealIp(String realIp) {
		this.realIp = realIp;
		if(this.realIp != null){
			porIpRealNaSessao();
		}
	}

	@PostConstruct
	private void init() {
		
	}
	
	public String getIpFromJSON() {
		String ipJSON = getRealIp().replace("\"", "").replace("{", "").replace("}", "");
		System.out.println(ipJSON);
		String[] list = ipJSON.split(":");
		for (String string : list) {
			System.out.println(string);
		}
		return list[1];
	}
	
	public void porIpRealNaSessao() {
		SessionContext.getInstance().setAttribute(Attributs.IP_ADDRESS,getIpFromJSON() );
	}
	
}
