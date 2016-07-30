package br.com.barcadero.sat.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.barcadero.commons.util.HandleFiles;
import br.com.barcadero.commons.xml.HandleXML;
import br.com.barcadero.module.sat.enums.EnumCFeCSTPISAliq;
import br.com.barcadero.module.sat.enums.EnumCSTCOFINSAliq;
import br.com.barcadero.module.sat.enums.EnumCSTICMS00;
import br.com.barcadero.module.sat.enums.EnumIndRatISSQN;
import br.com.barcadero.module.sat.enums.EnumIndRegra;
import br.com.barcadero.module.sat.enums.EnumMeioPagamento;
import br.com.barcadero.module.sat.enums.EnumModulosSAT;
import br.com.barcadero.module.sat.enums.EnumOrigICMS;
import br.com.barcadero.module.sat.enums.EnumRegimeTributarioISSQN;
import br.com.barcadero.module.sat.enums.EnumUF;
import br.com.barcadero.module.sat.handle.HandleSAT;
import br.com.barcadero.module.sat.retornos.RetEnvioVenda;
import br.com.barcadero.module.sat.util.Files;
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
		new MainTest().enviarDadosVenda();
		//decode();
		//retornoVenda();
	}
	
	@Test
	public void gerarXMLSAT() {
		
		CFe cfe 		= new CFe();
		InfCFe infCFe 	= new InfCFe();
		infCFe.setVersaoDadosEnt("0.06");
		//-------------------------------------------------
		//Identificacao
		//-------------------------------------------------
		Ide ide = new Ide();
		ide.setCNPJ("16716114000172");
		ide.setNumeroCaixa("001");
		ide.setSignAC("SGR-SAT SISTEMA DE GESTAO E RETAGUARDA DO SAT");
		infCFe.setIde(ide);
		//-------------------------------------------------
		//Identificacao do Emitente do Cupom fiscal
		//-------------------------------------------------
		Emit emit = new Emit();
		emit.setCNPJ("08723218000186"); //CNPJ da loja
		emit.setIE("149626224113");
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
			//HandleXML.toFile(cfe, "D://temp/", "cfe.xml");
			String xml = HandleXML.getXMLFromObject(cfe);
			//System.out.println(xml);
			assertEquals("O XML gerado nao foi igual ao esperado",getXMLVendaEmperado(),xml);
			//transmitirTanca(xml); //Habilitar somente quando for gerar os testes com o modulo conectado
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}
	
	public void enviarDadosVenda() {
		String dadosVenda = "<CFe><infCFe versaoDadosEnt=\"0.06\"><ide><CNPJ>16716114000172</CNPJ><signAC>SGR-SAT SISTEMA DE GESTAO E RETAGUARDA DO SAT</signAC><numeroCaixa>003</numeroCaixa></ide><emit><CNPJ>08723218000186</CNPJ><IE>149626224113</IE><IM>123456789</IM><cRegTribISSQN>5</cRegTribISSQN></emit><dest></dest><det nItem=\"1\"><prod><cProd>15</cProd><xProd>PRODUTO 1</xProd><NCM>121544</NCM><CFOP>5102</CFOP><uCom>UNIDADE</uCom><qCom>2.0000</qCom><vUnCom>25.87</vUnCom><indRegra>A</indRegra></prod><imposto><vItem12741>2.50</vItem12741><ICMS><ICMS00><Orig>0</Orig><CST>00</CST><pICMS>5.33</pICMS></ICMS00></ICMS><PIS><PISAliq><CST>01</CST><vBC>51.74</vBC><pPIS>0.6500</pPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>51.74</vBC><pCOFINS>3.0000</pCOFINS></COFINSAliq></COFINS></imposto><infAdProd></infAdProd></det><total><vCFeLei12741>1.05</vCFeLei12741></total><pgto><MP><cMP>01</cMP><vMP>60</vMP></MP></pgto></infCFe></CFe>";
		try {
			transmitirTanca(dadosVenda);
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
	
	public static void decode() {
		String valueBase64 = "PENGZT48aW5mQ0ZlIElkPSJDRmUzNTE2MDYwODcyMzIxODAwMDE4NjU5OTAwMDAyNTkxMDAwNDg5NjI4MjcwNSIgdmVyc2FvPSIwLjA2IiB2ZXJzYW9EYWRvc0VudD0iMC4wNiIgdmVyc2FvU0I9IjAxMDEwMSI+PGlkZT48Y1VGPjM1PC9jVUY+PGNORj42MjgyNzA8L2NORj48bW9kPjU5PC9tb2Q+PG5zZXJpZVNBVD45MDAwMDI1OTE8L25zZXJpZVNBVD48bkNGZT4wMDA0ODk8L25DRmU+PGRFbWk+MjAxNjA2MTA8L2RFbWk+PGhFbWk+MTE0MzQ0PC9oRW1pPjxjRFY+NTwvY0RWPjx0cEFtYj4yPC90cEFtYj48Q05QSj4xNjcxNjExNDAwMDE3MjwvQ05QSj48c2lnbkFDPlNHUi1TQVQgU0lTVEVNQSBERSBHRVNUQU8gRSBSRVRBR1VBUkRBIERPIFNBVDwvc2lnbkFDPjxhc3NpbmF0dXJhUVJDT0RFPnppb1VOd0RDYzJ4U2t6eHpBSGtDcXR3U1R0Ri9QZkE5VnpuYmFTOGFhRkZrWm5RNWZ2YW9XVkpFOUxmTGREc0ZSL2gyVFZEUzdOSUxrTlh6YWdVV0tQWm9XL3p4dWVjcmFrOXQ0S1dPN21QaTZINlVhY3FVM2tpWUJsYUVRZXBUVXFRcko4VVNubmR6b1BYUm0razBERStsdkh3MUI0cHREcm5xQXhhRnB2V2wwcW4yNFhtampxTGw0OTVFR3hJRDU5K2x1cERUbVRoTnBMM3dwNzlNZTg3TnRZRGtFR0FYMzdlNGo0RERwcmFwNHZGdEsxL2YydEFyZDM2c0doQzJaQ1JyL2JwYVArWkEza3FrS1FIMkFOWnJHallDc1ZlUVVQbUFocmowcEpZQS9OMVd6WEw3UUE3Z0p0bnhqY1J6d052RHlOUXlNZWw4TmJ2elM3Ulg4Zz09PC9hc3NpbmF0dXJhUVJDT0RFPjxudW1lcm9DYWl4YT4wMDE8L251bWVyb0NhaXhhPjwvaWRlPjxlbWl0PjxDTlBKPjA4NzIzMjE4MDAwMTg2PC9DTlBKPjx4Tm9tZT5UQU5DQSBJTkZPUk1BVElDQSBFSVJFTEk8L3hOb21lPjx4RmFudD5UQU5DQTwveEZhbnQ+PGVuZGVyRW1pdD48eExncj5SVUEgRU5HRU5IRUlSTyBKT1JHRSBPTElWQTwveExncj48bnJvPjczPC9ucm8+PHhCYWlycm8+VklMQSBNQVNDT1RFPC94QmFpcnJvPjx4TXVuPlNBTyBQQVVMTzwveE11bj48Q0VQPjA0MzYyMDYwPC9DRVA+PC9lbmRlckVtaXQ+PElFPjE0OTYyNjIyNDExMzwvSUU+PElNPjEyMzQ1Njc4OTwvSU0+PGNSZWdUcmliPjM8L2NSZWdUcmliPjxjUmVnVHJpYklTU1FOPjE8L2NSZWdUcmliSVNTUU4+PGluZFJhdElTU1FOPk48L2luZFJhdElTU1FOPjwvZW1pdD48ZGVzdD48Q05QSj40NjU0MTY3MzAwMDE1MDwvQ05QSj48eE5vbWU+UkFaQU8gU09DSUFMPC94Tm9tZT48L2Rlc3Q+PGVudHJlZ2E+PHhMZ3I+TG9ncmFkb3VybzwveExncj48bnJvPjEyMzwvbnJvPjx4Q3BsPmNvbXBsZW1lbnRvPC94Q3BsPjx4QmFpcnJvPkJhaXJybzwveEJhaXJybz48eE11bj5NdW5pY2lwaW88L3hNdW4+PFVGPkNFPC9VRj48L2VudHJlZ2E+PGRldCBuSXRlbT0iMSI+PHByb2Q+PGNQcm9kPjAwOTA5ODA8L2NQcm9kPjx4UHJvZD5QUk9EIEhPTU9MT0c8L3hQcm9kPjxOQ00+MDEwMzEwMDA8L05DTT48Q0ZPUD41MTAyPC9DRk9QPjx1Q29tPlVOPC91Q29tPjxxQ29tPjEuMDAwMDwvcUNvbT48dlVuQ29tPjEwLjk5PC92VW5Db20+PHZQcm9kPjEwLjk5PC92UHJvZD48aW5kUmVncmE+QTwvaW5kUmVncmE+PHZJdGVtPjEwLjk5PC92SXRlbT48dlJhdERlc2M+MC4wMDwvdlJhdERlc2M+PHZSYXRBY3I+MC4wMDwvdlJhdEFjcj48L3Byb2Q+PGltcG9zdG8+PHZJdGVtMTI3NDE+Mi41MDwvdkl0ZW0xMjc0MT48SUNNUz48SUNNUzAwPjxPcmlnPjA8L09yaWc+PENTVD4wMDwvQ1NUPjxwSUNNUz41LjMzPC9wSUNNUz48dklDTVM+MC41OTwvdklDTVM+PC9JQ01TMDA+PC9JQ01TPjxQSVM+PFBJU0FsaXE+PENTVD4wMTwvQ1NUPjx2QkM+MTAuOTk8L3ZCQz48cFBJUz4wLjE3MDA8L3BQSVM+PHZQSVM+MS44NzwvdlBJUz48L1BJU0FsaXE+PC9QSVM+PENPRklOUz48Q09GSU5TQWxpcT48Q1NUPjAxPC9DU1Q+PHZCQz4xMC45OTwvdkJDPjxwQ09GSU5TPjAuMDkwMDwvcENPRklOUz48dkNPRklOUz4wLjk5PC92Q09GSU5TPjwvQ09GSU5TQWxpcT48L0NPRklOUz48L2ltcG9zdG8+PGluZkFkUHJvZD5JbmZvcm1hY2FvIGFkaWNpb25hbDwvaW5mQWRQcm9kPjwvZGV0Pjx0b3RhbD48SUNNU1RvdD48dklDTVM+MC41OTwvdklDTVM+PHZQcm9kPjEwLjk5PC92UHJvZD48dkRlc2M+MC4wMDwvdkRlc2M+PHZQSVM+MS44NzwvdlBJUz48dkNPRklOUz4wLjk5PC92Q09GSU5TPjx2UElTU1Q+MC4wMDwvdlBJU1NUPjx2Q09GSU5TU1Q+MC4wMDwvdkNPRklOU1NUPjx2T3V0cm8+MC4wMDwvdk91dHJvPjwvSUNNU1RvdD48dkNGZT4xMC45OTwvdkNGZT48dkNGZUxlaTEyNzQxPjEuMDU8L3ZDRmVMZWkxMjc0MT48L3RvdGFsPjxwZ3RvPjxNUD48Y01QPjAxPC9jTVA+PHZNUD4xMC45OTwvdk1QPjwvTVA+PHZUcm9jbz4wLjAwPC92VHJvY28+PC9wZ3RvPjxpbmZBZGljPjxvYnNGaXNjbyB4Q2FtcG89InhDYW1wbzEiPjx4VGV4dG8+eFRleHRvMTwveFRleHRvPjwvb2JzRmlzY28+PC9pbmZBZGljPjwvaW5mQ0ZlPjxTaWduYXR1cmUgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPjxTaWduZWRJbmZvPjxDYW5vbmljYWxpemF0aW9uTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvVFIvMjAwMS9SRUMteG1sLWMxNG4tMjAwMTAzMTUiPjwvQ2Fub25pY2FsaXphdGlvbk1ldGhvZD48U2lnbmF0dXJlTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8wNC94bWxkc2lnLW1vcmUjcnNhLXNoYTI1NiI+PC9TaWduYXR1cmVNZXRob2Q+PFJlZmVyZW5jZSBVUkk9IiNDRmUzNTE2MDYwODcyMzIxODAwMDE4NjU5OTAwMDAyNTkxMDAwNDg5NjI4MjcwNSI+PFRyYW5zZm9ybXM+PFRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNlbnZlbG9wZWQtc2lnbmF0dXJlIj48L1RyYW5zZm9ybT48VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvVFIvMjAwMS9SRUMteG1sLWMxNG4tMjAwMTAzMTUiPjwvVHJhbnNmb3JtPjwvVHJhbnNmb3Jtcz48RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8wNC94bWxlbmMjc2hhMjU2Ij48L0RpZ2VzdE1ldGhvZD48RGlnZXN0VmFsdWU+L1M1aXpiQ3NEM3E4K21HVmJhSmt1OFhXV01IQk1RVElCTHYxRlF4dEJCaz08L0RpZ2VzdFZhbHVlPjwvUmVmZXJlbmNlPjwvU2lnbmVkSW5mbz48U2lnbmF0dXJlVmFsdWU+VnRKeFR4UUMzVzNNak9CSWQ2L1NCWnJKUEM5TlZsS3E3OGZZS2pTS3RlL3hYQURmdmZHVUs4NC9oQjdIQWVhZ1dEWHhkdmpsbzBDVHo4TnJrM0xyZnZ3NzZzdkVCdG10NmVDOFZubnFWMzdOMGJ5cnFzejhGUW9FdmkrK3FhcVFNUEs0aHR3YnJvWDkwVk1zQlR4S2RtbEdkUTJZYkJSME9MYk9IUG4rK1hWRzZEMzNKSDErbTFreTd4VkVUdDZ5UEVrYnVUV0J0ZFhvYTlCYUdpY3h3U3dvaGVldmNoZXNzRTZNRi85a0JnUTZyU3JHV2tKTlFpMzlyS211WUU5ZEgyZFpXRWcwNWpyZ1orOVMzajhUbkhzUHJRS3Z0WStTcnFNbGNXa2QvOGFranBNd25FWEUwS3Q0b1lzZTNScm5sWG80a1hpd2o0bVcveDhuUktNcXh3PT08L1NpZ25hdHVyZVZhbHVlPjxLZXlJbmZvPjxYNTA5RGF0YT48WDUwOUNlcnRpZmljYXRlPk1JSUcxakNDQkw2Z0F3SUJBZ0lRTmthMjlqRVRQU2Z1TWZ2eGxOUXE1ekFOQmdrcWhraUc5dzBCQVFzRkFEQm5NUXN3Q1FZRFZRUUdFd0pDVWpFMU1ETUdBMVVFQ2hNc1UyVmpjbVYwWVhKcFlTQmtZU0JHWVhwbGJtUmhJR1J2SUVWemRHRmtieUJrWlNCVFlXOGdVR0YxYkc4eElUQWZCZ05WQkFNVEdFRkRJRk5CVkNCa1pTQlVaWE4wWlNCVFJVWkJXaUJUVURBZUZ3MHhOVEEwTWpJd01EQXdNREJhRncweU1EQTBNVGt5TXpVNU5UbGFNSUhUTVFzd0NRWURWUVFHRXdKQ1VqRVNNQkFHQTFVRUNCTUpVMEZQSUZCQlZVeFBNUkV3RHdZRFZRUUtGQWhUUlVaQldpMVRVREVQTUEwR0ExVUVDeFFHUVVNdFUwRlVNU2d3SmdZRFZRUUxGQjlCZFhSbGJuUnBZMkZrYnlCd2IzSWdRVklnVTBWR1FWb2dVMUFnVTBGVU1Sd3dHZ1lEVlFRTEZCTXhOREk1TnpFM01ETXdNVE0xTmpNeE1ESXhNUkl3RUFZRFZRUUZFd2s1TURBd01ESTFPVEV4TURBdUJnTlZCQU1USjFSQlRrTkJJRWxPUms5U1RVRlVTVU5CSUVWSlVrVk1TVG93T0RjeU16SXhPREF3TURFNE5qQ0NBU0l3RFFZSktvWklodmNOQVFFQkJRQURnZ0VQQURDQ0FRb0NnZ0VCQU5lSm1Ebm9XSldtZHkvNkV0YXVSRE1MenZxZnlnbzJlVm16blh2L1FnL3pVdU5TNU53VUxkaGNWc2dIRjB4U3k4ZE9Ga1hPWHBUaG5YWDdES284eDJNSXFOdGtLUW5Uck9FS2J3ZGt5MHdhajdmQ2xIelBodThEOVoybyt2Um9ycmxiZ1RZRmlROG0yZzhKQWNYU3lGay9Fc1hYUm5CUE9NTktKR0hHOWxkNDkyMG56YU1WakxFbldwZVdNNUtaSnV4eWlCNUhFdnJLUXRzU3BOWHQxQUtwa2d4SGdZOC8wUGxwamp5Zjlmb2NDM2ZURDAwRzRxMEU5K0VNTGhiT0dPRlVNYVE0RzZxMDhJWXZlWHhCSGVCOVU4clIvU1JBRjB1RmxOR2gvM2ZhdUdGYjRFTmxmZjlNalpTUHhLUEtWdTlkSGZwWGdHd1FROENzV1lTTDJ0VUNBd0VBQWFPQ0FnOHdnZ0lMTUNRR0ExVWRFUVFkTUJ1Z0dRWUZZRXdCQXdPZ0VBUU9NRGczTWpNeU1UZ3dNREF4T0RZd0NRWURWUjBUQkFJd0FEQU9CZ05WSFE4QkFmOEVCQU1DQmVBd0h3WURWUjBqQkJnd0ZvQVVqamxCQUZ6eXVBWGFxRzJZdVFGR2JXNWozd0l3YXdZRFZSMGZCR1F3WWpCZ29GNmdYSVphYUhSMGNEb3ZMMkZqYzJGMExYUmxjM1JsTG1sdGNISmxibk5oYjJacFkybGhiQzVqYjIwdVluSXZjbVZ3YjNOcGRHOXlhVzh2YkdOeUwyRmpjMkYwYzJWbVlYcHpjQzloWTNOaGRITmxabUY2YzNCamNtd3VZM0pzTUhzR0ExVWRJQVIwTUhJd2NBWUpLd1lCQkFHQjdDMERNR013WVFZSUt3WUJCUVVIQWdFV1ZXaDBkSEE2THk5aFkzTmhkQzVwYlhCeVpXNXpZVzltYVdOcFlXd3VZMjl0TG1KeUwzSmxjRzl6YVhSdmNtbHZMMlJ3WXk5aFkzTmhkSE5sWm1GNmMzQXZaSEJqWDJGamMyRjBjMlZtWVhwemNDNXdaR1l3RXdZRFZSMGxCQXd3Q2dZSUt3WUJCUVVIQXdJd2dhY0dDQ3NHQVFVRkJ3RUJCSUdhTUlHWE1GOEdDQ3NHQVFVRkJ6QUNobE5vZEhSd2N6b3ZMMkZqYzJGMExYUmxjM1JsTG1sdGNISmxibk5oYjJacFkybGhiQzVqYjIwdVluSXZjbVZ3YjNOcGRHOXlhVzh2WTJWeWRHbG1hV05oWkc5ekwyRmpjMkYwTFhSbGMzUmxMbkEzWXpBMEJnZ3JCZ0VGQlFjd0FZWW9hSFIwY0RvdkwyOWpjM0F0Y0dsc2IzUXVhVzF3Y21WdWMyRnZabWxqYVdGc0xtTnZiUzVpY2pBTkJna3Foa2lHOXcwQkFRc0ZBQU9DQWdFQUcwNFlxdFIrZFVmY3cra2MzNWNHdHpUd3l4WnV4TlErdUI3Q2NvNXgwM0I3OE5GZXQ0VFZqaEFWay9hNGVJKzduVUpyRjZ2L1Zxdjd6NFZyckRjV3pJVGptVDIzam5VZ3c3Zjh1K0p0Wk5Nb1MzdlFLRmNLRDZxNHptOVJnZ0pQb1NsdWx0TXJNMDN1MmdnRVJocG4xc3AwK0hackUxaVZNRjY5OGs3WWhWS0szaWtRdWFKVTdlRW1OVjdyRE1iWHFieUJpSHZJcVA5OFNnTWFBbnBDM2V1RWVycUlxQ1dEbmNZbVMranplWWRlV3NMLzUvbXQ1OXhnTDhyYUY1NE80bFNKRE1UREVRYXVZMkZYRmxGeCt2UHRlb1g0STdPUDc5eThjUTJVT3FrQ2E2aFVKUzdjWVNib3RCRFg4dm5aQVZjbWRtc3BrNHFyR3EzUWZXR0pHSDdHT2NKcGgxdmFzOXVoaXhROGxUNmphR0UwTlhqZms4elc2MjdwaE5sNktFL3RIZ2RLUTZMWW4xRkIxN1JsVnhiVy8vK2NocHAzRTNQUTY3dGs5MmxUTExXayt6ZWxLd0lpcXhGSkRhbm01NjZKRUkydlg5SUZxY0FhaXpyd0lQa0o4ZmVkRzQvNzRUemxjUXQ1bmNDa3dyY0dGcjBSTXlJaEJBQ1ZxWkVPZnVNeWgrODdybTFGeDN6QTNoMG5PbHZTeC83N09xazdsNkpmY29tbGVsckFZYmJZbDdNR0t3ZVRWNW5YaHRiZjZGZ3I4bmhEMGZpd3BkL1ZPRWd0Vk0rNnp6QXlsem5XckdJSzB6cENKandYNnZnMHZzQldUS0xzeklEQkY3ODhtOHgxUW9NMC9FZVlTQUR4MEpHTEo5d1p2MVpIVGhYUTF5RnlCWjYrR3ZZPTwvWDUwOUNlcnRpZmljYXRlPjwvWDUwOURhdGE+PC9LZXlJbmZvPjwvU2lnbmF0dXJlPjwvQ0ZlPg==";
		try {
			String dec = HandleFiles.decodeBase64(valueBase64);
			Files files = new Files();
			files.writXMLVenda(valueBase64, "2221515156165161");
			System.out.println(dec);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void retornoVenda() {

		RetEnvioVenda retorno = new RetEnvioVenda();
		String retornoSAT = "463462|06000|0000|Emitido com sucesso + conteudo notas.|||PENGZT48aW5mQ0ZlIElkPSJDRmUzNTE2MDYwODcyMzIxODAwMDE4NjU5OTAwMDAyNTkxMDAwNDkwMDk3MjEzOCIgdmVyc2FvPSIwLjA2IiB2ZXJzYW9EYWRvc0VudD0iMC4wNiIgdmVyc2FvU0I9IjAxMDEwMSI+PGlkZT48Y1VGPjM1PC9jVUY+PGNORj4wOTcyMTM8L2NORj48bW9kPjU5PC9tb2Q+PG5zZXJpZVNBVD45MDAwMDI1OTE8L25zZXJpZVNBVD48bkNGZT4wMDA0OTA8L25DRmU+PGRFbWk+MjAxNjA2MTA8L2RFbWk+PGhFbWk+MTc1NjM2PC9oRW1pPjxjRFY+ODwvY0RWPjx0cEFtYj4yPC90cEFtYj48Q05QSj4xNjcxNjExNDAwMDE3MjwvQ05QSj48c2lnbkFDPlNHUi1TQVQgU0lTVEVNQSBERSBHRVNUQU8gRSBSRVRBR1VBUkRBIERPIFNBVDwvc2lnbkFDPjxhc3NpbmF0dXJhUVJDT0RFPjAvSDJtVVc2STBwcXFPb1F5M2NVWXUrQU1uMWRBcFZQQjdJY0lWUGxEZW1mOUxpNUMrREZQSk1BV3J4Y1JERnowd0tGUGlMRXhwTEhqTDdFS25Kei9tNFI5eWw4OVp5VzNXMTAvRnVzVjBRb3l5VFJqU0RUQ3o2Y3dmYXN3MHFHTUZMSjBZbnRsMzVQMHJPdnJGcTF0T1lUQWxXVnVkdlY1WmpJWHowTFh4MExTQjZmSXdFUi84VXIvR2FMOHcyUzk1UzJ3WHBXWVZ2RzRZbTk1MjY2N1FkU2gzWFRkT1FLL0NmN3JrWGlGdkVEUzJuZkpBVXYyNzJPMHU4eTNnb0VBOHA5czFha05Dd1BZL0NmSHROR0VCbDk1UFdZc3NBRVpLdGxpR0g3Z3N0aXZpTVFTUUxHR0Z3dGU3VUN0S25QTmJqMUpFR3FybFN6UWphc25WZUpxdz09PC9hc3NpbmF0dXJhUVJDT0RFPjxudW1lcm9DYWl4YT4wMDE8L251bWVyb0NhaXhhPjwvaWRlPjxlbWl0PjxDTlBKPjA4NzIzMjE4MDAwMTg2PC9DTlBKPjx4Tm9tZT5UQU5DQSBJTkZPUk1BVElDQSBFSVJFTEk8L3hOb21lPjx4RmFudD5UQU5DQTwveEZhbnQ+PGVuZGVyRW1pdD48eExncj5SVUEgRU5HRU5IRUlSTyBKT1JHRSBPTElWQTwveExncj48bnJvPjczPC9ucm8+PHhCYWlycm8+VklMQSBNQVNDT1RFPC94QmFpcnJvPjx4TXVuPlNBTyBQQVVMTzwveE11bj48Q0VQPjA0MzYyMDYwPC9DRVA+PC9lbmRlckVtaXQ+PElFPjE0OTYyNjIyNDExMzwvSUU+PElNPjEyMzQ1Njc4OTwvSU0+PGNSZWdUcmliPjM8L2NSZWdUcmliPjxjUmVnVHJpYklTU1FOPjE8L2NSZWdUcmliSVNTUU4+PGluZFJhdElTU1FOPk48L2luZFJhdElTU1FOPjwvZW1pdD48ZGVzdD48Q05QSj40NjU0MTY3MzAwMDE1MDwvQ05QSj48eE5vbWU+UkFaQU8gU09DSUFMPC94Tm9tZT48L2Rlc3Q+PGVudHJlZ2E+PHhMZ3I+TG9ncmFkb3VybzwveExncj48bnJvPjEyMzwvbnJvPjx4Q3BsPmNvbXBsZW1lbnRvPC94Q3BsPjx4QmFpcnJvPkJhaXJybzwveEJhaXJybz48eE11bj5NdW5pY2lwaW88L3hNdW4+PFVGPkNFPC9VRj48L2VudHJlZ2E+PGRldCBuSXRlbT0iMSI+PHByb2Q+PGNQcm9kPjAwOTA5ODA8L2NQcm9kPjx4UHJvZD5QUk9EIEhPTU9MT0c8L3hQcm9kPjxOQ00+MDEwMzEwMDA8L05DTT48Q0ZPUD41MTAyPC9DRk9QPjx1Q29tPlVOPC91Q29tPjxxQ29tPjEuMDAwMDwvcUNvbT48dlVuQ29tPjEwLjk5PC92VW5Db20+PHZQcm9kPjEwLjk5PC92UHJvZD48aW5kUmVncmE+QTwvaW5kUmVncmE+PHZJdGVtPjEwLjk5PC92SXRlbT48dlJhdERlc2M+MC4wMDwvdlJhdERlc2M+PHZSYXRBY3I+MC4wMDwvdlJhdEFjcj48L3Byb2Q+PGltcG9zdG8+PHZJdGVtMTI3NDE+Mi41MDwvdkl0ZW0xMjc0MT48SUNNUz48SUNNUzAwPjxPcmlnPjA8L09yaWc+PENTVD4wMDwvQ1NUPjxwSUNNUz41LjMzPC9wSUNNUz48dklDTVM+MC41OTwvdklDTVM+PC9JQ01TMDA+PC9JQ01TPjxQSVM+PFBJU0FsaXE+PENTVD4wMTwvQ1NUPjx2QkM+MTAuOTk8L3ZCQz48cFBJUz4wLjE3MDA8L3BQSVM+PHZQSVM+MS44NzwvdlBJUz48L1BJU0FsaXE+PC9QSVM+PENPRklOUz48Q09GSU5TQWxpcT48Q1NUPjAxPC9DU1Q+PHZCQz4xMC45OTwvdkJDPjxwQ09GSU5TPjAuMDkwMDwvcENPRklOUz48dkNPRklOUz4wLjk5PC92Q09GSU5TPjwvQ09GSU5TQWxpcT48L0NPRklOUz48L2ltcG9zdG8+PGluZkFkUHJvZD5JbmZvcm1hY2FvIGFkaWNpb25hbDwvaW5mQWRQcm9kPjwvZGV0Pjx0b3RhbD48SUNNU1RvdD48dklDTVM+MC41OTwvdklDTVM+PHZQcm9kPjEwLjk5PC92UHJvZD48dkRlc2M+MC4wMDwvdkRlc2M+PHZQSVM+MS44NzwvdlBJUz48dkNPRklOUz4wLjk5PC92Q09GSU5TPjx2UElTU1Q+MC4wMDwvdlBJU1NUPjx2Q09GSU5TU1Q+MC4wMDwvdkNPRklOU1NUPjx2T3V0cm8+MC4wMDwvdk91dHJvPjwvSUNNU1RvdD48dkNGZT4xMC45OTwvdkNGZT48dkNGZUxlaTEyNzQxPjEuMDU8L3ZDRmVMZWkxMjc0MT48L3RvdGFsPjxwZ3RvPjxNUD48Y01QPjAxPC9jTVA+PHZNUD4xMC45OTwvdk1QPjwvTVA+PHZUcm9jbz4wLjAwPC92VHJvY28+PC9wZ3RvPjxpbmZBZGljPjxvYnNGaXNjbyB4Q2FtcG89InhDYW1wbzEiPjx4VGV4dG8+eFRleHRvMTwveFRleHRvPjwvb2JzRmlzY28+PC9pbmZBZGljPjwvaW5mQ0ZlPjxTaWduYXR1cmUgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyMiPjxTaWduZWRJbmZvPjxDYW5vbmljYWxpemF0aW9uTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvVFIvMjAwMS9SRUMteG1sLWMxNG4tMjAwMTAzMTUiPjwvQ2Fub25pY2FsaXphdGlvbk1ldGhvZD48U2lnbmF0dXJlTWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8wNC94bWxkc2lnLW1vcmUjcnNhLXNoYTI1NiI+PC9TaWduYXR1cmVNZXRob2Q+PFJlZmVyZW5jZSBVUkk9IiNDRmUzNTE2MDYwODcyMzIxODAwMDE4NjU5OTAwMDAyNTkxMDAwNDkwMDk3MjEzOCI+PFRyYW5zZm9ybXM+PFRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNlbnZlbG9wZWQtc2lnbmF0dXJlIj48L1RyYW5zZm9ybT48VHJhbnNmb3JtIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvVFIvMjAwMS9SRUMteG1sLWMxNG4tMjAwMTAzMTUiPjwvVHJhbnNmb3JtPjwvVHJhbnNmb3Jtcz48RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMS8wNC94bWxlbmMjc2hhMjU2Ij48L0RpZ2VzdE1ldGhvZD48RGlnZXN0VmFsdWU+dW1MNWpxY2VGY1drZ0NWMDFkMnFnbloyU2Fnckdqbm0yTVJwT1RUdkxJdz08L0RpZ2VzdFZhbHVlPjwvUmVmZXJlbmNlPjwvU2lnbmVkSW5mbz48U2lnbmF0dXJlVmFsdWU+UVNqekpOTllXbTFVdlRvWlcxQWQ1SUE2bzUweEREUkd0Um1wQ24yclhKSUVlWmZpSUEzNFNoZFhZUVBnSjJMOFpFNVQvMXlweFR2Um96YmlsUkxuT1FQSXcrMTdjc3R3NWJkWDFLMVEyZFlSUTFLQlRUbGU3eXdFcEZxL0JDdWJXNVVQQnptOTJWQ1NZUGs4eHB4SGdKNmV6ODRlaTZ6a1RuM3FlQXZmVVdMOCtJbFFYNE5oUUhTcnRmWjJsVnVOaE1xcWZKaWdYSmFGTlUvb0h2QkZLcklVc2FWWEkwaUFBOTRWQzk5SDF5dDdrWGI2UnA0TngvYjZuQU95YlhKbmNZbzN4cGpwa0p4UVl4bndHMFdJUy96d25HcFJHN0loTnV3N29VN2N5TXFHTlBiUEZnekN5OFpLRWpUTHhCU3hvUTdUY0N3ME92MEcyOWFQVVZQZk1RPT08L1NpZ25hdHVyZVZhbHVlPjxLZXlJbmZvPjxYNTA5RGF0YT48WDUwOUNlcnRpZmljYXRlPk1JSUcxakNDQkw2Z0F3SUJBZ0lRTmthMjlqRVRQU2Z1TWZ2eGxOUXE1ekFOQmdrcWhraUc5dzBCQVFzRkFEQm5NUXN3Q1FZRFZRUUdFd0pDVWpFMU1ETUdBMVVFQ2hNc1UyVmpjbVYwWVhKcFlTQmtZU0JHWVhwbGJtUmhJR1J2SUVWemRHRmtieUJrWlNCVFlXOGdVR0YxYkc4eElUQWZCZ05WQkFNVEdFRkRJRk5CVkNCa1pTQlVaWE4wWlNCVFJVWkJXaUJUVURBZUZ3MHhOVEEwTWpJd01EQXdNREJhRncweU1EQTBNVGt5TXpVNU5UbGFNSUhUTVFzd0NRWURWUVFHRXdKQ1VqRVNNQkFHQTFVRUNCTUpVMEZQSUZCQlZVeFBNUkV3RHdZRFZRUUtGQWhUUlVaQldpMVRVREVQTUEwR0ExVUVDeFFHUVVNdFUwRlVNU2d3SmdZRFZRUUxGQjlCZFhSbGJuUnBZMkZrYnlCd2IzSWdRVklnVTBWR1FWb2dVMUFnVTBGVU1Sd3dHZ1lEVlFRTEZCTXhOREk1TnpFM01ETXdNVE0xTmpNeE1ESXhNUkl3RUFZRFZRUUZFd2s1TURBd01ESTFPVEV4TURBdUJnTlZCQU1USjFSQlRrTkJJRWxPUms5U1RVRlVTVU5CSUVWSlVrVk1TVG93T0RjeU16SXhPREF3TURFNE5qQ0NBU0l3RFFZSktvWklodmNOQVFFQkJRQURnZ0VQQURDQ0FRb0NnZ0VCQU5lSm1Ebm9XSldtZHkvNkV0YXVSRE1MenZxZnlnbzJlVm16blh2L1FnL3pVdU5TNU53VUxkaGNWc2dIRjB4U3k4ZE9Ga1hPWHBUaG5YWDdES284eDJNSXFOdGtLUW5Uck9FS2J3ZGt5MHdhajdmQ2xIelBodThEOVoybyt2Um9ycmxiZ1RZRmlROG0yZzhKQWNYU3lGay9Fc1hYUm5CUE9NTktKR0hHOWxkNDkyMG56YU1WakxFbldwZVdNNUtaSnV4eWlCNUhFdnJLUXRzU3BOWHQxQUtwa2d4SGdZOC8wUGxwamp5Zjlmb2NDM2ZURDAwRzRxMEU5K0VNTGhiT0dPRlVNYVE0RzZxMDhJWXZlWHhCSGVCOVU4clIvU1JBRjB1RmxOR2gvM2ZhdUdGYjRFTmxmZjlNalpTUHhLUEtWdTlkSGZwWGdHd1FROENzV1lTTDJ0VUNBd0VBQWFPQ0FnOHdnZ0lMTUNRR0ExVWRFUVFkTUJ1Z0dRWUZZRXdCQXdPZ0VBUU9NRGczTWpNeU1UZ3dNREF4T0RZd0NRWURWUjBUQkFJd0FEQU9CZ05WSFE4QkFmOEVCQU1DQmVBd0h3WURWUjBqQkJnd0ZvQVVqamxCQUZ6eXVBWGFxRzJZdVFGR2JXNWozd0l3YXdZRFZSMGZCR1F3WWpCZ29GNmdYSVphYUhSMGNEb3ZMMkZqYzJGMExYUmxjM1JsTG1sdGNISmxibk5oYjJacFkybGhiQzVqYjIwdVluSXZjbVZ3YjNOcGRHOXlhVzh2YkdOeUwyRmpjMkYwYzJWbVlYcHpjQzloWTNOaGRITmxabUY2YzNCamNtd3VZM0pzTUhzR0ExVWRJQVIwTUhJd2NBWUpLd1lCQkFHQjdDMERNR013WVFZSUt3WUJCUVVIQWdFV1ZXaDBkSEE2THk5aFkzTmhkQzVwYlhCeVpXNXpZVzltYVdOcFlXd3VZMjl0TG1KeUwzSmxjRzl6YVhSdmNtbHZMMlJ3WXk5aFkzTmhkSE5sWm1GNmMzQXZaSEJqWDJGamMyRjBjMlZtWVhwemNDNXdaR1l3RXdZRFZSMGxCQXd3Q2dZSUt3WUJCUVVIQXdJd2dhY0dDQ3NHQVFVRkJ3RUJCSUdhTUlHWE1GOEdDQ3NHQVFVRkJ6QUNobE5vZEhSd2N6b3ZMMkZqYzJGMExYUmxjM1JsTG1sdGNISmxibk5oYjJacFkybGhiQzVqYjIwdVluSXZjbVZ3YjNOcGRHOXlhVzh2WTJWeWRHbG1hV05oWkc5ekwyRmpjMkYwTFhSbGMzUmxMbkEzWXpBMEJnZ3JCZ0VGQlFjd0FZWW9hSFIwY0RvdkwyOWpjM0F0Y0dsc2IzUXVhVzF3Y21WdWMyRnZabWxqYVdGc0xtTnZiUzVpY2pBTkJna3Foa2lHOXcwQkFRc0ZBQU9DQWdFQUcwNFlxdFIrZFVmY3cra2MzNWNHdHpUd3l4WnV4TlErdUI3Q2NvNXgwM0I3OE5GZXQ0VFZqaEFWay9hNGVJKzduVUpyRjZ2L1Zxdjd6NFZyckRjV3pJVGptVDIzam5VZ3c3Zjh1K0p0Wk5Nb1MzdlFLRmNLRDZxNHptOVJnZ0pQb1NsdWx0TXJNMDN1MmdnRVJocG4xc3AwK0hackUxaVZNRjY5OGs3WWhWS0szaWtRdWFKVTdlRW1OVjdyRE1iWHFieUJpSHZJcVA5OFNnTWFBbnBDM2V1RWVycUlxQ1dEbmNZbVMranplWWRlV3NMLzUvbXQ1OXhnTDhyYUY1NE80bFNKRE1UREVRYXVZMkZYRmxGeCt2UHRlb1g0STdPUDc5eThjUTJVT3FrQ2E2aFVKUzdjWVNib3RCRFg4dm5aQVZjbWRtc3BrNHFyR3EzUWZXR0pHSDdHT2NKcGgxdmFzOXVoaXhROGxUNmphR0UwTlhqZms4elc2MjdwaE5sNktFL3RIZ2RLUTZMWW4xRkIxN1JsVnhiVy8vK2NocHAzRTNQUTY3dGs5MmxUTExXayt6ZWxLd0lpcXhGSkRhbm01NjZKRUkydlg5SUZxY0FhaXpyd0lQa0o4ZmVkRzQvNzRUemxjUXQ1bmNDa3dyY0dGcjBSTXlJaEJBQ1ZxWkVPZnVNeWgrODdybTFGeDN6QTNoMG5PbHZTeC83N09xazdsNkpmY29tbGVsckFZYmJZbDdNR0t3ZVRWNW5YaHRiZjZGZ3I4bmhEMGZpd3BkL1ZPRWd0Vk0rNnp6QXlsem5XckdJSzB6cENKandYNnZnMHZzQldUS0xzeklEQkY3ODhtOHgxUW9NMC9FZVlTQUR4MEpHTEo5d1p2MVpIVGhYUTF5RnlCWjYrR3ZZPTwvWDUwOUNlcnRpZmljYXRlPjwvWDUwOURhdGE+PC9LZXlJbmZvPjwvU2lnbmF0dXJlPjwvQ0ZlPg==|20160610175636|CFe35160608723218000186599000025910004900972138|10.99|46541673000150|0/H2mUW6I0pqqOoQy3cUYu+AMn1dApVPB7IcIVPlDemf9Li5C+DFPJMAWrxcRDFz0wKFPiLExpLHjL7EKnJz/m4R9yl89ZyW3W10/FusV0QoyyTRjSDTCz6cwfasw0qGMFLJ0Yntl35P0rOvrFq1tOYTAlWVudvV5ZjIXz0LXx0LSB6fIwER/8Ur/GaL8w2S95S2wXpWYVvG4Ym952667QdSh3XTdOQK/Cf7rkXiFvEDS2nfJAUv272O0u8y3goEA8p9s1akNCwPY/CfHtNGEBl95PWYssAEZKtliGH7gstiviMQSQLGGFwte7UCtKnPNbj1JEGqrlSzQjasnVeJqw==";
		retorno = RetEnvioVenda.getRetorno(retornoSAT);
	}
	
	public String getXMLVendaEmperado() {
		return "<?xml version=\"1.0\" ?><CFe><infCFe versaoDadosEnt=\"0.06\"><ide><CNPJ>16716114000172</CNPJ><signAC>SGR-SAT SISTEMA DE GESTAO E RETAGUARDA DO SAT</signAC><numeroCaixa>001</numeroCaixa></ide><emit><CNPJ>08723218000186</CNPJ><IE>149626224113</IE><IM>123456789</IM><cRegTribISSQN>1</cRegTribISSQN><indRatISSQN>N</indRatISSQN></emit><dest><CNPJ>46541673000150</CNPJ><xNome>RAZAO SOCIAL</xNome></dest><entrega><xLgr>Logradouro</xLgr><nro>123</nro><xCpl>complemento</xCpl><xBairro>Bairro</xBairro><xMun>Municipio</xMun><UF>CE</UF></entrega><det nItem=\"001\"><prod><cProd>0090980</cProd><xProd>PROD HOMOLOG</xProd><NCM>01031000</NCM><CFOP>5102</CFOP><uCom>UN</uCom><qCom>1.0000</qCom><vUnCom>10.99</vUnCom><indRegra>A</indRegra></prod><imposto><vItem12741>2.50</vItem12741><ICMS><ICMS00><Orig>0</Orig><CST>00</CST><pICMS>5.33</pICMS></ICMS00></ICMS><PIS><PISAliq><CST>01</CST><vBC>10.99</vBC><pPIS>0.1700</pPIS></PISAliq></PIS><COFINS><COFINSAliq><CST>01</CST><vBC>10.99</vBC><pCOFINS>0.0900</pCOFINS></COFINSAliq></COFINS></imposto><infAdProd>Informacao adicional</infAdProd></det><total><vCFeLei12741>1.05</vCFeLei12741></total><pgto><MP><cMP>01</cMP><vMP>10.99</vMP></MP></pgto></infCFe></CFe>";
	}

}
