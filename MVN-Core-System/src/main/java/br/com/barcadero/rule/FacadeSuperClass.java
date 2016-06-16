package br.com.barcadero.rule;

import javax.persistence.EntityManager;

/**
 * Esta classe sera utilizada para o que houver de comum nos Facades.
 * @author Rafael Rocha
 * classe criada dia 02/12/2013 as 20:50
 */
public class FacadeSuperClass {
	EntityManager manager 	= null;
	public FacadeSuperClass(){
		
	}

}
