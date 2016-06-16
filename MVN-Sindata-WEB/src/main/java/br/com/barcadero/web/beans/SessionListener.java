package br.com.barcadero.web.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import br.com.barcadero.core.handles.HandleEmpresaHomo;
import br.com.barcadero.core.handles.HandleLojaHomo;
import br.com.barcadero.core.handles.HandleUsuarioPadrao;
import br.com.barcadero.web.attributes.Attributs;

@WebListener
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Session was created with id: " + event.getSession().getId());
		if(GlobalVariables.isHomologacao){
			System.out.println("Sistema em homologacao");
			System.out.println("Inserindo usuario padrao de Homologacao");
			event.getSession().setAttribute(Attributs.USER, HandleUsuarioPadrao.getUsuarioHomologacao());
			System.out.println("Inserindo empresa de Homologacao");
			event.getSession().setAttribute(Attributs.EMP_LOGADA, HandleEmpresaHomo.getEmpresaHomo());
			System.out.println("Inserindo loja padrao de Homologacao");
			event.getSession().setAttribute(Attributs.LOJA_LOGADA, HandleLojaHomo.getLojaHomo());
		}

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
		String ultimoAcesso = (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(new Date(event.getSession().getLastAccessedTime())); 
		System.out.println("Sessão expirada "+event.getSession().getId()+". Ultimo Acesso = "+ultimoAcesso);	
	}

}
