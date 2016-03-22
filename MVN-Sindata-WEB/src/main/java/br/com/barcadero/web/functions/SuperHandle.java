package br.com.barcadero.web.functions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.context.RequestContext;

public abstract class SuperHandle {
	
	
	private static final String OPT_RESIZABLE 	= "resizable";
	private static final String OPT_DRAGGABLE 	= "draggable";
	private static final String OPT_MODAL 		= "modal";
	private static final String OPT_CLOSABLE	= "closable";
	/**
	 * Mostrar uma tela como se fosse uma popup.
	 * @param outcome: outcome de navegacao. Deve ter uma regra de navegacao
	 * @throws Exception
	 */
	protected static void openDialog(String outcome) throws Exception{
		try {
			Map<String,Object> options = new HashMap<String, Object>();
			options.put(OPT_RESIZABLE, false);
			options.put(OPT_DRAGGABLE, false);
			options.put(OPT_MODAL	 , true);
			options.put(OPT_CLOSABLE , true);
			RequestContext.getCurrentInstance().openDialog(outcome, options, null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Executa a abertura de um dialog passando paramentros.
	 * @param outcome
	 * @param params
	 * @throws Exception
	 */
	protected static void openDialog(String outcome, Map<String, List<String>> params) throws Exception{
		try {
			Map<String,Object> options = new HashMap<String, Object>();
			options.put(OPT_RESIZABLE, false);
			options.put(OPT_DRAGGABLE, false);
			options.put(OPT_MODAL	 , true);
			options.put(OPT_CLOSABLE , true);
			RequestContext.getCurrentInstance().openDialog(outcome, options, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
