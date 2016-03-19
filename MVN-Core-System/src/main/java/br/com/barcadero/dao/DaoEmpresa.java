package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.systeconline.dao.basicos.DaoEndereco;
import br.com.systeconline.dao.basicos.DaoModelo;
import br.com.systeconline.tables.basicos.Empresa;
import br.com.systeconline.tables.basicos.Endereco;
import br.com.systeconline.tables.basicos.Entidade;
import br.com.systeconline.tables.basicos.PessoaJuridica;

public class DaoEmpresa extends DaoModelo {

	private DaoPessoaJuridica daoPJ;
	private DaoEndereco daoEndereco;
	public DaoEmpresa(Session session) {
		super(session);
		daoPJ 		= new DaoPessoaJuridica(session);
		daoEndereco = new DaoEndereco(session);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return find(codigo);
	}

	@Override
	public List<Entidade> findAll() throws Exception {
		// TODO Auto-generated method stub
		return findAll();
	}
	
	/**
	 * Inserir uma empresa no banco de dados
	 * @param pj
	 * @param emp
	 * @return
	 * @throws Exception
	 */
//	public String insert(PessoaJuridica pj, Empresa emp) throws Exception{
//		//daoPJ.insert(pj);
//		long codPessoa = pj.getCodigo();
//		if(codPessoa <= 0L){
//			System.out.println("PJ codigo: " + codPessoa);
//			throw new Exception("Código da pessoal não foi retornado para confirmar o relacionamento.");
//		}
//		for (Endereco endereco : emp.getEnderecos()) {
//			endereco.setCodPessoa(codPessoa);
//			daoEndereco.insert(endereco);
//		}
//		emp.setCodPessoa(codPessoa);
//		insert(emp);
//		long codEmp = emp.getCodigo();
//		System.out.println("Cod emp: " + codEmp);
//		return "Empresa salva com sucesso!";
//	}

}
