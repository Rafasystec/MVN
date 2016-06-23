package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;

import br.com.barcadero.core.util.HandleCargaCidadesCE;
import br.com.barcadero.rule.FacadeEstado;
/**
 * Para realizar a carga de algumas tabelas quando necessario.
 * @author Rafael Rocha
 * @since 1.0 - dia 15/02/2016 as 10:42
 */
@ManagedBean(name="carga")
public class BeanCargaInicial extends SuperBean {

	private static final long serialVersionUID = 1L;
	private FacadeEstado fcdEstado;
	private HandleCargaCidadesCE cargaCidCE;
	public BeanCargaInicial() {
		// TODO Auto-generated constructor stub
		fcdEstado = new FacadeEstado(getDataBaseSession());
		cargaCidCE = new HandleCargaCidadesCE(getDataBaseSession(), getSession().getUsuarioLogado());
	}
	
	public String carregarEstados() throws Exception {
		fcdEstado.carregarEstados(getSession().getUsuarioLogado());
		return null;
	}
	
	public String carregarCidadesCeara() throws Exception {
		System.out.println("Execuntando a carga na tabela de Cidades do Ceara");
		cargaCidCE.loadCeara();
		System.out.println("Fim da carga");
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

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
