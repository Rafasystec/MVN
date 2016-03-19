package br.com.barcadero.module.sat.enums;

public enum EnumEstadoOperacao
{
/**Fields*/
/**Attributes*/


DESBLOQUEADO("0", "DESBLOQUEADO"),
BLOQUEIO_SEFAZ("1", "Bloqueio SEFAZ"),
BLOQUEIO_CONTRIBUINTE("2", "Bloqueio contribuinte"),
BLOQUEIO_AUTONAMO("3", "Bloqueio aut�nomo"),
BLOQUEIO_DESATIVACAO("4", "Bloqueio para desativa��o");

private EnumEstadoOperacao(String cod, String desc)
{	
	this.cod = cod;
	this.desc = desc;
}
	
private String cod;
private String desc;
		
public String getCod()
{
	return cod;
}

public String getDesc()
{
	return desc;
}


} /** End Class */
