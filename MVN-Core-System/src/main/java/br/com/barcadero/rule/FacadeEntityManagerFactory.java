package br.com.barcadero.rule;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

public class FacadeEntityManagerFactory {
	
	public EntityManager getEntityManager() {
		EntityManagerFactory factory	= Persistence.createEntityManagerFactory("GSIND");
		EntityManager manager			= factory.createEntityManager();
		/*
		--------------------------------------------------------------------------------------------------
		Há duas políticas adotadas pelos provedores JPA em relação às sincronizações: FlushModeTy-
		pe.AUTO (padrão) e FlushModeType.COMMIT. No modo AUTO, o provedor JPA realiza sincronizações
		automáticas antes de uma operação de consulta para garantir que as modificações, remoções e in-
		serções ainda não sincronizadas sejam consideradas na consulta. Já o comportamento no modo
		COMMIT não está especificado. Consequentemente, cada provedor pode implementar o comporta-
		mento que achar mais adequado.
		--------------------------------------------------------------------------------------------------
		Toda modificação, remoção ou inserção realizada no banco de dados devido às chamadas ao
		método flush() podem ser desfeitas através do método rollback(). Uma chamada a esse método
		também finaliza a transação.
		--------------------------------------------------------------------------------------------------
		*/
		manager.setFlushMode(FlushModeType.AUTO);
		return manager;
	}
}
