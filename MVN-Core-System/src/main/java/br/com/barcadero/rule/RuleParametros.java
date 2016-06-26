package br.com.barcadero.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoParametros;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.ParametrosSistema;
import br.com.barcadero.tables.ParametrosValores;

public class RuleParametros extends RuleModelo {

	DaoParametros daoParametros;
	
	public RuleParametros(Session session) {
		super(session);
		daoParametros	= new DaoParametros(session);
	}

	
	/**
	 * Inserir um parametro. Unsafe Method.
	 */
	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Deletar um parametro.
	 */
	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoParametros.delete(codigo);
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
	
	public String inserirParametro(ParametrosSistema parametro) throws Exception {
		return daoParametros.insertParametro(parametro);
	}
	
	/**
	 * Inserir um avlor para um parametro
	 * @param valor
	 * @return
	 * @throws Exception
	 */
	public String inserirValor(ParametrosValores valor) throws Exception {
		return daoParametros.insertValorParametro(valor);
	}
	
	public void cargaDeParametros() throws Exception {
		ParametrosSistema sistema = new ParametrosSistema();
		sistema.setDescricao("");
		sistema.setNumero(1);
		
		String[] parametros = {
			"DESATIVAR AGENDAMENTO AUTOMATICO|1|",
			"CONTROLAR FOLHAS DE CHEQUE|2|",
			"CRITICAR CONCILIAÇÃO FINANCEIRA|3|",
			"GERAR CODIGO DE BARRAS PARA PRODUTOS|4|",
			"CRITICAR ESTOQUE NEGATIVO|5|"
		};
		
		List<ParametrosSistema> list = getParametros(parametros);
		for (ParametrosSistema parametrosSistema : list) {
			inserirParametro(parametrosSistema);
		}
	}


	/**
	 * 
	 * @param parametros
	 * @return
	 * @throws Exception
	 */
	public List<ParametrosSistema> getParametros(String[] parametros) throws Exception {
		List<ParametrosSistema> list = new ArrayList<>();
		for (String string : parametros) {
			String[] valores = string.split(Pattern.quote("|"));
			ParametrosSistema param = new ParametrosSistema();
			param.setDescricao(valores[0]);
			param.setNumero(Integer.parseInt(valores[1]));
			try{
				param.setDetalhe(valores[2] == null ? "": valores[2]);
			}catch(ArrayIndexOutOfBoundsException e){
				param.setDetalhe("");
			}
			list.add(param);
		}
		return list;
	}

}
