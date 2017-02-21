package br.com.barcadero.core.listener;

import org.hibernate.envers.RevisionListener;

import br.com.barcadero.tables.CustonAudit;

public class ExempleListener implements RevisionListener{

	@Override
	public void newRevision(Object revisionEntity) {
		// TODO Auto-generated method stub
		CustonAudit exampleRevEntity = (CustonAudit) revisionEntity;
		exampleRevEntity.setUserName("Rafa boy");
	}

}
