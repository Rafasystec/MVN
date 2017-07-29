package br.com.barcadero.web.beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.com.barcadero.rule.RuleCidade;
import br.com.barcadero.rule.RuleEstado;
import br.com.barcadero.tables.Cidade;
import br.com.barcadero.tables.Estado;

@ManagedBean
@RequestScoped
public class BeanCidade extends SuperBean<Cidade>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6261268226972226726L;
	private long codigo 		= 0;
	private long codEstado 		= 0;
	private String descricao	= "";
	private String codIbge		= "";
	private Date dtCadastro;
	//private FacadeEstado facadeEstado;
	private List<Cidade> cidades;
	private List<Estado> estados;
	@ManagedProperty("#{ruleCidade}")
	private RuleCidade facadeCidade;
	@ManagedProperty("#{ruleEstado}")
	private RuleEstado facadeEstado;
	FacesContext context ;
	

	
//	public BeanCidade() {
//		facadeCidade = new RuleCidade(getEmpresaLogada(),getLojaLogada(),getDataBaseSession());
//		facadeEstado = new RuleEstado(getEmpresaLogada(),getLojaLogada(),getDataBaseSession()); 
//	}
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public long getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(long codEstado) {
		this.codEstado = codEstado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodIbge() {
		return codIbge;
	}

	public void setCodIbge(String codIbge) {
		this.codIbge = codIbge;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public List<Cidade> getCidades() {
		try{
			if(getCodEstado() != 0 ){
				//Procura pelo codigo especificado
				this.cidades = this.facadeCidade.getCidadesByCodEstado(getCodEstado());
			}
			return cidades;
		}catch(Exception e){
			e.printStackTrace();
			return cidades;
		}
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	//NOTE: Metodos que serao envocados na pagina
	public String inserir() {
		try{
			String msg	= "";
			Cidade cidade	= new Cidade(getSession().getUsuarioLogado());
			Estado estado	= null;
			cidade.setCodigo(getCodigo());
			cidade.setDescricao(getDescricao());
			cidade.setCodIbge(getCodIbge());
			
			estado = (Estado) facadeEstado.find(getCodEstado());
			if(estado != null){
				cidade.setEstado(estado);
				this.facadeCidade.insert(cidade);
				//exibirMensagem(msg);
			}else {
				System.out.println("O estdo veio nulo.");
				exibirErroGrave("O Estado veio nulo");
			}  
			return null;
		}catch(Exception e){
			e.printStackTrace();
			exibirErroGrave(e);
			return null;
		}
	}
	
	public String inserirOnPopup() {
		inserir();
		RequestContext.getCurrentInstance().closeDialog(null);
		return null;
	}
	
	public String cancelar() {
		RequestContext.getCurrentInstance().closeDialog(null);
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
	
	public List<Estado> getEstados() throws Exception {
		return facadeEstado.findAllEstados();
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public RuleCidade getFacadeCidade() {
		return facadeCidade;
	}

	public void setFacadeCidade(RuleCidade facadeCidade) {
		this.facadeCidade = facadeCidade;
	}

	public RuleEstado getFacadeEstado() {
		return facadeEstado;
	}

	public void setFacadeEstado(RuleEstado facadeEstado) {
		this.facadeEstado = facadeEstado;
	}

	@Override
	public boolean validar(Cidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
