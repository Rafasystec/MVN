package br.com.barcadero.web.functions;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.barcadero.web.beans.GlobalVariables;

/**
 * Servlet implementation class HandleServletHomo
 */
@WebServlet(
		loadOnStartup=3,
		urlPatterns = { "/HandleServletHomo" }, 
		initParams = { 
				@WebInitParam(name = "isHomologacao", value = "false", description = "para saber se é para iniciar em homogacao")
		})
public class HandleServletHomo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleServletHomo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String isHomo = config.getServletContext().getInitParameter("homologacao");
		GlobalVariables.isHomologacao = Boolean.parseBoolean(isHomo);
		if(GlobalVariables.isHomologacao){
			System.out.println("Iniciando aplicacao Sindata em modo de homologacao.");
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet Homologacao");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("doPost Homologacao");
	}

}
