package br.com.barcadero.web.beans;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.barcadero.tables.HistoricoLancamento;

@ManagedBean
@RequestScoped
public class BeanHistoricoLancamento extends BeanSuperClass{
	
	private long codigo;
	private long codExterno; //Codigo que sera apresentado ao usuario
	private long codEmp; //Codigo da empresa.
	private String descricao;
	private List<HistoricoLancamento> historicos;
	//private FacadeHistoricoLancamento fcHistorico;
	
	public BeanHistoricoLancamento(){
		super();
		try {
			//fcHistorico = new FacadeHistoricoLancamento(getManager());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public long getCodExterno() {
		return codExterno;
	}
	public void setCodExterno(long codExterno) {
		this.codExterno = codExterno;
	}
	public long getCodEmp() {
		return codEmp;
	}
	public void setCodEmp(long codEmp) {
		this.codEmp = codEmp;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<HistoricoLancamento> getHistoricos() throws Exception{
		try {
			//return fcHistorico.findAll();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void setHistoricos(List<HistoricoLancamento> historicos) {
		this.historicos = historicos;
	}

	public String salvar() {
		String target = null;
		HistoricoLancamento historico;
		try {
			historico = new HistoricoLancamento(null);
			historico.setCodExterno(getCodExterno());
			historico.setCodEmp(0L);
			historico.setDescricao(getDescricao());
			historico.setDtCadastro(new Date());
			//exibirMensagem(fcHistorico.salvar(historico));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;//chamaPagErro(e);
		}
		return target;
	}
	
	public String excluir() {
		return "";
	}
	
	public String alterar() {
		return "";
	}
}
