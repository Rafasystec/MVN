package br.com.barcadero.sat.tests;

import java.util.ArrayList;
import java.util.List;

import br.com.barcadero.commons.xml.HandleXML;
import br.com.barcadero.module.sat.enums.EnumCSTCOFINSAliq;
import br.com.barcadero.module.sat.enums.EnumCSTICMS00;
import br.com.barcadero.module.sat.enums.EnumEAN;
import br.com.barcadero.module.sat.enums.EnumIndRatISSQN;
import br.com.barcadero.module.sat.enums.EnumIndRegra;
import br.com.barcadero.module.sat.enums.EnumMeioPagamento;
import br.com.barcadero.module.sat.enums.EnumModulosSAT;
import br.com.barcadero.module.sat.enums.EnumOrigICMS;
import br.com.barcadero.module.sat.enums.EnumRegimeTributarioISSQN;
import br.com.barcadero.module.sat.enums.EnumUF;
import br.com.barcadero.module.sat.handle.HandleSAT;
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

public class MainTest {
	public static void main(String[] args) {
		gerarXMLSAT();
	}
	
	public static void gerarXMLSAT() {
		
		CFe cfe 		= new CFe();
		InfCFe infCFe 	= new InfCFe();
		infCFe.setVersaoDadosEnt("0.06");
		//Identificacao
		Ide ide = new Ide();
		ide.setCNPJ("16716114000172");
		ide.setNumeroCaixa("001");
		ide.setSignAC("SGR-SAT SISTEMA DE GESTAO E RETAGUARDA DO SAT");
		infCFe.setIde(ide);
		//Identificacao do Emitente do Cupom fiscal
		Emit emit = new Emit();
		emit.setCNPJ("08723218000186"); //CNPJ da loja
		emit.setIE("149626224113");
		emit.setCRegTribISSQN(EnumRegimeTributarioISSQN.MIRCOEMPRESA_MUNICIPAL);
		emit.setIndRatISSQN(EnumIndRatISSQN.NAO);
		emit.setIM("123456789");
		infCFe.setEmit(emit);
		//---------------------------------
		//Idetificacao do Destinatario do cupom fiscal
		Dest destinatario = new Dest();
		destinatario.setCpfCnpj(new CNPJ("46541673000150"));
		destinatario.setXNome("RAZAO SOCIAL");
		infCFe.setDest(destinatario);
		//---------------------------------
		//Identificacao do local de entrega
		Entrega entrega = new Entrega();
		entrega.setXLgr("Logradouro");
		entrega.setNro("123");
		entrega.setXCpl("complemento");
		entrega.setXBairro("Bairro");
		entrega.setXMun("Municipio");
		entrega.setUF(EnumUF.CE);
		infCFe.setEntrega(entrega );
		//---------------------------------
		//Detalhamento produtos e servicos da CF-e
		
		List<Det> dets = new ArrayList<Det>();
		Det det = new Det();
		det.setNItem("001");
		det.setInfAdProd("Informacao adicional");
		Prod prod = new Prod();
		prod.setCProd("0090980");
		//prod.setCEAN(EnumEAN.NENHUN);
		prod.setXProd("PROD HOMOLOG");
		prod.setNCM("01031000");
		//prod.setcEST("90987");
		prod.setCFOP("5102"); // Faixa de 5000
		prod.setUCom("UN");
		prod.setQCom("1.0000");
		prod.setVUnCom("10.99");
		prod.setIndRegra(EnumIndRegra.ARREDONDAMENTO);
		det.setProd(prod);
		//Tributos incidentes no Produto ou servico
		Imposto imposto = new Imposto();
		imposto.setVItem12741("2.50");
		//ICMS Normal e ST
		ICMS icms 		= new ICMS();
		ICMS00 icms00 	= new ICMS00();
		icms00.setOrig(EnumOrigICMS.NACIONAL);
		icms00.setCST(EnumCSTICMS00.TRIBUTADO_INTEGRALMENTE);
		icms00.setPICMS("5.33");
		icms.setiCMS(icms00);
		imposto.setICMS(icms );
		//PIS
		PIS pis 		= new PIS();
		PISAliq aliq	= new PISAliq();
		aliq.setCST("01");
		aliq.setPPIS("0.1700");
		aliq.setVBC("10.99");
		pis.setPISAliq(aliq);
		imposto.setPIS(pis );
		//Cofins
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
		//WA - Informacoes sobre Pagamento
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
			HandleXML.toFile(cfe, "D://temp/", "cfe.xml");
			String xml = HandleXML.getXMLFromObject(cfe);
			transmitirTanca(xml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void transmitirTanca(String xml) throws Exception {
		
		HandleSAT sat = new HandleSAT();
		sat.definirSatByClasse(EnumModulosSAT.TANCA.getClassName(), "");
		String result = sat.enviarDadosVenda(xml,"12345678");
		System.out.println(result);
	}

}
