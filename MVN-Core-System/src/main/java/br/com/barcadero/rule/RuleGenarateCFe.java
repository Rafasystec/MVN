package br.com.barcadero.rule;

import br.com.barcadero.core.enums.EnumStatusCFeNota;
import br.com.barcadero.module.sat.exceptions.SATException;
import br.com.barcadero.module.sat.xml.envio.CFe;
import br.com.barcadero.module.sat.xml.envio.InfCFe;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.Usuario;

public class RuleGenarateCFe {
	
	public static final int CODE_NAO_TEM_NOTA 		= 13;
	public static final int CODE_STATUS_INVALIDO 	= 14;
	
	public RuleGenarateCFe() {
		// TODO Auto-generated constructor stub
	}
	
	public CFeResult execute(Nota nota, Usuario usuario) {
		CFeResult cfeResult = new CFeResult();
		if(nota != null){
			if(nota.getStatusCFe().equals(EnumStatusCFeNota.XML_NAO_GERADO) || nota.getStatusCFe().equals(EnumStatusCFeNota.REJEITADO)){
				
				
			}else{
				cfeResult.setCodeExecution(CODE_STATUS_INVALIDO);
				cfeResult.setDescription("Staus permitido para emitir CF-e : " + EnumStatusCFeNota.XML_NAO_GERADO + " ou " + EnumStatusCFeNota.REJEITADO + " mas veio " + nota.getStatusCFe());
			}
		}else{
			cfeResult.setCodeExecution(CODE_NAO_TEM_NOTA);
			cfeResult.setDescription("Nota veio nulo.");
		}
		
		return cfeResult;
	}
	
	private String genarateXML(Nota nota) throws SATException {
		String xml = "";
		CFe cfe 		= new CFe();
		InfCFe infCFe 	= new InfCFe();
		
		return xml;
	}
	
	public class CFeResult{
		private int codeExecution 	= -1;
		private String description	= "Não houve execução. Apenas instanciado o retorno";
		
		public int getCodeExecution() {
			return codeExecution;
		}
		public void setCodeExecution(int codeExecution) {
			this.codeExecution = codeExecution;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
	}

}
