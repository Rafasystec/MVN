package br.com.barcadero.core.db.util;

import java.util.Date;

import org.hibernate.Session;

import br.com.barcadero.tables.Estado;

public class ConectaPostgre {
	
	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateHelper.getSessionFactory().openSession();
			//session.beginTransaction();
			//System.out.println("Conectou");
			//Estado estado = new Estado();
			//estado.setCodIbge("00112121");
			//estado.setCodigo(2);
			//estado.setDescricao("CEARA");
			//estado.setDtCadastro(new Date());
			//estado.setUf("CE");
			//session.save(estado);
			//session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}

}
