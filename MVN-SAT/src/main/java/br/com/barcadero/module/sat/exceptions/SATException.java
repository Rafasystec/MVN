package br.com.barcadero.module.sat.exceptions;

import br.com.barcadero.module.sat.handle.HandleRetornoSAT;
//import xseedRts.*;


public class SATException extends Exception
{
	private static final long serialVersionUID = 9183824456321613704L;
	private HandleRetornoSAT retornoSatVO = null;
	private String msg = "";

	public SATException(Throwable e)
	{	
		super(e);	
	}

	public SATException(HandleRetornoSAT retornoSatVO)
	{
		super(retornoSatVO.getMensagem());	
		this.retornoSatVO = retornoSatVO;	
	}

	public SATException(String msg)
	{
		super(msg);	
		this.msg = msg;	
	}

	public HandleRetornoSAT getRetornoSatVO() throws Exception
	{
		return retornoSatVO;
	}

	public String getMsg() throws Exception
	{
		return msg;
	}
}