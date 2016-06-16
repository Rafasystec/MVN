package br.com.barcadero.tables;

import javax.persistence.EntityManager;

/**
 * Classe criada para carregar a API de persistencia
 * @author Rafael Rocha
 * Criada dia 07/11/2013 as 23:00
 */

public class EntityMangerLoad {
	private static EntityManager manager= null;
//	private static EntityManagerFactory factory= null;
//	static {
//		try{
//			System.out.println("Iniciando o EntityManager");
//			factory = Persistence.createEntityManagerFactory("GSIND");
//			manager = factory.createEntityManager();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	public static EntityManager getManager(){
		return manager;
	}
}
