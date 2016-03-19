package br.com.systeconline.nfe.testes;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPMessage;

import org.junit.Test;

import br.com.systeconline.core.exeptions.ServiceException;
import br.com.systeconline.core.exeptions.XMLException;
import br.com.systeconline.core.handles.xml.HandleXML;
import br.com.systeconline.core.handles.xml.HandleXMLSignature;
import br.com.systeconline.core.nfe.servicos.IGeneralService;
import br.com.systeconline.core.nfe.servicos.NFeCoreSender;
import br.com.systeconline.core.nfe.servicos.ufs.producao.ServicesCE;
import br.com.systeconline.core.util.xml.XMLRetornoGeralNFe;
import br.com.systeconline.core.webservice.SOAPDados;
import br.com.systeconline.core.webservice.soap.SOAPFactory;
import br.com.systeconline.nfe.core.util.enumarations.ECodigoUFIBGE;
import br.com.systeconline.nfe.core.util.enumarations.EFinalidadeNFe;
import br.com.systeconline.nfe.core.util.enumarations.EFormaEmissaoNFe;
import br.com.systeconline.nfe.core.util.enumarations.EModeloNota;
import br.com.systeconline.nfe.core.util.enumarations.ETipoAmbiente;
import br.com.systeconline.nfe.core.util.enumarations.ETipoImpressaoDANFE;
import br.com.systeconline.nfe.core.util.enumarations.ETpEntradaSaida;
import br.com.systeconline.nfe.xml.CNPJ;
import br.com.systeconline.nfe.xml.CPF;
import br.com.systeconline.nfe.xml.InscricaoMunicipal;
import br.com.systeconline.nfe.xml.Signature;
import br.com.systeconline.nfe.xml.envio.EnviNFe;
import br.com.systeconline.nfe.xml.nota.Destinatario;
import br.com.systeconline.nfe.xml.nota.Det;
import br.com.systeconline.nfe.xml.nota.Emitente;
import br.com.systeconline.nfe.xml.nota.EnderEmitente;
import br.com.systeconline.nfe.xml.nota.Ide;
import br.com.systeconline.nfe.xml.nota.InfNFe;
import br.com.systeconline.nfe.xml.nota.NFe;
import br.com.systeconline.nfe.xml.nota.Prod;
import br.com.systeconline.nfe.xml.nota.impostos.Imposto;
import br.com.systeconline.nfe.xml.nota.impostos.PIS;
import br.com.systeconline.nfe.xml.nota.impostos.PISAliq;
import br.com.systeconline.nfe.xml.nota.impostos.icms.ICMS;
import br.com.systeconline.nfe.xml.nota.impostos.icms.ICMS00;
import br.com.systeconline.nfe.xml.nota.totais.ICMSTot;
import br.com.systeconline.nfe.xml.nota.totais.Total;

public class TestCaseXMLEnvio {
	
	private final IGeneralService service;
	private String tpAmb = ETipoAmbiente.HOMOLOGACAO.getValue();
	private SOAPDados dados = null;
	private HandleXML handleXML = null;
	
	public TestCaseXMLEnvio() throws MalformedURLException, ServiceException {
		this.service = new ServicesCE();
		dados = new SOAPDados();
		handleXML = new HandleXML();
		
	}
	
	
	public void validarXMLDeEnvio() {
		
	}
	
	@Test
	public void enviarNFe() {
		NFe nfe 		= new NFe();
		EnviNFe env		= new EnviNFe();
		try {
			InfNFe infNFe 	= new InfNFe();
			//Signature sig	= new Signature();
			env.setIdLote("120");
			env.setIndSinc("0");
			env.setVersao("3.10");
			//Preencher infNFe
			infNFe.setAvulsa(null);
			infNFe.setCana(null);
			infNFe.setId("NFe35151207525356000198650020000000021000000021");
			//Ide
			//--------------------------------------------
			infNFe.setIde(getIdeHomologacao());
			//--------------------
			infNFe.setEmit(getEmitenteHomo());
			//Dados do destinatario
			infNFe.setDest(getDestinatarioHomo());
			//Detalhes da nota
			List<Det> dets = new ArrayList<Det>();
			dets.add(getDetalhe());
			infNFe.setDet(dets);
			//Total da nota
			Total total = new Total();
			ICMSTot iCMSTot = new ICMSTot();
			iCMSTot.setvBC("10.00");
			iCMSTot.setvBCST("10.00");
			iCMSTot.setvICMSDeson("10.00");
			iCMSTot.setvBCST("10.00");
			iCMSTot.setvST("10.00");
			iCMSTot.setvProd("10.00");
			iCMSTot.setvFrete("10.00");
			
			
			total.setiCMSTot(iCMSTot);
			
			infNFe.setTotal(total);
			nfe.setInfNFe(infNFe);
			nfe.setInfNFeSupl(null);
			
			nfe.setSignature(null);
			ArrayList<NFe> list = new ArrayList<NFe>();
			list.add(nfe);
			env.setNfes(list);
			XMLRetornoGeralNFe retorno  = new XMLRetornoGeralNFe();
			SOAPMessage message			= null;
			HandleXML hXml = new HandleXML();
			String xml 		= hXml.getXMLObjectAsStringWriter(env, JAXBContext.newInstance(EnviNFe.class));
			System.out.println("xml envio lote:" + xml);
			HandleXMLSignature sign = new HandleXMLSignature();
			xml = sign.assinarEnviNFe(xml, new File("src/resource/07221070v2016.pfx").getAbsolutePath(), "_cert@gbo");
			System.out.println("xml Assinado: " + xml);
			dados.setServiceName(service.getWebServiceNFeAutorizacao(tpAmb));
			dados.setNameSpaceUri(service.getUrlNFeAutorizacao(tpAmb).toString());
			dados.setcUF(service.getCUF());
			message = SOAPFactory.getMessageXMLNFe(dados,xml, service.getVersaoNFeAutorizacao(tpAmb));
			message = SOAPFactory.enviar(message, service.getUrlNFeAutorizacao(tpAmb));
			retorno = HandleXML.getRetornoGeral(message);
			logarRetorno(retorno);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//return nfe;
	}
	
	private Ide getIdeHomologacao() {
		Ide ide = new Ide();
		ide.setcNF("00000002");
		ide.setcUF("23");
		ide.setNatOp("Venda de mercadoria adquirida ou recebida de terceiros");
		ide.setIndPag("0");
		ide.setMod(EModeloNota.NFE.getValue());
		ide.setSerie("2");
		ide.setnNF("123");
		ide.setDhEmi("2015-09-01T13:00:00-03:00");
		ide.setDhSaiEnt("2015-09-01T13:00:00-03:00");
		ide.setTpNF(ETpEntradaSaida.SAIDA.getValue());
		ide.setIdDest(Ide.OP_INTERANA);
		ide.setcMunFG("2304400");
		ide.setTpImp(ETipoImpressaoDANFE.DANFE_PAISAGEM.getValue());
		ide.setTpEmis(EFormaEmissaoNFe.NORMAL.getValue());
		ide.setcDV("01");
		ide.setTpAmb(ETipoAmbiente.HOMOLOGACAO.getValue());
		ide.setFinNFe(EFinalidadeNFe.NFE_NORMAL.getValue());
		ide.setIndFinal(Ide.CONSUMIDOR_S_FINAL);
		return ide;
	}
	
	private Emitente getEmitenteHomo() throws XMLException {
		Emitente emit = new Emitente();
		CNPJ cnpj = new CNPJ("07525356000198");
		emit.setCpfCnpj(cnpj);
		emit.setxNome("MARIO MAMEDE SOUSA");
		emit.setxFant("MARIO LTDA");
		EnderEmitente enderEmit = new EnderEmitente();
		enderEmit.setCEP(null);
		enderEmit.setCodigoMunicipioIBGE("2304400");
		enderEmit.setComplemento(null);
		enderEmit.setcPais(null);
		enderEmit.setFone(null);
		enderEmit.setLogradouro("AVENIDA C");
		enderEmit.setMunicipio("FORTALEZA");
		enderEmit.setNumero("151");
		enderEmit.setUF("UF");
		enderEmit.setxBairro("JANGURUSSU");
		enderEmit.setxPais(null);
		emit.setEnderEmit(enderEmit);
		emit.setiE("1234567");
		emit.setiEST(null);
		InscricaoMunicipal im = new InscricaoMunicipal("123456");
		emit.setImOuCnae(im);
		return emit;
		
	}
	
	private Destinatario getDestinatarioHomo() {
		Destinatario dest = new Destinatario();
		CPF cpf = new CPF("03403903362");
		dest.setCpfCnpjIdEstrangeiro(cpf);
		dest.setEmail("rafasystec");
		dest.setEnderDest(null);
		dest.setiE(null);
		dest.setIndIEDest(Destinatario.NAO_CONTRIBUINTE_ICM);
		dest.setiSUF(null);
		dest.setxNome("joao paiva andrade");
		return dest;
	}
	
	private Det getDetalhe() {
		Det det = new Det();
		det.setnItem("1");
		Prod prod = new Prod();
		prod.setcProd("31103");
		prod.setcEAN(null);
		prod.setxProd("NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL");
		prod.setNCM("90015000");
		prod.setCFOP("5102");
		prod.setuCom("UND");
		prod.setqCom("1.000");
		prod.setvUnCom("10.00");
		prod.setvProd("10.00");
		prod.setcEANTrib(null);
		prod.setuTrib("UND");
		prod.setqTrib("1.000");
		prod.setuTrib("UND");
		prod.setIndTot("1");
		det.setProd(prod);
		Imposto imp = new Imposto();
		ICMS icms = new ICMS();
		ICMS00 icms00 = new ICMS00();
		icms00.setOrig("0");
		icms00.setcST("00");
		icms00.setModBC("0");
		icms00.setvBC("0.00");
		icms00.setpICMS("0.00");
		icms00.setvICMS("0.00");
		icms.setIcms(icms00);
		imp.setTpTrib(icms);
		PIS pis = new PIS();
		PISAliq pisAliq = new PISAliq();
		pisAliq.setCst("00");
		pisAliq.setvBC("0.00");
		pisAliq.setpPis("0.00");
		pisAliq.setvPis("0.00");
		pis.setTpPIS(pisAliq);
		imp.setPis(pis);
		return det;
	}

	@Test
	public void enviarSOAPConsStatus() throws Exception {
		NFeCoreSender sender = new NFeCoreSender(ECodigoUFIBGE.CEARA.getValue(), tpAmb);
		XMLRetornoGeralNFe retorno = sender.consultarStatusServico("STATUS");
		logarRetorno(retorno);
		assertEquals(Boolean.TRUE, isConsStatusServicoSucesso(retorno.getcStat()));
		
	}
	
	@Test
	public void enviarSOAPConsSitNFe() throws Exception {
		NFeCoreSender sender = new NFeCoreSender(ECodigoUFIBGE.CEARA.getValue(), tpAmb);
		XMLRetornoGeralNFe retorno = sender.consultarProtocolo("NFe35151207525356000198650020000000021000000021");
		logarRetorno(retorno);
		assertEquals(Boolean.TRUE, isConsultaProtocoloSucesso(retorno.getcStat()));		
	}
	
	public boolean isConsultaProtocoloSucesso(int status) {
		if(status == 100 || status == 101 || status == 110){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isConsStatusServicoSucesso(int status) {
		if(status == 107 || status == 108 || status == 109){
			return true;
		}else{
			return false;
		}
	}
	
	public void logarRetorno(XMLRetornoGeralNFe retorno) {
		System.out.println("Codigo status: " + retorno.getcStat());
		System.out.println("Motivo:" + retorno.getMotivo());
		if(retorno.getFalt() != null){
			System.out.println("Falha no envio");
			System.out.println("Ator: " + retorno.getFalt().getActor());
			System.out.println("Codigo: " + retorno.getFalt().getCode());
			System.out.println("Mensagem de falha completa: " + retorno.getFalt().getFullMessage());
		}
	}
	
	public void statusServico() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
