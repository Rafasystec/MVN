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
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	

}
