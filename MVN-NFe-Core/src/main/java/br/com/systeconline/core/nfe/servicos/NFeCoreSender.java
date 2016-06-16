package br.com.systeconline.core.nfe.servicos;

import javax.xml.bind.JAXBContext;
import javax.xml.soap.SOAPMessage;

import br.com.barcadero.core.handles.xml.HandleXML;
import br.com.barcadero.core.util.xml.XMLRetornoGeralNFe;
import br.com.barcadero.core.webservice.SOAPDados;
import br.com.barcadero.core.webservice.soap.SOAPFactory;
import br.com.systeconline.core.nfe.servicos.ufs.producao.ServicesCE;
import br.com.systeconline.nfe.xml.consulta.ConSitNFe;
import br.com.systeconline.nfe.xml.consulta.servico.ConsStatServ;

public class NFeCoreSender {
	
	private final IGeneralService service;
	private final String tpAmb 	;
	private SOAPDados dados 	;
	private HandleXML handleXML ;
	public NFeCoreSender(String cUF, String tpAmb) {
		// TODO Auto-generated constructor stub
		this.service   = new ServicesCE();
		this.dados 	   = new SOAPDados();
		this.tpAmb     = tpAmb;
		this.handleXML = new HandleXML();
	}
	public SOAPDados getDados() {
		return dados;
	}
	public void setDados(SOAPDados dados) {
		this.dados = dados;
	}
	public IGeneralService getService() {
		return service;
	}
	public String getTpAmb() {
		return tpAmb;
	}
	
	public XMLRetornoGeralNFe consultarStatusServico(String servico) throws Exception{
		XMLRetornoGeralNFe retorno  = new XMLRetornoGeralNFe();
		SOAPMessage message			= null;
		try {
			ConsStatServ status = new ConsStatServ();
			status.setcUF(service.getCUF());
			status.setTpAmb(tpAmb);
			status.setVersao(service.getVersaoNFeStatusServico(tpAmb));
			status.setxServ(servico);
			dados.setServiceName(service.getWebServiceNFeStatusServico(tpAmb));
			dados.setNameSpaceUri(service.getUrlNFeStatusServico(tpAmb).toString());
			dados.setcUF(service.getCUF());
			String xml = handleXML.getXMLObjectAsStringWriter(status, JAXBContext.newInstance(ConsStatServ.class));
			message = SOAPFactory.getMessageXMLNFe(dados,xml, service.getVersaoNFeStatusServico(tpAmb));
			message = SOAPFactory.enviar(message, service.getUrlNFeStatusServico(tpAmb));
			retorno = HandleXML.getRetornoGeral(message);
			return retorno;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public XMLRetornoGeralNFe consultarProtocolo(String chaveNFe) throws Exception{
		XMLRetornoGeralNFe retorno = new XMLRetornoGeralNFe();
		try {
			ConSitNFe sitNfe 	= new ConSitNFe();
			SOAPMessage message = null;
			//Montando o objeto
			sitNfe.setVersao(service.getVersaoNFeConsultaProtocolo(tpAmb));
			sitNfe.setChNFe(chaveNFe);
			sitNfe.setxServ("CONSULTAR");
			sitNfe.setTpAmb(tpAmb);
			String xml = handleXML.getXMLObjectAsStringWriter(sitNfe, JAXBContext.newInstance(ConSitNFe.class));
			dados.setServiceName(service.getWebServiceNFeConsultaProtocolo(tpAmb));
			dados.setNameSpaceUri(service.getUrlNFeConsultaProtocolo(tpAmb).toString());
			dados.setcUF(service.getCUF());
			message = SOAPFactory.getMessageXMLNFe(dados,xml, service.getVersaoNFeConsultaProtocolo(tpAmb));
			message = SOAPFactory.enviar(message, service.getUrlNFeConsultaProtocolo(tpAmb));
			retorno = HandleXML.getRetornoGeral(message);
			return retorno;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	

}
