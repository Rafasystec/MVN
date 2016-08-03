package br.com.barcadero.web.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class HandleDialog {
	
	private static final String PATH_POPUPS = "/popups/";
	protected static Map<String,List<String>> params = new HashMap<String,List<String>>();
	
	public static void closeDialog(Object object) {
        RequestContext.getCurrentInstance().closeDialog(object);
    }
	
	public static void openDialog(String page, String width, String height) {
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("resizable", false);
        options.put("draggable", true);
        options.put("width", width);
        options.put("height", height);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
         
        RequestContext.getCurrentInstance().openDialog(PATH_POPUPS + page + ".xhtml", options, null);
	}
	
	public static void openDialogOutCome(String outcome, String width, String height) {
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("resizable", false);
        options.put("draggable", true);
        options.put("width", width);
        options.put("height", height);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
         
        RequestContext.getCurrentInstance().openDialog(outcome, options, null);
	}
	
	public static void openDialog(String page, Map<String,List<String>> params, String width, String height) {
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("width", width);
        options.put("height", height);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
         
        RequestContext.getCurrentInstance().openDialog(PATH_POPUPS + page + ".xhtml", options, params);
	}
	
	public static void openDialog(Map<String,List<String>> params, String outcome, String width, String height) {
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("width", width);
        options.put("height", height);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
         
        RequestContext.getCurrentInstance().openDialog(outcome, options, params);
	}
	
	
	
	public static void newParam(String key, String value) {
		
		List<String> list = new ArrayList<String>();
    	list.add(value);
    	newParam(key, list);
	}
	
	public static void newParam(String key, List<String> list) {
		params.put(key, list);
	}
	
	public static Map<String,List<String>> getParams() {
		return params;
	}
	
	public static String getParameter(String key) {
		Map<String, String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		return param.get(key);
	}
	
}
