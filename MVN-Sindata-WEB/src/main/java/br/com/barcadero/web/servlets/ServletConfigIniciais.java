package br.com.barcadero.web.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.barcadero.rule.RuleEstado;

@WebServlet(
		loadOnStartup=5,
		urlPatterns = { "/config/iniciais" } 
		)
public class ServletConfigIniciais extends HttpServlet {

	private static final long serialVersionUID = 6265667955340119546L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		RuleEstado ruleEstado = context.getBean(RuleEstado.class);
		try {
			ruleEstado.carregarEstados();
		} catch (Exception e) {
			System.err.println("Erro ao carregar os Estados");
			e.printStackTrace();
		}
		
	}
}
