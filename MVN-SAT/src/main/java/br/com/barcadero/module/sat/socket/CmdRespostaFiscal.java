package br.com.barcadero.module.sat.socket;

import br.com.barcadero.commons.socket.SocketDados;

public class CmdRespostaFiscal extends SocketDados{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1091549904546447060L;
	private String Identificador        = "";
	private String ChaveAcessoValidador = "";
	private String idFila               = "";
	private String ChaveAcesso          = "";
	private String Nsu                  = "";
	private String NumerodeAprovacao    = "";
	private String Bandeira             = "";
	private String Adquirente           = "";
	private String CNPJ                 = "";
	private String ImpressaoFiscal      = "";
	private String NumeroDocumento		= "";
	public String getIdentificador() {
		return Identificador;
	}
	public void setIdentificador(String identificador) {
		Identificador = identificador;
	}
	public String getChaveAcessoValidador() {
		return ChaveAcessoValidador;
	}
	public void setChaveAcessoValidador(String chaveAcessoValidador) {
		ChaveAcessoValidador = chaveAcessoValidador;
	}
	public String getIdFila() {
		return idFila;
	}
	public void setIdFila(String idFila) {
		this.idFila = idFila;
	}
	public String getChaveAcesso() {
		return ChaveAcesso;
	}
	public void setChaveAcesso(String chaveAcesso) {
		ChaveAcesso = chaveAcesso;
	}
	public String getNsu() {
		return Nsu;
	}
	public void setNsu(String nsu) {
		Nsu = nsu;
	}
	public String getNumerodeAprovacao() {
		return NumerodeAprovacao;
	}
	public void setNumerodeAprovacao(String numerodeAprovacao) {
		NumerodeAprovacao = numerodeAprovacao;
	}
	public String getBandeira() {
		return Bandeira;
	}
	public void setBandeira(String bandeira) {
		Bandeira = bandeira;
	}
	public String getAdquirente() {
		return Adquirente;
	}
	public void setAdquirente(String adquirente) {
		Adquirente = adquirente;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getImpressaoFiscal() {
		return ImpressaoFiscal;
	}
	public void setImpressaoFiscal(String impressaoFiscal) {
		ImpressaoFiscal = impressaoFiscal;
	}
	public String getNumeroDocumento() {
		return NumeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		NumeroDocumento = numeroDocumento;
	}



}
