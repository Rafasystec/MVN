package br.com.barcadero.filtros;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;

import br.com.barcadero.core.db.util.HibernateHelper;
import br.com.barcadero.web.attributes.Attributs;



public class FiltroDeConexao implements Filter{
	/**
	 * @author Rafael Rocha
	 * Criada dia 08/11/2013
	 */
	private EntityManagerFactory factoryManager;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filtro conexao");
		
		try{
			//Realizado no inicio
			//------------------------------------------------------------------------------
			//NOTE: Todo o codigo que estiver antes do metodo doFilter sera executado na ida
			//------------------------------------------------------------------------------
			chain.doFilter(request, response);
			//------------------------------------------------------------------------------
			//NOTE: Todo o codigo que estiver depois do metodo doFilter sera executado na volta
			//------------------------------------------------------------------------------
			//session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			//session.getTransaction().rollback();
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		//this.factoryManager = Persistence.createEntityManagerFactory("GSIND");
	}

}
