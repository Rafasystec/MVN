package br.com.barcadero.filtros;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import br.com.barcadero.core.db.util.HibernateHelper;
import br.com.barcadero.tables.AuditoriaLog;
import br.com.barcadero.web.attributes.Attributs;

/**
 * Servlet Filter implementation class FiltroAuditoriaAcesso
 * Para registrar os acessos ao sistema.
 * @author Rafael Rocha
 */
@WebFilter("/private/*")
public class FiltroAuditoriaAcesso implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAuditoriaAcesso() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	private HttpSession session;
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		session = httpRequest.getSession(true);
		String currentPage	= httpRequest.getServletPath();
		if(session.getAttribute(Attributs.CURRENT_PAGE) == null){
			session.setAttribute(Attributs.LAST_PAGE, currentPage);
			session.setAttribute(Attributs.CURRENT_PAGE, currentPage);
		}else{
			String oldPage = session.getAttribute(Attributs.CURRENT_PAGE).toString();
			if(!oldPage.equals(currentPage)){
				session.setAttribute(Attributs.LAST_PAGE, oldPage);
				session.setAttribute(Attributs.CURRENT_PAGE, currentPage);
			}
		}
		auditHost(httpRequest);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Registra a auditoria no banco de dados
	 * @param httpRequest
	 */
	private void auditHost(HttpServletRequest httpRequest) {
		Session sessionBD = HibernateHelper.getSessionFactory().openSession();
		AuditoriaLog auditoria = new AuditoriaLog();
		try {
			if(httpRequest != null){
				sessionBD.getTransaction().begin();
				auditoria.setCdUser("");
				auditoria.setContextPath(httpRequest.getContextPath());
				auditoria.setCurrentPage(httpRequest.getServletPath());
				auditoria.setDateTimeReq(new Date());
				auditoria.setHostIp(httpRequest.getRemoteAddr());
				auditoria.setHttpSessionId(httpRequest.getRequestedSessionId());
				auditoria.setIsSecure(String.valueOf(httpRequest.isSecure()));
				auditoria.setLastPage(session.getAttribute(Attributs.LAST_PAGE).toString());
				auditoria.setLocale(httpRequest.getLocale().toString());
				auditoria.setMethod(httpRequest.getMethod());
				auditoria.setProtocol(httpRequest.getProtocol());
				auditoria.setRemoteAddress(httpRequest.getRemoteAddr());
				auditoria.setRemotePort(String.valueOf(httpRequest.getRemotePort()));
				auditoria.setRequestURI(httpRequest.getRequestURI());
				auditoria.setRequestURL(httpRequest.getRequestURL().toString());
				auditoria.setServerName(httpRequest.getServerName());
				auditoria.setServerPort(String.valueOf(httpRequest.getServerPort()));
				auditoria.setServletPath(httpRequest.getServletPath());
				sessionBD.save(auditoria);
				sessionBD.getTransaction().commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
			if(sessionBD != null){
				sessionBD.getTransaction().rollback();
			}
			System.out.println("Erro na auditoria: " + e.getMessage());
		}finally {
			if(sessionBD != null){
				sessionBD.close();
			}
		}
	}

}
