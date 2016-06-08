package br.com.barcadero.sat.tests;

import java.util.ArrayList;
import java.util.List;

import br.com.barcadero.module.sat.enums.EnumCSTICMS00;
import br.com.barcadero.module.sat.enums.EnumEAN;
import br.com.barcadero.module.sat.enums.EnumIndRatISSQN;
import br.com.barcadero.module.sat.enums.EnumIndRegra;
import br.com.barcadero.module.sat.enums.EnumOrigICMS;
import br.com.barcadero.module.sat.enums.EnumRegimeTributarioISSQN;
import br.com.barcadero.module.sat.enums.EnumUF;
import br.com.barcadero.module.sat.xml.envio.CFe;
import br.com.barcadero.module.sat.xml.envio.Dest;
import br.com.barcadero.module.sat.xml.envio.Det;
import br.com.barcadero.module.sat.xml.envio.Emit;
import br.com.barcadero.module.sat.xml.envio.Entrega;
import br.com.barcadero.module.sat.xml.envio.ICMS;
import br.com.barcadero.module.sat.xml.envio.ICMS00;
import br.com.barcadero.module.sat.xml.envio.Ide;
import br.com.barcadero.module.sat.xml.envio.Imposto;
import br.com.barcadero.module.sat.xml.envio.InfCFe;
import br.com.barcadero.module.sat.xml.envio.Prod;
import br.com.barcadero.module.sat.xml.util.CNPJ;

public class MainTest {
	
	public void gerarXMLSAT() {
		
		CFe cfe 		= new CFe();
		InfCFe infCFe 	= new InfCFe();
		infCFe.setVersaoDadosEnt("0.06");
		//Identificacao
		Ide ide = new Ide();
		ide.setCNPJ("11111111111111");
		ide.setNumeroCaixa("01");
		ide.setSignAC("SISTEMA DE GESTAO E RETAGUARDA DO SAT");
		infCFe.setIde(ide);
		//Identificacao do Emitente do Cupom fiscal
		Emit emit = new Emit();
		emit.setCNPJ("11111111111111"); //CNPJ da loja
		emit.setIE("11111111");
		emit.setCRegTribISSQN(EnumRegimeTributarioISSQN.MIRCOEMPRESA_MUNICIPAL);
		emit.setIndRatISSQN(EnumIndRatISSQN.NAO);
		emit.setIM("2828928388393");
		infCFe.setEmit(emit);
		//---------------------------------
		//Idetificacao do Destinatario do cupom fiscal
		Dest destinatario = new Dest();
		destinatario.setCpfCnpj(new CNPJ("11111111111111"));
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
		prod.setCEAN(EnumEAN.NENHUN);
		prod.setXProd("PROD HOMOLOG");
		prod.setNCM("89098909");
		prod.setcEST("90987");
		prod.setCFOP("5012"); // Faixa de 5000
		prod.setUCom("UN");
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
		//N - ICMS Normal e ST
		
		det.setImposto(imposto );
		
		
		
		dets.add(det);
		infCFe.setDets(dets);
		
		cfe.setInfCFe(infCFe);
	}

}
