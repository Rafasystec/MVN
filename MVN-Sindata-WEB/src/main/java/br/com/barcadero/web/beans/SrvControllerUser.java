package br.com.barcadero.web.beans;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import org.hibernate.Session;
import com.google.gson.Gson;
import br.com.barcadero.core.db.util.HibernateHelper;
import br.com.barcadero.rule.RuleUsuario;
import br.com.barcadero.tables.Usuario;

@WebServlet(
		name="userController",
		urlPatterns="/userController"
)
public class SrvControllerUser extends HttpServlet {

	
	private static final long serialVersionUID = 6462806622804930368L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType(MediaType.APPLICATION_JSON);
		Session session = HibernateHelper.getSessionFactory().openSession();
		try {
			
			String param = req.getParameter("term");
			System.out.println("Parametro: " + param);
			RuleUsuario fcdUser = new RuleUsuario(null, null, session);
			List<Usuario> list = fcdUser.find(param);
			String result = new Gson().toJson(list);
			resp.getWriter().write(result);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}finally {
			if(session != null){
				session.close();
			}
		}
	}

}
