package br.com.barcadero.web.converters;

import br.com.barcadero.tables.Entidade;

public class SuperConverter {
	
	protected long getValueAsLong(String value) {
		if(value!=null && !value.trim().isEmpty()){
			return Long.parseLong(value);
		}else{
			return 0L;
		}
	}
	
	public String getAsString(Object value) {
		if(value==null){
			return "0";
		}
		
		if(value instanceof Entidade){
			return  ""+((Entidade) value).getCodigo();
		}
		
		return String.valueOf(value);
	}

}
