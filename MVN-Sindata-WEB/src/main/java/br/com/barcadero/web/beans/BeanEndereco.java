package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.core.enums.EnumTipoLograd;
import br.com.barcadero.core.enums.EnumUF;

/**
 * Usar a classe HandleEndereco
 * @author antoniorafael
 *
 */
@ManagedBean
@RequestScoped
@Deprecated
public class BeanEndereco {
	private long codBairro;
	private long codPessoa;
	private long codCidade;
	private String tipo; 
	private String numero;
	private String cep;
	private String logradouro;
	private String tpLograd;
	private String complemento;
	private String referencia;
	private String uf;
	
	public long getCodBairro() {
		return codBairro;
	}
	public void setCodBairro(long codBairro) {
		this.codBairro = codBairro;
	}
	public long getCodPessoa() {
		return codPessoa;
	}
	public void setCodPessoa(long codPessoa) {
		this.codPessoa = codPessoa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getTpLograd() {
		return tpLograd;
	}
	public void setTpLograd(String tpLograd) {
		this.tpLograd = tpLograd;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	//Another Methods
	public String inserir() throws Exception{
		
		try {

			return "";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public EnumUF[] getEstados() throws Exception {
		return EnumUF.values();
	}

	public EnumTipoLograd[] getTipoLogradouro() {
		return EnumTipoLograd.values();
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public long getCodCidade() {
		return codCidade;
	}
	public void setCodCidade(long codCidade) {
		this.codCidade = codCidade;
	}
	
}
