package br.com.systeconline.core.nfe.servicos.ufs.producao;

import java.net.MalformedURLException;
import java.net.URL;

import br.com.barcadero.core.exeptions.ServiceException;
import br.com.systeconline.core.nfe.servicos.AGeneralService;
import br.com.systeconline.nfe.core.util.enumarations.ECodigoUFIBGE;

public class ServicesCE extends AGeneralService {

	@Override
	public String getMetodoRecepcaoEvento(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getMetodoNFeRecepcao(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getMetodoNFeRetRecepcao(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getMetodoNFeInutilizacao(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getMetodoNFeConsultaProtocolo(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getMetodoNFeStatusServico(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getMetodoNFeConsultaCadastro(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getMetodoNFeDownloadNF(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getMetodoNFeAutorizacao(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getMetodoNFeRetAutorizacao(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public URL getUrlRecepcaoEnvento(String tpAmbiente) throws MalformedURLException {
		// TODO Auto-generated method stub
		if(tpAmbiente.equalsIgnoreCase(AMB_HOMOLOGACAO)){
			return new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento?WSDL");
		}else{
			return new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/RecepcaoEvento?wsdl");
		}
		
	}

	@Override
	public URL getUrlNFeRecepcao(String tpAmbiente) throws MalformedURLException {
		// TODO Auto-generated method stub
		if(tpAmbiente.equalsIgnoreCase(AMB_HOMOLOGACAO)){
			throw new MalformedURLException("Não Existe ambiente de homogação para NFeRecepcao");
		}else{
			return new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeRecepcao2?wsdl");
		}
	}

	@Override
	public URL getUrlNFeRetRecepcao(String tpAmbiente) throws MalformedURLException {
		// TODO Auto-generated method stub
		if(tpAmbiente.equalsIgnoreCase(AMB_HOMOLOGACAO)){
			throw new MalformedURLException("Não Existe ambiente de homogação para NFeRetRecepcao");
		}else{
			return new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeRetRecepcao2?wsdl");
		}
		
	}

	@Override
	public URL getUrlNFeInutilizacao(String tpAmbiente) throws MalformedURLException {
		// TODO Auto-generated method stub
		if(tpAmbiente.equalsIgnoreCase(AMB_HOMOLOGACAO)){
			return new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2?WSDL");
		}else{
			return new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeInutilizacao2?wsdl");
		}
		
	}

	@Override
	public URL getUrlNFeConsultaProtocolo(String tpAmbiente) throws MalformedURLException {
		// TODO Auto-generated method stub
		if(tpAmbiente.equalsIgnoreCase(AMB_HOMOLOGACAO)){
			return new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeConsulta2?WSDL");
		}else{
			return new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeConsulta2?wsdl");
		}
		
	}

	@Override
	public URL getUrlNFeStatusServico(String tpAmbiente) throws MalformedURLException {
		// TODO Auto-generated method stub
		if(tpAmbiente.equalsIgnoreCase(AMB_HOMOLOGACAO)){
			return new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2?WSDL");
		}else{
			return  new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeStatusServico2?wsdl");
		}
		
	}

	@Override
	public URL getUrlNFeConsultaCadastro(String tpAmbiente) throws MalformedURLException {
		// TODO Auto-generated method stub
		if(tpAmbiente.equalsIgnoreCase(AMB_HOMOLOGACAO)){
			return new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2?WSDL");
		}else{
			return new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/CadConsultaCadastro2?wsdl");
		}
		
	}

	@Override
	public URL getUrlNFeDownloadNF(String tpAmbiente) throws MalformedURLException {
		// TODO Auto-generated method stub
		if(tpAmbiente.equalsIgnoreCase(AMB_HOMOLOGACAO)){
			return new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeDownloadNF?WSDL");
		}else{
			return new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeDownloadNF?wsdl");
		}
		
	}

	@Override
	public URL getUrlNFeAutorizacao(String tpAmbiente) throws MalformedURLException {
		// TODO Auto-generated method stub
		if(tpAmbiente.equalsIgnoreCase(AMB_HOMOLOGACAO)){
			return new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeAutorizacao?WSDL");
		}else{
			return new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeAutorizacao?wsdl");
		}
		
	}

	@Override
	public URL getUrlNFeRetAutorizacao(String tpAmbiente) throws MalformedURLException {
		// TODO Auto-generated method stub
		if(tpAmbiente.equalsIgnoreCase(AMB_HOMOLOGACAO)){
			return new URL("https://nfeh.sefaz.ce.gov.br/nfe2/services/NfeRetAutorizacao?WSDL");
		}else{
			return new URL("https://nfe.sefaz.ce.gov.br/nfe2/services/NfeRetAutorizacao?wsdl");
		}
		
	}

	@Override
	public String getVersaoRecepcaoEvento(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "1.00";
	}

	@Override
	public String getVersaoNFeRecepcao(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "2.00";
	}

	@Override
	public String getVersaoNFeRetRecepcao(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "2.00";
	}

	@Override
	public String getVersaoNFeInutilizacao(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "3.10";
	}

	@Override
	public String getVersaoNFeConsultaProtocolo(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "3.10";
	}

	@Override
	public String getVersaoNFeStatusServico(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "3.10";
	}

	@Override
	public String getVersaoNFeConsultaCadastro(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "3.10";
	}

	@Override
	public String getVersaoNFeDownloadNF(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "3.10";
	}

	@Override
	public String getVersaoNFeAutorizacao(String tpAmbiente) {
		// TODO Auto-generated method stub
		return "3.10";
	}

	@Override
	public String getVersaoNFeRetAutorizacao(String tpAmbient) {
		// TODO Auto-generated method stub
		return "3.10";
	}

	@Override
	public String getWebServiceRecepcaoEvento(String tpAmbiente)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWebServiceNFeRecepcao(String tpAmbiente)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWebServiceNFeRetRecepcao(String tpAmbiente)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWebServiceNFeInutilizacao(String tpAmbiente)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWebServiceNFeConsultaProtocolo(String tpAmbiente)
			throws ServiceException {
		// TODO Auto-generated method stub
		return webServiceNfeConsultaProtocolo;
	}

	@Override
	public String getWebServiceNFeStatusServico(String tpAmbiente)
			throws ServiceException {
		// TODO Auto-generated method stub
		return webServiceNfeStatusServico;
	}

	@Override
	public String getWebServiceNFeConsultaCadastro(String tpAmbiente)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWebServiceNFeDownloadNF(String tpAmbiente)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWebServiceNFeAutorizacao(String tpAmbiente)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWebServiceNFeRetAutorizacao(String tpAmbiente)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCUF() {
		// TODO Auto-generated method stub
		return ECodigoUFIBGE.CEARA.getValue();
	}

}
