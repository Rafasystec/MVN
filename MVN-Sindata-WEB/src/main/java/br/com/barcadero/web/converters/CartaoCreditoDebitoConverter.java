package br.com.barcadero.web.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barcadero.rule.RuleCartaoDebitoCredito;
import br.com.barcadero.tables.CartaoCreditoDebito;
@Component("cartaoCreditoDebitoConverter")
public class CartaoCreditoDebitoConverter implements Converter,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 732540050587659006L;
	
	@Autowired(required=true)
	private RuleCartaoDebitoCredito ruleCartaoDebitoCredito;
	
	public CartaoCreditoDebitoConverter() {
		System.out.println("Converter " + CartaoCreditoDebitoConverter.class.getName() + " .......... ON");
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			return ruleCartaoDebitoCredito.find(getValueAsLong(value));
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value==null){
			return "0";
		}
		if(value instanceof CartaoCreditoDebito){
			return ""+ ((CartaoCreditoDebito)value).getCodigo();
		}
		return String.valueOf(value);
	}

	public RuleCartaoDebitoCredito getRuleCartaoDebitoCredito() {
		return ruleCartaoDebitoCredito;
	}

	public void setRuleCartaoDebitoCredito(RuleCartaoDebitoCredito ruleCartaoDebitoCredito) {
		this.ruleCartaoDebitoCredito = ruleCartaoDebitoCredito;
	}

	private long getValueAsLong(String value) {
		if(value!=null && !value.trim().isEmpty()){
			return Long.parseLong(value);
		}else{
			return 0L;
		}
	}
}
