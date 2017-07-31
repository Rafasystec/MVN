package br.com.barcadero.web.converters;
 
import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barcadero.rule.RuleBancos;
import br.com.barcadero.tables.Bancos;

@Component("bancosConverter")
public class BancosConverter implements Converter,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7707265904607376572L;
	
	@Autowired(required=true)
	private RuleBancos ruleBancos;
	
	public BancosConverter() {
		System.out.println("Converter " + BancosConverter.class.getName() + " .......... ON");
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		try {
			return ruleBancos.find(getValueAsLong(value));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value==null){
			return "0";
		}
		if(value instanceof Bancos){
			return  ""+((Bancos) value).getCodigo();
		}
		return String.valueOf(value);
	}

	public RuleBancos getRuleBancos() {
		return ruleBancos;
	}

	public void setRuleBancos(RuleBancos ruleBancos) {
		this.ruleBancos = ruleBancos;
	}
	
	private long getValueAsLong(String value) {
		if(value!=null && !value.trim().isEmpty()){
			return Long.parseLong(value);
		}else{
			return 0L;
		}
	}

}
