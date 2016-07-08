package br.com.barcadero.web.validators;

import java.util.Map;
import java.util.regex.Pattern;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.validate.ClientValidator;

import br.com.barcadero.web.functions.HandleMessage;

@FacesValidator("custom.emailValidator")
public class EmailValidator implements Validator, ClientValidator {
	
	private Pattern pattern;
	private static final String PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public EmailValidator() {
		pattern = Pattern.compile(PATTERN);
	}
	
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if(value == null) {
			return;
		}
		
		if(!pattern.matcher(value.toString()).matches()) {
			throw new ValidatorException(HandleMessage.validatorError("E-mail inválido. Ex.: cliente@dominio.com.br"));
		}
	}
	
	public Map<String, Object> getMetadata() {
		return null;
	}
	
	public String getValidatorId() {
		return "custom.emailValidator";
	}
}
