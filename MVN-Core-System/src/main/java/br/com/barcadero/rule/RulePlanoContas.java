package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumTipoPlanoConta;
import br.com.barcadero.dao.DaoPlanoContas;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.PlanoConta;
import br.com.barcadero.tables.Usuario;


public class RulePlanoContas extends RuleModelo<PlanoConta>{
	

	DaoPlanoContas dao;
	public RulePlanoContas(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		dao = new DaoPlanoContas(empresa, loja, session);
	}

	public void cargaInicial(Empresa empresa, Usuario usuario) throws Exception {
		
		PlanoConta contaAtivo = new PlanoConta(empresa,usuario);
		contaAtivo.setDescricao("ATIVO");
		contaAtivo.setNivel1(1);
		contaAtivo.setTpConta(EnumTipoPlanoConta.RECEITA);
		
		dao.insert(contaAtivo);
		
		PlanoConta contaAtivoCirculante = new PlanoConta(empresa,usuario);
		contaAtivoCirculante.setDescricao("ATIVO CIRCULANTE");
		//contaAtivoCirculante.setEmpresa(empresa);
		contaAtivoCirculante.setNivel1(1);
		contaAtivoCirculante.setNivel2(1);
		contaAtivoCirculante.setTpConta(EnumTipoPlanoConta.RECEITA);
		
		dao.insert(contaAtivoCirculante);
		
		PlanoConta contaCaixa = new PlanoConta(empresa,usuario);
		contaCaixa.setDescricao("CAIXA");
		//contaCaixa.setEmpresa(empresa);
		contaCaixa.setNivel1(1);
		contaCaixa.setNivel2(1);
		contaCaixa.setNivel3(1);
		contaCaixa.setTpConta(EnumTipoPlanoConta.RECEITA);
		
		dao.insert(contaCaixa);
		
		PlanoConta contaBanco = new PlanoConta(empresa,usuario);
		contaBanco.setDescricao("BANCOS COM MOVIMENTO");
		//contaBanco.setEmpresa(empresa);
		contaBanco.setNivel1(1);
		contaBanco.setNivel2(1);
		contaBanco.setNivel3(2);
		contaBanco.setTpConta(EnumTipoPlanoConta.RECEITA);
		
		dao.insert(contaBanco);
//		
//		PlanoConta contaBancoDoBrasil = new PlanoConta(empresa,usuario);
//		contaBancoDoBrasil.setDescricao("BANCO DO BRASIL");
//		contaBancoDoBrasil.setEmpresa(empresa);
//		contaBancoDoBrasil.setNivel1(1);
//		contaBancoDoBrasil.setNivel2(1);
//		contaBancoDoBrasil.setNivel3(2);
//		contaBancoDoBrasil.setNivel4(1);
//		contaBancoDoBrasil.setTpConta(EnumTipoPlanoConta.RECEITA);
//		
//		dao.insert(contaBancoDoBrasil);
//		
//		PlanoConta contaBancoBradesco = new PlanoConta(empresa,usuario);
//		contaBancoBradesco.setDescricao("BANCO BRADESCO");
//		contaBancoBradesco.setEmpresa(empresa);
//		contaBancoBradesco.setNivel1(1);
//		contaBancoBradesco.setNivel2(1);
//		contaBancoBradesco.setNivel3(2);
//		contaBancoBradesco.setNivel4(2);
//		contaBancoBradesco.setTpConta(EnumTipoPlanoConta.RECEITA);
//		
//		dao.insert(contaBancoBradesco);
//		
//		PlanoConta contaNaoCirculante = new PlanoConta(empresa,usuario);
//		contaNaoCirculante.setDescricao("NAO CIRCULANTE");
//		contaNaoCirculante.setEmpresa(empresa);
//		contaNaoCirculante.setNivel1(1);
//		contaNaoCirculante.setNivel2(2);
//		contaNaoCirculante.setTpConta(EnumTipoPlanoConta.RECEITA);
//		
//		dao.insert(contaNaoCirculante);
//		
//		PlanoConta contasAReceber = new PlanoConta(empresa,usuario);
//		contasAReceber.setDescricao("CONTAS A RECEBER");
//		contasAReceber.setEmpresa(empresa);
//		contasAReceber.setNivel1(1);
//		contasAReceber.setNivel2(2);
//		contasAReceber.setNivel3(1);
//		contasAReceber.setTpConta(EnumTipoPlanoConta.RECEITA);
//		
//		dao.insert(contasAReceber);
//		
//		PlanoConta contaCustoEDespesas = new PlanoConta(empresa,usuario);
//		contaCustoEDespesas.setDescricao("CUSTOS E DESPESAS");
//		contaCustoEDespesas.setEmpresa(empresa);
//		contaCustoEDespesas.setNivel1(3);
//		contaCustoEDespesas.setTpConta(EnumTipoPlanoConta.DESPESA);
//		
//		dao.insert(contaCustoEDespesas);
//		
//		PlanoConta contaDespesasFixas = new PlanoConta(empresa,usuario);
//		contaDespesasFixas.setDescricao("DESPESAS FIXAS");
//		contaDespesasFixas.setEmpresa(empresa);
//		contaDespesasFixas.setNivel1(3);
//		contaDespesasFixas.setNivel1(1);
//		contaDespesasFixas.setTpConta(EnumTipoPlanoConta.DESPESA);
//		
//		dao.insert(contaDespesasFixas);
//		
//		PlanoConta contaAluguel = new PlanoConta(empresa,usuario);
//		contaAluguel.setDescricao("ALUGUEL");
//		contaAluguel.setEmpresa(empresa);
//		contaAluguel.setNivel1(3);
//		contaAluguel.setNivel1(1);
//		contaAluguel.setNivel3(1);
//		contaAluguel.setTpConta(EnumTipoPlanoConta.DESPESA);
//		
//		dao.insert(contaAluguel);
//		
//		PlanoConta contaEnergia = new PlanoConta(empresa,usuario);
//		contaEnergia.setDescricao("ENERGIA");
//		contaEnergia.setEmpresa(empresa);
//		contaEnergia.setNivel1(3);
//		contaEnergia.setNivel1(1);
//		contaEnergia.setNivel3(2);
//		contaEnergia.setTpConta(EnumTipoPlanoConta.DESPESA);
//		
//		dao.insert(contaEnergia);
//		
//		PlanoConta contaAgua = new PlanoConta(empresa,usuario);
//		contaAgua.setDescricao("AGUA");
//		contaAgua.setEmpresa(empresa);
//		contaAgua.setNivel1(3);
//		contaAgua.setNivel1(1);
//		contaAgua.setNivel3(3);
//		contaAgua.setTpConta(EnumTipoPlanoConta.DESPESA);
//		
//		dao.insert(contaAgua);
//		
//		PlanoConta contaCondominio = new PlanoConta(usuario);
//		contaCondominio.setDescricao("CONDOMINIO");
//		contaCondominio.setEmpresa(empresa);
//		contaCondominio.setNivel1(3);
//		contaCondominio.setNivel1(1);
//		contaCondominio.setNivel3(4);
//		contaCondominio.setTpConta(EnumTipoPlanoConta.DESPESA);
//		
//		dao.insert(contaCondominio);
//		
//		PlanoConta contaInternet = new PlanoConta(usuario);
//		contaInternet.setDescricao("INTERNET");
//		contaInternet.setEmpresa(empresa);
//		contaInternet.setNivel1(3);
//		contaInternet.setNivel1(1);
//		contaInternet.setNivel3(5);
//		contaInternet.setTpConta(EnumTipoPlanoConta.DESPESA);
//		
//		dao.insert(contaInternet);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanoConta find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanoConta> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanoConta> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanoConta> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
