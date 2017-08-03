package br.com.barcadero.web.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barcadero.rule.RuleCentroDeCusto;

@Component("centroDeCustoConverter")
public class CentroDeCustoConverter extends SuperConverter implements Converter,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1340264112104881914L;
	@Autowired
	private RuleCentroDeCusto ruleCentroDeCusto;
	public CentroDeCustoConverter() {
		System.out.println("Coverter " + CentroDeCustoConverter.class.getName() + " ........ON");
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			return ruleCentroDeCusto.find(getValueAsLong(value));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return getAsString(value);
	}
	
	

}
