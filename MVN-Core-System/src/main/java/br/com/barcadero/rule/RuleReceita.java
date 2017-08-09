package br.com.barcadero.rule;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.barcadero.commons.util.HandleDateHour;
import br.com.barcadero.core.enums.EnumNaturezaReceita;
import br.com.barcadero.dao.DaoReceita;
import br.com.barcadero.tables.ContaReceber;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Receita;
@Service
public class RuleReceita extends RuleModelo<Receita> {

	@Autowired
	private DaoReceita daoReceita;
	@Autowired
	private RuleContaAReceber ruleContaAReceber;
	public RuleReceita() {
		
	}
	
	@Override
	public String delete(long codigo) throws Exception {
		return daoReceita.delete(codigo);
	}

	@Override
	public Receita find(long codigo) throws Exception {
		return daoReceita.find(codigo, Receita.class);
	}

	@Override
	public List<Receita> findByEmpresa(Empresa empresa) throws Exception {
		return daoReceita.findByEmpresa(empresa);
	}

	@Override
	public List<Receita> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receita> findAll() throws Exception {
		return daoReceita.findAll();
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	@Override
	public Receita insert(Receita entidade) throws Exception {
		lancarContasAReceberParaTodoOAno(entidade);
		return daoReceita.insert(entidade);
	}

	/**
	 * Gera contas a receber para o restante dos meses desse ano
	 * @param entidade
	 * @throws Exception
	 */
	private void lancarContasAReceberParaTodoOAno(Receita entidade) throws Exception {
		if(entidade != null){
			if(entidade.getNaturezaReceita() == EnumNaturezaReceita.FIXA){
				//Gerar varias receitas para todos os meses ate o final do ano
				//Gerar tambem o contas a receber
				int ano = Integer.parseInt(HandleDateHour.getCurrentYear());
				int mes = Integer.parseInt(HandleDateHour.getCurrentMonth());
				int diferencaMeses = 12 - mes;
				for (int i = 0; i < diferencaMeses; i++) {
					ContaReceber contaReceber = new ContaReceber();
					contaReceber.setDescricao(entidade.getDescricao());
					Date datePG = HandleDateHour.getDate(ano, mes + i, entidade.getDiaBase());
					contaReceber.setDtPrevisao(datePG);
					contaReceber.setDtVencimento(datePG);
					contaReceber.setEmpresa(entidade.getEmpresa());
					contaReceber.setNrNotaFiscal("000000");
					contaReceber.setReceita(entidade);
					contaReceber.setValorAReceber(entidade.getValor());
					ruleContaAReceber.insert(contaReceber);
				}
			}
		}
	}

	@Override
	public Receita update(Receita entidade) throws Exception {
		return daoReceita.update(entidade);
	}

	public DaoReceita getDaoReceita() {
		return daoReceita;
	}

	public void setDaoReceita(DaoReceita daoReceita) {
		this.daoReceita = daoReceita;
	}

	public RuleContaAReceber getRuleContaAReceber() {
		return ruleContaAReceber;
	}

	public void setRuleContaAReceber(RuleContaAReceber ruleContaAReceber) {
		this.ruleContaAReceber = ruleContaAReceber;
	}

}
