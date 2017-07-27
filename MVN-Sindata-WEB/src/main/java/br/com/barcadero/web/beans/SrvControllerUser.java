package br.com.barcadero.web.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

@WebServlet(
		name="userController",
		urlPatterns="/userController"
)
public class SrvControllerUser extends HttpServlet {

	
	private static final long serialVersionUID = 6462806622804930368L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType(MediaType.APPLICATION_JSON);
		
		try {
			
			String param = req.getParameter("term");
			System.out.println("Parametro: " + param);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

}
