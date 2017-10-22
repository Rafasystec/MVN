package br.com.barcadero.sat.tests;

import java.util.ArrayList;
import java.util.List;

import br.com.barcadero.commons.enuns.EnumTipoModuloSAT;
import br.com.barcadero.commons.xml.HandleXML;
import br.com.barcadero.module.sat.enums.EnumCFeCSTPISAliq;
import br.com.barcadero.module.sat.enums.EnumCSTCOFINSAliq;
import br.com.barcadero.module.sat.enums.EnumCSTICMS00;
import br.com.barcadero.module.sat.enums.EnumIndRatISSQN;
import br.com.barcadero.module.sat.enums.EnumIndRegra;
import br.com.barcadero.module.sat.enums.EnumMeioPagamento;
import br.com.barcadero.module.sat.enums.EnumOrigICMS;
import br.com.barcadero.module.sat.enums.EnumRegimeTributarioISSQN;
import br.com.barcadero.module.sat.enums.EnumUF;
import br.com.barcadero.module.sat.handle.HandleRetornoSAT;
import br.com.barcadero.module.sat.socket.CFeComandosSokect;
import br.com.barcadero.module.sat.xml.cancelamento.CFeCanc;
import br.com.barcadero.module.sat.xml.envio.CFe;
import br.com.barcadero.module.sat.xml.envio.COFINS;
import br.com.barcadero.module.sat.xml.envio.COFINSAliq;
import br.com.barcadero.module.sat.xml.envio.Dest;
import br.com.barcadero.module.sat.xml.envio.Det;
import br.com.barcadero.module.sat.xml.envio.Emit;
import br.com.barcadero.module.sat.xml.envio.Entrega;
import br.com.barcadero.module.sat.xml.envio.ICMS;
import br.com.barcadero.module.sat.xml.envio.ICMS00;
import br.com.barcadero.module.sat.xml.envio.Ide;
import br.com.barcadero.module.sat.xml.envio.Imposto;
import br.com.barcadero.module.sat.xml.envio.InfCFe;
import br.com.barcadero.module.sat.xml.envio.MP;
import br.com.barcadero.module.sat.xml.envio.PIS;
import br.com.barcadero.module.sat.xml.envio.PISAliq;
import br.com.barcadero.module.sat.xml.envio.Pgto;
import br.com.barcadero.module.sat.xml.envio.Prod;
import br.com.barcadero.module.sat.xml.envio.Total;
import br.com.barcadero.module.sat.xml.util.CNPJ;

public class TestEnviarComandoVendaSocket {
	
	public static void main(String[] args) {
//		CFeComandosSokect comandosSokect = new CFeComandosSokect("localhost", EnumTipoModuloSAT.EMULADOR);
//		try {
//			HandleRetornoSAT handleRetornoVendaSAT = comandosSokect.enviarDadosVenda("12345678", gerarCFeDeTeste());
//			if(handleRetornoVendaSAT.getCodigoRetorno1().equals("06000")){
//				System.out.println("Chave venda: " + handleRetornoVendaSAT.getChaveDeConsulta());
//				HandleRetornoSAT handleRetornoCanceSAT = comandosSokect.cancelarUltimaVenda("12345678", handleRetornoVendaSAT.getChaveDeConsulta(), getCfeCanc(handleRetornoVendaSAT.getChaveDeConsulta()));
//				System.out.println("Cancalamento: "+handleRetornoCanceSAT.getCodigoRetorno1());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public static String getCNPJSWEmuladorSP() {
		return "32832786000108";
	}
	
	public static String getAssinaturaEmualdor() {
		return "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
	}
	
	/**
	 * Esse CNPJ pode varia, depende de qual vc tenha cadastrador no ativador do emulador
	 * @return
	 */
	public static String getCNPJCOntribuinteEmuladorSP() {
		return "11111111111111";
	}
	
	private static CFe gerarCFeDeTeste() {
		CFe cfe 		= new CFe();
		InfCFe infCFe 	= new InfCFe();
		infCFe.setVersaoDadosEnt("0.06");
		//-------------------------------------------------
		//Identificacao da SoftwareHouse
		//-------------------------------------------------
		Ide ide = new Ide();
		ide.setCNPJ(getCNPJSWEmuladorSP());
		ide.setNumeroCaixa("001");
		ide.setSignAC(getAssinaturaEmualdor());
		infCFe.setIde(ide);
		//-------------------------------------------------
		//Identificacao do Emitente do Cupom fiscal
		//-------------------------------------------------
		Emit emit = new Emit();
		emit.setCNPJ(getCNPJCOntribuinteEmuladorSP()); //CNPJ da loja
		emit.setIE("111111111111");
		emit.setCRegTribISSQN(EnumRegimeTributarioISSQN.MIRCOEMPRESA_MUNICIPAL);
		emit.setIndRatISSQN(EnumIndRatISSQN.NAO);
		emit.setIM("123456789");
		infCFe.setEmit(emit);
		//-------------------------------------------------
		//Idetificacao do Destinatario do cupom fiscal
		//-------------------------------------------------
		Dest destinatario = new Dest();
		destinatario.setCpfCnpj(new CNPJ("46541673000150"));
		destinatario.setXNome("RAZAO SOCIAL");
		infCFe.setDest(destinatario);
		//-------------------------------------------------
		//Identificacao do local de entrega
		//-------------------------------------------------
		Entrega entrega = new Entrega();
		entrega.setXLgr("Logradouro");
		entrega.setNro("123");
		entrega.setXCpl("complemento");
		entrega.setXBairro("Bairro");
		entrega.setXMun("Municipio");
		entrega.setUF(EnumUF.CE);
		infCFe.setEntrega(entrega );
		//-------------------------------------------------
		//Detalhamento produtos e servicos da CF-e
		//-------------------------------------------------
		List<Det> dets = new ArrayList<Det>();
		Det det = new Det();
		det.setNItem("001");
		det.setInfAdProd("Informacao adicional");
		Prod prod = new Prod();
		prod.setCProd("0090980");
		prod.setXProd("PROD HOMOLOG");
		prod.setNCM("01031000");
		prod.setCFOP("5102"); // Faixa de 5000
		prod.setUCom("UN");
		prod.setQCom("1.0000");
		prod.setVUnCom("10.99");
		prod.setIndRegra(EnumIndRegra.ARREDONDAMENTO);
		det.setProd(prod);
		//-------------------------------------------------
		//Tributos incidentes no Produto ou servico
		//-------------------------------------------------
		Imposto imposto = new Imposto();
		imposto.setVItem12741("2.50");
		//-------------------------------------------------
		//ICMS Normal e ST
		//-------------------------------------------------
		ICMS icms 		= new ICMS();
		ICMS00 icms00 	= new ICMS00();
		icms00.setOrig(EnumOrigICMS.NACIONAL);
		icms00.setCST(EnumCSTICMS00.TRIBUTADO_INTEGRALMENTE);
		icms00.setPICMS("5.33");
		icms.setiCMS(icms00);
		imposto.setICMS(icms );
		//-------------------------------------------------
		//PIS
		//-------------------------------------------------
		PIS pis 		= new PIS();
		PISAliq aliq	= new PISAliq();
		aliq.setCST(EnumCFeCSTPISAliq.CST_01);
		aliq.setPPIS("0.1700");
		aliq.setVBC("10.99");
		pis.setPisGroup(aliq);
		imposto.setPIS(pis );
		//-------------------------------------------------
		//Cofins
		//-------------------------------------------------
		COFINS cofins 			= new COFINS();
		COFINSAliq cofinsAliq 	= new COFINSAliq();
		cofinsAliq.setCST(EnumCSTCOFINSAliq.OPER_TRIBUT_NORMAL);
		cofinsAliq.setPCOFINS("0.0900");
		cofinsAliq.setVBC("10.99");
		cofins.setCofins(cofinsAliq);
		imposto.setCOFINS(cofins );
		det.setImposto(imposto );
		dets.add(det);
		infCFe.setDets(dets);
		//------------------------
		Total total = new Total(); 
		total.setVCFeLei12741("1.05");
		infCFe.setTotal(total);
		//-------------------------------------------------
		//WA - Informacoes sobre Pagamento
		//-------------------------------------------------
		Pgto pgto = new Pgto();
		List<MP> mps = new ArrayList<MP>();
		MP mp = new MP();
		mp.setCMP(EnumMeioPagamento.DINHEIRO);
		mp.setVMP("10.99");
		mps.add(mp);
		pgto.setMPs(mps );
		infCFe.setPgto(pgto);
		cfe.setInfCFe(infCFe);
		try {
			String xml = HandleXML.getXMLFromObject(cfe);
			System.out.println(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cfe;
	}
	/**
	 * 
	 * @param cfeChave
	 * @return
	 */
	public static CFeCanc getCfeCanc(String cfeChave) {
		CFeCanc cFeCanc = new CFeCanc();
		br.com.barcadero.module.sat.xml.cancelamento.InfCFe infCFe	= new br.com.barcadero.module.sat.xml.cancelamento.InfCFe();
		//infCFe.setChCanc("CFe35160608723218000186599000025910004973807404");
		infCFe.setChCanc(cfeChave);
		//--------------------------------------------------------
		//NOTE: B - Identificacao do Cupom Fiscal Eletronico
		//--------------------------------------------------------
		br.com.barcadero.module.sat.xml.cancelamento.Ide ide = new br.com.barcadero.module.sat.xml.cancelamento.Ide();
		ide.setCNPJ("16716114000172");
		ide.setNumeroCaixa("001");
		ide.setSignAC("SGR-SAT SISTEMA DE GESTAO E RETAGUARDA DO SAT");
		infCFe.setIde(ide);
		//---------------------------------------------------------------
		//NOTE: C - Identificacao do Emitente do Cupom Fiscal eletronico
		//---------------------------------------------------------------
		br.com.barcadero.module.sat.xml.cancelamento.Emit emit = new br.com.barcadero.module.sat.xml.cancelamento.Emit();
		infCFe.setEmit(emit);
		//---------------------------------------------------------------
		//NOTE: E - Identificacao do Destinatario do Cupom Fiscal eletronco
		//---------------------------------------------------------------
		br.com.barcadero.module.sat.xml.cancelamento.Dest dest = new br.com.barcadero.module.sat.xml.cancelamento.Dest();
		dest.setCpfCnpj(new CNPJ("46541673000150"));
		infCFe.setDest(dest);
		//---------------------------------------------------------------
		//NOTE: W - Valores Totais do CF-e
		//---------------------------------------------------------------
		br.com.barcadero.module.sat.xml.cancelamento.Total total = new br.com.barcadero.module.sat.xml.cancelamento.Total();
		infCFe.setTotal(total);
		//---------------------------------------------------------------
		//Z - Informacoes Adicionais do CF-e
		//---------------------------------------------------------------
//		InfAdic infAdic = new InfAdic();
//		infCFe.setInfAdic(infAdic);
		
		cFeCanc.setInfCFe(infCFe);
		return cFeCanc;
	}
}
