package br.com.systeconline.test.db;

import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Session;
import br.com.systeconline.dao.basicos.DaoBairro;
import br.com.systeconline.dao.basicos.DaoCidade;
import br.com.systeconline.tables.basicos.Bairro;
import br.com.systeconline.tables.basicos.Cidade;

public class TesteDaoBairro {

	//private Session session;
	private DaoBairro dao;
	TesteDaoBairro(){
		//session = HibernateHelper.getSession();
		//session.beginTransaction();
		//dao = new DaoBairro(session);
	}
	
		
	public static void main(String[] args) {
		//TesteDaoBairro teste = new TesteDaoBairro();
		
		TesteDaoBairro.inserirCidade();
	}
	public void insert() {
		try {
			Bairro bairro = new Bairro(null); 	
			//bairro.setCodCidade(1);
			bairro.setCodIbge("0993883983");
			bairro.setDescricao("JANGURUSSU");
			bairro.setDtCadastro(new Date());
			dao.insert(bairro);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void inserirCidade() {
		Cidade cidade = new Cidade(null);
		Bairro bairro = new Bairro(null);
		Session session = null;
		try {
			
			session = HibernateHelper.getSession();
			session.beginTransaction();
			
		
			
			DaoCidade daoCid = new DaoCidade(session);
			cidade = (Cidade)daoCid.find(18L);
			bairro.setCidade(cidade);
			bairro.setCodIbge("09094484877");
			bairro.setDescricao("JUREMA");
			
			ArrayList<Bairro> bairros = new ArrayList<Bairro>();
			bairros.add(bairro);
			
			cidade.setBairros(bairros);
			
			session.save(cidade);
			//session.save(bairro);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			session.getTransaction().rollback();
		}
	}
}
