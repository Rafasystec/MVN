package br.com.barcadero.test.db;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.core.db.util.HibernateHelper;
import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.dao.DaoEstado;
import br.com.barcadero.tables.Estado;

public class TestDaoEstado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//delete();	
		//update();
		insert();
		//listAll();
	}
	
	private static void update() {
		Session session = HibernateHelper.getSession();
		session.beginTransaction();
		DaoEstado dao = null;//new DaoEstado(null,null,session);
		
		try {
			Estado estado = (Estado) dao.find(3);
			estado.setCodIbge("11888888");
			dao.update(estado);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	
	private static void delete() {
		Session session = HibernateHelper.getSession();
		session.beginTransaction();
		DaoEstado dao = null;//new DaoEstado(null,null,session);
		
		try {
			dao.delete(9);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	
	private static void insert() {
//		Session session = HibernateHelper.getSession();
//		session.beginTransaction();
//		DaoEstado dao = new DaoEstado(session);
//		Estado estado = new Estado();
//		try {
//			estado.setCodIbge("00020399809");
//			//estado.setCodigo(3);
//			estado.setDescricao("ceará");
//			estado.setDtCadastro(new Date());
//			estado.setUf("CE");
//			
//			Cidade cidade = new Cidade();
//			cidade.setCdEmp(1);
//			cidade.setCdLoja(1);
//			cidade.setCdUser(1);
//			cidade.setCodIbge("0099877763");
//			cidade.setDescricao("Jazeiro do norte");
//			cidade.setEstado(estado);
//			
//			Bairro bairro = new Bairro();
//			bairro.setCodIbge("09938839334");
//			bairro.setDescricao("MARACA");
//			bairro.setCidade(cidade);
//			List<Bairro> bairros = new ArrayList<Bairro>();
//			bairros.add(bairro);		
//			cidade.setBairros(bairros);			
//			List<Cidade> cidades = new ArrayList<Cidade>();
//			cidades.add(cidade);
//			estado.setCidades(cidades);
//			
//			dao.insert(estado);
//			
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		session.getTransaction().commit();
	}
	
	private static void listAll() {
		Session session = HibernateHelper.getSession();
		session.beginTransaction();
		DaoEstado dao = null;//new DaoEstado(null,null,session);
		try {
			List<Estado> list = (List)dao.findAll();
			for(Estado estado : list){
				System.out.println("Estado: " + estado.getDescricao() + "-" + estado.getUf());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		
	}
	
	public void inserirEstados() {
		Session session = HibernateHelper.getSession();
		session.beginTransaction();
		DaoEstado dao = null;//new DaoEstado(null,null,session);
		for (EnumUF uf : EnumUF.values()) {
			Estado estado = new Estado(null);
			estado.setCodIbge(String.valueOf(uf.getCdIbge()));
			estado.setDescricao(uf.getLabel());
			estado.setUf(uf);	
		}
		
	}

}
