package br.com.systeconline.core.nfe.servicos;

import java.net.MalformedURLException;
import java.net.URL;

import br.com.barcadero.core.exeptions.ServiceException;

public interface IGeneralService {
	/**
	 * Utilizar enumeracao
	 * @param servico
	 * @return
	 */
	public String getMetodoRecepcaoEvento(String tpAmbiente)		throws ServiceException;
	public String getMetodoNFeRecepcao(String tpAmbiente)			throws ServiceException;
	public String getMetodoNFeRetRecepcao(String tpAmbiente)		throws ServiceException;
	public String getMetodoNFeInutilizacao(String tpAmbiente)		throws ServiceException;
	public String getMetodoNFeConsultaProtocolo(String tpAmbiente)	throws ServiceException;
	public String getMetodoNFeStatusServico(String tpAmbiente)		throws ServiceException;
	public String getMetodoNFeConsultaCadastro(String tpAmbiente)	throws ServiceException;
	public String getMetodoNFeDownloadNF(String tpAmbiente)			throws ServiceException;
	public String getMetodoNFeAutorizacao(String tpAmbiente)		throws ServiceException;
	public String getMetodoNFeRetAutorizacao(String tpAmbiente)		throws ServiceException;
	public URL getUrlRecepcaoEnvento(String tpAmbiente)	throws MalformedURLException;
	public URL getUrlNFeRecepcao(String tpAmbiente)		throws MalformedURLException;
	public URL getUrlNFeRetRecepcao(String tpAmbiente)	throws MalformedURLException;
	public URL getUrlNFeInutilizacao(String tpAmbiente)	throws MalformedURLException;
	public URL getUrlNFeConsultaProtocolo(String tpAmbiente)throws MalformedURLException;
	public URL getUrlNFeStatusServico(String tpAmbiente)	throws MalformedURLException;
	public URL getUrlNFeConsultaCadastro(String tpAmbiente)	throws MalformedURLException;
	public URL getUrlNFeDownloadNF(String tpAmbiente)		throws MalformedURLException;
	public URL getUrlNFeAutorizacao(String tpAmbiente)throws MalformedURLException;
	public URL getUrlNFeRetAutorizacao(String tpAmbiente)	throws MalformedURLException;
	public String getVersaoRecepcaoEvento(String tpAmbiente);
	public String getVersaoNFeRecepcao(String tpAmbiente);
	public String getVersaoNFeRetRecepcao(String tpAmbiente);
	public String getVersaoNFeInutilizacao(String tpAmbiente);
	public String getVersaoNFeConsultaProtocolo(String tpAmbiente);
	public String getVersaoNFeStatusServico(String tpAmbiente);
	public String getVersaoNFeConsultaCadastro(String tpAmbiente);
	public String getVersaoNFeDownloadNF(String tpAmbiente);
	public String getVersaoNFeAutorizacao(String tpAmbiente);
	public String getVersaoNFeRetAutorizacao(String tpAmbient);
	public String getWebServiceRecepcaoEvento(String tpAmbiente)		throws ServiceException;
	public String getWebServiceNFeRecepcao(String tpAmbiente)			throws ServiceException;
	public String getWebServiceNFeRetRecepcao(String tpAmbiente)		throws ServiceException;
	public String getWebServiceNFeInutilizacao(String tpAmbiente)		throws ServiceException;
	public String getWebServiceNFeConsultaProtocolo(String tpAmbiente)	throws ServiceException;
	public String getWebServiceNFeStatusServico(String tpAmbiente)		throws ServiceException;
	public String getWebServiceNFeConsultaCadastro(String tpAmbiente)	throws ServiceException;
	public String getWebServiceNFeDownloadNF(String tpAmbiente)			throws ServiceException;
	public String getWebServiceNFeAutorizacao(String tpAmbiente)		throws ServiceException;
	public String getWebServiceNFeRetAutorizacao(String tpAmbiente)		throws ServiceException;
	public String getCUF();
}
