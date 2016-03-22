package br.com.systeconline.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.barcadero.web.beans.GlobalVariables;
import br.com.systeconline.tables.basicos.Usuario;
import br.com.systeconline.web.attributes.Attributs;
/**
 * Este filtro é uma outra maneira de implementar controle de sessao com usuario.
 * @author Rafael Rocha
 * Criado dia 29/11/2013 as 18:28
 */
@WebFilter(urlPatterns="/private/*")
public class FiltroDeAcesso implements Filter{

	private HttpServletRequest req 		= null;
	private HttpServletResponse resp 	= null;
	private HttpSession session	   		= null;
	private Usuario usuario				= null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,	FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		try {
			if(GlobalVariables.isHomologacao){
				chain.doFilter(request, response);
			}else{
				verifyNow(request, response, chain);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * Verifica as credenciais.
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	public void verifyNow(ServletRequest request, ServletResponse response,	FilterChain chain) throws IOException, ServletException {
		req     = (HttpServletRequest)request;
		session = req.getSession(false);
		if(session != null){
			if(session.getAttribute(Attributs.USER) != null){
				usuario = (Usuario)session.getAttribute(Attributs.USER);
			}
		}
		if(usuario == null){
			String contextPath = ((HttpServletRequest) request).getContextPath();
			resp = (HttpServletResponse) response;
			resp.sendRedirect(contextPath + "/public/PagLogin.xhtml");
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
