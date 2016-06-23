package br.com.barcadero.web.beans;

public interface IBeanClass {

	abstract public String salvar()throws Exception;
	abstract public String alterar()throws Exception;
	abstract public String deletar()throws Exception;
	abstract public String novo()throws Exception;
	abstract public String imprimir()throws Exception;
}
