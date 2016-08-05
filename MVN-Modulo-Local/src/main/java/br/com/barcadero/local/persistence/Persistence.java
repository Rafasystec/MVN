package br.com.barcadero.local.persistence;

import javax.persistence.EntityManager;

/**
 * Classe para auxiliar na criacao da persistencia com o Monitor
 * @author Rafael Rocha
 *
 */
public class Persistence {
	public static EntityManager entityManager;
	
	public Persistence() throws Exception{
		// TODO Auto-generated constructor stub
		System.out.println("Iniciando gerenciador de Persistencia");
		entityManager = getEntityManager();
	}
	
	public static EntityManager getEntityManager() {
		EntityManager manager = javax.persistence.Persistence.createEntityManagerFactory("MONITOR").createEntityManager();
		return manager;
	}
	
	public static void close() {
		if(entityManager != null){
			if(entityManager.isOpen()){
				entityManager.close();
			}
		}
	}

}
