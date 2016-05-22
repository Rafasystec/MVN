package br.com.barcadero.rule.financeiro;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoPlanoContas;
import br.com.systeconline.core.enums.EnumTipoPlanoConta;
import br.com.systeconline.rule.RuleModelo;
import br.com.systeconline.tables.basicos.Empresa;
import br.com.systeconline.tables.basicos.Entidade;
import br.com.systeconline.tables.financeiro.PlanoConta;

public class RulePlanoContas extends RuleModelo{
	
	public RulePlanoContas(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}

	public void cargaInicial(Empresa empresa) throws Exception {
		
		DaoPlanoContas dao = new DaoPlanoContas(getSession());
		
		PlanoConta contaAtivo = new PlanoConta();
		contaAtivo.setDescricao("ATIVO");
		contaAtivo.setEmpresa(empresa);
		contaAtivo.setNivel1(1);
		contaAtivo.setTpConta(EnumTipoPlanoConta.RECEITA);
		
		dao.insert(contaAtivo);
		
		PlanoConta contaAtivoCirculante = new PlanoConta();
		contaAtivoCirculante.setDescricao("ATIVO CIRCULANTE");
		contaAtivoCirculante.setEmpresa(empresa);
		contaAtivoCirculante.setNivel1(1);
		contaAtivoCirculante.setNivel2(1);
		contaAtivoCirculante.setTpConta(EnumTipoPlanoConta.RECEITA);
		
		dao.insert(contaAtivoCirculante);
		
		PlanoConta contaCaixa = new PlanoConta();
		contaCaixa.setDescricao("CAIXA");
		contaCaixa.setEmpresa(empresa);
		contaCaixa.setNivel1(1);
		contaCaixa.setNivel2(1);
		contaCaixa.setNivel3(1);
		contaCaixa.setTpConta(EnumTipoPlanoConta.RECEITA);
		
		dao.insert(contaCaixa);
		
		PlanoConta contaBanco = new PlanoConta();
		contaBanco.setDescricao("BANCOS COM MOVIMENTO");
		contaBanco.setEmpresa(empresa);
		contaBanco.setNivel1(1);
		contaBanco.setNivel2(1);
		contaBanco.setNivel3(2);
		contaBanco.setTpConta(EnumTipoPlanoConta.RECEITA);
		
		dao.insert(contaBanco);
		
		PlanoConta contaBancoDoBrasil = new PlanoConta();
		contaBancoDoBrasil.setDescricao("BANCO DO BRASIL");
		contaBancoDoBrasil.setEmpresa(empresa);
		contaBancoDoBrasil.setNivel1(1);
		contaBancoDoBrasil.setNivel2(1);
		contaBancoDoBrasil.setNivel3(2);
		contaBancoDoBrasil.setNivel4(1);
		contaBancoDoBrasil.setTpConta(EnumTipoPlanoConta.RECEITA);
		
		dao.insert(contaBancoDoBrasil);
		
		PlanoConta contaBancoBradesco = new PlanoConta();
		contaBancoBradesco.setDescricao("BANCO BRADESCO");
		contaBancoBradesco.setEmpresa(empresa);
		contaBancoBradesco.setNivel1(1);
		contaBancoBradesco.setNivel2(1);
		contaBancoBradesco.setNivel3(2);
		contaBancoBradesco.setNivel4(2);
		contaBancoBradesco.setTpConta(EnumTipoPlanoConta.RECEITA);
		
		dao.insert(contaBancoBradesco);
		
		PlanoConta contaNaoCirculante = new PlanoConta();
		contaNaoCirculante.setDescricao("NAO CIRCULANTE");
		contaNaoCirculante.setEmpresa(empresa);
		contaNaoCirculante.setNivel1(1);
		contaNaoCirculante.setNivel2(2);
		contaNaoCirculante.setTpConta(EnumTipoPlanoConta.RECEITA);
		
		dao.insert(contaNaoCirculante);
		
		PlanoConta contasAReceber = new PlanoConta();
		contasAReceber.setDescricao("CONTAS A RECEBER");
		contasAReceber.setEmpresa(empresa);
		contasAReceber.setNivel1(1);
		contasAReceber.setNivel2(2);
		contasAReceber.setNivel3(1);
		contasAReceber.setTpConta(EnumTipoPlanoConta.RECEITA);
		
		dao.insert(contasAReceber);
		
		PlanoConta contaCustoEDespesas = new PlanoConta();
		contaCustoEDespesas.setDescricao("CUSTOS E DESPESAS");
		contaCustoEDespesas.setEmpresa(empresa);
		contaCustoEDespesas.setNivel1(3);
		contaCustoEDespesas.setTpConta(EnumTipoPlanoConta.DESPESA);
		
		dao.insert(contaCustoEDespesas);
		
		PlanoConta contaDespesasFixas = new PlanoConta();
		contaDespesasFixas.setDescricao("DESPESAS FIXAS");
		contaDespesasFixas.setEmpresa(empresa);
		contaDespesasFixas.setNivel1(3);
		contaDespesasFixas.setNivel1(1);
		contaDespesasFixas.setTpConta(EnumTipoPlanoConta.DESPESA);
		
		dao.insert(contaDespesasFixas);
		
		PlanoConta contaAluguel = new PlanoConta();
		contaAluguel.setDescricao("ALUGUEL");
		contaAluguel.setEmpresa(empresa);
		contaAluguel.setNivel1(3);
		contaAluguel.setNivel1(1);
		contaAluguel.setNivel3(1);
		contaAluguel.setTpConta(EnumTipoPlanoConta.DESPESA);
		
		dao.insert(contaAluguel);
		
		PlanoConta contaEnergia = new PlanoConta();
		contaEnergia.setDescricao("ENERGIA");
		contaEnergia.setEmpresa(empresa);
		contaEnergia.setNivel1(3);
		contaEnergia.setNivel1(1);
		contaEnergia.setNivel3(2);
		contaEnergia.setTpConta(EnumTipoPlanoConta.DESPESA);
		
		dao.insert(contaEnergia);
		
		PlanoConta contaAgua = new PlanoConta();
		contaAgua.setDescricao("AGUA");
		contaAgua.setEmpresa(empresa);
		contaAgua.setNivel1(3);
		contaAgua.setNivel1(1);
		contaAgua.setNivel3(3);
		contaAgua.setTpConta(EnumTipoPlanoConta.DESPESA);
		
		dao.insert(contaAgua);
		
		PlanoConta contaCondominio = new PlanoConta();
		contaCondominio.setDescricao("CONDOMINIO");
		contaCondominio.setEmpresa(empresa);
		contaCondominio.setNivel1(3);
		contaCondominio.setNivel1(1);
		contaCondominio.setNivel3(4);
		contaCondominio.setTpConta(EnumTipoPlanoConta.DESPESA);
		
		dao.insert(contaCondominio);
		
		PlanoConta contaInternet = new PlanoConta();
		contaInternet.setDescricao("INTERNET");
		contaInternet.setEmpresa(empresa);
		contaInternet.setNivel1(3);
		contaInternet.setNivel1(1);
		contaInternet.setNivel3(5);
		contaInternet.setTpConta(EnumTipoPlanoConta.DESPESA);
		
		dao.insert(contaInternet);
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
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
