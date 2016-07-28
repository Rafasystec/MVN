package br.com.barcadero.module.sat.handle;
import java.util.*;

public class HandleRetornoSAT
{
/**Fields*/
/**Attributes*/
	private String numeroSessao;
	private String codigoRetorno1;
	private String mensagem;
	private String cod;
	private String mensagemSEFAZ;
	private String CSR;
	private String codigoRetorno2;
	private String arquivoCFeSAT;
	private String timeStamp;
	private String chaveDeConsulta;
	private String valorTotaldoCupom;
	private String digestValue;
	private String signatureValue;
	private String numDocFiscal;
	private String nSerie;
	private String tipoLan;
	private String lanIP;
	private String lanMAC;
	private String lanMask;
	private String lanGateway;
	private String lanDNS1;
	private String lanDNS2;
	private String statusLan;
	private String nivelBateria;
	private String mtTotal;
	private String mtUsada;
	private String dhAtual;
	private String versaoSB;
	private String versaoLayout;
	private String ultimoCFeSat;
	private String listaInicial;
	private String listaFinal;
	private String dhCFe;
	private String dhUltima;
	private String certificadoEmissao;
	private String certificadoVencimento;
	private String estadoOperacao;
	ArrayList<HandleLogSAT> logsSatVO;

	public HandleRetornoSAT () {
		
	}

	public static String getDescricaoRetorno1(String codigo) {
		return  new HendleCodesFromModule().getDescricao(codigo); 
	}
	
	public String getNumeroSessao() {
		return numeroSessao;
	}
	public void setNumeroSessao(String numeroSessao) {
		this.numeroSessao = numeroSessao;
	}
	public String getCodigoRetorno1() {
		return codigoRetorno1;
	}
	public void setCodigoRetorno1(String codigoRetorno1) {
		this.codigoRetorno1 = codigoRetorno1;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getMensagemSEFAZ() {
		return mensagemSEFAZ;
	}
	public void setMensagemSEFAZ(String mensagemSEFAZ) {
		this.mensagemSEFAZ = mensagemSEFAZ;
	}
	public String getCSR() {
		return CSR;
	}
	public void setCSR(String csr) {
		CSR = csr;
	}
	public String getCodigoRetorno2() {
		return codigoRetorno2;
	}
	public void setCodigoRetorno2(String codigoRetorno2) {
		this.codigoRetorno2 = codigoRetorno2;
	}
	public String getArquivoCFeSAT() {
		return arquivoCFeSAT;
	}
	public void setArquivoCFeSAT(String arquivoCFeSAT) {
		this.arquivoCFeSAT = arquivoCFeSAT;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getChaveDeConsulta() {
		return chaveDeConsulta;
	}
	public void setChaveDeConsulta(String chaveDeConsulta) {
		this.chaveDeConsulta = chaveDeConsulta;
	}
	public String getValorTotaldoCupom() {
		return valorTotaldoCupom;
	}
	public void setValorTotaldoCupom(String valorTotaldoCupom) {
		this.valorTotaldoCupom = valorTotaldoCupom;
	}
	public String getDigestValue() {
		return digestValue;
	}
	public void setDigestValue(String digestValue) {
		this.digestValue = digestValue;
	}
	public String getSignatureValue() {
		return signatureValue;
	}
	public void setSignatureValue(String signatureValue) {
		this.signatureValue = signatureValue;
	}
	public String getNumDocFiscal() {
		return numDocFiscal;
	}
	public void setNumDocFiscal(String numDocFiscal) {
		this.numDocFiscal = numDocFiscal;
	}
	public String getNSerie() {
		return nSerie;
	}
	public void setNSerie(String serie) {
		nSerie = serie;
	}
	public String getTipoLan() {
		return tipoLan;
	}
	public void setTipoLan(String tipoLan) {
		this.tipoLan = tipoLan;
	}
	public String getLanIP() {
		return lanIP;
	}
	public void setLanIP(String lanIP) {
		this.lanIP = lanIP;
	}
	public String getLanMAC() {
		return lanMAC;
	}
	public void setLanMAC(String lanMAC) {
		this.lanMAC = lanMAC;
	}
	public String getLanMask() {
		return lanMask;
	}
	public void setLanMask(String lanMask) {
		this.lanMask = lanMask;
	}
	public String getLanGateway() {
		return lanGateway;
	}
	public void setLanGateway(String lanGateway) {
		this.lanGateway = lanGateway;
	}
	public String getLanDNS1() {
		return lanDNS1;
	}
	public void setLanDNS1(String lanDNS1) {
		this.lanDNS1 = lanDNS1;
	}
	public String getLanDNS2() {
		return lanDNS2;
	}
	public void setLanDNS2(String lanDNS2) {
		this.lanDNS2 = lanDNS2;
	}
	public String getStatusLan() {
		return statusLan;
	}
	public void setStatusLan(String statusLan) {
		this.statusLan = statusLan;
	}
	public String getNivelBateria() {
		return nivelBateria;
	}
	public void setNivelBateria(String nivelBateria) {
		this.nivelBateria = nivelBateria;
	}
	public String getMtTotal() {
		return mtTotal;
	}
	public void setMtTotal(String mtTotal) {
		this.mtTotal = mtTotal;
	}
	public String getMtUsada() {
		return mtUsada;
	}
	public void setMtUsada(String mtUsada) {
		this.mtUsada = mtUsada;
	}
	public String getDhAtual() {
		return dhAtual;
	}
	public void setDhAtual(String dhAtual) {
		this.dhAtual = dhAtual;
	}
	public String getVersaoSB() {
		return versaoSB;
	}
	public void setVersaoSB(String versaoSB) {
		this.versaoSB = versaoSB;
	}
	public String getVersaoLayout() {
		return versaoLayout;
	}
	public void setVersaoLayout(String versaoLayout) {
		this.versaoLayout = versaoLayout;
	}
	public String getUltimoCFeSat() {
		return ultimoCFeSat;
	}
	public void setUltimoCFeSat(String ultimoCFeSat) {
		this.ultimoCFeSat = ultimoCFeSat;
	}
	public String getListaInicial() {
		return listaInicial;
	}
	public void setListaInicial(String listaInicial) {
		this.listaInicial = listaInicial;
	}
	public String getListaFinal() {
		return listaFinal;
	}
	public void setListaFinal(String listaFinal) {
		this.listaFinal = listaFinal;
	}
	public String getDhCFe() {
		return dhCFe;
	}
	public void setDhCFe(String dhCFe) {
		this.dhCFe = dhCFe;
	}
	public String getDhUltima() {
		return dhUltima;
	}
	public void setDhUltima(String dhUltima) {
		this.dhUltima = dhUltima;
	}
	public String getCertificadoEmissao() {
		return certificadoEmissao;
	}
	public void setCertificadoEmissao(String certificadoEmissao) {
		this.certificadoEmissao = certificadoEmissao;
	}
	public String getCertificadoVencimento() {
		return certificadoVencimento;
	}
	public void setCertificadoVencimento(String certificadoVencimento) {
		this.certificadoVencimento = certificadoVencimento;
	}
	public String getEstadoOperacao() {
		return estadoOperacao;
	}
	public void setEstadoOperacao(String estadoOperacao) {
		this.estadoOperacao = estadoOperacao;
	}
	public ArrayList<HandleLogSAT> getLogsSatVO() {
		return logsSatVO;
	}
	public void setLogsSatVO(ArrayList<HandleLogSAT> logsSatVO) {
		this.logsSatVO = logsSatVO;
	}



}
