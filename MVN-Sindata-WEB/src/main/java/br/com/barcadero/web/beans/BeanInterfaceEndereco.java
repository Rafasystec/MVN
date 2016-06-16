package br.com.barcadero.web.beans;

/**
 * Todos os beans que pretendenter controlar o endereco devem
 * implementar esta Interface. Exemplo de Benas que podem utilizar
 * esta interface: Benas que matem Clientes, Funcionarios, Filiados
 * e quem mais possuir algum endereco para ser cadastrado no sistema.
 * @author Rafael Rocha
 * @since Gsind 1.0 Beta dia 24/10/2013 as 13:25
 */
public interface BeanInterfaceEndereco {
	
	public long getCodBairro();
	public long getCodPessoa();
	public String getTipo();
	public String getNumero();
	public String getCep();
	public String getLogradouro();
	public String getTpLograd();
	public String getComplemento();
	public String getReferencia();
	public void setCodBairro(long codBairro);
	public void setCodPessoa(long codPessoa);
	public void setTipo(String tipo);
	public void setNumero(String numero);
	public void setCep(String cep);
	public void setLogradouro(String logradouro);
	public void setTpLograd(String tpLograd);
	public void setComplemento(String complemento);
	public void setReferencia(String referencia);
}
