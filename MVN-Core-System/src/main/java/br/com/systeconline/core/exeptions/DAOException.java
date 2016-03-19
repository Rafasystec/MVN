package br.com.systeconline.core.exeptions;

public class DAOException extends Exception {
	
	private static final long serialVersionUID = -1951729759966276024L;
	private final Exception exception;
	public DAOException(Exception e) {
		// TODO Auto-generated constructor stub
		exception = e;
	}
	public Exception getException() {
		return exception;
	}
	
}
