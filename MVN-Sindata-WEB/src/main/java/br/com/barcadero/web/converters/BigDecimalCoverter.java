package br.com.barcadero.web.converters;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import br.com.barcadero.web.functions.HandleMessage;

@FacesConverter("bigDecimalConverter")
public class BigDecimalCoverter implements Converter {        

	@Override
	 public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		DecimalFormat df = null;
		
		try {
			
			if (value == null || value.isEmpty()) {
				return value;
			}
			value = value.replace(".","").replace(",", ".");			
			df = new DecimalFormat("#,##0.00");
			df.setParseBigDecimal(true);
	        BigDecimal decimal = (BigDecimal) df.parse(value);
			return decimal;
	        
		} catch (Exception e) {
			throw new ConverterException(HandleMessage.converterError(e.getMessage()));
		}
	        
	}
	
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
    
}
