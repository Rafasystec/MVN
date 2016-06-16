package br.com.barcadero.frameworks.test.rules;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.barcadero.core.enums.EnumModeloNota;
import br.com.barcadero.core.enums.EnumStatusCaixa;
import br.com.barcadero.core.enums.EnumTipoNota;
import br.com.barcadero.core.enums.EnumTpOperacaoCaixa;
import br.com.barcadero.rule.RuleCaixa;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.CaixaAbertura;
import br.com.barcadero.tables.CaixaFechamento;
import br.com.barcadero.tables.CaixaOperacoes;
import br.com.barcadero.test.db.HibernateHelper;

public class TestRuleCaixa {

	private static Session session;
	private static RuleCaixa ruleCaixa;
	private static int lastCdCaixa;
	private static long lastCodeCaixa;
	//@BeforeClass
	public static void init() {
		System.out.println("Init JUnit case for Caixa process");
		System.out.println(TestRuleCaixa.class + " Init");
		session 		= HibernateHelper.getSession();
		session.beginTransaction();
		ruleCaixa		= new RuleCaixa(session);
	}
	
	//@AfterClass
	public static void destroy() {
		System.out.println("After class destroy invoked");
		if(session != null){
			session.getTransaction().commit();
			session.close();
		}
	}

//	@Test
	public void testInsert() {
		System.out.println("Init teste isert");
		Caixa caixa = new Caixa(null, null);
		caixa.setCdCaixa(2);
		caixa.setCodAtivCfe("2338498");
		caixa.setFlStCaixa(EnumStatusCaixa.ABERTO);
		caixa.setIp("10.0.0.1");
		caixa.setTipoNota(EnumModeloNota.MOD_59);
		try {
			System.out.println(ruleCaixa.insert(caixa));
			lastCdCaixa 	= caixa.getCdCaixa();
			lastCodeCaixa	= caixa.getCodigo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	//@Test
	public void testInsertAbertura() throws Exception {
		System.out.println("Init teste testInsertAbertura");
		Caixa caixa = (Caixa) ruleCaixa.find(1L);
		if(caixa != null){
			List<CaixaAbertura> aberturas = new ArrayList<CaixaAbertura>();
			CaixaAbertura abertura = new CaixaAbertura(null, null);
			abertura.setCaixa(caixa);
			aberturas.add(abertura);
			caixa.setAberturas(aberturas);
			caixa.setFlStCaixa(EnumStatusCaixa.ABERTO);
			System.out.println(ruleCaixa.insert(caixa));
		}else{
			testInsert();
			fail("Nao foi encontrado caixa com o codigo >> " + lastCodeCaixa);
		}
	}
	
	//@Test
	public void testInsertFechamento() throws Exception {
		System.out.println("Init teste testInsertFechamento");
		Caixa caixa = (Caixa) ruleCaixa.find(1L);
		if(caixa != null){
			List<CaixaFechamento> fechamentos = new ArrayList<CaixaFechamento>();
			CaixaFechamento fechamento = new CaixaFechamento(null, null);
			fechamento.setCaixa(caixa);
			fechamentos.add(fechamento);
			caixa.setFechamentos(fechamentos);
			caixa.setFlStCaixa(EnumStatusCaixa.FECHADO);
			System.out.println(ruleCaixa.update(caixa));
		}else{
			fail("Nao foi encontrado caixa com o codigo >> " + lastCodeCaixa);
		}
	}

//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFind() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindAll() {
//		fail("Not yet implemented");
//	}

}
