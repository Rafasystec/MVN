package br.com.systeconline.test.nota;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.fail;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.barcadero.rule.frontend.RuleMeioPgto;
import br.com.systeconline.core.enums.EnumCompeTotalNota;
import br.com.systeconline.core.enums.EnumItemCancelado;
import br.com.systeconline.core.enums.EnumModeloNota;
import br.com.systeconline.core.enums.EnumNaturezaOperacao;
import br.com.systeconline.rule.nota.RuleNota;
import br.com.systeconline.rule.nota.RuleNotaItens;
import br.com.systeconline.tables.basicos.Loja;
import br.com.systeconline.tables.basicos.Usuario;
import br.com.systeconline.tables.frontend.MeiosPagamento;
import br.com.systeconline.tables.nota.Nota;
import br.com.systeconline.tables.nota.NotaItens;
import br.com.systeconline.tables.nota.NotaMeioPgto;
import br.com.systeconline.test.db.HibernateHelper;

public class TestNotaProcess {
	
	
	private static Session session;
	private static RuleMeioPgto ruleMeioPgto;
	private static RuleNota ruleNota;
	private static RuleNotaItens ruleItens;
	private static long lastCodeNota;
	
	@BeforeClass
	public static void init() {
		System.out.println(TestNotaProcess.class + " Init");
		session 		= HibernateHelper.getSession();
		session.beginTransaction();
		ruleMeioPgto 	= new RuleMeioPgto(session);
		ruleNota	 	= new RuleNota(session);
		ruleItens		= new RuleNotaItens(session);
	}
	
	@AfterClass
	public static void destroy() {
		if(session != null){
			session.getTransaction().commit();
			session.close();
		}
	}
	
	@Test
	public void salvar() throws Exception {
		
		System.out.println("Iniciando Teste do processo de NOTA");
		Nota nota 		= new Nota(null, null);
		nota.setDtEmissao(new Date());
		nota.setInfAdicionais("NOTA SALVA EM AMBIENTE DE TESTE");
		nota.setModelo(EnumModeloNota.MOD_59);
		nota.setNaturezaOperacao(EnumNaturezaOperacao.SAIDA);
		nota.setSerieNota("012");
		nota.setPcAcresNota(new BigDecimal(0));
		nota.setVlTotTributos(new BigDecimal("10.00"));
		
		List<NotaItens> itens = new ArrayList<NotaItens>();
		List<NotaMeioPgto> meios = new ArrayList<NotaMeioPgto>();
		
		NotaItens item = new NotaItens(null, null);
		item.setFlCancelado(EnumItemCancelado.N);
		item.setQuantidade(new BigDecimal(1.000));
		item.setVlTotal(new BigDecimal("10"));
		item.setNota(nota);
		item.setSerieNota(nota.getSerieNota());
		item.setFlCompoeTotNota(EnumCompeTotalNota.S);
		item.setPcDesc(new BigDecimal(0));
		item.setVlDesc(new BigDecimal(0));
		item.setVlTotFrete(new BigDecimal(0));
		
		NotaItens item2 = new NotaItens(null, null);
		item2.setFlCancelado(EnumItemCancelado.N);
		item2.setQuantidade(new BigDecimal(3.000));
		item2.setVlTotal(new BigDecimal("10"));
		item2.setNota(nota);
		item2.setSerieNota(nota.getSerieNota());
		item2.setFlCompoeTotNota(EnumCompeTotalNota.S);
		item2.setPcDesc(new BigDecimal(0));
		item2.setVlDesc(new BigDecimal(0));
		item2.setVlTotFrete(new BigDecimal(0));
		
		NotaItens item3 = new NotaItens(null, null);
		item3.setFlCancelado(EnumItemCancelado.N);
		item3.setQuantidade(new BigDecimal(1.000));
		item3.setVlTotal(new BigDecimal("23.30"));
		item3.setNota(nota);
		item3.setSerieNota(nota.getSerieNota());
		item3.setFlCompoeTotNota(EnumCompeTotalNota.S);
		item3.setPcDesc(new BigDecimal(0));
		item3.setVlDesc(new BigDecimal(0));
		item3.setVlTotFrete(new BigDecimal(0));
		
		
		itens.add(item);
		itens.add(item2);
		itens.add(item3);
		
		nota.setItens(itens);
		MeiosPagamento meioPgto = (MeiosPagamento) ruleMeioPgto.find(1L);
		
		//Formas de pagamento
		NotaMeioPgto meio = new NotaMeioPgto(null, null);
		meio.setCdAdministradora(2);
		meio.setQtParcelas(4);
		meio.setValor(new BigDecimal(20.34));
		meio.setNota(nota);
		meio.setSerieNota(nota.getSerieNota());
		meio.setMeioPagamento(meioPgto);
		meios.add(meio);
		
		nota.setMeiosPgto(meios);
		
		try {
			System.out.println(ruleNota.insert(nota)); 
			lastCodeNota = nota.getCodigo();
			System.out.println("Codigo da ultima nota >> " + lastCodeNota);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void inserirMeioPgto() throws Exception {
		System.out.println("Inserir meio de pagamento na nota");		
		MeiosPagamento meioPgto = (MeiosPagamento) ruleMeioPgto.find(1L); 
		NotaMeioPgto notaMeio	= new NotaMeioPgto(null, null);
		Nota nota 				= ruleNota.findNota(lastCodeNota);
		
		notaMeio.setCdAdministradora(9);
		notaMeio.setMeioPagamento(meioPgto);
		notaMeio.setQtParcelas(0);
		notaMeio.setSerieNota("012");
		notaMeio.setValor(new BigDecimal(30));
		notaMeio.setNota(nota);
		
		ArrayList<NotaMeioPgto> meios = new ArrayList<NotaMeioPgto>();
		meios.add(notaMeio);
		nota.setMeiosPgto(meios);
		try {
			ruleNota.insert(nota);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void inserirItem()throws Exception {
		
		NotaItens item = new NotaItens(null, null);
		Nota nota 	   = ruleNota.findNota(lastCodeNota);
		
		ArrayList<NotaItens> itens = new ArrayList<NotaItens>();
		
		item.setNota(nota);
		item.setCdProd("2213222");
		item.setDescricao("COLHER DE CHA");
		item.setFlCancelado(EnumItemCancelado.S);
		item.setFlCompoeTotNota(EnumCompeTotalNota.N);
		item.setNrItem(4);
		item.setSerieNota(nota.getSerieNota());
		item.setQuantidade(new BigDecimal(3d));
		item.setVlTotal(new BigDecimal(12.29));
		item.setVlUnidade(new BigDecimal(10.29));
		
		itens.add(item);
		nota.setItens(itens);
		
		ruleNota.insert(nota);
	}
	
	//@Test
	public void saveItemFromAProduct() throws Exception {
		System.out.println("Begin method saveItemFormAProduct");
		Nota nota 	   = ruleNota.findNota(lastCodeNota);
		NotaItens item = new NotaItens(nota.getLoja(), nota.getUsuario());
		item.setQuantidade(new BigDecimal(10L));
		System.out.println("saveItemFormAProduct response >> " + ruleItens.saveItemNotaFromProduto(1L, nota, item)); 
	}
	
//	@Test
	public void salvarNotaEItemPorProduto() {
		Loja loja = new Loja();
		loja.setCodigo(1L);
		Usuario user = new Usuario();
		user.setCodigo(1L);
		try {
			Nota nota = ruleNota.createNota(loja, user, "0:0:0:0:0:0:0:1");
			NotaItens item = new NotaItens(nota.getLoja(), nota.getUsuario());
			item.setQuantidade(new BigDecimal(11L));
			item.setCodProduto(1L);
			System.out.println("saveItemFormAProduct response >> " + ruleItens.saveItemNotaFromProduto(nota, item));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	private static Nota notaSt;
//	@Test
	public void adicionarProduto() throws Exception {
		notaSt = ruleNota.findNota(11);
		NotaItens item = new NotaItens(null, null);
		item.setQuantidade(new BigDecimal(11L));
		item.setCodProduto(1L);
		System.out.println("saveItemFormAProduct response >> " + ruleItens.saveItemNotaFromProduto(notaSt, item));
	}
	

}
