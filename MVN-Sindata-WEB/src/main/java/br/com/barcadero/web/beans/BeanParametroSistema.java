package br.com.barcadero.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleParametros;
import br.com.barcadero.tables.ParametrosSistema;

@ManagedBean
@RequestScoped
public class BeanParametroSistema extends SuperBean {

	private static final long serialVersionUID = -2828344895149578421L;
	private RuleParametros rulePar;
	
	public BeanParametroSistema() {
		rulePar = new RuleParametros(getDataBaseSession());
	}
	
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ParametrosSistema> getAllParametros() {
		
		try {
			return rulePar.findAll(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
