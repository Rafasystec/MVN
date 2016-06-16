package br.com.barcadero.test.db;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoCliente;
import br.com.barcadero.dao.DaoEndereco;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Endereco;

public class TestDaoCliente {

	private DaoCliente dao;
	public TestDaoCliente() {
		dao = new DaoCliente(HibernateHelper.getSession());
	}
	
	public static void main(String[] args) {
//		insert();
	}
	
//	private static void insert() {
//		Session session = HibernateHelper.getSession();
//		DaoCliente dao = new DaoCliente(session);
//		DaoEndereco daoEnd = new DaoEndereco(session);
//		try {
//			Cliente cliente = new Cliente();
//			Endereco ender = new Endereco();
//			Endereco ender2 = new Endereco();
//			session.beginTransaction();
//			
//			cliente.setCdEmp(1L);
//			cliente.setCdLoja(1L);
//			cliente.setCdUser(10);
//			cliente.setCidNatural("MOSSORO");
//			cliente.setCpfCnpj("099899887788");
//			cliente.setDtNacimento(new Date(1988, 3, 05));
//			cliente.setEmail("rafa@teste");
//			cliente.setNome("João DE NETO");
//			cliente.setNomeMae("maria");
//			cliente.setNomePai("valter");
//			cliente.setPaisNatural("BRASIL");
//			cliente.setTel1("9990988900");
//			cliente.setTel2("8880988900");
//			cliente.setTpPessoa("F");
//			cliente.setUfNatural("CE");
//			
//			//session.merge(cliente);
//			
//			ender.setCdEmp(1);
//			ender.setCdLoja(1);
//			ender.setCdUser(1);
//			ender.setCep("6000000");
//			ender.setLogradouro("JOSE BASTOS");
//			ender.setNumero("100");
//			ender.setTipo("c");
//			ender.setTpLogradouro(EnumTipoLograd.AVENIDA);
//			
//			ender2.setCdEmp(1);
//			ender2.setCdLoja(1);
//			ender2.setCdUser(1);
//			ender2.setCep("6000000");
//			ender2.setLogradouro("ANTONIO SALES");
//			ender2.setNumero("100");
//			ender2.setTipo("c");
//			ender2.setTpLogradouro(EnumTipoLograd.AVENIDA);
//			
//			ArrayList<Endereco> list = new ArrayList<Endereco>();
//			list.add(ender);
//			list.add(ender2);
//			cliente.setEnderecos(list);
//			
//			dao.insert(cliente);
//			daoEnd.insert(ender);
//			
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//	}
}
