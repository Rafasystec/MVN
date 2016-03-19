package br.com.systeconline.core.exeptions;

public class SOAPException extends Exception {

	private static final long serialVersionUID = -8363095430854195025L;
	
	public SOAPException(Exception e) {
		// TODO Auto-generated constructor stub
		super(e.getMessage(), e.getCause());
		e.printStackTrace();
	}
	
	public SOAPException(String message){
		super(message);
	}
	
	

}
