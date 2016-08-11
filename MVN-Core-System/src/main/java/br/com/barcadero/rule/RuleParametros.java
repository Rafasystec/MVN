package br.com.barcadero.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.core.enums.EnumSimNao;
import br.com.barcadero.dao.DaoParametros;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.ParametrosSistema;
import br.com.barcadero.tables.ParametrosValores;

@Service
public class RuleParametros extends RuleModelo<ParametrosSistema> {

	
	private DaoParametros daoParametros;
	@Autowired
	public RuleParametros(DaoParametros daoParametros) {
		System.out.println("Auto-generated constructor stub RuleParametros");
		this.daoParametros = daoParametros;
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
			"DESATIVAR AGENDAMENTO AUTOMATICO|1||S",
			"CONTROLAR FOLHAS DE CHEQUE|2||N",
			"CRITICAR CONCILIAÇÃO FINANCEIRA|3||N",
			"GERAR CODIGO DE BARRAS PARA PRODUTOS|4||N",
			"CRITICAR ESTOQUE NEGATIVO|5||N"
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
			try {
				String value = valores[3] == null ? "": valores[3];
				if(value.trim().equalsIgnoreCase("S")){
					param.setValor(EnumSimNao.SIM);
				}else{
					param.setValor(EnumSimNao.NAO);
				}
			} catch (Exception e) {
				param.setValor(EnumSimNao.NAO);
			}
			list.add(param);
		}
		return list;
	}
	/**
	 * Procurar todos os registros e retornar uma lista com ParametrosSistema
	 * @param usarClasse
	 * @return
	 * @throws Exception
	 */
	public List<ParametrosSistema> findAll(boolean usarClasse) throws Exception {
		return daoParametros.findAll();
	}

	@Override
	public ParametrosSistema find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParametrosSistema> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParametrosSistema> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParametrosSistema> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
