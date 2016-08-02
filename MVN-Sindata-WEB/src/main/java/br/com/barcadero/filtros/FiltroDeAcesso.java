package br.com.barcadero.filtros;

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
import br.com.barcadero.tables.Usuario;
import br.com.barcadero.web.attributes.Attributs;
import br.com.barcadero.web.beans.GlobalVariables;
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
	//private Usuario usuario				= null;
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
		Usuario usuario = null;
		if(session != null){
			if(session.getAttribute(Attributs.USER) != null){
				usuario = (Usuario)session.getAttribute(Attributs.USER);
				if(validarLojaEEmpresa((HttpServletRequest) request)){
					if(session.getAttribute(Attributs.EMP_LOGADA) != null){
						if(session.getAttribute(Attributs.LOJA_LOGADA) == null){
							redirectToLogin(request, response);
						}
					}else{
						redirectToLogin(request, response);
					}
				}
			}
			if(usuario == null){
				redirectToLogin(request, response);
			}else{
				chain.doFilter(request, response);
			}
		}else{
			redirectToLogin(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	private void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		String contextPath = ((HttpServletRequest) request).getContextPath();
		resp = (HttpServletResponse) response;
		resp.sendRedirect(contextPath + "/public/PagLogin.xhtml");
	}
	
	private boolean validarLojaEEmpresa(HttpServletRequest request) {
		if(request != null){
			String page = request.getRequestURI();
			if(page.indexOf("PagLogin") != -1 || page.indexOf("PagEscolherEmpresa") != -1){
				return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
	}
	
}
