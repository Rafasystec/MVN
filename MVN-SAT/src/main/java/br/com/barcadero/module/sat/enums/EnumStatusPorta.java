package br.com.barcadero.module.sat.enums;



public enum EnumStatusPorta
{
/**Fields*/
/**Attributes*/


SERIAL("0", "Serial"),
ENVIO_OK("1", "Envio OK"),
ENVIO_NOK("2", "Envio NOK"),
LEITURA_OK("3", "Leitura OK"),
LEITURA_NOK("4", "Leitura NOK"),
ERRO("5", "Erro desconhecido"),
CANAL_INDISP("6", "Canal n�o dispon�vel"),
ACESSO_NEGADO("7", "Acesso negado"),
TIMEOUT("8", "Timeout na recep��o");

private EnumStatusPorta(String cod, String desc)
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
