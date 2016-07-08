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

@FacesValidator("custom.nomeValidator")
public class NomeValidator implements Validator, ClientValidator {
	
	private Pattern pattern;
	private static final String PATTERN = "[A-Za-z\u00C0-\u00FF^\\s]+";
	
	public NomeValidator() {
		pattern = Pattern.compile(PATTERN);
	}
	
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if(value == null) {
			return;
		}
		
		if(!pattern.matcher(value.toString()).matches()) {
			throw new ValidatorException(HandleMessage.validatorError("Nome inválido. Preencher o nome somente com letras. Ex.: João da Silva"));
		}
	}
	
	public Map<String, Object> getMetadata() {
		return null;
	}
	
	public String getValidatorId() {
		return "custom.nomeValidator";
	}
}
